import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.Date;

public class PaymentPage {
    public int amt;
    //Date date=new Date();
    public PaymentPage(int x) {
        amt=x;
        initComponents();
    }

    private void exitBtnActionPerformed(ActionEvent e) {

        System.exit(1);
    }

    private void logoutBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        MainLogin ml=new MainLogin();
        paymentframe.dispose();
    }

    private void backBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        ShoppingPage sp=new ShoppingPage();
        paymentframe.dispose();
    }

    private void initComponents() {
        
        paymentframe = new JFrame();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        logoutBtn = new JButton();
        exitBtn = new JButton();
        expDate = new JLabel();
        amount = new JLabel();

        //======== paymentframe ========
        {
            var paymentframeContentPane = paymentframe.getContentPane();

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                . BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

                //---- label1 ----
                label1.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\pay.png"));

                //---- label2 ----
                label2.setText("Your Payment Transaction has been Processed.");
                label2.setFont(new Font("Segoe UI", Font.BOLD, 28));

                //---- label3 ----
                label3.setText("Amount  :  Rs.");
                label3.setFont(new Font("Segoe UI", Font.BOLD, 18));

                //---- label5 ----
                label5.setText("Thank You for your Purchase.Come back Soon !!");
                label5.setFont(new Font("Segoe UI", Font.BOLD, 18));
                label5.setForeground(Color.blue);

                //---- logoutBtn ----
                logoutBtn.setText("LogOut");
                logoutBtn.addActionListener(e -> logoutBtnActionPerformed(e));

                //---- exitBtn ----
                exitBtn.setText("Exit");
                exitBtn.addActionListener(e -> exitBtnActionPerformed(e));

                //---- expDate ----
                expDate.setText("Your Order will be delivered within 3 Days.");
                expDate.setFont(new Font("Segoe UI", Font.BOLD, 18));

                //---- amount ----
                amount.setText("0");
                amount.setHorizontalAlignment(SwingConstants.CENTER);
                amount.setFont(new Font("Segoe UI", Font.BOLD, 16));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(amount, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE))
                                            .addGap(5, 5, 5))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                            .addGap(133, 133, 133)
                                            .addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(126, 126, 126)
                                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(172, 172, 172)
                                            .addComponent(expDate, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)))
                                    .addContainerGap())))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(amount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addComponent(expDate, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                    .addGap(64, 64, 64)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
                            .addGap(30, 30, 30)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(40, Short.MAX_VALUE))
                );
            }

            GroupLayout paymentframeContentPaneLayout = new GroupLayout(paymentframeContentPane);
            paymentframeContentPane.setLayout(paymentframeContentPaneLayout);
            paymentframeContentPaneLayout.setHorizontalGroup(
                paymentframeContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            paymentframeContentPaneLayout.setVerticalGroup(
                paymentframeContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            paymentframe.pack();
            paymentframe.setLocationRelativeTo(paymentframe.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        amount.setText(String.valueOf(amt));
        paymentframe.setVisible(true);
        paymentframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //System.out.println(amt);

       // amount.setText(String.valueOf(amt));
        //expDate.setText(String.valueOf((date.getDate()+3)+"/"+String.valueOf(date.getMonth())+"/"+String.valueOf(date.getYear())));
        //expDate.setText("Your order will be delivered within 3 Days.");
    }

    
    private JFrame paymentframe;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JButton logoutBtn;
    private JButton exitBtn;
    private JLabel expDate;
    private JLabel amount;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        PaymentPage p=new PaymentPage(5);
    }
}
