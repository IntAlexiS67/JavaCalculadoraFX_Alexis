package org.alexisdieguez.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class CalculadoraController {

    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = false;

    public CalculadoraController() {
    }

    public void procesoDeEntrada(String entrada, Label pantalla) {
        switch (entrada) {
            case "C":
                opcion1 = "";
                operador = "";
                opcion2 = "";
                calculoTerminado = false;
                pantalla.setText("0");
                break;

            case "+":
            case "-":
            case "*":
            case "/":
            case "√":
                // Si presionamos un operador tras un cálculo, el resultado anterior es el inicio
                if (calculoTerminado) {
                    calculoTerminado = false;
                }
                if (!opcion1.isEmpty()) {
                    operador = entrada;
                }
                actualizarPantalla(pantalla);
                break;

            case ".":
                if (calculoTerminado) {
                    calculoTerminado = false;
                    opcion1 = "0.";
                    opcion2 = "";
                    operador = "";
                } else {
                    if (operador.isEmpty()) {
                        if (opcion1.isEmpty()) {
                            opcion1 = "0.";
                        } else if (!opcion1.contains(".")) {
                            opcion1 += ".";
                        }
                    } else {
                        if (opcion2.isEmpty()) {
                            opcion2 = "0.";
                        } else if (!opcion2.contains(".")) {
                            opcion2 += ".";
                        }
                    }
                }
                actualizarPantalla(pantalla);
                break;

            case "=":
                if (!opcion1.isEmpty() && operador.equals("√")) {
                    opcion1 = calcular(opcion1, "", operador);
                    operador = "";
                    opcion2 = "";
                    calculoTerminado = true;
                } else if (!opcion1.isEmpty() && !opcion2.isEmpty() && !operador.isEmpty()) {
                    opcion1 = calcular(opcion1, opcion2, operador);
                    operador = "";
                    opcion2 = "";
                    calculoTerminado = true;
                }
                actualizarPantalla(pantalla);
                break;

            default:
                // Bloque para manejar la entrada de números (0-9)
                if (entrada.matches("[0-9]")) {
                    if (calculoTerminado) {
                        calculoTerminado = false;
                        opcion1 = entrada;
                        opcion2 = "";
                        operador = "";
                    } else {
                        if (operador.isEmpty()) {
                            opcion1 += entrada;
                        } else {
                            opcion2 += entrada;
                        }
                    }
                    actualizarPantalla(pantalla);
                }
                break;
        }
    }

    private void actualizarPantalla(Label pantalla) {
        pantalla.setMaxWidth(Double.MAX_VALUE);
        pantalla.setAlignment(Pos.CENTER_RIGHT);

        if (opcion1.isEmpty()) {
            pantalla.setText("0");
        } else if (operador.isEmpty()) {
            pantalla.setText(opcion1);
        } else if (opcion2.isEmpty()) {
            pantalla.setText(opcion1 + " " + operador);
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2);
        }
    }

    // Métodos de operaciones matemáticas
    private String calcular(String num1, String num2, String op) {
        switch (op) {
            case "+":
                return resultadoSuma(num1, num2);
            case "-":
                return resultadoResta(num1, num2);
            case "*":
                return resultadoMultiplicacion(num1, num2);
            case "/":
                return resultadoDivision(num1, num2);
            case "√":
                return resultadoRadical(num1);
            default:
                return num1;
        }
    }

    private String formatearResultado(double valor) {
        // Si el resultado equivale a un entero (ej: 5.0), devolvemos "5" para limpiar la pantalla
        if (valor % 1 == 0) {
            return String.valueOf((int) valor);
        }
        return String.valueOf(valor);
    }

    private String resultadoSuma(String numeroUno, String numeroDos) {
        double datoUno = Double.parseDouble(numeroUno.trim());
        double datoDos = Double.parseDouble(numeroDos.trim());
        return formatearResultado(datoUno + datoDos);
    }

    private String resultadoResta(String numeroUno, String numeroDos) {
        double datoUno = Double.parseDouble(numeroUno.trim());
        double datoDos = Double.parseDouble(numeroDos.trim());
        return formatearResultado(datoUno - datoDos);
    }

    private String resultadoDivision(String numeroUno, String numeroDos) {
        double datoUno = Double.parseDouble(numeroUno.trim());
        double datoDos = Double.parseDouble(numeroDos.trim());

        if (datoDos == 0) {
            return "Error";
        }
        return formatearResultado(datoUno / datoDos);
    }

    private String resultadoMultiplicacion(String numeroUno, String numeroDos) {
        double datoUno = Double.parseDouble(numeroUno.trim());
        double datoDos = Double.parseDouble(numeroDos.trim());
        return formatearResultado(datoUno * datoDos);
    }

    private String resultadoRadical(String numeroUno) {
        double datoUno = Double.parseDouble(numeroUno.trim());
        if (datoUno < 0) {
            return "Error";
        }
        return formatearResultado(Math.sqrt(datoUno));
    }

}
