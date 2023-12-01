package gui;

import java.awt.Color;
import javax.swing.JOptionPane;
import src.controllers.UserController;
import src.entity.Address;

public class SignUp extends javax.swing.JFrame {
    private Address add;
    
    public SignUp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        signUpBtn = new javax.swing.JButton();
        logInLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        street = new javax.swing.JTextField();
        passwordLabel2 = new javax.swing.JLabel();
        password2 = new javax.swing.JPasswordField();
        username2 = new javax.swing.JTextField();
        usernameLabel2 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        province = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        provinceLabel = new javax.swing.JLabel();
        postalCode = new javax.swing.JTextField();
        zipLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        country = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1206, 795));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image2.png"))); // NOI18N

        name.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        nameLabel.setText("Name");

        passwordLabel.setText("Password");

        titleLabel.setFont(new java.awt.Font("Lato Black", 1, 36)); // NOI18N
        titleLabel.setText("Create an account");

        signUpBtn.setBackground(new java.awt.Color(102, 153, 255));
        signUpBtn.setFont(new java.awt.Font("Cantarell Extra Bold", 0, 18)); // NOI18N
        signUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        signUpBtn.setText("Sign up");
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });

        logInLabel.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        logInLabel.setForeground(new java.awt.Color(51, 51, 51));
        logInLabel.setText("<HTML><U>Already have an account</U></HTML>");
        logInLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logInLabelMouseClicked(evt);
            }
        });

        username.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        usernameLabel.setText("Username");

        addressLabel.setText("Address");

        street.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        street.setForeground(new java.awt.Color(153, 153, 153));
        street.setText("e.g., 123 Main St ");
        street.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                streetMouseClicked(evt);
            }
        });

        passwordLabel2.setText("Confirm Password");

        username2.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        usernameLabel2.setText("Confirm Username");

        city.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        city.setForeground(new java.awt.Color(153, 153, 153));
        city.setText("Calgary");
        city.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cityMouseClicked(evt);
            }
        });

        province.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        province.setForeground(new java.awt.Color(153, 153, 153));
        province.setText("AB");
        province.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                provinceMouseClicked(evt);
            }
        });

        cityLabel.setText("City");

        provinceLabel.setText("Province");

        postalCode.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        postalCode.setForeground(new java.awt.Color(153, 153, 153));
        postalCode.setText("12345");
        postalCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postalCodeMouseClicked(evt);
            }
        });

        zipLabel.setText("Postal Code");

        countryLabel.setText("Country");

        country.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        country.setForeground(new java.awt.Color(153, 153, 153));
        country.setText("Canada");
        country.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signUpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logInLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password)
                    .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password2)
                    .addComponent(username2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(street)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(city, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(province)
                            .addComponent(provinceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(country, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(countryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(postalCode)
                            .addComponent(zipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(street, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(provinceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(signUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(110, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(132, 132, 132))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        String nm = name.getText();
        String un = username.getText();
        String un2 = username2.getText();
        String pw = password.getText();
        String pw2 = password2.getText();
        
        String st = street.getText();
        String cty = city.getText();
        String cntry = country.getText();
        String prov = province.getText();
        String pstc = postalCode.getText();
        
        if (un.equals(un2) && pw.equals(pw2)) {
            add = new Address(st, cty, prov, cntry, pstc);

            UserController.getInstance().registerCustomer(nm, add, un, pw);
            
            name.setText("");
            username.setText("");
            username2.setText("");
            password.setText("");
            password2.setText("");
            street.setText("");
            city.setText("");
            province.setText("");
            country.setText("");
            postalCode.setText("");
            
            JOptionPane.showMessageDialog(this, "Successfully registered! Login to your new account.");
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "Username or password do not match! Try again.");
            name.setText("");
            password.setText("");
            name.requestFocus();
        }
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void logInLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInLabelMouseClicked
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_logInLabelMouseClicked

    private void provinceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_provinceMouseClicked
        province.setText("");
        province.setForeground(Color.black);
    }//GEN-LAST:event_provinceMouseClicked

    private void countryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countryMouseClicked
        country.setText("");
        country.setForeground(Color.black);
    }//GEN-LAST:event_countryMouseClicked

    private void postalCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postalCodeMouseClicked
        postalCode.setText("");
        postalCode.setForeground(Color.black);
    }//GEN-LAST:event_postalCodeMouseClicked

    private void cityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cityMouseClicked
        city.setText("");
        city.setForeground(Color.black);
    }//GEN-LAST:event_cityMouseClicked

    private void streetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_streetMouseClicked
        street.setText("");
        street.setForeground(Color.black);
    }//GEN-LAST:event_streetMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField city;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField country;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JLabel image;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logInLabel;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password2;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JTextField postalCode;
    private javax.swing.JTextField province;
    private javax.swing.JLabel provinceLabel;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JTextField street;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username2;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel2;
    private javax.swing.JLabel zipLabel;
    // End of variables declaration//GEN-END:variables
}
