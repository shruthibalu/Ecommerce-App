import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

 
public class MostDemandingPdt extends JFrame {
    DefaultTableModel demandPdtsTable =new DefaultTableModel();

    public MostDemandingPdt() {
        initComponents();
    }

    private void initComponents() {
        
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        pdtTable = new JTable(demandPdtsTable);

        //======== this ========
        setBackground(Color.white);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Most Demanding Products");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 18));

        //======== scrollPane1 ========
        {

            //---- pdtTable ----
            pdtTable.setBorder(LineBorder.createBlackLineBorder());
            scrollPane1.setViewportView(pdtTable);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(135, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                    .addGap(115, 115, 115))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        demandPdtsTable.addColumn("Product Name");
        demandPdtsTable.addColumn("No. of times Purchased");
        this.setVisible(true);
try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from customers_list where cust_uname=? and city=?");
            //String queryCheck = "select * from cart_items where date_added>=to_timestamp('? 00:00:00','mm/dd/yyyy hh:mi:ss')";//and date_added<=to_timestamp('? 23:59:59','mm/dd/yyyy hh24:mi:ss')";
            String queryCheck = "select PRODUCT_NAME,count(product_name) from cart_items GROUP BY(CART_ITEMS.PRODUCT_NAME) ORDER BY(count(product_name)) DESC FETCH FIRST 5 ROWS ONLY";
            PreparedStatement ps = con.prepareStatement(queryCheck);
           // ps.setString(1,String.valueOf(date));
            //ps.setString(2,String.valueOf(date2));

            //ps.setString(2,date);

            // ps.setString(1,city);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                demandPdtsTable.addRow(new Object[]{ rs.getString(1), rs.getInt(2)});
                //++rr;
            }

//step5 close the connection object
            con.close();

        }catch(Exception f){ System.out.println(f);}

    }
    

    public static void main(String[] args) {
        MostDemandingPdt m=new MostDemandingPdt();
    }

    
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable pdtTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
