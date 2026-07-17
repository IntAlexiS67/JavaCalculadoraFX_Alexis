package org.alexisdieguez.view;
 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.alexisdieguez.controller.CalculadoraController;
 
public class CalculadoraView {
 
    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;
    // Controlador
    private CalculadoraController controlador;
 
    // CONSTRUCTOR CORREGIDO: Recibe el controlador y lo asigna
    public CalculadoraView(CalculadoraController controlador) {
        this.controlador = controlador;
 
        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #F788E1;");
 
        pantalla = new Label("0");
        pantalla.setFont(Font.font("-fx-background-color: #FFD6F4; Consolas;-fx-text-fill: #AB6F97", FontWeight.BOLD, 40));
        pantalla.setMaxWidth(Double.MAX_VALUE); // Ocupa todo el ancho
        pantalla.setAlignment(Pos.CENTER_RIGHT); // Alineado a la derecha
// Fondo blanco y padding para que no toque el borde
        pantalla.setStyle("-fx-background-color: white; -fx-padding: 0 10 0 0;");
 
        cuadroBotones = new GridPane();
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);
 
        //  Configuración de Botones 
        
        // -- Primera fila de botones 
        Button btnClearNum = nuevoBoton("C");
        Button btnPunto = nuevoBoton(".");
        Button btnCero = nuevoBoton("0");
        Button btnDivisor = nuevoBoton("/");
        
        // -- Segunda fila de botones (7, 8, 9, *)
        Button btnSiete = nuevoBoton("7");
        Button btnOcho = nuevoBoton("8");
        Button btnNueve = nuevoBoton("9");
        Button btnMultiplicar = nuevoBoton("*");
        
        //-- Tercera fila de botones (4, 5, 6, -)
        Button btnCuatro = nuevoBoton("4");
        Button btnCinco = nuevoBoton("5");
        Button btnSeis = nuevoBoton("6");
        Button btnMenos = nuevoBoton("-");
        
        //-- Cuarta fila de botones (1, 2, 3, +)
        Button btnUno = nuevoBoton("1");
        Button btnDos = nuevoBoton("2");
        Button btnTres = nuevoBoton("3");
        Button btnMas = nuevoBoton("+");
        
        //-- Quinta fila de botones
        Button btnPorcentaje = nuevoBoton("%");
        Button btnRaiz = nuevoBoton("√");
        Button btnPotencia = nuevoBoton("^");
        Button btnIgual = nuevoBoton("=");
 
        // Fila 1
        cuadroBotones.add(btnRaiz, 0, 0);
        cuadroBotones.add(btnPotencia, 1, 0);
        cuadroBotones.add(btnPorcentaje, 2, 0);
        cuadroBotones.add(btnClearNum, 3, 0);
 
        // Fila 2
        cuadroBotones.add(btnSiete, 0, 1);
        cuadroBotones.add(btnOcho, 1, 1);
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnDivisor, 3, 1);
 
        // Fila 3
        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2);
        cuadroBotones.add(btnMultiplicar, 3, 2);
 
        // Fila 4
        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMenos, 3, 3);
 
        // Fila 5
        cuadroBotones.add(btnPunto, 0, 4);
        cuadroBotones.add(btnCero, 1, 4);
        cuadroBotones.add(btnMas, 2, 4);
        cuadroBotones.add(btnIgual, 3, 4);
 
        view.getChildren().addAll(pantalla, cuadroBotones);
    }
 
    public VBox getView() {
        return view;
    }
 
    private Button nuevoBoton(String texto) {
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));
        btn.setStyle("-fx-background-color: #FFB5ED; -fx-text-fill:white; -fx-background-radius:5px; -fx-cursor: hand;");
 
        btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color: #D4A5C4; -fx-text-fill:white; -fx-background-radius:5px;");
            btn.setTranslateY(2);
        });
        btn.setOnMouseReleased(e -> {
            btn.setStyle("-fx-background-color: #FFB5ED; -fx-text-fill:white; -fx-background-radius:5px;");
            btn.setTranslateY(0);
        });
 
        // Ahora sí funciona porque controlador ya está inicializado
        btn.setOnAction(e -> controlador.procesoDeEntrada(texto, pantalla));
        return btn;
    }
}