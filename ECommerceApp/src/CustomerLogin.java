import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

public class CustomerLogin {
    String uname,pwd,name,pass;

    public CustomerLogin() {
        initComponents();
    }

    private void signUpBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        Registration regform=new Registration();
        custloginpage.dispose();
    }

    private void custLoginBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        uname=custUnameTxtFld.getText();
        pwd=custPwdFld.getText();
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
            Statement stmt=con.createStatement();
            final String queryCheck = "SELECT cust_uname,cust_pwd from customers_list WHERE  cust_uname= ? AND cust_pwd=?";
            final PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, uname);
            ps.setString(2,pwd);
            final ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                name=rs.getString(1);
                pass=rs.getString(2);
            }
            if(name==null){
                JOptionPane.showMessageDialog(custloginpage,"Username and Password does not match");
            }
            else if(name.matches(uname)&&pass.matches(pwd)){
                ShoppingPage shppage=new ShoppingPage();
                shppage.username=name;
                custloginpage.dispose();
            }
            con.close();
        }catch(Exception f){JOptionPane.showMessageDialog(custloginpage,f);}
    }

    private void initComponents() {
        
        custloginpage = new JFrame();
        panel1 = new JPanel();
        label1 = new JLabel();
        custUnameLbl = new JLabel();
        custPwdLbl = new JLabel();
        custUnameTxtFld = new JTextField();
        custLoginBtn = new JButton();
        signUpBtn = new JButton();
        label4 = new JLabel();
        custPwdFld = new JPasswordField();

        //======== custloginpage ========
        {
            var custloginpageContentPane = custloginpage.getContentPane();

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
                . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing
                . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
                Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
                ) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
                public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName (
                ) )) throw new RuntimeException( ); }} );

                //---- label1 ----
                label1.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\customerlogo.png"));

                //---- custUnameLbl ----
                custUnameLbl.setText("Username");

                //---- custPwdLbl ----
                custPwdLbl.setText("Password");

                //---- custUnameTxtFld ----
                custUnameTxtFld.setBorder(LineBorder.createBlackLineBorder());

                //---- custLoginBtn ----
                custLoginBtn.setText("Login");
                custLoginBtn.addActionListener(e -> custLoginBtnActionPerformed(e));

                //---- signUpBtn ----
                signUpBtn.setText("SignUp");
                signUpBtn.addActionListener(e -> signUpBtnActionPerformed(e));

                //---- label4 ----
                label4.setText("Login as Customer");
                label4.setHorizontalAlignment(SwingConstants.CENTER);
                label4.setFont(new Font("Segoe UI", Font.BOLD, 16));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addComponent(label1)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(custUnameLbl, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                        .addComponent(custPwdLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(27, 27, 27)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(custUnameTxtFld, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                        .addComponent(custPwdFld, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(custLoginBtn, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(signUpBtn, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(46, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addGap(23, 23, 23))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(custUnameLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(custUnameTxtFld, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                            .addGap(44, 44, 44)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(custPwdLbl, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addComponent(custPwdFld, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                            .addGap(36, 36, 36)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(signUpBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(custLoginBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            GroupLayout custloginpageContentPaneLayout = new GroupLayout(custloginpageContentPane);
            custloginpageContentPane.setLayout(custloginpageContentPaneLayout);
            custloginpageContentPaneLayout.setHorizontalGroup(
                custloginpageContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            custloginpageContentPaneLayout.setVerticalGroup(
                custloginpageContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            custloginpage.pack();
            custloginpage.setLocationRelativeTo(custloginpage.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        custloginpage.setVisible(true);
    }

    public static void main(String[] args) {
        CustomerLogin custlogin=new CustomerLogin();
    }

    
    private JFrame custloginpage;
    private JPanel panel1;
    private JLabel label1;
    private JLabel custUnameLbl;
    private JLabel custPwdLbl;
    private JTextField custUnameTxtFld;
    private JButton custLoginBtn;
    private JButton signUpBtn;
    private JLabel label4;
    private JPasswordField custPwdFld;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
