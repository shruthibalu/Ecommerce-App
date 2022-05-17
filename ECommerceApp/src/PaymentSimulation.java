import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class PaymentSimulation extends JFrame {
    public PaymentSimulation() {
        initComponents();
    }

    private void initComponents() {
        
        panel1 = new JPanel();
        paymentModeComBox = new JComboBox<>();
        cardNoTxtFld = new JTextField();
        scrollPane1 = new JScrollPane();
        itemsList = new JList();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        priceLbl = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) )
            ; panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;

            //---- paymentModeComBox ----
            paymentModeComBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "Credit Card",
                "Debit Card",
                "Cash on Delivery"
            }));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(itemsList);
            }

            //---- label1 ----
            label1.setText("Payment Mode");
            label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

            //---- label2 ----
            label2.setText("Card Number");
            label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

            //---- label3 ----
            label3.setText("Selected Items");
            label3.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label4 ----
            label4.setText("Amount");
            label4.setFont(new Font("Segoe UI", Font.BOLD, 14));

            //---- priceLbl ----
            priceLbl.setText("text");

            //---- button1 ----
            button1.setText("Pay");
            button1.setFont(new Font("Segoe UI", Font.BOLD, 14));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(cardNoTxtFld, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(paymentModeComBox, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(priceLbl, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addGap(88, 88, 88)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceLbl, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paymentModeComBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(cardNoTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        
    }

    
    private JPanel panel1;
    private JComboBox<String> paymentModeComBox;
    private JTextField cardNoTxtFld;
    private JScrollPane scrollPane1;
    private JList itemsList;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel priceLbl;
    private JButton button1;
   
}
