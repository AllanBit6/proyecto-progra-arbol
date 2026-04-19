package com.mycompany.proyectoprograarbol.Views;
import com.mxgraph.view.mxGraph;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.layout.mxCompactTreeLayout;

public class MainView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainView.class.getName());

    public MainView() {
        initComponents();
        
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 300));
        
        drawTree();
    }
    
    private void drawTree() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            // Nodos
            Object root = graph.insertVertex(parent, null, "A", 0, 0, 40, 40);
            Object left = graph.insertVertex(parent, null, "B", 0, 0, 40, 40);
            Object right = graph.insertVertex(parent, null, "C", 0, 0, 40, 40);

            // Conexiones
            graph.insertEdge(parent, null, "", root, left);
            graph.insertEdge(parent, null, "", root, right);

        } finally {
            graph.getModel().endUpdate();
        }

        mxCompactTreeLayout layout = new mxCompactTreeLayout(graph);
        layout.execute(parent);
        
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(graphComponent, java.awt.BorderLayout.CENTER);

        jPanel1.removeAll();
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(graphComponent, java.awt.BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        insertButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        trailsButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 866, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        jLabel1.setText("Datos");

        jLabel2.setText("Persistencia");

        insertButton.setText("Insertar");
        insertButton.addActionListener(this::insertButtonActionPerformed);

        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(this::deleteButtonActionPerformed);

        updateButton.setText("Editar");
        updateButton.addActionListener(this::updateButtonActionPerformed);

        loadButton.setText("Cargar");
        loadButton.addActionListener(this::loadButtonActionPerformed);

        saveButton.setText("Guardar");

        trailsButton.setText("Recorridos");
        trailsButton.addActionListener(this::trailsButtonActionPerformed);

        viewButton.setText("Ver Registros Completos");
        viewButton.addActionListener(this::viewButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(158, 158, 158))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(trailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insertButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(loadButton)
                .addGap(37, 37, 37)
                .addComponent(saveButton)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton)
                    .addComponent(loadButton)
                    .addComponent(saveButton)
                    .addComponent(viewButton))
                .addGap(18, 18, 18)
                .addComponent(trailsButton)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        InsertForm form = new InsertForm();
        form.setVisible(true);
    }//GEN-LAST:event_insertButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DeleteForm form = new DeleteForm();
        form.setVisible(true);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        UpdateForm form = new UpdateForm();
        form.setVisible(true);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void trailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailsButtonActionPerformed
        TrailForm form = new TrailForm();
        form.setVisible(true);
    }//GEN-LAST:event_trailsButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        RecordsForms form = new RecordsForms();
        form.setVisible(true);
    }//GEN-LAST:event_viewButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton trailsButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
