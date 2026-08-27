package view;

import dao.TreatmentTypeDAO;
import model.TreatmentType;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageTreatmentsForm extends javax.swing.JFrame {

    private int selectedTreatmentId = 0;

    public ManageTreatmentsForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadTreatments();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlEdit = new javax.swing.JPanel();
        lblSelectedText = new javax.swing.JLabel();
        lblSelectedTreatment = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtNewPrice = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTreatments = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Treatment Prices");

        lblSelectedText.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblSelectedText.setText("Selected Treatment:");

        lblSelectedTreatment.setFont(new java.awt.Font("Gill Sans MT", 2, 14)); // NOI18N
        lblSelectedTreatment.setText("No treatment selected");

        lblPrice.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblPrice.setText("New Price:");

        txtNewPrice.setColumns(12);

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblSelectedText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSelectedTreatment)
                .addGap(137, 137, 137)
                .addComponent(lblPrice)
                .addGap(18, 18, 18)
                .addComponent(txtNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSelectedTreatment)
                            .addComponent(lblSelectedText)))
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrice)
                            .addComponent(txtNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );

        lblTitle.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        lblTitle.setText("MANAGE TREATMENT PRICES");

        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblTreatments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTreatmentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTreatments);

        btnClose.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/refresh.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnUpdate.setText("Update Price");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(btnClose))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(36, 36, 36))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(20, 20, 20))
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
    }// </editor-fold>//GEN-END:initComponents

    private void tblTreatmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTreatmentsMouseClicked
        int row = tblTreatments.getSelectedRow();
        if (row == -1) return;
        selectedTreatmentId = Integer.parseInt(tblTreatments.getValueAt(row, 0).toString());
        lblSelectedTreatment.setText(tblTreatments.getValueAt(row, 1).toString());
        txtNewPrice.setText(tblTreatments.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblTreatmentsMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedTreatmentId == 0) {
            JOptionPane.showMessageDialog(this, "Select a treatment first.");
            return;
        }
        double price;
        try {
            price = Double.parseDouble(txtNewPrice.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Enter a valid treatment price.");
            return;
        }
        if (price <= 0) {
            JOptionPane.showMessageDialog(this, "Treatment price must be greater than zero.");
            return;
        }
        if (new TreatmentTypeDAO().updateTreatmentPrice(selectedTreatmentId, price)) {
            JOptionPane.showMessageDialog(this, "Treatment price updated successfully.");
            loadTreatments();
        } else {
            JOptionPane.showMessageDialog(this, "Unable to update treatment price.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        selectedTreatmentId = 0;
        lblSelectedTreatment.setText("No treatment selected");
        txtNewPrice.setText("");
        loadTreatments();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void loadTreatments() {
        DefaultTableModel model = (DefaultTableModel) tblTreatments.getModel();
        model.setRowCount(0);
        List<TreatmentType> list = new TreatmentTypeDAO().getAllTreatmentTypes();
        for (TreatmentType t : list) {
            model.addRow(new Object[] { t.getTreatmentTypeId(), t.getTypeName(), t.getDescription(), t.getFee() });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSelectedText;
    private javax.swing.JLabel lblSelectedTreatment;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JTable tblTreatments;
    private javax.swing.JTextField txtNewPrice;
    // End of variables declaration//GEN-END:variables
}
