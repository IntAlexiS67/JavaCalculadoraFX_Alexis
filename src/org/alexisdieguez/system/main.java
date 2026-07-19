package org.alexisdieguez.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.alexisdieguez.view.CalculadoraView;
import org.alexisdieguez.controller.CalculadoraController; // Importa el controlador

public class main extends Application {

    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        launch(args);
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        // 1. Instanciamos el controlador
        CalculadoraController controlador = new CalculadoraController();
        // 2. Pasamos el controlador al constructor de la vista
        CalculadoraView calculadora = new CalculadoraView(controlador);
        Pane raiz = new Pane(calculadora.getView());
        Scene escena = new Scene(raiz, 266, 390);

        escenarioPrincipal.setTitle("Calculadora de Alexis");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
