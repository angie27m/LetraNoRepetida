/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.primernorepetido;

import java.util.Scanner;

/**
 * Esta clase se encarga de encontrar la primer letra que no se repite dentro de
 * una cadena de texto haciendo una lectura letra por letra hasta el final de la
 * misma
 *
 * @author Angie Manrique
 * @version 1.0
 */
public class Procedimiento {

    /**
     * La variable cadenaIngresada guarda el texto ingresado por el usuario
     */
    private String cadenaIngresada;
    /**
     * La variable tipo char array es usada para conocer las letras que se
     * repiten
     */
    private char[] cadenaSeparada;
    /**
     * Contiene la primer letra que no se repite
     */
    private char letraSinRepetir;

    /**
     * Método constructor: Ingreso de la cadena de texto
     */
    public Procedimiento() {
        String seguir = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el texto:  ");
            cadenaIngresada = scanner.nextLine();
            separacion();
            Scanner respuesta = new Scanner(System.in);
            System.out.println("¿Desea continuar? S=>Si");
            seguir = respuesta.nextLine();
        } while (seguir.equals("s") || seguir.equals("S"));
    }

    /**
     * Este método se encarga de separar por caracteres el string ingresado por
     * el usuario
     *
     * @param contador esta variable es usada para identificar si es la primer
     * letra del texto
     */
    public void separacion() {
        cadenaSeparada = cadenaIngresada.toCharArray();
        byte contador = 1;
        letraSinRepetir = cadenaSeparada[0];
        for (int i = 0; i < cadenaIngresada.length(); i++) {
            if (contador == 1) {
                letraSinRepetir = cadenaSeparada[i];
                contador = 0;
            } else if (letraSinRepetir == cadenaSeparada[i]) {
                letraSinRepetir = validarUnica();
            } else if (letraSinRepetir == 0) {
                letraSinRepetir = validarRepetidas(cadenaSeparada[i]);
            }
            impresion(cadenaSeparada[i]);
        }
    }

    /**
     * Este método hace la validación de las letras dentro de la cadena
     * verificando si son iguales o no
     *
     * @param letraSinRepetir esta variable contiene la primer letra que no ha
     * sido repetida
     * @param acumulador variable usada para saber la cantidad de veces que se
     * ha repetido una letra dentro del texto
     * @return retorna la primer letra que encuentra sin repetirse
     */
    private char validarUnica() {
        int acumulador, i = 0, j = 0;
        while (i < cadenaSeparada.length) {
            if (cadenaSeparada[i] != letraSinRepetir) {
                acumulador=0;
                while (j < cadenaSeparada.length) {
                    if (cadenaSeparada[i] == cadenaSeparada[j]) {
                        acumulador++;
                    }
                    j++;
                }
                if (acumulador == 1) {
                    return cadenaSeparada[i];
                }
            }
            i++;

        }
        return 0;
    }

    /**
     * Busca las letras repetidas haciendo uso de un contador, cuando el
     * contador es igual a 1 retorna la letra guardada
     *
     * @param caracter
     * @return devuelve el caracter que está siendo comparado
     */
    private char validarRepetidas(char caracter) {
        int contador = 0;
        for (int i = 0; i < cadenaSeparada.length; i++) {
            if (cadenaSeparada[i] == caracter) {
                contador++;
            }
        }
        if (contador == 1) {
            return caracter;
        } else {
            return 0;
        }
    }

    /**
     * Este método se encarga de las impresiones del programa
     *
     * @param letraSinRepetir esta variable contiene la primer letra que no ha
     * sido repetida
     * @param caracter esta variable guarda la letra que esta siendo leída
     */
    private void impresion(char caracter) {
        if (letraSinRepetir == 0) {
            System.out.println("Reading: " + caracter);
            System.out.println("Todas las letras se repiten");
        } else {
            System.out.println("Reading: " + caracter);
            System.out.println("La primer letra que no se repite es: " + letraSinRepetir);
        }
    }
}
