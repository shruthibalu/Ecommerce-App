import javax.swing.*;

public class adminui extends JFrame{
    private JPanel adminuipanel;
    private JTabbedPane customerpane;
    private JPanel CustomerPanel;
    private JPanel ProductPanel;

    private JButton viewCustomer;
    private JButton searchCustomerButton;
    private JPanel AdminContent;
    private JTable table1;

    adminui(){
        customerpane.addTab("Products",ProductPanel);
    }


    public static void main(String[] args) {
        JFrame adminuiframe= new adminui();
        adminuiframe.setVisible(true);
        adminuiframe.setContentPane(new adminui().customerpane);
        adminuiframe.pack();
        adminuiframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
