import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class CustPurchasedProducts extends JFrame {
    String username;
    int rowc=1,rr=1;
    DefaultTableModel prodctpurchase=new DefaultTableModel();
    DefaultTableModel transactions=new DefaultTableModel();


    public CustPurchasedProducts(String x) {
        username=x;
        initComponents();
    }

    private void initComponents() {
        
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        purchpdtTable = new JTable(prodctpurchase);
        scrollPane3 = new JScrollPane();
        transTable = new JTable(transactions);

        //======== this ========
        setBackground(Color.white);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Your  Purchase History");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label1.setBorder(LineBorder.createBlackLineBorder());

        //---- label2 ----
        label2.setText("Your Transaction History");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setBorder(LineBorder.createBlackLineBorder());

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(purchpdtTable);
        }

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(transTable);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap(25, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        prodctpurchase.addColumn("No.");
        prodctpurchase.addColumn("Product Name");
        prodctpurchase.addColumn("Price");
        prodctpurchase.addColumn("Date of Purchase");

        transactions.addColumn("No.");
        transactions.addColumn("No. of Products");
        transactions.addColumn("Total Amount");
        transactions.addColumn("Date of Transaction");


        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from customers_list where cust_uname=? and city=?");
            final String queryCheck = "select product_name,Products.pdt_price,date_added from cart_items,products where cust_username=? and cart_items.product_name=products.pdt_name";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, username);
            // ps.setString(1,city);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                prodctpurchase.addRow(new Object[]{rowc, rs.getString(1), rs.getInt(2), rs.getDate(3)});
                ++rowc;
            }

//step5 close the connection object
            con.close();

        }catch(Exception f){ System.out.println(f);}

        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from customers_list where cust_uname=? and city=?");
            String queryCheck = "select noproducts,totalamount,purchase_date from purchases where username=?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, username);
            // ps.setString(1,city);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                transactions.addRow(new Object[]{rr, rs.getInt(1), rs.getInt(2), rs.getDate(3)});
                ++rr;
            }

//step5 close the connection object
            con.close();

        }catch(Exception f){ System.out.println(f);}


    }

    
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTable purchpdtTable;
    private JScrollPane scrollPane3;
    private JTable transTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
