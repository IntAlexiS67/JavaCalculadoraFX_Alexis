
package org.alexisdieguez.controller;

import javafx.scene.control.Label;

public class CalculadoraController {
    private String opcion = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = true;
    public CalculadoraController(){
    }
        public void procesoDeEntrada(String entrada, Label pantalla){
            if (entrada.matches("[0-9]")) {
                if (operador.isEmpty()) {
                    opcion += entrada;
                }
                actualizarPantalla (pantalla);
            }
        }
        private void actualizarPantalla(Label pantalla){
            if (operador.isEmpty()) {
                pantalla.setText(opcion);
            }
        }
    }

