import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class SearchProduct {
    DefaultTableModel pdts=new DefaultTableModel();
    public SearchProduct() {
        initComponents();
    }

    private void ratingcat1ActionPerformed(ActionEvent e) {
        if(ratingcat1.isSelected()) {


            pdts.setRowCount(0);
            // TODO add your code here
            try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_rating < 3.5");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }
        }



    }

    private void ratingcat2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(ratingcat2.isSelected()) {


            pdts.setRowCount(0);

            // TODO add your code here
            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_rating >3.5 and pdt_rating<4");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }
        }
    }

    private void ratingcat3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(ratingcat3.isSelected()) {

            pdts.setRowCount(0);

            // TODO add your code here
            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_rating >4 and pdt_rating<4.5");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }
        }

    }

    private void ratingcat4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(ratingcat4.isSelected()) {


            pdts.setRowCount(0);

            // TODO add your code here
            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_rating >4.5");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }
        }
    }

    private void pricecat1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(pricecat1.isSelected()){
            pdts.setRowCount(0);

            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_price<3000");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }

        }
    }

    private void pricecat2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(pricecat2.isSelected()){
            pdts.setRowCount(0);

            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_price>=3000 and pdt_price<6000");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }

        }
    }

    private void pricecat3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(pricecat3.isSelected()){
            pdts.setRowCount(0);

            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_price>=6000 and pdt_price<20000");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }

        }
    }

    private void pricecat4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(pricecat4.isSelected()){
            pdts.setRowCount(0);

            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_price>=20000 and pdt_price<35000");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }

        }
    }

    private void pricecat5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(pricecat5.isSelected()){
            pdts.setRowCount(0);

            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_price>=35000 and pdt_price<60000");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }

        }
    }

    private void pricecat6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(pricecat6.isSelected()){
            pdts.setRowCount(0);

            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
                Statement stmt = con.createStatement();

//step4 execute query
                ResultSet rs = stmt.executeQuery("select * from products where pdt_price>=60000");
                while (rs.next())
                    //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                    pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
                con.close();

            } catch (Exception f) {
                System.out.println(f);
            }

        }
    }

    private void outStockBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        int num;
        pdts.setRowCount(0);

        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
//step3 create the statement object
            Statement stmt = con.createStatement();

//step4 execute query
            ResultSet rs = stmt.executeQuery("select * from products where no_stock<20");
            while (rs.next()) {
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});
                num=rs.getInt(6);
                if(num == 0){
                    JOptionPane.showMessageDialog(pdtFrame,"All products have the Minimum required Stock");
                }
            }

//step5 close the connection object
            con.close();

        } catch (Exception f) {
            System.out.println(f);
        }

    }

    private void viewallPdtsActionPerformed(ActionEvent e) {
        // TODO add your code here
        pdts.setRowCount(0);

        try {

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from products");
            while (rs.next())
                pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});

            con.close();
        } catch (Exception f) {
            System.out.println(f);
        }
    }

    private void catComBoxActionPerformed(ActionEvent e) {
        // TODO add your code here
        String cat= (String) catComBox.getSelectedItem();
        pdts.setRowCount(0);

        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt = con.createStatement();

//step4 execute query
            //ResultSet rs = stmt.executeQuery("select * from products");
            String queryCheck = "select * from products where cat_id=?";//and date_added<=";//and date_added<=to_timestamp('? 23:59:59','mm/dd/yyyy hh24:mi:ss')";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,cat);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                pdts.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)});


//step5 close the connection object
            con.close();

        } catch (Exception f) {
            System.out.println(f);
        }
    }

    private void initComponents() {
        
        pdtFrame = new JFrame();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        ratingcat1 = new JRadioButton();
        ratingcat3 = new JRadioButton();
        ratingcat2 = new JRadioButton();
        ratingcat4 = new JRadioButton();
        panel3 = new JPanel();
        label2 = new JLabel();
        pricecat1 = new JRadioButton();
        pricecat2 = new JRadioButton();
        pricecat3 = new JRadioButton();
        pricecat4 = new JRadioButton();
        pricecat5 = new JRadioButton();
        pricecat6 = new JRadioButton();
        outStockBtn = new JButton();
        viewallPdts = new JButton();
        catComBox = new JComboBox<>();
        scrollPane1 = new JScrollPane();
        searchPdttable = new JTable(pdts);

        //======== pdtFrame ========
        {
            var pdtFrameContentPane = pdtFrame.getContentPane();

            //======== panel1 ========
            {
                panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
                EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing
                . border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,
                java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
                { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )
                throw new RuntimeException( ) ;} } );

                //======== panel2 ========
                {
                    panel2.setBackground(Color.white);
                    panel2.setBorder(LineBorder.createBlackLineBorder());

                    //---- label1 ----
                    label1.setText("Sort by Rating :");

                    //---- ratingcat1 ----
                    ratingcat1.setText("3 to 3.5");
                    ratingcat1.addActionListener(e -> ratingcat1ActionPerformed(e));

                    //---- ratingcat3 ----
                    ratingcat3.setText("4 to 4.5");
                    ratingcat3.addActionListener(e -> ratingcat3ActionPerformed(e));

                    //---- ratingcat2 ----
                    ratingcat2.setText("3.5 to 4");
                    ratingcat2.addActionListener(e -> ratingcat2ActionPerformed(e));

                    //---- ratingcat4 ----
                    ratingcat4.setText("4.5 to 5");
                    ratingcat4.addActionListener(e -> ratingcat4ActionPerformed(e));

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(ratingcat3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ratingcat1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ratingcat2, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                            .addComponent(ratingcat4, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(ratingcat1)
                                    .addComponent(ratingcat2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(ratingcat3)
                                    .addComponent(ratingcat4))
                                .addContainerGap(33, Short.MAX_VALUE))
                    );
                }

                //======== panel3 ========
                {
                    panel3.setBackground(Color.white);
                    panel3.setBorder(LineBorder.createBlackLineBorder());

                    //---- label2 ----
                    label2.setText("Sort By Price  :");

                    //---- pricecat1 ----
                    pricecat1.setText("<3K");
                    pricecat1.addActionListener(e -> pricecat1ActionPerformed(e));

                    //---- pricecat2 ----
                    pricecat2.setText("3K to 6k");
                    pricecat2.addActionListener(e -> pricecat2ActionPerformed(e));

                    //---- pricecat3 ----
                    pricecat3.setText("6K to 20K");
                    pricecat3.addActionListener(e -> pricecat3ActionPerformed(e));

                    //---- pricecat4 ----
                    pricecat4.setText("20K to 35K");
                    pricecat4.addActionListener(e -> pricecat4ActionPerformed(e));

                    //---- pricecat5 ----
                    pricecat5.setText("35K to 60k");
                    pricecat5.addActionListener(e -> pricecat5ActionPerformed(e));

                    //---- pricecat6 ----
                    pricecat6.setText(">60K");
                    pricecat6.addActionListener(e -> pricecat6ActionPerformed(e));

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(pricecat5, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pricecat6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGroup(panel3Layout.createParallelGroup()
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(pricecat1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                                    .addComponent(pricecat3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                                .addGroup(panel3Layout.createParallelGroup()
                                                    .addGroup(panel3Layout.createSequentialGroup()
                                                        .addGap(9, 9, 9)
                                                        .addComponent(pricecat2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panel3Layout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(pricecat4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(pricecat2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pricecat1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(pricecat3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pricecat4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(pricecat5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pricecat6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(29, Short.MAX_VALUE))
                    );
                }

                //---- outStockBtn ----
                outStockBtn.setText("View Low Stock Products");
                outStockBtn.addActionListener(e -> outStockBtnActionPerformed(e));

                //---- viewallPdts ----
                viewallPdts.setText("View All Products");
                viewallPdts.addActionListener(e -> viewallPdtsActionPerformed(e));

                //---- catComBox ----
                catComBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "CA1",
                    "CA2",
                    "CA3",
                    "CA4",
                    "CA5",
                    "CA6"
                }));
                catComBox.addActionListener(e -> catComBoxActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addComponent(catComBox, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addComponent(outStockBtn, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addComponent(viewallPdts, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(catComBox, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(outStockBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(viewallPdts, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(217, Short.MAX_VALUE))
                );
            }

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(searchPdttable);
            }

            GroupLayout pdtFrameContentPaneLayout = new GroupLayout(pdtFrameContentPane);
            pdtFrameContentPane.setLayout(pdtFrameContentPaneLayout);
            pdtFrameContentPaneLayout.setHorizontalGroup(
                pdtFrameContentPaneLayout.createParallelGroup()
                    .addGroup(pdtFrameContentPaneLayout.createSequentialGroup()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                        .addContainerGap())
            );
            pdtFrameContentPaneLayout.setVerticalGroup(
                pdtFrameContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pdtFrameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                        .addContainerGap())
            );
            pdtFrame.pack();
            pdtFrame.setLocationRelativeTo(pdtFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(ratingcat1);
        bg1.add(ratingcat2);
        bg1.add(ratingcat3);
        bg1.add(ratingcat4);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(pricecat1);
        bg2.add(pricecat2);
        bg2.add(pricecat3);
        bg2.add(pricecat4);
        bg2.add(pricecat5);
        bg2.add(pricecat6);



        pdtFrame.setVisible(true);
        pdts.addColumn("Category ID");
        pdts.addColumn("Product ID");
        pdts.addColumn("Product Name");
        pdts.addColumn("Product Price");
        pdts.addColumn("Rating");
        pdts.addColumn("Stock");
    }

    
    private JFrame pdtFrame;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JRadioButton ratingcat1;
    private JRadioButton ratingcat3;
    private JRadioButton ratingcat2;
    private JRadioButton ratingcat4;
    private JPanel panel3;
    private JLabel label2;
    private JRadioButton pricecat1;
    private JRadioButton pricecat2;
    private JRadioButton pricecat3;
    private JRadioButton pricecat4;
    private JRadioButton pricecat5;
    private JRadioButton pricecat6;
    private JButton outStockBtn;
    private JButton viewallPdts;
    private JComboBox<String> catComBox;
    private JScrollPane scrollPane1;
    private JTable searchPdttable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        SearchProduct sp=new SearchProduct();
    }
}
