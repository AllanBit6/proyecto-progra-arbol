package com.mycompany.proyectoprograarbol.Views;
import com.mxgraph.view.mxGraph;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mycompany.proyectoprograarbol.Services.TreeService;
import com.mycompany.proyectoprograarbol.persistence.entities.*;
import javax.swing.JOptionPane;

public class MainView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainView.class.getName());
    private Node raiz;
    private TreeService service = new TreeService();
    
    public MainView() {
        initComponents();
        
        
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 300));
        
    }
    
    private void drawTree(Node raiz) {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            if (raiz != null) {
                drawNode(graph, parent, raiz, null, 200, 50, 100);
            }
        } finally {
            graph.getModel().endUpdate();
        }

        mxCompactTreeLayout layout = new mxCompactTreeLayout(graph);
        layout.execute(graph.getDefaultParent());

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        jPanel1.removeAll();
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(graphComponent, java.awt.BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private Object drawNode(mxGraph graph, Object parent, Node nodo,
        Object parentVertex, int x, int y, int offset) {

        if (nodo == null) return null;

        String label = nodo.data.getCode() + "-" + nodo.data.getName();

        Object vertex = graph.insertVertex(parent, null, label, x, y, 60, 40);

        if (parentVertex != null) {
            graph.insertEdge(parent, null, "", parentVertex, vertex);
        }
        drawNode(graph, parent, nodo.left, vertex,
                 x - offset, y + 80, offset / 2);
        drawNode(graph, parent, nodo.right, vertex,
                 x + offset, y + 80, offset / 2);

        return vertex;
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
        searchButton = new javax.swing.JButton();

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
        saveButton.addActionListener(this::saveButtonActionPerformed);

        trailsButton.setText("Recorridos");
        trailsButton.addActionListener(this::trailsButtonActionPerformed);

        viewButton.setText("Ver Registros Completos");
        viewButton.addActionListener(this::viewButtonActionPerformed);

        searchButton.setText("Buscar Registro");
        searchButton.addActionListener(this::searchButtonActionPerformed);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(loadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(139, 139, 139))
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
                    .addComponent(viewButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(trailsButton)
                        .addComponent(searchButton))
                    .addComponent(saveButton))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        InsertForm form = new InsertForm(service);
        
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                drawTree(service.getTreeAsync());
            }
        });
        
        form.setVisible(true);
    }//GEN-LAST:event_insertButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        raiz = service.getTreeAsync();
        drawTree(raiz);
    }//GEN-LAST:event_loadButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DeleteForm form = new DeleteForm(service);
        
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                drawTree(service.getTreeAsync());
            }
        });
        
        form.setVisible(true);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        UpdateForm form = new UpdateForm(service);
        
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                drawTree(service.getTreeAsync());
            }
        });
        
        form.setVisible(true);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void trailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailsButtonActionPerformed
        TrailForm form = new TrailForm(service);
        form.setVisible(true);
    }//GEN-LAST:event_trailsButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        RecordsForms form = new RecordsForms(service);
        form.setVisible(true);
    }//GEN-LAST:event_viewButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
        try{
            service.saveAsync();
            JOptionPane.showMessageDialog(null, "Sincronizado con BD exitosamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al sincronizar con BD");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        SearchForm form = new SearchForm(service);
        form.setVisible(true);
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton trailsButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
