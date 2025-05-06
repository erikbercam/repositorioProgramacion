
package model.exceptions;

/**
 * Excepción personalizada para datos inválidos generales
 * @author User
 */
public class InvalidDataException extends Exception {
    
    /**
     * Constructor por defecto
     */
    public InvalidDataException() {
        super("Datos inválidos");
    }
    
    /**
     * Constructor con mensaje personalizado
     * @param message el mensaje de error
     */
    public InvalidDataException(String message) {
        super(message);
    }
}