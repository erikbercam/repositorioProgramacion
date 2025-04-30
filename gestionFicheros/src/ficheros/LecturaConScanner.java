/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author erikbercam
 */
public class LecturaConScanner {
    static Scanner keyboard = new Scanner(System.in);
    static  Scanner scan = new Scanner(fichero);
    
    public static void main(String[] args) throws FileNotFoundException {
        File fileName = new File("C:\\Users\\erikbercam\\Desktop\\pruebas.txt");
        String opcion;
        do {
        
            try{
                    System.out.println("MENU:");
        System.out.println("1-Leer fichero");
        System.out.println("Z-Salir");
        
        System.out.println("Opcion: ");
        opcion = keyboard.next();
        
        switch (opcion) {
            case "1":
                String contentFile;
                contentFile =  leerFichero(fileName);
                break;
            case "z":
                scan.close();
                System.out.println("Saliendo...");
                 break;
            default:
                System.out.println("Opcion incorrecta"); 
            }                 
        } catch (FileNotFoundException ex){
                System.out.println("Error: " + ex.getMessage());
        }
        } while (!opcion.equals("z"));
      
        
    
   
}
 private String leerFichero(String fileName){
       String contenido=""; 
       File fileName = new File(fileName);
       Scanner scan = new Scanner(fichero);
        scan.useDelimiter("\n");
        String linea;
        while (scan.hasNext()) {
        linea= scan.next();
        contenido = contenido + linea + "\n";
        System.out.println(linea);
        }
        scan.close();
        return contenido;
    }
    }

