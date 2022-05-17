import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import java.sql.*;


public class AdminLogin {
    String uname;
    String pwd;
    public AdminLogin() {
        initComponents();
    }

    @SuppressWarnings("deprecation")
	private void adminLoginBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        uname=adminUNameTxtFld.getText();
        pwd=adminPwdTxtFld.getText();

        if(uname.equals("Admin") && pwd.equals("Admin")){
            AdminHomePage ap=new AdminHomePage();
            adminLoginPage.dispose();
        }
        else{
            JOptionPane.showMessageDialog(adminLoginPage,"Invalid Login and Password");
        }
    }

    private void adminClrBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        adminUNameTxtFld.setText(null);
        adminPwdTxtFld.setText(null);
    }

    private void initComponents() {
       
        adminLoginPage = new JFrame();
        panel1 = new JPanel();
        adminUnameLbl = new JLabel();
        adminpwdLbl = new JLabel();
        adminUNameTxtFld = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        adminLoginBtn = new JButton();
        adminClrBtn = new JButton();
        adminPwdTxtFld = new JPasswordField();

        //======== adminLoginPage ========
        {
            var adminLoginPageContentPane = adminLoginPage.getContentPane();

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
                border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER
                ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
                .BOLD,12),java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(
                new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r"
                .equals(e.getPropertyName()))throw new RuntimeException();}});

                //---- adminUnameLbl ----
                adminUnameLbl.setText("Username");

                //---- adminpwdLbl ----
                adminpwdLbl.setText("Password");

                //---- adminUNameTxtFld ----
                adminUNameTxtFld.setBorder(LineBorder.createBlackLineBorder());

                //---- label3 ----
                label3.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\adminlogo.png"));
                label3.setBorder(null);

                //---- label4 ----
                label4.setText("Login as Administrator");
                label4.setFont(new Font("Arial", Font.BOLD, 18));
                label4.setHorizontalAlignment(SwingConstants.CENTER);

                //---- adminLoginBtn ----
                adminLoginBtn.setText("Login");
                adminLoginBtn.addActionListener(e -> adminLoginBtnActionPerformed(e));

                //---- adminClrBtn ----
                adminClrBtn.setText("Clear");
                adminClrBtn.addActionListener(e -> adminClrBtnActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap(176, Short.MAX_VALUE)
                            .addComponent(label3)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(adminUnameLbl, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adminpwdLbl, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addGap(40, 40, 40)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(adminUNameTxtFld, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                        .addComponent(adminPwdTxtFld, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(63, 63, 63)
                                    .addComponent(adminLoginBtn, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)
                                    .addComponent(adminClrBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
                            .addGap(99, 176, Short.MAX_VALUE))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(309, 309, 309)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(248, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminUnameLbl, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adminUNameTxtFld, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                    .addGap(41, 41, 41)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(adminpwdLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adminPwdTxtFld, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                    .addGap(38, 38, 38)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminLoginBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adminClrBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(111, Short.MAX_VALUE))
                );
            }

            GroupLayout adminLoginPageContentPaneLayout = new GroupLayout(adminLoginPageContentPane);
            adminLoginPageContentPane.setLayout(adminLoginPageContentPaneLayout);
            adminLoginPageContentPaneLayout.setHorizontalGroup(
                adminLoginPageContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            adminLoginPageContentPaneLayout.setVerticalGroup(
                adminLoginPageContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            adminLoginPage.pack();
            adminLoginPage.setLocationRelativeTo(adminLoginPage.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        adminLoginPage.setVisible(true);
        //adminLoginPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        AdminLogin adminloginpage=new AdminLogin();
    }

    
    private JFrame adminLoginPage;
    private JPanel panel1;
    private JLabel adminUnameLbl;
    private JLabel adminpwdLbl;
    private JTextField adminUNameTxtFld;
    private JLabel label3;
    private JLabel label4;
    private JButton adminLoginBtn;
    private JButton adminClrBtn;
    private JPasswordField adminPwdTxtFld;
  
}
