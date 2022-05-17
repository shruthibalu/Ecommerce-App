import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import java.sql.*;
import javax.swing.event.*;


public class Registration {
    String u_name,pass,address,city;
    Long mobno;
    int age;
    char gender;
    String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((str != null)
                && (!str.equals(""))
                && (str.chars().allMatch(Character::isLetter)));
    }

    public Registration() {
        initComponents();
    }
    private void signUpBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        u_name = unameTxtFld.getText();
        pass = passwordTxtFld.getText();
        //mobno=mobnoTxtFld.getText();
        if (!isValid(u_name)) {
            JOptionPane.showMessageDialog(registrationframe, "Please enter a valid email id for UserName");
        }
        else {
            if (!pass.matches(pattern)) {
                JOptionPane.showMessageDialog(registrationframe, "Your password must contain atleast 8 characters with atleast one uppercase,lowercase and special character");
            }
            else {
                address = addressTxtArea.getText();
                age = Integer.parseInt(ageLbl.getText());
                if (maleRadBtn.isSelected()) {
                    gender = 'M';
                }
                else if (FemaleRadBtn.isSelected()) {
                    gender = 'F';
                }
                else {
                    gender = 'T';
                }
                try {
                    mobno = Long.parseLong(mobnoTxtFld.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(registrationframe, "Invalid Phone Number");
                }

                if (mobnoTxtFld.getText().length() != 10) {
                    JOptionPane.showMessageDialog(registrationframe, "Please Enter a valid Mobile Number with 10 digits");
                }

                else {

                    city = cityTxtFld.getText();
                    if (!isStringOnlyAlphabet(city)) {
                        JOptionPane.showMessageDialog(registrationframe, "Please Enter a valid City Name");
                    }
                    else {

                        try {
                        	Class.forName("oracle.jdbc.driver.OracleDriver");
                			Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl1","hr","password");
                            Statement stmt = con.createStatement();


                            String insert_query = "insert into customers_list values(customer_no_sequence.nextval,?,?,?,?,?,?,?)";
                            PreparedStatement preSt = con.prepareStatement(insert_query);

                            preSt.setString(1, u_name);
                            preSt.setString(2, pass);
                            preSt.setInt(3, age);
                            preSt.setString(4, String.valueOf(gender));
                            preSt.setLong(5, mobno);
                            preSt.setString(6, address);
                            preSt.setString(7, city);

                            preSt.executeUpdate();
                            con.close();
                            JOptionPane.showMessageDialog(registrationframe, "Registration Successful!");
                            ShoppingPage shop = new ShoppingPage();
                            shop.username = u_name;
                            registrationframe.dispose();
                        } catch (Exception f) {
                            JOptionPane.showMessageDialog(registrationframe,f);
                        }
                    }
                }
            }
        }
    }


    private void slider1StateChanged(ChangeEvent e) {
        // TODO add your code here
        ageLbl.setText(String.valueOf(slider1.getValue()));
    }

    private void loginBActionPerformed(ActionEvent e) {
        // TODO add your code here
        CustomerLogin cl=new CustomerLogin();
        registrationframe.dispose();
    }

    private void clearBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        unameTxtFld.setText(null);
        passwordTxtFld.setText(null);
        addressTxtArea.setText(null);
        mobnoTxtFld.setText(null);
        cityTxtFld.setText(null);
        ageLbl.setText(null);
    }

    /*private void slider1StateChanged(ChangeEvent e) {
        // TODO add your code here
        ageLbl.setText(String.valueOf(slider1.getValue()));
    }*/

    /*private void ageStateChanged(ChangeEvent e) {
        // TODO add your code here
        ageLbl.setText(age.getValue);
    }*/

    private void initComponents() {
        
        registrationframe = new JFrame();
        panel1 = new JPanel();
        label1 = new JLabel();
        unameLbl = new JLabel();
        PwdLbl = new JLabel();
        AgeLbl = new JLabel();
        unameTxtFld = new JTextField();
        genderLbl = new JLabel();
        label6 = new JLabel();
        mobNoLBL = new JLabel();
        mobnoTxtFld = new JTextField();
        maleRadBtn = new JRadioButton();
        FemaleRadBtn = new JRadioButton();
        addressLbl = new JLabel();
        scrollPane1 = new JScrollPane();
        addressTxtArea = new JTextArea();
        signUpBtn = new JButton();
        clearBtn = new JButton();
        label10 = new JLabel();
        loginB = new JButton();
        label11 = new JLabel();
        cityTxtFld = new JTextField();
        label2 = new JLabel();
        ageLbl = new JLabel();
        slider1 = new JSlider();
        trRadBtn = new JRadioButton();
        passwordTxtFld = new JPasswordField();

        //======== registrationframe ========
        {
            var registrationframeContentPane = registrationframe.getContentPane();

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
                . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
                . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
                12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
                . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
                getPropertyName () )) throw new RuntimeException( ); }} );

                //---- label1 ----
                label1.setText("Sign Up to Create your new Account");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setFont(new Font("Segoe UI", Font.BOLD, 18));

                //---- unameLbl ----
                unameLbl.setText("Username :");
                unameLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));

                //---- PwdLbl ----
                PwdLbl.setText("Password :");
                PwdLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));

                //---- AgeLbl ----
                AgeLbl.setText("Age   :");
                AgeLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));

                //---- unameTxtFld ----
                unameTxtFld.setBorder(LineBorder.createBlackLineBorder());

                //---- genderLbl ----
                genderLbl.setText("Gender :");
                genderLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));

                //---- mobNoLBL ----
                mobNoLBL.setText("Mobile No.");
                mobNoLBL.setFont(new Font("Segoe UI", Font.BOLD, 16));

                //---- mobnoTxtFld ----
                mobnoTxtFld.setBorder(LineBorder.createBlackLineBorder());

                //---- maleRadBtn ----
                maleRadBtn.setText("M");

                //---- FemaleRadBtn ----
                FemaleRadBtn.setText("F");

                //---- addressLbl ----
                addressLbl.setText("Address");
                addressLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));

                //======== scrollPane1 ========
                {

                    //---- addressTxtArea ----
                    addressTxtArea.setBorder(LineBorder.createBlackLineBorder());
                    scrollPane1.setViewportView(addressTxtArea);
                }

                //---- signUpBtn ----
                signUpBtn.setText("Sign Up");
                signUpBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                signUpBtn.addActionListener(e -> signUpBtnActionPerformed(e));

                //---- clearBtn ----
                clearBtn.setText("Clear");
                clearBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                clearBtn.addActionListener(e -> clearBtnActionPerformed(e));

                //---- label10 ----
                label10.setText("       Already have an account?");

                //---- loginB ----
                loginB.setText("Login");
                loginB.addActionListener(e -> loginBActionPerformed(e));

                //---- label11 ----
                label11.setText("text");
                label11.setBorder(LineBorder.createBlackLineBorder());
                label11.setIcon(new ImageIcon("C:\\Users\\SHRUTHI\\OneDrive\\Desktop\\ECommerceApp\\images\\personicon.png"));

                //---- cityTxtFld ----
                cityTxtFld.setBorder(LineBorder.createBlackLineBorder());

                //---- label2 ----
                label2.setText("City");
                label2.setFont(new Font("Segoe UI", Font.BOLD, 16));

                //---- ageLbl ----
                ageLbl.setFont(new Font("Segoe UI", Font.PLAIN, 16));

                //---- slider1 ----
                slider1.setMinimum(5);
                slider1.setMaximum(99);
                slider1.addChangeListener(e -> slider1StateChanged(e));

                //---- trRadBtn ----
                trRadBtn.setText("T");

                //---- passwordTxtFld ----
                passwordTxtFld.setBorder(LineBorder.createBlackLineBorder());

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(82, 82, 82)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(addressLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(mobNoLBL, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                .addComponent(genderLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(AgeLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(PwdLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(unameLbl, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(unameTxtFld)
                                                .addComponent(mobnoTxtFld)
                                                .addComponent(scrollPane1)
                                                .addComponent(cityTxtFld)
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(maleRadBtn, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ageLbl, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                            .addGap(86, 86, 86)
                                                            .addComponent(label6, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                            .addGap(18, 18, 18)
                                                            .addComponent(slider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                            .addGap(43, 43, 43)
                                                            .addComponent(FemaleRadBtn, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(31, 31, 31)
                                                            .addComponent(trRadBtn, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE))))
                                                .addComponent(passwordTxtFld, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGap(55, 55, 55)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGap(142, 142, 142)
                                                    .addComponent(loginB, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(196, 196, 196)
                                    .addComponent(signUpBtn, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60)
                                    .addComponent(clearBtn, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
                            .addGap(51, 51, 51))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label11)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(unameLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(unameTxtFld, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(29, 29, 29)
                                            .addComponent(PwdLbl, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(passwordTxtFld, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(AgeLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(ageLbl, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(slider1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(maleRadBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(genderLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(FemaleRadBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trRadBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(mobNoLBL, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(addressLbl, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(mobnoTxtFld, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cityTxtFld, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                    .addGap(24, 24, 24))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(loginB, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(signUpBtn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addComponent(clearBtn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                            .addGap(51, 51, 51))
                );
            }

            GroupLayout registrationframeContentPaneLayout = new GroupLayout(registrationframeContentPane);
            registrationframeContentPane.setLayout(registrationframeContentPaneLayout);
            registrationframeContentPaneLayout.setHorizontalGroup(
                registrationframeContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, registrationframeContentPaneLayout.createSequentialGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            registrationframeContentPaneLayout.setVerticalGroup(
                registrationframeContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, registrationframeContentPaneLayout.createSequentialGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                        .addContainerGap())
            );
            registrationframe.pack();
            registrationframe.setLocationRelativeTo(registrationframe.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        ButtonGroup gen=new ButtonGroup();
        gen.add(maleRadBtn);
        gen.add(FemaleRadBtn);
        gen.add(trRadBtn);
        registrationframe.setVisible(true);

    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
		Registration reg=new Registration();
    }

   
    private JFrame registrationframe;
    private JPanel panel1;
    private JLabel label1;
    private JLabel unameLbl;
    private JLabel PwdLbl;
    private JLabel AgeLbl;
    private JTextField unameTxtFld;
    private JLabel genderLbl;
    private JLabel label6;
    private JLabel mobNoLBL;
    private JTextField mobnoTxtFld;
    private JRadioButton maleRadBtn;
    private JRadioButton FemaleRadBtn;
    private JLabel addressLbl;
    private JScrollPane scrollPane1;
    private JTextArea addressTxtArea;
    private JButton signUpBtn;
    private JButton clearBtn;
    private JLabel label10;
    private JButton loginB;
    private JLabel label11;
    private JTextField cityTxtFld;
    private JLabel label2;
    private JLabel ageLbl;
    private JSlider slider1;
    private JRadioButton trRadBtn;
    private JPasswordField passwordTxtFld;
   
}
