import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

 




public class MainLogin {


    public MainLogin() {
        initComponents();
    }

    private void mainAdminLoginBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        AdminLogin admin=new AdminLogin();
        mainLoginPage.dispose();
    }

    private void mainCustLoginBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        CustomerLogin customerloginframe=new CustomerLogin();
        mainLoginPage.dispose();
    }

    private void initComponents() {
        
        mainLoginPage = new JFrame();
        panel1 = new JPanel();
        label1 = new JLabel();
        mainAdminLoginBtn = new JButton();
        mainCustLoginBtn = new JButton();
        label2 = new JLabel();

        //======== mainLoginPage ========
        {
            var mainLoginPageContentPane = mainLoginPage.getContentPane();

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
                .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax
                . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,
                12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans
                .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e.
                getPropertyName () ) )throw new RuntimeException( ) ;} } );

                //---- label1 ----
                label1.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\ecommercelogo.png"));

                //---- mainAdminLoginBtn ----
                mainAdminLoginBtn.setText("Login as Administrator");
                mainAdminLoginBtn.addActionListener(e -> mainAdminLoginBtnActionPerformed(e));

                //---- mainCustLoginBtn ----
                mainCustLoginBtn.setText("Login as Customer");
                mainCustLoginBtn.addActionListener(e -> mainCustLoginBtnActionPerformed(e));

                //---- label2 ----
                label2.setText("WELCOME");
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setFont(new Font("Segoe UI", Font.BOLD, 16));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(43, 43, 43)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(mainAdminLoginBtn, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(mainCustLoginBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(28, 28, 28))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 92, Short.MAX_VALUE))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(mainAdminLoginBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(mainCustLoginBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(143, Short.MAX_VALUE))
                );
            }

            GroupLayout mainLoginPageContentPaneLayout = new GroupLayout(mainLoginPageContentPane);
            mainLoginPageContentPane.setLayout(mainLoginPageContentPaneLayout);
            mainLoginPageContentPaneLayout.setHorizontalGroup(
                mainLoginPageContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            mainLoginPageContentPaneLayout.setVerticalGroup(
                mainLoginPageContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            mainLoginPage.pack();
            mainLoginPage.setLocationRelativeTo(mainLoginPage.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        mainLoginPage.setVisible(true);
        mainLoginPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MainLogin mainlogin=new MainLogin();
    }

   
    private JFrame mainLoginPage;
    private JPanel panel1;
    private JLabel label1;
    private JButton mainAdminLoginBtn;
    private JButton mainCustLoginBtn;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
