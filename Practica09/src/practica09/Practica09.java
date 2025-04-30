/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica09;

import java.util.Scanner;

public class Practica09 {
static Scanner sc = new Scanner(System.in);
static final int MAX_PAISES = 7;
static final int MAX_MEDALLAS = 3;
    public static void main(String[] args) {
 //  int [] [] cuenta = new int [MAX_PAISES] [MAX_MEDALLAS];
   String[] paises = {"Ecuador", "Bolivia", "Perukistan", "SanRoque", "TacosGalos", "Euroasia", "Euroarabia"};
   String [] medallas = {"ORO", "PLATA", "BRONCE");
   int [] [] contadorMedallas = {{0, 2, 3}, {15,16, 0}, { 10,0, 0}, {4, 6, 9}, {3,6,7}, {8, 23, 0}, {3, 3, 3}};
        for (String medalla : medallas) {
                  System.out.printf("%-10s", medalla);
        }
        System.out.println(" ");
        for (int i = 0; i < MAX_PAISES; i++) {
            System.out.printf("%-10s", paises[i]);
                        for (int j = 0; j < MAX_MEDALLAS; j++) {
                System.out.printf("%3d",contadorMedallas[i][j]) ;
            }
            System.out.println("");
        }

        }
        
        
        
        
//   int[] miArray1D = {1,2,3};
//   //int [] [] miArray2D =  new int[3] [4];
//   int [] [] miArray2D = {{1 , 2, 3, 4} , { 5, 7, 8, 9}, {10 , 11 ,12 ,13 } };
    }

