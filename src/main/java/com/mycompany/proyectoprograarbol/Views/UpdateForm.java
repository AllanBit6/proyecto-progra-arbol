package com.mycompany.proyectoprograarbol.Views;
import com.mycompany.proyectoprograarbol.Services.TreeService;
import com.mycompany.proyectoprograarbol.persistence.entities.*;
import javax.swing.JOptionPane;

public class UpdateForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UpdateForm.class.getName());
    TreeService sv;
    
    public UpdateForm(TreeService service) {
        initComponents();
        sv = service;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameEntry = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        directionEntry = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        balanceEntry = new javax.swing.JSpinner();
        addButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        codeEntry = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Modificar Cliente");

        jLabel1.setText("Nombres");

        jLabel2.setText("Departamento");

        directionEntry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Totonicapan", "Quetzaltenango", "Quiche", "San Marcos", "Solola", "El Progreso", "Huehuetenango", "Guatemala" }));

        jLabel3.setText("Saldo");

        balanceEntry.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        addButton.setText("Actualizar");
        addButton.addActionListener(this::addButtonActionPerformed);

        jLabel6.setText("Codigo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(nameEntry)
                            .addComponent(balanceEntry, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(directionEntry, 0, 221, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(codeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(directionEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(addButton)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String code = codeEntry.getText();
        String name = nameEntry.getText();
        String address = directionEntry.getSelectedItem().toString();
        double balance = (double) balanceEntry.getValue();

        if (code.isEmpty() || name.isEmpty()) {
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

            customer.setName(name);
            customer.setAddress(address);
            customer.setBalance(balance);

            sv.updateNode(customer);

            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar: " + e.getMessage());
        }
    }//GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JSpinner balanceEntry;
    private javax.swing.JTextField codeEntry;
    private javax.swing.JComboBox<String> directionEntry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nameEntry;
    // End of variables declaration//GEN-END:variables
}
