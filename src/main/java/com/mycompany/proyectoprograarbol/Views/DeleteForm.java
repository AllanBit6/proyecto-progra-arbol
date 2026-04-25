package com.mycompany.proyectoprograarbol.Views;
import com.mycompany.proyectoprograarbol.Services.TreeService;
import com.mycompany.proyectoprograarbol.persistence.entities.*;
import javax.swing.JOptionPane;

public class DeleteForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DeleteForm.class.getName());
    TreeService sv;
    
    public DeleteForm(TreeService service) {
        initComponents();
        sv = service;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        codeEntry = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Eliminar Cliente");

        codeEntry.addActionListener(this::codeEntryActionPerformed);

        jLabel1.setText("Codigo en arbol del cliente");

        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(this::deleteButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(codeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(deleteButton)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
         String code = codeEntry.getText();

        if (code.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se deben rellenar todos los campos");
            return;
        }

        try {
            Customer searchCustomer = new Customer();
            searchCustomer.setCode(code);

            Node node = sv.searchNode(searchCustomer);

            if (node == null) {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                return;
            }

            Customer customer = node.data;
            sv.deleteNode(customer);

            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void codeEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeEntryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeEntryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeEntry;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
