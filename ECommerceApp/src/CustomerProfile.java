import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

public class CustomerProfile extends JFrame {
    public String un;
    String pwd,addr,city;
    String age,gen;
    String mobNo;
    String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    int num;
    public CustomerProfile(String a) {
        un=a;
        initComponents();
    }

    private void updateBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        pwd = pwdTxtFld.getText();
        gen = genderTxtFld.getText();
        age=AgeTxtFld.getText();
        city=cityTxtFld.getText();
        addr=addrTxtFld.getText();
        mobNo=mobNoTxtFld.getText();

        if (!(pwd.matches(pattern))) {
            JOptionPane.showMessageDialog(this, "Your password must contain atleast 8 characters with atleast one uppercase,lowercase and special character");
        }
        else {



                            try {
                            	Class.forName("oracle.jdbc.driver.OracleDriver");
                    			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
                                Statement stmt = con.createStatement();


                                String insert_query = "update customers_list set cust_pwd=?,cust_age=?,cust_gender=?,cust_mobno=?,address=?,city=? where cust_uname=?";
                                PreparedStatement preSt = con.prepareStatement(insert_query);

                                preSt.setString(1, pwd);
                                preSt.setInt(2, Integer.parseInt(age));
                                preSt.setString(3, gen);
                                preSt.setInt(4, Integer.parseInt(mobNo));
                                preSt.setString(5, addr);
                                preSt.setString(6, city);
                                preSt.setString(7, un);

                                preSt.executeUpdate();
                                JOptionPane.showMessageDialog(this,"Profile Updated Successfully !");

                                con.close();
                            } catch (Exception f) {
                                //System.out.println(f);
                                JOptionPane.showMessageDialog(this,f);
                            }
                        }
                    }






    private void initComponents() {
       
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        usernameLbl = new JLabel();
        pwdTxtFld = new JTextField();
        AgeTxtFld = new JTextField();
        mobNoTxtFld = new JTextField();
        addrTxtFld = new JTextField();
        label9 = new JLabel();
        cityTxtFld = new JTextField();
        genderTxtFld = new JTextField();
        updateBtn = new JButton();
        label8 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
            , 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
            panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setText("Your  Profile");
            label1.setFont(new Font("Segoe UI", Font.BOLD, 22));
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label2 ----
            label2.setText("Username   :");
            label2.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label3 ----
            label3.setText("Password  :");
            label3.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label4 ----
            label4.setText("Age  :");
            label4.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label5 ----
            label5.setText("Gender  :");
            label5.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label6 ----
            label6.setText("Mobile Number");
            label6.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label7 ----
            label7.setText("Address   :");
            label7.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- usernameLbl ----
            usernameLbl.setBorder(LineBorder.createBlackLineBorder());

            //---- pwdTxtFld ----
            pwdTxtFld.setBorder(LineBorder.createBlackLineBorder());

            //---- AgeTxtFld ----
            AgeTxtFld.setBorder(LineBorder.createBlackLineBorder());

            //---- mobNoTxtFld ----
            mobNoTxtFld.setBorder(LineBorder.createBlackLineBorder());

            //---- addrTxtFld ----
            addrTxtFld.setBorder(LineBorder.createBlackLineBorder());

            //---- label9 ----
            label9.setText("City");
            label9.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- cityTxtFld ----
            cityTxtFld.setBorder(LineBorder.createBlackLineBorder());

            //---- genderTxtFld ----
            genderTxtFld.setBorder(LineBorder.createBlackLineBorder());

            //---- updateBtn ----
            updateBtn.setText("Update Profile");
            updateBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
            updateBtn.addActionListener(e -> updateBtnActionPerformed(e));

            //---- label8 ----
            label8.setText("text");
            label8.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\personlogo.png"));

            //---- label10 ----
            label10.setText("Any changes made ");
            label10.setFont(new Font("Segoe UI", Font.BOLD, 18));
            label10.setVerticalAlignment(SwingConstants.TOP);
            label10.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label11 ----
            label11.setText("to   your   Profile   will   be");
            label11.setFont(new Font("Segoe UI", Font.BOLD, 18));

            //---- label12 ----
            label12.setText("Automatically Updated");
            label12.setHorizontalAlignment(SwingConstants.CENTER);
            label12.setFont(new Font("Segoe UI", Font.BOLD, 18));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label9, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mobNoTxtFld, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(genderTxtFld, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(AgeTxtFld, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(addrTxtFld, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(cityTxtFld, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(pwdTxtFld, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(usernameLbl, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label10, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label12, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(21, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameLbl, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pwdTxtFld, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AgeTxtFld, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderTxtFld, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobNoTxtFld, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addrTxtFld, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label11)))
                        .addGap(13, 13, 13)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cityTxtFld, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(130, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label12)
                                .addContainerGap(215, Short.MAX_VALUE))))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
       

        System.out.println(un);
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
            Statement stmt=con.createStatement();
            final String queryCheck = "select * from customers_list where cust_uname=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);

            ps.setString(1,un);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                num=rs.getInt(1);
                usernameLbl.setText(rs.getString(2));
                pwdTxtFld.setText(rs.getString(3));
                AgeTxtFld.setText(String.valueOf(rs.getInt(4)));
                genderTxtFld.setText(rs.getString(5));
                mobNoTxtFld.setText(String.valueOf(rs.getLong(6)));
                addrTxtFld.setText(rs.getString(7));
                cityTxtFld.setText(rs.getString(8));
            }
            //step5 close the connection object
            con.close();
        } catch (Exception f) {
            System.out.println(f);
        }
        this.setVisible(true);

    }

    
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel usernameLbl;
    private JTextField pwdTxtFld;
    private JTextField AgeTxtFld;
    private JTextField mobNoTxtFld;
    private JTextField addrTxtFld;
    private JLabel label9;
    private JTextField cityTxtFld;
    private JTextField genderTxtFld;
    private JButton updateBtn;
    private JLabel label8;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        CustomerProfile c=new CustomerProfile("a");
    }


}
