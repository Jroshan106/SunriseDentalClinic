package view;

import dao.DentistAvailabilityDAO;
import model.DentistAvailability;
import model.User;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageAvailabilityForm extends javax.swing.JFrame {
    private User currentUser;
    public ManageAvailabilityForm(){initComponents();setLocationRelativeTo(null);setupTable();}
    public ManageAvailabilityForm(User currentUser){this();this.currentUser=currentUser;loadAvailability();}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        pnlDate = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        pnlStart = new javax.swing.JPanel();
        lblStartTime = new javax.swing.JLabel();
        txtStartTime = new javax.swing.JTextField();
        pnlEnd = new javax.swing.JPanel();
        lblEndTime = new javax.swing.JLabel();
        txtEndTime = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAvailability = new javax.swing.JTable();
        pnlButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Available Dates & Time Slots");

        lblTitle.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        lblTitle.setText("MANAGE AVAILABLE DATES & TIME");

        pnlForm.setLayout(new javax.swing.BoxLayout(pnlForm, javax.swing.BoxLayout.Y_AXIS));

        lblDate.setText("Available Date (YYYY-MM-DD):");

        txtDate.setColumns(15);

        javax.swing.GroupLayout pnlDateLayout = new javax.swing.GroupLayout(pnlDate);
        pnlDate.setLayout(pnlDateLayout);
        pnlDateLayout.setHorizontalGroup(
            pnlDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDateLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblDate)
                .addGap(57, 57, 57)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDateLayout.setVerticalGroup(
            pnlDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDateLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlForm.add(pnlDate);

        lblStartTime.setText("Start Time (HH:MM):");

        txtStartTime.setColumns(15);
        txtStartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStartLayout = new javax.swing.GroupLayout(pnlStart);
        pnlStart.setLayout(pnlStartLayout);
        pnlStartLayout.setHorizontalGroup(
            pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartLayout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(lblStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        pnlStartLayout.setVerticalGroup(
            pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStartTime)))
        );

        pnlForm.add(pnlStart);

        lblEndTime.setText("End Time (HH:MM):");

        txtEndTime.setColumns(15);

        javax.swing.GroupLayout pnlEndLayout = new javax.swing.GroupLayout(pnlEnd);
        pnlEnd.setLayout(pnlEndLayout);
        pnlEndLayout.setHorizontalGroup(
            pnlEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEndLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblEndTime)
                .addGap(118, 118, 118)
                .addComponent(txtEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEndLayout.setVerticalGroup(
            pnlEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEndLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        pnlForm.add(pnlEnd);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addComponent(lblTitle)
                .addGap(57, 57, 57)
                .addComponent(btnClose)
                .addGap(22, 22, 22))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(tblAvailability);

        btnAdd.setText("Add Availability");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlButtons.add(btnAdd);

        btnDelete.setText("Delete Selected");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlButtons.add(btnDelete);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        pnlButtons.add(btnRefresh);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        pnlButtons.add(btnClear);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setupTable(){tblAvailability.setModel(new DefaultTableModel(new Object[]{"ID","Date","Start Time","End Time","Available"},0){public boolean isCellEditable(int r,int c){return false;}});}
    private void loadAvailability(){if(currentUser==null||currentUser.getDentistId()==null)return;DefaultTableModel m=(DefaultTableModel)tblAvailability.getModel();m.setRowCount(0);for(DentistAvailability a:new DentistAvailabilityDAO().getByDentist(currentUser.getDentistId()))m.addRow(new Object[]{a.getAvailabilityId(),a.getAvailableDate(),a.getStartTime(),a.getEndTime(),a.isAvailable()?"Yes":"No"});}
    private void clearFields(){txtDate.setText("");txtStartTime.setText("");txtEndTime.setText("");}
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(currentUser==null||currentUser.getDentistId()==null){JOptionPane.showMessageDialog(this,"Please login as a dentist first.");return;}String date=txtDate.getText().trim(),start=txtStartTime.getText().trim(),end=txtEndTime.getText().trim();if(date.isEmpty()||start.isEmpty()||end.isEmpty()){JOptionPane.showMessageDialog(this,"Please fill all fields.");return;}LocalDate d;LocalTime s,e;try{d=LocalDate.parse(date);s=LocalTime.parse(start);e=LocalTime.parse(end);}catch(Exception ex){JOptionPane.showMessageDialog(this,"Date must be YYYY-MM-DD and time must be HH:MM.");return;}if(d.isBefore(LocalDate.now())){JOptionPane.showMessageDialog(this,"Available date cannot be in the past.");return;}if(!s.isBefore(e)){JOptionPane.showMessageDialog(this,"Start time must be before end time.");return;}List<DentistAvailability> existing=new DentistAvailabilityDAO().getByDentist(currentUser.getDentistId());for(DentistAvailability old:existing){if(date.equals(old.getAvailableDate())){LocalTime os=LocalTime.parse(old.getStartTime()),oe=LocalTime.parse(old.getEndTime());if(s.isBefore(oe)&&e.isAfter(os)){JOptionPane.showMessageDialog(this,"This time overlaps an existing availability slot.");return;}}}DentistAvailability a=new DentistAvailability();a.setDentistId(currentUser.getDentistId());a.setAvailableDate(date);a.setStartTime(start);a.setEndTime(end);a.setAvailable(true);if(new DentistAvailabilityDAO().addAvailability(a)){JOptionPane.showMessageDialog(this,"Availability added successfully.");clearFields();loadAvailability();}else JOptionPane.showMessageDialog(this,"Unable to add availability.");
    }//GEN-LAST:event_btnAddActionPerformed
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row=tblAvailability.getSelectedRow();if(row<0){JOptionPane.showMessageDialog(this,"Select an availability record.");return;}int id=Integer.parseInt(tblAvailability.getValueAt(row,0).toString());if(JOptionPane.showConfirmDialog(this,"Delete selected availability?","Confirm",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)return;if(new DentistAvailabilityDAO().deleteAvailability(id,currentUser.getDentistId())){JOptionPane.showMessageDialog(this,"Availability deleted.");loadAvailability();}else JOptionPane.showMessageDialog(this,"Unable to delete availability.");
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadAvailability();
    }//GEN-LAST:event_btnRefreshActionPerformed
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtStartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStartTimeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlDate;
    private javax.swing.JPanel pnlEnd;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlStart;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblAvailability;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEndTime;
    private javax.swing.JTextField txtStartTime;
    // End of variables declaration//GEN-END:variables
}
