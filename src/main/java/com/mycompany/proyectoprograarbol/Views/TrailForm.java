package com.mycompany.proyectoprograarbol.Views;
import com.mycompany.proyectoprograarbol.Services.TreeService;
import com.mycompany.proyectoprograarbol.persistence.entities.*;
import java.util.List;
import javax.swing.JOptionPane;

public class TrailForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TrailForm.class.getName());
    TreeService sv;
    
    public TrailForm(TreeService service) {
        initComponents();
        sv = service;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        enordenButton = new javax.swing.JButton();
        postordenButton = new javax.swing.JButton();
        preordenButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        enordenButton.setText("Enorden");
        enordenButton.addActionListener(this::enordenButtonActionPerformed);

        postordenButton.setText("Postorden");
        postordenButton.addActionListener(this::postordenButtonActionPerformed);

        preordenButton.setText("Preorden");
        preordenButton.addActionListener(this::preordenButtonActionPerformed);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Recorridos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enordenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(postordenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(preordenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(279, 279, 279))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enordenButton)
                        .addGap(18, 18, 18)
                        .addComponent(postordenButton)
                        .addGap(18, 18, 18)
                        .addComponent(preordenButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enordenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enordenButtonActionPerformed
        logArea.setText("");
        List<Customer>lista = sv.getInOrder();
        String cad = "";
        
        for(Customer c: lista){
            cad += c.getId() + "-" + c.getName() + "-" + c.getCode()+"\n";
        }
        logArea.setText(cad);
        
    }//GEN-LAST:event_enordenButtonActionPerformed

    private void postordenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postordenButtonActionPerformed
        logArea.setText("");
        List<Customer>lista = sv.getPostOrder();
        String cad = "";
        
        for(Customer c: lista){
            cad += c.getId() + "-" + c.getName() + "-" + c.getCode()+"\n";
        }
        logArea.setText(cad);
    }//GEN-LAST:event_postordenButtonActionPerformed

    private void preordenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preordenButtonActionPerformed
        logArea.setText("");
        List<Customer>lista = sv.getPreOrder();
        String cad = "";
        
        for(Customer c: lista){
            cad += c.getId() + "-" + c.getName() + "-" + c.getCode()+"\n";
        }
        logArea.setText(cad);
    }//GEN-LAST:event_preordenButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enordenButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logArea;
    private javax.swing.JButton postordenButton;
    private javax.swing.JButton preordenButton;
    // End of variables declaration//GEN-END:variables
}
