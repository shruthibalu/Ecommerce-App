import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

 
public class ListTransactions {
    DefaultTableModel prodctTransTable =new DefaultTableModel();
    DefaultTableModel cartTable =new DefaultTableModel();

    public ListTransactions() {

        initComponents();
    }

    private void listTransBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        prodctTransTable.setRowCount(0);
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from customers_list where cust_uname=? and city=?");
            String queryCheck = "select * from purchases";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            //ps.setString(1, username);
            // ps.setString(1,city);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                prodctTransTable.addRow(new Object[]{ rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getDate(5)});
                //++rr;
            }

//step5 close the connection object
            con.close();

        }catch(Exception f){ System.out.println(f);}
    }

    private void listpdtButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        cartTable.setRowCount(0);
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from customers_list where cust_uname=? and city=?");
            String queryCheck = "select Distinct cust_username,product_name,date_added from cart_items";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            //ps.setString(1, username);
            // ps.setString(1,city);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                cartTable.addRow(new Object[]{ rs.getString(1), rs.getString(2),rs.getDate(3)});
                //++rr;
            }

//step5 close the connection object
            con.close();

        }catch(Exception f){ System.out.println(f);}

    }

    private void srchPdtActionPerformed(ActionEvent e) {
        // TODO add your code here
        cartTable.setRowCount(0);

        String pdt=pdtTextFld.getText();
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from customers_list where cust_uname=? and city=?");
            String queryCheck = "select cust_username,product_name,date_added from cart_items where product_name=?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,pdt);
            // ps.setString(1,city);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                cartTable.addRow(new Object[]{ rs.getString(1), rs.getString(2),rs.getDate(3)});
                //++rr;
            }

//step5 close the connection object
            con.close();

        }catch(Exception f){ System.out.println(f);}
        unTxtFld.setText(null);

    }

    private void srchUnActionPerformed(ActionEvent e) {
        // TODO add your code here
        cartTable.setRowCount(0);
        String un=unTxtFld.getText();

        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
            Statement stmt=con.createStatement();
            String queryCheck = "select cust_username,product_name,date_added from cart_items where cust_username=?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,un);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                cartTable.addRow(new Object[]{ rs.getString(1), rs.getString(2),rs.getDate(3)});
            }
            con.close();
        }catch(Exception f){ System.out.println(f);}

        pdtTextFld.setText(null);

    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        cartTable.setRowCount(0);

        String date=dateTxtFld.getText();
        String date2=dateTxtFld2.getText();

        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from customers_list where cust_uname=? and city=?");
            //String queryCheck = "select * from cart_items where date_added>=to_timestamp('? 00:00:00','mm/dd/yyyy hh:mi:ss')";//and date_added<=to_timestamp('? 23:59:59','mm/dd/yyyy hh24:mi:ss')";
            String queryCheck = "select * from cart_items where date_added>=to_date(?,'dd/mm/yyyy') and date_added<to_date(?,'dd/mm/yyyy')";//and date_added<=";//and date_added<=to_timestamp('? 23:59:59','mm/dd/yyyy hh24:mi:ss')";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,String.valueOf(date));
            ps.setString(2,String.valueOf(date2));

            //ps.setString(2,date);

            // ps.setString(1,city);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                cartTable.addRow(new Object[]{ rs.getString(1), rs.getString(2),rs.getDate(3)});
                //++rr;
            }

//step5 close the connection object
            con.close();

        }catch(Exception f){ System.out.println(f);}
        unTxtFld.setText(null);
        pdtTextFld.setText(null);

    }

    private void mstDmdPdtBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
            MostDemandingPdt p=new MostDemandingPdt();
    }

    private void initComponents() {
        
        transFrame = new JFrame();
        panel1 = new JPanel();
        listTransBtn = new JButton();
        panel2 = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        pdtTextFld = new JTextField();
        srchPdt = new JButton();
        label4 = new JLabel();
        unTxtFld = new JTextField();
        srchUn = new JButton();
        label5 = new JLabel();
        dateTxtFld = new JTextField();
        button1 = new JButton();
        dateTxtFld2 = new JTextField();
        label2 = new JLabel();
        label6 = new JLabel();
        listpdtButton = new JButton();
        mstDmdPdtBtn = new JButton();
        scrollPane1 = new JScrollPane();
        pdtTransTable = new JTable(prodctTransTable);
        scrollPane2 = new JScrollPane();
        cart_items_table = new JTable(cartTable);
        Products = new JLabel();

        //======== transFrame ========
        {
            var transFrameContentPane = transFrame.getContentPane();

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
                new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
                , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
                , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
                , java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
                new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
                ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
                ; }} );

                //---- listTransBtn ----
                listTransBtn.setText("List all Transactions");
                listTransBtn.addActionListener(e -> listTransBtnActionPerformed(e));

                //======== panel2 ========
                {
                    panel2.setBackground(Color.white);
                    panel2.setBorder(LineBorder.createBlackLineBorder());

                    //---- label1 ----
                    label1.setText("Search By:");

                    //---- label3 ----
                    label3.setText("Product");

                    //---- pdtTextFld ----
                    pdtTextFld.setBorder(LineBorder.createBlackLineBorder());

                    //---- srchPdt ----
                    srchPdt.setText("Search By Product");
                    srchPdt.addActionListener(e -> srchPdtActionPerformed(e));

                    //---- label4 ----
                    label4.setText("Username");

                    //---- unTxtFld ----
                    unTxtFld.setBorder(LineBorder.createBlackLineBorder());

                    //---- srchUn ----
                    srchUn.setText("Search By Username");
                    srchUn.addActionListener(e -> srchUnActionPerformed(e));

                    //---- label5 ----
                    label5.setText("Date (dd/mm/yyyy)");

                    //---- dateTxtFld ----
                    dateTxtFld.setBorder(LineBorder.createBlackLineBorder());
                    dateTxtFld.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                    dateTxtFld.setToolTipText("From Date");

                    //---- button1 ----
                    button1.setText("Search By Date");
                    button1.addActionListener(e -> button1ActionPerformed(e));

                    //---- dateTxtFld2 ----
                    dateTxtFld2.setBorder(LineBorder.createBlackLineBorder());
                    dateTxtFld2.setToolTipText("To Date");

                    //---- label2 ----
                    label2.setText("From Date");

                    //---- label6 ----
                    label6.setText("To Date");

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(unTxtFld)
                                    .addComponent(srchUn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateTxtFld)
                                    .addComponent(dateTxtFld2)
                                    .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(srchPdt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pdtTextFld)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pdtTextFld, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(srchPdt, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unTxtFld, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(srchUn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label2)
                                .addGap(4, 4, 4)
                                .addComponent(dateTxtFld, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateTxtFld2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1)
                                .addGap(12, 12, 12))
                    );
                }

                //---- listpdtButton ----
                listpdtButton.setText("List Purchased Products ");
                listpdtButton.addActionListener(e -> listpdtButtonActionPerformed(e));

                //---- mstDmdPdtBtn ----
                mstDmdPdtBtn.setText("Most Demanding Products");
                mstDmdPdtBtn.addActionListener(e -> mstDmdPdtBtnActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(listTransBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(listpdtButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mstDmdPdtBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(listTransBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(listpdtButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mstDmdPdtBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(pdtTransTable);
            }

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(cart_items_table);
            }

            //---- Products ----
            Products.setText("Products Purchased");

            GroupLayout transFrameContentPaneLayout = new GroupLayout(transFrameContentPane);
            transFrameContentPane.setLayout(transFrameContentPaneLayout);
            transFrameContentPaneLayout.setHorizontalGroup(
                transFrameContentPaneLayout.createParallelGroup()
                    .addGroup(transFrameContentPaneLayout.createSequentialGroup()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(transFrameContentPaneLayout.createParallelGroup()
                            .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                            .addGroup(transFrameContentPaneLayout.createSequentialGroup()
                                .addComponent(Products, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 335, Short.MAX_VALUE))
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)))
            );
            transFrameContentPaneLayout.setVerticalGroup(
                transFrameContentPaneLayout.createParallelGroup()
                    .addGroup(transFrameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(transFrameContentPaneLayout.createParallelGroup()
                            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                            .addGroup(transFrameContentPaneLayout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Products, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
            );
            transFrame.pack();
            transFrame.setLocationRelativeTo(transFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        prodctTransTable.addColumn("Trans No");
        prodctTransTable.addColumn("UserName");
        prodctTransTable.addColumn("No. of Products");
        prodctTransTable.addColumn("Total Amount");
        prodctTransTable.addColumn("Date of Purchase");

        cartTable.addColumn("Purchased By");
        cartTable.addColumn("Product purchased");
        cartTable.addColumn("Date of Purchase");


        transFrame.setVisible(true);





    }

    public static void main(String[] args) {
        ListTransactions lt=new ListTransactions();
    }

   
    private JFrame transFrame;
    private JPanel panel1;
    private JButton listTransBtn;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label3;
    private JTextField pdtTextFld;
    private JButton srchPdt;
    private JLabel label4;
    private JTextField unTxtFld;
    private JButton srchUn;
    private JLabel label5;
    private JTextField dateTxtFld;
    private JButton button1;
    private JTextField dateTxtFld2;
    private JLabel label2;
    private JLabel label6;
    private JButton listpdtButton;
    private JButton mstDmdPdtBtn;
    private JScrollPane scrollPane1;
    private JTable pdtTransTable;
    private JScrollPane scrollPane2;
    private JTable cart_items_table;
    private JLabel Products;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
