package view;

import dao.UserDAO;
import javax.swing.JOptionPane;

public class CreateAccountForm extends javax.swing.JFrame {

    public CreateAccountForm() {
        initComponents();
        setLocationRelativeTo(null);
        updateDentistFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblConfirmPassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblRole = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox();
        lblDentistName = new javax.swing.JLabel();
        txtDentistName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblSpecialization = new javax.swing.JLabel();
        txtSpecialization = new javax.swing.JTextField();
        pnlButtons = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Account");

        jPanel1.setPreferredSize(new java.awt.Dimension(740, 474));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        lblTitle.setText("CREATE NEW ACCOUNT");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        lblUsername.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblUsername.setText("Username:");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 310, -1));

        lblPassword.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblPassword.setText("Password:");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 310, -1));

        lblConfirmPassword.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblConfirmPassword.setText("Confirm Password:");
        jPanel1.add(lblConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        jPanel1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 310, -1));

        lblRole.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblRole.setText("Account Type:");
        jPanel1.add(lblRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "STAFF", "DENTIST" }));
        cmbRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRoleActionPerformed(evt);
            }
        });
        jPanel1.add(cmbRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 110, -1));

        lblDentistName.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblDentistName.setText("Dentist Name:");
        jPanel1.add(lblDentistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));
        jPanel1.add(txtDentistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 310, -1));

        lblEmail.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblEmail.setText("Email:");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 310, -1));

        lblPhone.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblPhone.setText("Phone:");
        jPanel1.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 310, -1));

        lblSpecialization.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblSpecialization.setText("Specialization:");
        jPanel1.add(lblSpecialization, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));
        jPanel1.add(txtSpecialization, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 310, -1));

        btnCreate.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnCreate.setText("Create Account");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        pnlButtons.add(btnCreate);

        btnClear.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnClear.setText("Clear all");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        pnlButtons.add(btnClear);

        jPanel1.add(pnlButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 280, -1));

        btnClose.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 16, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRoleActionPerformed
        updateDentistFields();
    }//GEN-LAST:event_cmbRoleActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        String confirm = new String(txtConfirmPassword.getPassword()).trim();
        String role = cmbRole.getSelectedItem().toString();

        if (!username.matches("[A-Za-z0-9_]{3,30}")) {
            JOptionPane.showMessageDialog(this, "Username must contain 3-30 letters, numbers or underscores.");
            return;
        }
        if (password.length() < 4) {
            JOptionPane.showMessageDialog(this, "Password must contain at least 4 characters.");
            return;
        }
        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }

        UserDAO dao = new UserDAO();
        if (dao.usernameExists(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists.");
            return;
        }

        boolean success;
        if ("STAFF".equalsIgnoreCase(role)) {
            success = dao.createStaffAccount(username, password);
        } else {
            String name = txtDentistName.getText().trim();
            String email = txtEmail.getText().trim();
            String phone = txtPhone.getText().trim();
            String specialization = txtSpecialization.getText().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || specialization.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all dentist information.");
                return;
            }
            if (!name.matches("[A-Za-z .'-]{2,100}")) {
                JOptionPane.showMessageDialog(this, "Enter a valid dentist name.");
                return;
            }
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(this, "Enter a valid email address.");
                return;
            }
            if (!phone.matches("0\\d{9}")) {
                JOptionPane.showMessageDialog(this, "Phone number must contain 10 digits and start with 0.");
                return;
            }
            success = dao.createDentistAccount(username, password, name, email, phone, specialization);
        }

        if (success) {
            JOptionPane.showMessageDialog(this, "Account created successfully.");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Unable to create account.");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void updateDentistFields() {
        if (cmbRole.getSelectedItem() == null) return;
        boolean dentist = "DENTIST".equalsIgnoreCase(cmbRole.getSelectedItem().toString());
        txtDentistName.setEnabled(dentist);
        txtEmail.setEnabled(dentist);
        txtPhone.setEnabled(dentist);
        txtSpecialization.setEnabled(dentist);
    }

    private void clearFields() {
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtDentistName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtSpecialization.setText("");
        cmbRole.setSelectedIndex(0);
        updateDentistFields();
        txtUsername.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox cmbRole;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblDentistName;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSpecialization;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtDentistName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSpecialization;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
