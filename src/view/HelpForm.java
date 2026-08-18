package view;

public class HelpForm extends javax.swing.JFrame {
    private String role="STAFF";
    public HelpForm(){initComponents();setLocationRelativeTo(null);loadHelp();}
    public HelpForm(String role){this.role=role;initComponents();setLocationRelativeTo(null);loadHelp();}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHelp = new javax.swing.JTextArea();
        pnlButtons = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Help - Sunrise Dental Clinic");

        lblTitle.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        lblTitle.setText("HELP");

        txtHelp.setColumns(20);
        txtHelp.setRows(5);
        txtHelp.setEditable(false);
        txtHelp.setLineWrap(true);
        txtHelp.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtHelp);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(349, 349, 349)
                            .addComponent(lblTitle)
                            .addGap(213, 213, 213)
                            .addComponent(btnClose))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void loadHelp(){if("DENTIST".equalsIgnoreCase(role))txtHelp.setText("DENTIST HELP GUIDE\n\n1. Login using your dentist username and password.\n\n2. Open View / Approve Appointments to view appointments assigned to you.\n\n3. Select a pending appointment and approve or decline it.\n\n4. Open Manage Available Dates & Time Slots to enter your available dates and times.\n\n5. Open Patient Special Notes to enter or update special notes for patients.\n\n6. Logout when you finish using the system.");else txtHelp.setText("CLINIC STAFF HELP GUIDE\n\n1. Login using the clinic staff username and password.\n\n2. Register a new appointment using patient details, dentist, treatment, date and time.\n\n3. Search appointments using the appointment number.\n\n4. View Dentist Schedule before creating appointments.\n\n5. Calculate and print bills for approved appointments.\n\n6. View and print patient notes entered by dentists.\n\n7. Use Reports for appointment and revenue information.\n\n8. Logout when finished.");}
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JTextArea txtHelp;
    // End of variables declaration//GEN-END:variables
}
