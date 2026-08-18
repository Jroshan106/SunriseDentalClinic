package view;

import dao.AppointmentDAO;
import dao.PatientNoteDAO;
import model.Appointment;
import model.PatientNote;
import java.util.List;
import javax.swing.JOptionPane;

public class StaffNotesForm extends javax.swing.JFrame {
    public StaffNotesForm(){initComponents();setLocationRelativeTo(null);}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSearch = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        pnlButtons = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblAppointmentNo = new javax.swing.JLabel();
        txtAppointmentNo = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View / Print Patient Notes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnlSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, -1));

        txtNotes.setEditable(false);
        txtNotes.setColumns(20);
        txtNotes.setLineWrap(true);
        txtNotes.setRows(5);
        txtNotes.setWrapStyleWord(true);
        txtNotes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(txtNotes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 125, 660, 284));

        btnPrint.setText("Print Notes");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(btnPrint)
                .addGap(29, 29, 29)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlButtonsLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnClear))
                    .addGroup(pnlButtonsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrint)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(pnlButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        lblAppointmentNo.setText("Appointment Number:");
        getContentPane().add(lblAppointmentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 87, -1, -1));

        txtAppointmentNo.setColumns(15);
        getContentPane().add(txtAppointmentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 84, -1, -1));

        btnSearch.setText("View Notes");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 84, -1, -1));

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 16, -1, -1));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        jLabel1.setText("Special Notes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 16, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String no=txtAppointmentNo.getText().trim();if(no.isEmpty()){JOptionPane.showMessageDialog(this,"Enter appointment number.");return;}Appointment a=new AppointmentDAO().getAppointmentByNo(no);if(a==null){txtNotes.setText("");JOptionPane.showMessageDialog(this,"Appointment not found.");return;}List<PatientNote> notes=new PatientNoteDAO().getNotesByAppointment(no);StringBuilder sb=new StringBuilder("SUNRISE DENTAL CLINIC\nPATIENT SPECIAL NOTES\n===========================================\nAppointment No : "+a.getAppointmentNo()+"\nPatient : "+a.getPatientName()+"\nDentist : "+a.getDentistName()+"\nTreatment : "+a.getTreatmentType()+"\nDate : "+a.getAppointmentDate()+"\n===========================================\n\n");if(notes.isEmpty())sb.append("No special notes have been added.\n");else for(PatientNote n:notes)sb.append("Dentist: ").append(n.getDentistName()).append("\nNote Date: ").append(n.getNoteDate()).append("\nSpecial Note:\n").append(n.getNote()).append("\n-------------------------------------------\n");txtNotes.setText(sb.toString());
    }//GEN-LAST:event_btnSearchActionPerformed
    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        if(txtNotes.getText().trim().isEmpty()){JOptionPane.showMessageDialog(this,"Search for patient notes first.");return;}try{txtNotes.print();}catch(Exception e){JOptionPane.showMessageDialog(this,"Printing failed: "+e.getMessage());}
    }//GEN-LAST:event_btnPrintActionPerformed
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtAppointmentNo.setText("");txtNotes.setText("");
    }//GEN-LAST:event_btnClearActionPerformed
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAppointmentNo;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JTextField txtAppointmentNo;
    private javax.swing.JTextArea txtNotes;
    // End of variables declaration//GEN-END:variables
}
