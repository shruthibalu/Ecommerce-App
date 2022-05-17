import java.awt.event.*;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

public class ShoppingPage {
    String selectedphone,selectedbook,selectedwatch,selectedshoe,selectedcomputer,selecteddress,price;
    public String username;
    public int total=0;
    long millis=System.currentTimeMillis();
    java.sql.Date date=new java.sql.Date(millis);

    DefaultListModel<String> cartitemsarr = new DefaultListModel<>();
    DefaultListModel<String> cartitemsPrice = new DefaultListModel<>();

    public ShoppingPage() {
        initComponents();
    }

    private void mobilesComBoxActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();
            selectedphone= (String) mobilesComBox.getItemAt(mobilesComBox.getSelectedIndex());
            final String queryCheck = "SELECT pdt_rating,pdt_price from products where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, (String) mobilesComBox.getSelectedItem());
            //ps.setString(2,pwd);
            final ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                mobileRatingLbl.setText(rs.getString(1));
                mobilePrice.setText(rs.getString(2));

            }
            con.close();
        }catch(Exception f){ System.out.println(f);}

    }

    private void footwearsComBoxActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{

        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

            Statement stmt=con.createStatement();
            selectedshoe= (String) footwearsComBox.getItemAt(footwearsComBox.getSelectedIndex());
            final String queryCheck = "SELECT pdt_rating,pdt_price from products where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, (String) footwearsComBox.getSelectedItem());
            //ps.setString(2,pwd);
            final ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                shoeRatingLbl.setText(rs.getString(1));
                shoesPrice.setText(rs.getString(2));

            }
            con.close();
        }catch(Exception f){ System.out.println(f);}
    }

    private void booksComBoxActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");


            Statement stmt=con.createStatement();
            selectedbook= (String) booksComBox.getItemAt(booksComBox.getSelectedIndex());
            final String queryCheck = "SELECT pdt_rating,pdt_price from products where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, (String) booksComBox.getSelectedItem());
            //ps.setString(2,pwd);
            final ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                booksRatingLbl.setText(rs.getString(1));
                booksPrice.setText(rs.getString(2));

            }
            con.close();
        }catch(Exception f){ System.out.println(f);}
    }

    private void watchesComBoxActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

            Statement stmt=con.createStatement();
            selectedwatch= (String) watchesComBox.getItemAt(watchesComBox.getSelectedIndex());
            final String queryCheck = "SELECT pdt_rating,pdt_price from products where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, (String) watchesComBox.getSelectedItem());
            //ps.setString(2,pwd);
            final ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                watchRatingLbl.setText(rs.getString(1));
                watchesPrice.setText(rs.getString(2));

            }
            con.close();
        }catch(Exception f){ System.out.println(f);}

    }

    private void computersCmbBoxActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();
            selectedcomputer= (String) computersCmbBox.getItemAt(computersCmbBox.getSelectedIndex());
            final String queryCheck = "SELECT pdt_rating,pdt_price from products where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, (String) computersCmbBox.getSelectedItem());
            //ps.setString(2,pwd);
            final ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                computersRatingLbl.setText(rs.getString(1));
                computersPrice.setText(rs.getString(2));

            }
            con.close();
        }catch(Exception f){ System.out.println(f);}

    }

    private void ClothesCmbBoxActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");


            Statement stmt=con.createStatement();
            selecteddress= (String) ClothesCmbBox.getSelectedItem();
            final String queryCheck = "SELECT pdt_rating,pdt_price from products where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, (String) ClothesCmbBox.getSelectedItem());
            //ps.setString(2,pwd);
            final ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                clothesRatingLbl.setText(rs.getString(1));
                clothesPrice.setText(rs.getString(2));

            }
            con.close();
        }catch(Exception f){ System.out.println(f);}

    }

    private void buyMobilesBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        price=mobilePrice.getText();
        total+=Integer.parseInt(price);
        cartitemsarr.addElement(selectedphone);
        cartitemsPrice.addElement(price);
        totalLbl.setText(String.valueOf(total));

        try{

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

            Statement stmt=con.createStatement();

            final String queryCheck = "update products set no_stock=no_stock-1 where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,selectedphone);

             ResultSet rs = ps.executeQuery();
             con.close();
        }catch(Exception f){ System.out.println(f);}
    }

    private void buyFootwearsBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        price=shoesPrice.getText();
        total+=Integer.parseInt(price);
        cartitemsarr.addElement(selectedshoe);
        cartitemsPrice.addElement(price);
        totalLbl.setText(String.valueOf(total));

        try{

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

            Statement stmt=con.createStatement();

            final String queryCheck = "update products set no_stock=no_stock-1 where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,selectedshoe);

            final ResultSet rs = ps.executeQuery();

            con.close();
        }catch(Exception f){ System.out.println(f);}
    }

    private void buyBooksBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        price=booksPrice.getText();
        total+=Integer.parseInt(price);
        cartitemsarr.addElement(selectedbook);
        cartitemsPrice.addElement(price);

        totalLbl.setText(String.valueOf(total));

        try{

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

            Statement stmt=con.createStatement();

            final String queryCheck = "update products set no_stock=no_stock-1 where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,selectedbook);

            final ResultSet rs = ps.executeQuery();

            con.close();
        }catch(Exception f){ System.out.println(f);}


    }

    private void buyWatchesBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        price=watchesPrice.getText();
        total+=Integer.parseInt(price);
        cartitemsarr.addElement(selectedwatch);
        cartitemsPrice.addElement(price);

        totalLbl.setText(String.valueOf(total));
        try{

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

            Statement stmt=con.createStatement();

            final String queryCheck = "update products set no_stock=no_stock-1 where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,selectedwatch);

            final ResultSet rs = ps.executeQuery();

            con.close();
        }catch(Exception f){ System.out.println(f);}


    }


   /* private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }*/

   private void buyClothesBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        price=clothesPrice.getText();
        total+=Integer.parseInt(price);
        cartitemsarr.addElement(selecteddress);
        cartitemsPrice.addElement(price);

        totalLbl.setText(String.valueOf(total));
        try{

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

            Statement stmt=con.createStatement();

            final String queryCheck = "update products set no_stock=no_stock-1 where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,selecteddress);

            final ResultSet rs = ps.executeQuery();

            con.close();
        }catch(Exception f){ System.out.println(f);}

    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buyCompButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        price=computersPrice.getText();
        total+=Integer.parseInt(price);
        cartitemsarr.addElement(selectedcomputer);
        cartitemsPrice.addElement(price);

        totalLbl.setText(String.valueOf(total));

        try{

        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
            Statement stmt=con.createStatement();

            final String queryCheck = "update products set no_stock=no_stock-1 where pdt_name=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1,selectedcomputer);

            final ResultSet rs = ps.executeQuery();

            con.close();
        }catch(Exception f){ System.out.println(f);}
    }

    private void paymentBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query

            String insert_query="insert into purchases values(purchase_no_sequence.nextval,?,?,?,?)";
            PreparedStatement preSt=con.prepareStatement(insert_query);
           // preSt.setInt(1,custcount);
            preSt.setString(1,username);
            preSt.setInt(2,cartitemsarr.getSize());
            preSt.setInt(3, Integer.parseInt(totalLbl.getText()));
            preSt.setDate(4,date);

            preSt.executeUpdate();

           for(int i=0;i<cartitemsarr.size();i++){

               insert_query="insert into cart_items values(?,?,?)";
               preSt=con.prepareStatement(insert_query);

               preSt.setString(1,username);
               preSt.setString(2,(cartitemsarr.getElementAt(i)));
               preSt.setDate(3,date);
               preSt.executeUpdate();
           }
            con.close();
       }catch(Exception f){ System.out.println(f);}

        PaymentPage p=new PaymentPage(total);
       ShoppingPage.dispose();

        //page.amt=total;

    }

    private void logoutBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        MainLogin m=new MainLogin();
        ShoppingPage.dispose();
    }

    private void viewProfMenuActionPerformed(ActionEvent e) {
        // TODO add your code here
        new CustomerProfile(username).setVisible(true);
        //cp.un=username;
    }

    private void viewPurPdtmenuActionPerformed(ActionEvent e) {
        // TODO add your code here
        new CustPurchasedProducts(username).setVisible(true);
    }

    private void logOutBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        MainLogin a=new MainLogin();
        ShoppingPage.dispose();
    }


   // private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    //}

    private void initComponents() {
        
        ShoppingPage = new JFrame();
        menuBar1 = new JMenuBar();
        viewProfbtn = new JMenu();
        viewProfMenu = new JMenuItem();
        logoutBtn = new JMenu();
        viewPurPdtmenu = new JMenuItem();
        logOutBtn = new JButton();
        ShoppingLeftPane = new JPanel();
        cartLabel = new JLabel();
        scrollPane3 = new JScrollPane();
        cartList = new JList(cartitemsarr);
        paymentBtn = new JButton();
        totalLbl = new JLabel();
        label10 = new JLabel();
        scrollPane4 = new JScrollPane();
        cartPriceList = new JList(cartitemsPrice);
        label9 = new JLabel();
        panel1 = new JPanel();
        mobilesComBox = new JComboBox();
        mobilePhonesLbl = new JLabel();
        buyMobilesBtn = new JButton();
        label3 = new JLabel();
        footwearsLbl = new JLabel();
        footwearsComBox = new JComboBox();
        buyFootwearsBtn = new JButton();
        label1 = new JLabel();
        label5 = new JLabel();
        booksLbl = new JLabel();
        booksComBox = new JComboBox();
        buyBooksBtn = new JButton();
        label8 = new JLabel();
        watchesLbl = new JLabel();
        watchesComBox = new JComboBox();
        buyWatchesBtn = new JButton();
        mobilePrice = new JLabel();
        shoesPrice = new JLabel();
        booksPrice = new JLabel();
        watchesPrice = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        mobilerating = new JLabel();
        mobileRatingLbl = new JLabel();
        label12 = new JLabel();
        shoeRatingLbl = new JLabel();
        label14 = new JLabel();
        booksRatingLbl = new JLabel();
        label16 = new JLabel();
        watchRatingLbl = new JLabel();
        label18 = new JLabel();
        computerLbl = new JLabel();
        computersCmbBox = new JComboBox();
        label20 = new JLabel();
        computersPrice = new JLabel();
        label22 = new JLabel();
        computersRatingLbl = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        ClothesCmbBox = new JComboBox();
        clothesLbl = new JLabel();
        clothesPrice = new JLabel();
        label28 = new JLabel();
        clothesRatingLbl = new JLabel();
        buyClothesBtn = new JButton();
        buyCompButton = new JButton();
        scrollPane2 = new JScrollPane();
        scrollPane1 = new JScrollPane();

        //======== ShoppingPage ========
        {
            ShoppingPage.setTitle("Shopping Page");
            var ShoppingPageContentPane = ShoppingPage.getContentPane();

            //======== menuBar1 ========
            {

                //======== viewProfbtn ========
                {
                    viewProfbtn.setText("Profile");
                    viewProfbtn.setBackground(new Color(204, 204, 204));
                    viewProfbtn.setBorder(LineBorder.createBlackLineBorder());

                    //---- viewProfMenu ----
                    viewProfMenu.setText("View and Edit Profile");
                    viewProfMenu.addActionListener(e -> viewProfMenuActionPerformed(e));
                    viewProfbtn.add(viewProfMenu);
                }
                menuBar1.add(viewProfbtn);

                //======== logoutBtn ========
                {
                    logoutBtn.setText("Actions");
                    logoutBtn.setBackground(new Color(204, 204, 204));
                    logoutBtn.setBorder(new LineBorder(Color.black, 1, true));
                    logoutBtn.addActionListener(e -> logoutBtnActionPerformed(e));

                    //---- viewPurPdtmenu ----
                    viewPurPdtmenu.setText("View History");
                    viewPurPdtmenu.addActionListener(e -> viewPurPdtmenuActionPerformed(e));
                    logoutBtn.add(viewPurPdtmenu);
                }
                menuBar1.add(logoutBtn);

                //---- logOutBtn ----
                logOutBtn.setText("LogOut");
                logOutBtn.addActionListener(e -> logOutBtnActionPerformed(e));
                menuBar1.add(logOutBtn);
            }
            ShoppingPage.setJMenuBar(menuBar1);

            //======== ShoppingLeftPane ========
            {
                ShoppingLeftPane.setBackground(new Color(204, 204, 204));
                ShoppingLeftPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
                swing.border.EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border
                .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069al\u006fg"
                ,java.awt.Font.BOLD,12),java.awt.Color.red),ShoppingLeftPane. getBorder
                ()));ShoppingLeftPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
                .beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.getPropertyName()))throw new RuntimeException
                ();}});

                //---- cartLabel ----
                cartLabel.setText("Your Cart ");

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(cartList);
                }

                //---- paymentBtn ----
                paymentBtn.setText("Proceed to Payment");
                paymentBtn.addActionListener(e -> paymentBtnActionPerformed(e));

                //---- label10 ----
                label10.setText("       Total :");

                //======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(cartPriceList);
                }

                //---- label9 ----
                label9.setText("Rs.");

                GroupLayout ShoppingLeftPaneLayout = new GroupLayout(ShoppingLeftPane);
                ShoppingLeftPane.setLayout(ShoppingLeftPaneLayout);
                ShoppingLeftPaneLayout.setHorizontalGroup(
                    ShoppingLeftPaneLayout.createParallelGroup()
                        .addGroup(ShoppingLeftPaneLayout.createSequentialGroup()
                            .addGroup(ShoppingLeftPaneLayout.createParallelGroup()
                                .addGroup(ShoppingLeftPaneLayout.createSequentialGroup()
                                    .addGroup(ShoppingLeftPaneLayout.createParallelGroup()
                                        .addComponent(cartLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ShoppingLeftPaneLayout.createParallelGroup()
                                        .addGroup(ShoppingLeftPaneLayout.createSequentialGroup()
                                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(ShoppingLeftPaneLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
                                .addGroup(ShoppingLeftPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(ShoppingLeftPaneLayout.createParallelGroup()
                                        .addGroup(ShoppingLeftPaneLayout.createSequentialGroup()
                                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(totalLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(paymentBtn, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
                            .addContainerGap())
                );
                ShoppingLeftPaneLayout.setVerticalGroup(
                    ShoppingLeftPaneLayout.createParallelGroup()
                        .addGroup(ShoppingLeftPaneLayout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addGroup(ShoppingLeftPaneLayout.createParallelGroup()
                                .addComponent(cartLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGroup(ShoppingLeftPaneLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(ShoppingLeftPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(ShoppingLeftPaneLayout.createParallelGroup()
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(totalLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(paymentBtn)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            //======== panel1 ========
            {

                //---- mobilesComBox ----
                mobilesComBox.addActionListener(e -> mobilesComBoxActionPerformed(e));

                //---- mobilePhonesLbl ----
                mobilePhonesLbl.setText("Mobile Phones");

                //---- buyMobilesBtn ----
                buyMobilesBtn.setText("Add to Cart");
                buyMobilesBtn.addActionListener(e -> buyMobilesBtnActionPerformed(e));

                //---- label3 ----
                label3.setText("text");
                label3.setBorder(LineBorder.createBlackLineBorder());
                label3.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\shoe.png"));

                //---- footwearsLbl ----
                footwearsLbl.setText("Footwears");

                //---- footwearsComBox ----
                footwearsComBox.addActionListener(e -> footwearsComBoxActionPerformed(e));

                //---- buyFootwearsBtn ----
                buyFootwearsBtn.setText("Add to Cart");
                buyFootwearsBtn.addActionListener(e -> buyFootwearsBtnActionPerformed(e));

                //---- label1 ----
                label1.setText("text");
                label1.setBorder(LineBorder.createBlackLineBorder());
                label1.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\phoneIcon.jpg"));

                //---- label5 ----
                label5.setText("text");
                label5.setBorder(LineBorder.createBlackLineBorder());
                label5.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\books.png"));

                //---- booksLbl ----
                booksLbl.setText("Books");

                //---- booksComBox ----
                booksComBox.addActionListener(e -> booksComBoxActionPerformed(e));

                //---- buyBooksBtn ----
                buyBooksBtn.setText("Add to Cart");
                buyBooksBtn.addActionListener(e -> buyBooksBtnActionPerformed(e));

                //---- label8 ----
                label8.setText("text");
                label8.setBorder(LineBorder.createBlackLineBorder());
                label8.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\watchicon.png"));

                //---- watchesLbl ----
                watchesLbl.setText("Watches");

                //---- watchesComBox ----
                watchesComBox.addActionListener(e -> watchesComBoxActionPerformed(e));

                //---- buyWatchesBtn ----
                buyWatchesBtn.setText("Add to Cart");
                buyWatchesBtn.addActionListener(e -> buyWatchesBtnActionPerformed(e));

                //---- watchesPrice ----
                watchesPrice.setText(" ");

                //---- label2 ----
                label2.setText("Price :   Rs.");

                //---- label4 ----
                label4.setText("Price :   Rs.");

                //---- label6 ----
                label6.setText("Price :     Rs.");

                //---- label7 ----
                label7.setText("Price :   Rs.");

                //---- mobilerating ----
                mobilerating.setText("Rating :");

                //---- label12 ----
                label12.setText("Rating :");

                //---- label14 ----
                label14.setText("Rating :");

                //---- label16 ----
                label16.setText("Rating :");

                //---- label18 ----
                label18.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\computericon.png"));

                //---- computerLbl ----
                computerLbl.setText("Computers/Appliances");

                //---- computersCmbBox ----
                computersCmbBox.addActionListener(e -> computersCmbBoxActionPerformed(e));

                //---- label20 ----
                label20.setText("Price :    Rs.    ");

                //---- computersPrice ----
                computersPrice.setText("text");

                //---- label22 ----
                label22.setText("Rating :");

                //---- label24 ----
                label24.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\shirticon.png"));

                //---- label25 ----
                label25.setText("Price  Rs .");

                //---- ClothesCmbBox ----
                ClothesCmbBox.addActionListener(e -> ClothesCmbBoxActionPerformed(e));

                //---- clothesLbl ----
                clothesLbl.setText("Clothes");

                //---- label28 ----
                label28.setText("Rating :");

                //---- buyClothesBtn ----
                buyClothesBtn.setText("Add  to  Cart");
                buyClothesBtn.addActionListener(e -> {
			button2ActionPerformed(e);
			buyClothesBtnActionPerformed(e);
		});

                //---- buyCompButton ----
                buyCompButton.setText("Add to Cart");
                buyCompButton.addActionListener(e -> buyCompButtonActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label18, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(computerLbl, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                        .addComponent(computersCmbBox, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label20, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(computersPrice, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label22, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(computersRatingLbl, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                        .addComponent(buyCompButton, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                    .addComponent(label24, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(booksRatingLbl, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                        .addComponent(booksPrice, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                                                .addComponent(buyBooksBtn, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(booksComBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                                    .addComponent(booksLbl, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(buyMobilesBtn, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 81, Short.MAX_VALUE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(mobilesComBox, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(mobilePhonesLbl, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(mobilePrice, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(mobilerating, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(33, 33, 33)
                                                    .addComponent(mobileRatingLbl, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)))
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label8, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))))
                            .addGap(37, 37, 37)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(footwearsComBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(footwearsLbl, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(shoesPrice, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addGap(61, 61, 61))
                                    .addComponent(clothesLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                            .addComponent(label16, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(watchRatingLbl, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(buyWatchesBtn, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ClothesCmbBox, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(label28, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(label25, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(clothesPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(clothesRatingLbl, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addComponent(buyClothesBtn, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(shoeRatingLbl, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(watchesPrice, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(watchesComBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(watchesLbl, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(buyFootwearsBtn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(footwearsLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(footwearsComBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(shoesPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(label12, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(shoeRatingLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(18, 18, 18)
                                            .addComponent(buyFootwearsBtn, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(mobilePhonesLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(mobilesComBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(mobilePrice, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addComponent(mobilerating, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(mobileRatingLbl, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buyMobilesBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(label1))
                                            .addGap(0, 6, Short.MAX_VALUE))))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(watchesLbl, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(watchesComBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(watchesPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label16, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(watchRatingLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buyWatchesBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(booksLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(booksComBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(booksPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(label14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(booksRatingLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buyBooksBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(clothesLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ClothesCmbBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label25, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addComponent(clothesPrice, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label28, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clothesRatingLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buyClothesBtn))
                                .addComponent(label18, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(computerLbl, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(computersCmbBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label20, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                        .addComponent(computersPrice, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label22, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                        .addComponent(computersRatingLbl, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buyCompButton))
                                .addComponent(label24, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(32, Short.MAX_VALUE))
                );
            }

            GroupLayout ShoppingPageContentPaneLayout = new GroupLayout(ShoppingPageContentPane);
            ShoppingPageContentPane.setLayout(ShoppingPageContentPaneLayout);
            ShoppingPageContentPaneLayout.setHorizontalGroup(
                ShoppingPageContentPaneLayout.createParallelGroup()
                    .addGroup(ShoppingPageContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ShoppingLeftPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            ShoppingPageContentPaneLayout.setVerticalGroup(
                ShoppingPageContentPaneLayout.createParallelGroup()
                    .addGroup(ShoppingPageContentPaneLayout.createSequentialGroup()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, ShoppingPageContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ShoppingLeftPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            ShoppingPage.pack();
            ShoppingPage.setLocationRelativeTo(ShoppingPage.getOwner());
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(scrollPane1);
        }
        

        fillcomboboxes();
        ShoppingPage.setVisible(true);
        ShoppingPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   }

    private void fillcomboboxes() {
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select pdt_name from products where cat_id='CA1'");

            while(rs.next()){
                mobilesComBox.addItem(rs.getString(1));
            }
            rs=stmt.executeQuery("select pdt_name from products where cat_id='CA2'");

            while(rs.next()){
                booksComBox.addItem(rs.getString(1));
            }
            rs=stmt.executeQuery("select pdt_name from products where cat_id='CA3'");

            while(rs.next()){
                watchesComBox.addItem(rs.getString(1));
            }
            rs=stmt.executeQuery("select pdt_name from products where cat_id='CA4'");

            while(rs.next()){
                footwearsComBox.addItem(rs.getString(1));
            }
            rs=stmt.executeQuery("select pdt_name from products where cat_id='CA5'");

            while(rs.next()){
                computersCmbBox.addItem(rs.getString(1));
            }
            rs=stmt.executeQuery("select pdt_name from products where cat_id='CA6'");

            while(rs.next()){
                ClothesCmbBox.addItem(rs.getString(1));
            }
            con.close();

        }catch(Exception f){ System.out.println(f);}
   }

    
    private JFrame ShoppingPage;
    private JMenuBar menuBar1;
    private JMenu viewProfbtn;
    private JMenuItem viewProfMenu;
    private JMenu logoutBtn;
    private JMenuItem viewPurPdtmenu;
    private JButton logOutBtn;
    private JPanel ShoppingLeftPane;
    private JLabel cartLabel;
    private JScrollPane scrollPane3;
    private JList cartList;
    private JButton paymentBtn;
    private JLabel totalLbl;
    private JLabel label10;
    private JScrollPane scrollPane4;
    private JList cartPriceList;
    private JLabel label9;
    private JPanel panel1;
    private JComboBox mobilesComBox;
    private JLabel mobilePhonesLbl;
    private JButton buyMobilesBtn;
    private JLabel label3;
    private JLabel footwearsLbl;
    private JComboBox footwearsComBox;
    private JButton buyFootwearsBtn;
    private JLabel label1;
    private JLabel label5;
    private JLabel booksLbl;
    private JComboBox booksComBox;
    private JButton buyBooksBtn;
    private JLabel label8;
    private JLabel watchesLbl;
    private JComboBox watchesComBox;
    private JButton buyWatchesBtn;
    private JLabel mobilePrice;
    private JLabel shoesPrice;
    private JLabel booksPrice;
    private JLabel watchesPrice;
    private JLabel label2;
    private JLabel label4;
    private JLabel label6;
    private JLabel label7;
    private JLabel mobilerating;
    private JLabel mobileRatingLbl;
    private JLabel label12;
    private JLabel shoeRatingLbl;
    private JLabel label14;
    private JLabel booksRatingLbl;
    private JLabel label16;
    private JLabel watchRatingLbl;
    private JLabel label18;
    private JLabel computerLbl;
    private JComboBox computersCmbBox;
    private JLabel label20;
    private JLabel computersPrice;
    private JLabel label22;
    private JLabel computersRatingLbl;
    private JLabel label24;
    private JLabel label25;
    private JComboBox ClothesCmbBox;
    private JLabel clothesLbl;
    private JLabel clothesPrice;
    private JLabel label28;
    private JLabel clothesRatingLbl;
    private JButton buyClothesBtn;
    private JButton buyCompButton;
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        ShoppingPage shoppage=new ShoppingPage();

    }
}
