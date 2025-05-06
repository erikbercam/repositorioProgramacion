package model.exceptions;

/**
 * Excepción personalizada para errores de formato en campos específicos
 * @author User
 */
public class FormatException extends Exception {
    
    private final String field;
    
    /**
     * Constructor con especificación del campo que causó el error
     * @param field el campo con formato incorrecto
     */
    public FormatException(String field) {
        super("Formato incorrecto en el campo: " + field);
        this.field = field;
    }
    
    /**
     * Constructor con mensaje personalizado y campo
     * @param message el mensaje de error
     * @param field el campo con formato incorrecto
     */
    public FormatException(String message, String field) {
        super(message);
        this.field = field;
    }
    
    /**
     * Obtiene el campo que causó el error
     * @return el nombre del campo
     */
    public String getField() {
        return field;
    }
}