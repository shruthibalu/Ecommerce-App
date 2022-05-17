import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class AddProduct extends JFrame {
    String category,productid,productname;
    int quantity;
    String price;
    String rating;
    String cc,pp;
    int q;
    DefaultTableModel cat=new DefaultTableModel();
    DefaultTableModel product=new DefaultTableModel();
    public AddProduct() {
        initComponents();
        ProductsTable();
        showCategoriesTable();
    }

    private void AddtoInventoryBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        category= (String) categoryComBox.getSelectedItem();
        //productid=pdtIdTxtFld.getText();
        productname=pdtName.getText();
        quantity= (int) stockvalue.getValue();
        rating=ratingtxtfld.getText();
        price=priceTxtFld.getText();

        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
            Statement stmt=con.createStatement();

            //ResultSet rs=stmt.executeQuery("select cust_no from customers_list");
            //while(rs.next())
              //  cusno=rs.getInt(1);
            //cusno++;
            String insert_query="insert into products values(?,product_id_sequence.nextval,?,?,?,?)";
            PreparedStatement preSt=con.prepareStatement(insert_query);
            preSt.setString(1,category);
            preSt.setString(2,productname);
            preSt.setInt(3, Integer.parseInt(price));
            preSt.setFloat(4, Float.parseFloat(rating));
            preSt.setInt(5,quantity);
            //preSt.setString(7, address);
            //preSt.setString(8,city);
            //cusno++;
            preSt.executeUpdate();
            con.close();

            JOptionPane.showMessageDialog(this ,"Product added to Inventory");
            //ShoppingPage shop=new ShoppingPage();
            //shop.username=u_name;


            //con.close();

        }catch(Exception f){JOptionPane.showMessageDialog(this,f);}


        product.setRowCount(0);
        cat.setRowCount(0);

        ProductsTable();
        showCategoriesTable();



    }

    private void updateBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        cc= (String) categoryCombox.getSelectedItem();
        pp= (String) productCombox.getSelectedItem();
        q= (int) pdtstock.getValue();
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
            Statement stmt=con.createStatement();
            final String queryCheck = "update products set no_stock=no_stock + ? where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setInt(1,q);
            ps.setString(2,pp);
            ResultSet rs = ps.executeQuery();
            con.close();
        }catch(Exception f){ System.out.println(f);}
        JOptionPane.showMessageDialog(this ,"Stock for "+pp+" Updated Successfully");
        product.setRowCount(0);
        cat.setRowCount(0);
        ProductsTable();
        showCategoriesTable();
    }

    private void categoryComBoxActionPerformed(ActionEvent e) {
        // TODO add your code here


    }

    private void categoryComboxActionPerformed(ActionEvent e) {
        // TODO add your code here
        productCombox.removeAllItems();
        cc= (String) categoryCombox.getSelectedItem();
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from samplelogin");
            //JOptionPane.showMessageDialog(adminLoginPage,"Login Successful");
            final String queryCheck = "SELECT pdt_name from products where cat_id = ?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, (String) categoryCombox.getSelectedItem());
            //ps.setString(2,pwd);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                productCombox.addItem(rs.getString(1));
               // clothesPrice.setText(rs.getString(2));

            }


            con.close();


        }catch(Exception f){ System.out.println(f);}




    }

    private void initComponents() {
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        categoryComBox = new JComboBox();
        label4 = new JLabel();
        pdtName = new JTextField();
        label5 = new JLabel();
        stockvalue = new JSpinner();
        label6 = new JLabel();
        ratingtxtfld = new JTextField();
        AddtoInventoryBtn = new JButton();
        label13 = new JLabel();
        priceTxtFld = new JTextField();
        panel3 = new JPanel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        categoryCombox = new JComboBox();
        productCombox = new JComboBox();
        label10 = new JLabel();
        pdtstock = new JSpinner();
        updateBtn = new JButton();
        scrollPane1 = new JScrollPane();
        categoryTable = new JTable(cat);
        label11 = new JLabel();
        label12 = new JLabel();
        scrollPane2 = new JScrollPane();
        productstable = new JTable(product);

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setBorder(LineBorder.createBlackLineBorder());

                //---- label1 ----
                label1.setText("Add Product");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setFont(new Font("Segoe UI", Font.BOLD, 16));

                //---- label2 ----
                label2.setText("Category");
                label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- categoryComBox ----
                categoryComBox.addActionListener(e -> categoryComBoxActionPerformed(e));

                //---- label4 ----
                label4.setText("Product Name");
                label4.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- pdtName ----
                pdtName.setBorder(LineBorder.createBlackLineBorder());

                //---- label5 ----
                label5.setText("Quantity");
                label5.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- stockvalue ----
                stockvalue.setBorder(LineBorder.createBlackLineBorder());

                //---- label6 ----
                label6.setText("Rating");
                label6.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- ratingtxtfld ----
                ratingtxtfld.setBorder(LineBorder.createBlackLineBorder());

                //---- AddtoInventoryBtn ----
                AddtoInventoryBtn.setText("Add to Inventory");
                AddtoInventoryBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                AddtoInventoryBtn.addActionListener(e -> AddtoInventoryBtnActionPerformed(e));

                //---- label13 ----
                label13.setText("Price");
                label13.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- priceTxtFld ----
                priceTxtFld.setBorder(LineBorder.createBlackLineBorder());

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addComponent(AddtoInventoryBtn, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(stockvalue, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 35, Short.MAX_VALUE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 14, Short.MAX_VALUE))
                                                .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                                            .addGap(18, 18, 18)
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addComponent(ratingtxtfld, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 6, Short.MAX_VALUE))
                                                .addComponent(categoryComBox)))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(priceTxtFld, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 6, Short.MAX_VALUE))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(pdtName)))))
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(categoryComBox, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pdtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(stockvalue, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                            .addGap(24, 24, 24)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ratingtxtfld, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceTxtFld, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                            .addGap(33, 33, 33)
                            .addComponent(AddtoInventoryBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21))
                );
            }

            //======== panel3 ========
            {
                panel3.setBackground(Color.white);
                panel3.setBorder(LineBorder.createBlackLineBorder());

                //---- label7 ----
                label7.setText("Update Stock");
                label7.setFont(new Font("Segoe UI", Font.BOLD, 16));
                label7.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label8 ----
                label8.setText("Category");
                label8.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- label9 ----
                label9.setText("Product Name");
                label9.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- categoryCombox ----
                categoryCombox.addActionListener(e -> categoryComboxActionPerformed(e));

                //---- label10 ----
                label10.setText("Add Stock");
                label10.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- pdtstock ----
                pdtstock.setBorder(LineBorder.createBlackLineBorder());

                //---- updateBtn ----
                updateBtn.setText("Update");
                updateBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                updateBtn.addActionListener(e -> updateBtnActionPerformed(e));

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addComponent(productCombox)
                                        .addComponent(categoryCombox)))
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(pdtstock, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 25, Short.MAX_VALUE)))
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                            .addGap(0, 59, Short.MAX_VALUE)
                            .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addGap(55, 55, 55))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addComponent(categoryCombox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(productCombox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label10, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                .addComponent(pdtstock, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
        }

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(categoryTable);
        }

        //---- label11 ----
        label11.setText("Category");
        label11.setFont(new Font("Segoe UI", Font.BOLD, 16));

        //---- label12 ----
        label12.setText("Products");
        label12.setFont(new Font("Segoe UI", Font.BOLD, 16));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(productstable);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label12, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 252, Short.MAX_VALUE))
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 138, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        cat.addColumn("category_id");
        cat.addColumn("category_Name");
        cat.addColumn("No_products");


        product.addColumn("Category Id");
        product.addColumn("Product Id");
        product.addColumn("Product Name");
        product.addColumn("Product Price");
        product.addColumn("Rating");
        product.addColumn("Stock");

        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from samplelogin");
            //JOptionPane.showMessageDialog(adminLoginPage,"Login Successful");
            ResultSet rs=stmt.executeQuery("select category_id from category");
            //String pdt;
            while(rs.next()){
                categoryCombox.addItem(rs.getString(1));
                categoryComBox.addItem(rs.getString(1));

                // mobilesComBox.addItem(rs.getString());
            }


            con.close();


        }catch(Exception f){ System.out.println(f);}





        this.setVisible(true);

    }
    void showCategoriesTable(){
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt = con.createStatement();

//step4 execute query
            ResultSet rs = stmt.executeQuery("select * from category");
            while (rs.next())
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                cat.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getInt(3)});


//step5 close the connection object
            con.close();

        } catch (Exception f) {
            System.out.println(f);
        }



    }

    void ProductsTable(){
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt = con.createStatement();

//step4 execute query
            ResultSet rs = stmt.executeQuery("select * from products");
            while (rs.next())
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                product.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
            con.close();

        } catch (Exception f) {
            System.out.println(f);
        }


    }

    
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JComboBox categoryComBox;
    private JLabel label4;
    private JTextField pdtName;
    private JLabel label5;
    private JSpinner stockvalue;
    private JLabel label6;
    private JTextField ratingtxtfld;
    private JButton AddtoInventoryBtn;
    private JLabel label13;
    private JTextField priceTxtFld;
    private JPanel panel3;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JComboBox categoryCombox;
    private JComboBox productCombox;
    private JLabel label10;
    private JSpinner pdtstock;
    private JButton updateBtn;
    private JScrollPane scrollPane1;
    private JTable categoryTable;
    private JLabel label11;
    private JLabel label12;
    private JScrollPane scrollPane2;
    private JTable productstable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        AddProduct ap=new AddProduct();
    }

}
