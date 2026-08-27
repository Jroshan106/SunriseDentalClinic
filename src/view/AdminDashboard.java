package view;

import model.User;
import javax.swing.JOptionPane;
import view.Login;
import view.ManageTreatmentsForm;

public class AdminDashboard extends javax.swing.JFrame {

    private User currentUser;

    public AdminDashboard(User currentUser) {
        initComponents();
        this.currentUser = currentUser;
        lblAdmin.setText("Logged in as: " + currentUser.getUsername());
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnCreateAccount = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();
        btnTreatments = new javax.swing.JButton();
        lblAdmin = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sunrise Dental Clinic - Admin Dashboard");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        lblTitle.setText("ADMIN DASHBOARD");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        btnCreateAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/add-user.png"))); // NOI18N
        btnCreateAccount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 100, 85));

        btnManageUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/user-edit.png"))); // NOI18N
        btnManageUsers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });
        jPanel1.add(btnManageUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 100, 85));

        btnTreatments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/medical-price.png"))); // NOI18N
        btnTreatments.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTreatments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTreatmentsActionPerformed(evt);
            }
        });
        jPanel1.add(btnTreatments, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 100, 85));

        lblAdmin.setFont(new java.awt.Font("Gill Sans MT", 2, 14)); // NOI18N
        lblAdmin.setText("Welcome, ");
        jPanel1.add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnLogout.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        btnExit.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel2.setText("Create New Account");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel3.setText("Manage Treatment Prices");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel4.setText("Manage User Accounts");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logo (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/BG - Copy.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        new CreateAccountForm().setVisible(true);
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
        new ManageUsersForm(currentUser).setVisible(true);
    }//GEN-LAST:event_btnManageUsersActionPerformed

    private void btnTreatmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTreatmentsActionPerformed
        new ManageTreatmentsForm().setVisible(true);
    }//GEN-LAST:event_btnTreatmentsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton btnTreatments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
