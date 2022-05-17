import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 
public class AdminHomePage extends JFrame {
    public AdminHomePage() {
        initComponents();
    }

    private void listAllCustomersBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        CustomersList c=new CustomersList();


    }

    private void listAllPdtsBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        SearchProduct p=new SearchProduct();
    }

    private void listallPaymentsActionPerformed(ActionEvent e) {
        // TODO add your code here
        //new ListTransactions().
        ListTransactions lt=new ListTransactions();
    }

    private void addProductBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        AddProduct ap=new AddProduct();
    }

    private void backBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        MainLogin a=new MainLogin();
        adminhome.dispose();
    }

    private void initComponents() {
      
        adminhome = new JFrame();
        panel1 = new JPanel();
        customersLbl = new JLabel();
        productsLabel = new JLabel();
        transactionsLabel = new JLabel();
        listAllCustomersBtn = new JButton();
        listAllPdtsBtn = new JButton();
        listallPayments = new JButton();
        addProductBtn = new JButton();
        backBtn = new JButton();

        //======== adminhome ========
        {
            var adminhomeContentPane = adminhome.getContentPane();

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                . BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

                //---- customersLbl ----
                customersLbl.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\person.png"));

                //---- productsLabel ----
                productsLabel.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\cartlogo.png"));

                //---- transactionsLabel ----
                transactionsLabel.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\paymentlogo.png"));

                //---- listAllCustomersBtn ----
                listAllCustomersBtn.setText("List Customers");
                listAllCustomersBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                listAllCustomersBtn.addActionListener(e -> listAllCustomersBtnActionPerformed(e));

                //---- listAllPdtsBtn ----
                listAllPdtsBtn.setText("List Products");
                listAllPdtsBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                listAllPdtsBtn.addActionListener(e -> listAllPdtsBtnActionPerformed(e));

                //---- listallPayments ----
                listallPayments.setText("List all Payment Transactions");
                listallPayments.setFont(new Font("Segoe UI", Font.BOLD, 14));
                listallPayments.addActionListener(e -> listallPaymentsActionPerformed(e));

                //---- addProductBtn ----
                addProductBtn.setText("Add to Inventory");
                addProductBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                addProductBtn.addActionListener(e -> addProductBtnActionPerformed(e));

                //---- backBtn ----
                backBtn.setText("Back to Login");
                backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                backBtn.addActionListener(e -> backBtnActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(customersLbl)
                                            .addGap(90, 90, 90)
                                            .addComponent(productsLabel)
                                            .addGap(97, 97, 97)
                                            .addComponent(transactionsLabel))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(listAllCustomersBtn, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                            .addGap(161, 161, 161)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(addProductBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(listAllPdtsBtn, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addGap(118, 118, 118)
                                            .addComponent(listallPayments, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                            .addGap(0, 81, Short.MAX_VALUE)))
                                    .addGap(0, 28, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addGap(0, 985, Short.MAX_VALUE)
                                    .addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(customersLbl, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(productsLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addComponent(transactionsLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(51, 51, 51)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(listAllCustomersBtn, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addComponent(listAllPdtsBtn, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addComponent(listallPayments, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                            .addGap(37, 37, 37)
                            .addComponent(addProductBtn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                            .addComponent(backBtn)
                            .addContainerGap())
                );
            }

            GroupLayout adminhomeContentPaneLayout = new GroupLayout(adminhomeContentPane);
            adminhomeContentPane.setLayout(adminhomeContentPaneLayout);
            adminhomeContentPaneLayout.setHorizontalGroup(
                adminhomeContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            adminhomeContentPaneLayout.setVerticalGroup(
                adminhomeContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            adminhome.pack();
            adminhome.setLocationRelativeTo(adminhome.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        adminhome.setVisible(true);
    }

    
    private JFrame adminhome;
    private JPanel panel1;
    private JLabel customersLbl;
    private JLabel productsLabel;
    private JLabel transactionsLabel;
    private JButton listAllCustomersBtn;
    private JButton listAllPdtsBtn;
    private JButton listallPayments;
    private JButton addProductBtn;
    private JButton backBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        AdminHomePage admhp=new AdminHomePage();
        //admhp.setVisible(true);
    }
}
