
package com.mycompany.proyectoprograarbol;
import com.mycompany.proyectoprograarbol.Views.MainView;
import com.formdev.flatlaf.FlatDarkLaf;


public class ProyectoPrograArbol {

    public static void main(String[] args) {
        FlatDarkLaf.setup();

        java.awt.EventQueue.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }
}
