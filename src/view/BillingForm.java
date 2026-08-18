package view;

import dao.AppointmentDAO;
import dao.BillDAO;
import model.Appointment;
import model.Bill;
import javax.swing.JOptionPane;

public class BillingForm extends javax.swing.JFrame {
    private static final double CONSULTATION_FEE=2000.00;
    private Appointment currentAppointment;
    public BillingForm(){initComponents();setLocationRelativeTo(null);txtConsultationFee.setText(String.format("%.2f",CONSULTATION_FEE));}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAppointmentNo = new javax.swing.JLabel();
        txtAppointmentNo = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReceipt = new javax.swing.JTextArea();
        txtDiscount = new javax.swing.JTextField();
        lblTreatmentFee = new javax.swing.JLabel();
        txtTreatmentFee = new javax.swing.JTextField();
        txtConsultationFee = new javax.swing.JTextField();
        lblConsultationFee = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblDiscount = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        btnCalculate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calculate & Print Bill");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAppointmentNo.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblAppointmentNo.setText("Appointment Number:");
        jPanel1.add(lblAppointmentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 147, -1, -1));

        txtAppointmentNo.setColumns(12);
        jPanel1.add(txtAppointmentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 144, 117, -1));

        btnSearch.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 145, 58, -1));

        txtReceipt.setEditable(false);
        txtReceipt.setColumns(20);
        txtReceipt.setRows(5);
        jScrollPane1.setViewportView(txtReceipt);

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCenterLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(pnlCenter, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 195, -1, -1));

        txtDiscount.setColumns(12);
        jPanel1.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 113, 154, -1));

        lblTreatmentFee.setText("Treatment Fee:");
        jPanel1.add(lblTreatmentFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 54, -1, -1));

        txtTreatmentFee.setColumns(12);
        jPanel1.add(txtTreatmentFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 51, 154, -1));

        txtConsultationFee.setColumns(12);
        jPanel1.add(txtConsultationFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 79, 154, -1));

        lblConsultationFee.setText("Consultation Fee:");
        jPanel1.add(lblConsultationFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 82, -1, -1));

        lblTotal.setText("Total:");
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 147, -1, -1));

        txtTotal.setColumns(12);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 144, 154, -1));

        lblDiscount.setText("Discount:");
        jPanel1.add(lblDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 116, -1, -1));
        jPanel1.add(pnlButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 465, 746, -1));

        btnCalculate.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnCalculate.setText("Calculate Bill");
        btnCalculate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 438, -1, -1));

        btnSave.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnSave.setText("Save Bill");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 438, -1, -1));

        btnPrint.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnPrint.setText("Print Bill");
        btnPrint.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 438, -1, -1));

        btnClose.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnClose.setText("Close");
        btnClose.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 6, 48, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 27, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String no=txtAppointmentNo.getText().trim();if(no.isEmpty()){JOptionPane.showMessageDialog(this,"Enter appointment number.");return;}currentAppointment=new AppointmentDAO().getAppointmentByNo(no);if(currentAppointment==null){JOptionPane.showMessageDialog(this,"Appointment not found.");return;}if(!"APPROVED".equalsIgnoreCase(currentAppointment.getStatus())&&!"COMPLETED".equalsIgnoreCase(currentAppointment.getStatus())){JOptionPane.showMessageDialog(this,"Bill can only be generated for an approved appointment. Current status: "+currentAppointment.getStatus());currentAppointment=null;return;}txtTreatmentFee.setText(String.format("%.2f",currentAppointment.getTreatmentFee()));txtDiscount.setText("0");txtTotal.setText("");txtReceipt.setText("");
    }//GEN-LAST:event_btnSearchActionPerformed
    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        if(currentAppointment==null){JOptionPane.showMessageDialog(this,"Search for an appointment first.");return;}double discount;try{discount=Double.parseDouble(txtDiscount.getText().trim());}catch(Exception e){JOptionPane.showMessageDialog(this,"Enter a valid discount.");return;}if(discount<0||discount>currentAppointment.getTreatmentFee()+CONSULTATION_FEE){JOptionPane.showMessageDialog(this,"Invalid discount amount.");return;}Bill b=new Bill();b.setTreatmentFee(currentAppointment.getTreatmentFee());b.setConsultationFee(CONSULTATION_FEE);b.setDiscount(discount);double total=b.calculateTotal();txtTotal.setText(String.format("%.2f",total));txtReceipt.setText("SUNRISE DENTAL CLINIC\nPATIENT BILL\n===============================\nAppointment: "+currentAppointment.getAppointmentNo()+"\nPatient: "+currentAppointment.getPatientName()+"\nDentist: "+currentAppointment.getDentistName()+"\nTreatment: "+currentAppointment.getTreatmentType()+"\n-------------------------------\nTreatment Fee: Rs. "+String.format("%.2f",currentAppointment.getTreatmentFee())+"\nConsultation Fee: Rs. "+String.format("%.2f",CONSULTATION_FEE)+"\nDiscount: Rs. "+String.format("%.2f",discount)+"\nTOTAL: Rs. "+String.format("%.2f",total));
    }//GEN-LAST:event_btnCalculateActionPerformed
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(currentAppointment==null||txtTotal.getText().trim().isEmpty()){JOptionPane.showMessageDialog(this,"Calculate the bill first.");return;}Bill b=new Bill();b.setAppointmentNo(currentAppointment.getAppointmentNo());b.setTreatmentFee(currentAppointment.getTreatmentFee());b.setConsultationFee(CONSULTATION_FEE);b.setDiscount(Double.parseDouble(txtDiscount.getText().trim()));b.setTotal(Double.parseDouble(txtTotal.getText().trim()));if(new BillDAO().saveBill(b))JOptionPane.showMessageDialog(this,"Bill saved successfully.");else JOptionPane.showMessageDialog(this,"Unable to save bill.");
    }//GEN-LAST:event_btnSaveActionPerformed
    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        if(txtReceipt.getText().trim().isEmpty()){JOptionPane.showMessageDialog(this,"Calculate the bill first.");return;}try{txtReceipt.print();}catch(Exception e){JOptionPane.showMessageDialog(this,"Printing failed: "+e.getMessage());}
    }//GEN-LAST:event_btnPrintActionPerformed
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAppointmentNo;
    private javax.swing.JLabel lblConsultationFee;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTreatmentFee;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JTextField txtAppointmentNo;
    private javax.swing.JTextField txtConsultationFee;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextArea txtReceipt;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTreatmentFee;
    // End of variables declaration//GEN-END:variables
}
