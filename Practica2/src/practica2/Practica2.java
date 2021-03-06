/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res;
        String operacion;
        boolean comprobar = false;

        do {
            String numero1;
            do {
                imprimir("Introdueix el primer numero. ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);

            do {

                imprimir("\nOperació? (Indica el signe)\n+ = sumar \n- = restar \n"
                        + "x = multiplicar \n/ = dividir\n* = elevar primer num al segon num."
                        + "\n% = residu\n");

                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                } else {
                    comprobar = false;
                }
            } while (comprobar != true);

            String numero2;
            do {
                imprimir("\nIntrodueix el segon numero.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2); 

            do {
                comprobar = true;

               res = operarCalculadora(operacion, n1, n2);     

            } while (comprobar != true);

            imprimir("(" + numero1 + ") " + operacion + " (" + numero2 + ")"
                    + " = " + res + "\n\nVols continuar operant?\n[s/n]");

            do {
                comprobar = true;
                operacion = sc.nextLine();

                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\nError, posa un valor vàlid.\n");
                        comprobar = false;
                }
            } while (comprobar != true);
        } while (operacion.equals("s") || operacion.equals("S"));
    }

    public static void imprimir(String frase) {

        System.out.println(frase);

    }

    public static double operarCalculadora(String operacion, double n1, double n2) {

        double res = 0;
        Scanner sc = new Scanner(System.in);
        String numero2;
        double nume2;

        switch (operacion) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "x":
            case "X":
                res = n1 * n2;
                break;
            case "/":
                while (n2 == 0) {
                    do {
                        System.err.println("\nAl denominador hi ha un zero \n"
                                + "per a evitar errors coloca un altre valor.");
                        numero2 = sc.nextLine();
                    } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                    nume2 = Double.parseDouble(numero2);
                    n2 = new Double(numero2);
                }
                res = n1 / n2;
                break;
            case "*":
                res = Math.pow(n1, n2);
                break;
            case "%":
                while (n2 == 0) {
                    do {
                        System.err.println("\nAl denominador hi ha un zero \n"
                                + "per a evitar errors coloca un altre valor.");
                        numero2 = sc.nextLine();
                    } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                    nume2 = Double.parseDouble(numero2);
                    n2 = new Double(numero2);
                }
                res = n1 % n2;
                break;
        }

        return res;
    }
}
