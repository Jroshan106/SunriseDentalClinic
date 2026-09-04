package view;

import dao.UserDAO;
import model.User;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;

public class ManageUsersForm extends javax.swing.JFrame {

    private User currentUser;

    public ManageUsersForm(User currentUser) {
        initComponents();
        this.currentUser = currentUser;
        setLocationRelativeTo(null);

        setupTable();
        loadUsers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        pnlButtons = new javax.swing.JPanel();
        btnResetPassword = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage User Accounts");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        lblTitle.setText("MANAGE USER ACCOUNTS");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 36, -1, -1));

        jScrollPane1.setViewportView(tblUsers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 650, 304));

        btnResetPassword.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnResetPassword.setText("Reset Password");
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });
        pnlButtons.add(btnResetPassword);

        btnDelete.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnDelete.setText("Delete Account");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlButtons.add(btnDelete);

        jPanel1.add(pnlButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 423, 557, -1));

        btnClose.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/refresh.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        int row = tblUsers.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a user account first.");
            return;
        }

        int userId = Integer.parseInt(tblUsers.getValueAt(row, 0).toString());
        String username = tblUsers.getValueAt(row, 1).toString();
        JPasswordField txtNew = new JPasswordField();
        JPasswordField txtConfirm = new JPasswordField();
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("New Password:")); panel.add(txtNew);
        panel.add(new JLabel("Confirm Password:")); panel.add(txtConfirm);

        int option = JOptionPane.showConfirmDialog(this, panel, "Reset Password - " + username, JOptionPane.OK_CANCEL_OPTION);
        if (option != JOptionPane.OK_OPTION) return;

        String password = new String(txtNew.getPassword());
        String confirm = new String(txtConfirm.getPassword());
        if (password.length() < 4) {
            JOptionPane.showMessageDialog(this, "Password must contain at least 4 characters.");
            return;
        }
        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }

        if (new UserDAO().resetPassword(userId, password)) {
            JOptionPane.showMessageDialog(this, "Password reset successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Unable to reset password.");
        }
    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblUsers.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select an account first.");
            return;
        }

        int userId = Integer.parseInt(tblUsers.getValueAt(row, 0).toString());
        String username = tblUsers.getValueAt(row, 1).toString();
        String role = tblUsers.getValueAt(row, 2).toString();

        if ("ADMIN".equalsIgnoreCase(role)) {
            JOptionPane.showMessageDialog(this, "Admin accounts cannot be deleted.");
            return;
        }
        if (userId == currentUser.getUserId()) {
            JOptionPane.showMessageDialog(this, "You cannot delete your own account.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Delete account: " + username + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        if (new UserDAO().deleteUser(userId)) {
            JOptionPane.showMessageDialog(this, "Account deleted successfully.");
            loadUsers();
        } else {
            JOptionPane.showMessageDialog(this, "Unable to delete account.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadUsers();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    private void setupTable() {
        tblUsers.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "User ID",
                "Username",
                "Role",
                "Dentist ID",
                "Dentist Name"
            }
        )   {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    });
}
    private void loadUsers() {
        DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
        model.setRowCount(0);
        List<User> users = new UserDAO().getAllUsers();
        for (User user : users) {
            model.addRow(new Object[] {
                user.getUserId(), user.getUsername(), user.getRole(),
                user.getDentistId(), user.getDentistName()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JTable tblUsers;
    // End of variables declaration//GEN-END:variables
}
