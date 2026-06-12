package org.alexisdieguez.system;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main extends Application {


    
    @Override
public void start(Stage escenarioPrincipal) throws Exception {



    VBox raiz = new VBox(10);
    raiz.setAlignment(Pos.CENTER);

    Scene escena = new Scene(raiz, 400, 300);

    escenarioPrincipal.setTitle("Mi Calculadora Alexis Diéguez");
    escenarioPrincipal.setScene(escena);
    escenarioPrincipal.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
