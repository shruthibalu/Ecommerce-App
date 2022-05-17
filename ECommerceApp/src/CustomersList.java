import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

 
public class CustomersList extends JFrame {
    String uname,city;
    DefaultTableModel custtable=new DefaultTableModel();

    public CustomersList() {
        initComponents();
    }

    private void listCustBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        custtable.setRowCount(0);


        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from customers_list");
            while(rs.next())
                custtable.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getString(8)});
            con.close();

        }catch(Exception f){ JOptionPane.showMessageDialog(this,f);}


    }

    private void srchBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        custtable.setRowCount(0);

        //uname=unameTxtFld.getText();
        city=cityTxtFld.getText();
        if(city.matches("[a-zA-Z]*")) {

            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
                Statement stmt = con.createStatement();
                final String queryCheck = "select * from customers_list where city=?";
                final PreparedStatement ps = con.prepareStatement(queryCheck);
                ps.setString(1, city);
                final ResultSet rs = ps.executeQuery();
                while (rs.next())
                    custtable.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getLong(6), rs.getString(7), rs.getString(8)});
                con.close();

            } catch (Exception f) {
                JOptionPane.showMessageDialog(this,f);
            }

        }
        else{
            JOptionPane.showMessageDialog(this,"Please enter a valid City Name");
        }




    }

    private void ageRadBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        custtable.setRowCount(0);

        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from customers_list where cust_uname=? and city=?");
            final String queryCheck = "select * from customers_list order by cust_age";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            //ps.setString(1, uname);
            //ps.setString(1,city);
            final ResultSet rs = ps.executeQuery();
            while(rs.next())
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                custtable.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getString(8)});


//step5 close the connection object
            con.close();

        }catch(Exception f){             JOptionPane.showMessageDialog(this,"Please enter a valid Age");
            ;}
    }

    private void srchUnameActionPerformed(ActionEvent e) {
        // TODO add your code here
        custtable.setRowCount(0);
        uname=unameTxtFld.getText();

        //if((uname!=null)&&(city!=null)){
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from customers_list where cust_uname=? and city=?");
            final String queryCheck = "select * from customers_list where cust_uname=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, uname);
           // ps.setString(1,city);
            final ResultSet rs = ps.executeQuery();
            while(rs.next())
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                custtable.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getString(8)});


//step5 close the connection object
            con.close();

        }catch(Exception f){             JOptionPane.showMessageDialog(this,"Please enter a valid  Name");
            ;}



    }

    private void initComponents() {
        
        panel1 = new JPanel();
        listCustBtn = new JButton();
        panel2 = new JPanel();
        label1 = new JLabel();
        ageRadBtn = new JRadioButton();
        panel3 = new JPanel();
        label2 = new JLabel();
        unameTxtFld = new JTextField();
        label3 = new JLabel();
        cityTxtFld = new JTextField();
        label4 = new JLabel();
        srchBtn = new JButton();
        srchUname = new JButton();
        scrollPane1 = new JScrollPane();
        customersTable = new JTable(custtable);

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
            javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax
            . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
            . awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .
            PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .
            equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- listCustBtn ----
            listCustBtn.setText("List all Customers");
            listCustBtn.addActionListener(e -> listCustBtnActionPerformed(e));

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setBorder(LineBorder.createBlackLineBorder());

                //---- label1 ----
                label1.setText("Sort By :");

                //---- ageRadBtn ----
                ageRadBtn.setText("Age");
                ageRadBtn.addActionListener(e -> ageRadBtnActionPerformed(e));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(ageRadBtn, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                            .addContainerGap(56, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ageRadBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(27, Short.MAX_VALUE))
                );
            }

            //======== panel3 ========
            {
                panel3.setBackground(Color.white);
                panel3.setBorder(LineBorder.createBlackLineBorder());

                //---- label2 ----
                label2.setText("Search By:");

                //---- unameTxtFld ----
                unameTxtFld.setBorder(LineBorder.createBlackLineBorder());

                //---- label3 ----
                label3.setText("UserName :");

                //---- cityTxtFld ----
                cityTxtFld.setBorder(LineBorder.createBlackLineBorder());

                //---- label4 ----
                label4.setText("City:");

                //---- srchBtn ----
                srchBtn.setText("Search by City");
                srchBtn.addActionListener(e -> srchBtnActionPerformed(e));

                //---- srchUname ----
                srchUname.setText("Search by UName");
                srchUname.addActionListener(e -> srchUnameActionPerformed(e));

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(unameTxtFld, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(srchUname, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                                .addComponent(srchBtn, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cityTxtFld, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(17, Short.MAX_VALUE))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(unameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(srchUname)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cityTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(srchBtn)
                            .addContainerGap())
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(listCustBtn, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(listCustBtn, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(customersTable);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
       // customersTable.add
        this.setVisible(true);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        custtable.addColumn("Cust_No");
        custtable.addColumn("UserName");
        custtable.addColumn("Password");
        custtable.addColumn("Age");
        custtable.addColumn("Gender");
        custtable.addColumn("Mobile Number");
        custtable.addColumn("Address");
        custtable.addColumn("City");




    }

    
    private JPanel panel1;
    private JButton listCustBtn;
    private JPanel panel2;
    private JLabel label1;
    private JRadioButton ageRadBtn;
    private JPanel panel3;
    private JLabel label2;
    private JTextField unameTxtFld;
    private JLabel label3;
    private JTextField cityTxtFld;
    private JLabel label4;
    private JButton srchBtn;
    private JButton srchUname;
    private JScrollPane scrollPane1;
    private JTable customersTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        CustomersList clist=new CustomersList();

    }
}
