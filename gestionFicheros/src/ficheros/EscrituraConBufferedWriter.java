   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erikbercam
 */
public class EscrituraConBufferedWriter {
    public static void main(String[] args)  {
        
        FileWriter fw = null;
        try {
            File fichero = new File("src\\ficheros\\ebc.txt");
            fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("primera");
            bw.write("segunda");
            bw.newLine();
            bw.write("tercera");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error de entrada-salida" + ex.getMessage());;
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(EscrituraConBufferedWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
}
