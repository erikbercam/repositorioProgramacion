
package model.exceptions;


public class InvalidDataException extends Exception {
    
  
    public InvalidDataException() {
        super("Datos inválidos");
    }
    
    public InvalidDataException(String message) {
        super(message);
    }
}
