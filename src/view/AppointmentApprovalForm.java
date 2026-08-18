package view;

import dao.AppointmentDAO;
import model.Appointment;
import model.User;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AppointmentApprovalForm extends javax.swing.JFrame {
    private User currentUser;
    public AppointmentApprovalForm(){initComponents();setLocationRelativeTo(null);setupTable();}
    public AppointmentApprovalForm(User currentUser){this();this.currentUser=currentUser;loadAppointments();}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        btnApprove = new javax.swing.JButton();
        btnDecline = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Approve / Decline Appointments");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        lblTitle.setText("MY APPOINTMENTS");
        jPanel2.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 230, 39));

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel2.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 80, -1));

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/refresh.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 40, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane1.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(tblAppointments);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 660, 330));

        btnApprove.setBackground(new java.awt.Color(143, 215, 81));
        btnApprove.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnApprove.setText("Approve");
        btnApprove.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 51), new java.awt.Color(0, 153, 255)));
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });
        jPanel2.add(btnApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 100, 29));

        btnDecline.setBackground(new java.awt.Color(255, 153, 153));
        btnDecline.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnDecline.setText("Decline");
        btnDecline.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 51), new java.awt.Color(51, 153, 255)));
        btnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineActionPerformed(evt);
            }
        });
        jPanel2.add(btnDecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 100, 29));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/BG - Copy.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setupTable(){tblAppointments.setModel(new DefaultTableModel(new Object[]{"Appointment No","Patient","Treatment","Date","Time","Status"},0){public boolean isCellEditable(int r,int c){return false;}});}
    private void loadAppointments(){if(currentUser==null||currentUser.getDentistId()==null)return;DefaultTableModel m=(DefaultTableModel)tblAppointments.getModel();m.setRowCount(0);for(Appointment a:new AppointmentDAO().getAppointmentsForDentist(currentUser.getDentistId()))m.addRow(new Object[]{a.getAppointmentNo(),a.getPatientName(),a.getTreatmentType(),a.getAppointmentDate(),a.getAppointmentTime(),a.getStatus()});}
    private void updateStatus(String status){if(currentUser==null)return;int row=tblAppointments.getSelectedRow();if(row<0){JOptionPane.showMessageDialog(this,"Select an appointment.");return;}String no=tblAppointments.getValueAt(row,0).toString(),current=tblAppointments.getValueAt(row,5).toString();if(!"PENDING".equalsIgnoreCase(current)){JOptionPane.showMessageDialog(this,"Only pending appointments can be approved or declined.");return;}if(JOptionPane.showConfirmDialog(this,"Change appointment status to "+status+"?","Confirm",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)return;if(new AppointmentDAO().updateAppointmentStatus(no,currentUser.getDentistId(),status)){JOptionPane.showMessageDialog(this,"Appointment status updated to "+status+".");loadAppointments();}else JOptionPane.showMessageDialog(this,"Unable to update appointment.");}
    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        updateStatus("APPROVED");
    }//GEN-LAST:event_btnApproveActionPerformed
    private void btnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineActionPerformed
        updateStatus("DECLINED");
    }//GEN-LAST:event_btnDeclineActionPerformed
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadAppointments();
    }//GEN-LAST:event_btnRefreshActionPerformed
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDecline;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblAppointments;
    // End of variables declaration//GEN-END:variables
}
