
package practica09;

import java.util.Scanner;

public class Ejemplo {
  static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] lista = new int[4];

       
        for (int i = 0; i < lista.length; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            lista[i] = sc.nextInt();
        }
        int targetSum = 8;
        boolean valorCorrecto = false;
        for (int i = 0; i < lista.length; i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[i] + lista[j] == targetSum) {
                    valorCorrecto = true;
                    break;
                }
            }
        }
        if (valorCorrecto) {
            System.out.println("Dan 8");
        } else {
            System.out.println("Prueba otros parguelas");
        }
    }
}


