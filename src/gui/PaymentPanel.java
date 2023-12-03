package gui;

import java.awt.Color;
import javax.swing.JOptionPane;
import src.controllers.UserController;
import src.entity.Address;

public class PaymentPanel extends javax.swing.JFrame {
    private Address add;
    
    public PaymentPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        makePaymentBtn = new javax.swing.JButton();
        addressLabel = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        expiryDate = new javax.swing.JTextField();
        cvv = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        provinceLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Lato Black", 1, 36)); // NOI18N
        titleLabel.setText("Make your payment");

        makePaymentBtn.setBackground(new java.awt.Color(102, 153, 255));
        makePaymentBtn.setFont(new java.awt.Font("Cantarell Extra Bold", 0, 18)); // NOI18N
        makePaymentBtn.setForeground(new java.awt.Color(255, 255, 255));
        makePaymentBtn.setText("Make Payment");
        makePaymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePaymentBtnActionPerformed(evt);
            }
        });

        addressLabel.setText("Credit Card Number");

        number.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        number.setForeground(new java.awt.Color(153, 153, 153));
        number.setText("e.g., 1234567890");
        number.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numberMouseClicked(evt);
            }
        });

        expiryDate.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        expiryDate.setForeground(new java.awt.Color(153, 153, 153));
        expiryDate.setText("Calgary");
        expiryDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expiryDateMouseClicked(evt);
            }
        });

        cvv.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        cvv.setForeground(new java.awt.Color(153, 153, 153));
        cvv.setText("AB");
        cvv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cvvMouseClicked(evt);
            }
        });

        cityLabel.setText("Expirey Date");

        provinceLabel.setText("CVV");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(number, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(expiryDate, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(cityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(provinceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(makePaymentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(provinceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(makePaymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
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

    private void cvvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cvvMouseClicked
        cvv.setText("");
        cvv.setForeground(Color.black);
    }//GEN-LAST:event_cvvMouseClicked

    private void expiryDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expiryDateMouseClicked
        expiryDate.setText("");
        expiryDate.setForeground(Color.black);
    }//GEN-LAST:event_expiryDateMouseClicked

    private void numberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numberMouseClicked
        number.setText("");
        number.setForeground(Color.black);
    }//GEN-LAST:event_numberMouseClicked

    private void makePaymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePaymentBtnActionPerformed
        String nbr = number.getText();
        String exp = expiryDate.getText();
        String cvvInt = cvv.getText();
    }//GEN-LAST:event_makePaymentBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cvv;
    private javax.swing.JTextField expiryDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton makePaymentBtn;
    private javax.swing.JTextField number;
    private javax.swing.JLabel provinceLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
