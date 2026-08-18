package view;

import dao.AppointmentDAO;
import dao.BillDAO;
import model.Appointment;
import model.Bill;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReportsForm extends javax.swing.JFrame {
    public ReportsForm(){initComponents();setLocationRelativeTo(null);showAllAppointments();}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnAll = new javax.swing.JButton();
        btnToday = new javax.swing.JButton();
        btnApproved = new javax.swing.JButton();
        btnRevenue = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReports = new javax.swing.JTable();
        lblSummary = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reports");

        btnAll.setText("All Appointments");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });
        pnlTop.add(btnAll);

        btnToday.setText("Today's Appointments");
        btnToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodayActionPerformed(evt);
            }
        });
        pnlTop.add(btnToday);

        btnApproved.setText("Approved Appointments");
        btnApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprovedActionPerformed(evt);
            }
        });
        pnlTop.add(btnApproved);

        btnRevenue.setText("Billing / Revenue");
        btnRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevenueActionPerformed(evt);
            }
        });
        pnlTop.add(btnRevenue);

        jScrollPane1.setViewportView(tblReports);

        lblSummary.setText("Total Records: 0");

        btnPrint.setText("Print Report");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        jLabel1.setText("Reports");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSummary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(233, 233, 233)
                .addComponent(btnClose)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void showAppointments(List<Appointment> list,String name){DefaultTableModel m=new DefaultTableModel(new String[]{"Appointment No","Patient","Dentist","Treatment","Date","Time","Status"},0){public boolean isCellEditable(int r,int c){return false;}};for(Appointment a:list)m.addRow(new Object[]{a.getAppointmentNo(),a.getPatientName(),a.getDentistName(),a.getTreatmentType(),a.getAppointmentDate(),a.getAppointmentTime(),a.getStatus()});tblReports.setModel(m);lblSummary.setText(name+" - Total Records: "+list.size());}
    private void showAllAppointments(){showAppointments(new AppointmentDAO().getAllAppointments(),"All Appointments");}
    private void showTodayAppointments(){showAppointments(new AppointmentDAO().getTodayAppointments(),"Today's Appointments");}
    private void showApprovedAppointments(){showAppointments(new AppointmentDAO().getApprovedAppointments(),"Approved Appointments");}
    private void showRevenueReport(){BillDAO dao=new BillDAO();List<Bill> bills=dao.getAllBills();DefaultTableModel m=new DefaultTableModel(new String[]{"Bill ID","Appointment No","Treatment Fee","Consultation Fee","Discount","Total","Bill Date"},0){public boolean isCellEditable(int r,int c){return false;}};for(Bill b:bills)m.addRow(new Object[]{b.getBillId(),b.getAppointmentNo(),b.getTreatmentFee(),b.getConsultationFee(),b.getDiscount(),b.getTotal(),b.getBillDate()});tblReports.setModel(m);lblSummary.setText("Billing Report - Total Bills: "+bills.size()+" | Total Revenue: Rs. "+String.format("%.2f",dao.getTotalRevenue()));}
    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        showAllAppointments();
    }//GEN-LAST:event_btnAllActionPerformed
    private void btnTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodayActionPerformed
        showTodayAppointments();
    }//GEN-LAST:event_btnTodayActionPerformed
    private void btnApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprovedActionPerformed
        showApprovedAppointments();
    }//GEN-LAST:event_btnApprovedActionPerformed
    private void btnRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevenueActionPerformed
        showRevenueReport();
    }//GEN-LAST:event_btnRevenueActionPerformed
    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try{tblReports.print(JTable.PrintMode.FIT_WIDTH);}catch(Exception e){JOptionPane.showMessageDialog(this,"Unable to print report: "+e.getMessage());}
    }//GEN-LAST:event_btnPrintActionPerformed
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnApproved;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRevenue;
    private javax.swing.JButton btnToday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSummary;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblReports;
    // End of variables declaration//GEN-END:variables
}
