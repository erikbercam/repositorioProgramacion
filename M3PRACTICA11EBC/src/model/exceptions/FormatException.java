package model.exceptions;


public class FormatException extends Exception {
    
    private final String field;
    

    public FormatException(String field) {
        super("Formato incorrecto en el campo: " + field);
        this.field = field;
    }
    

    public FormatException(String message, String field) {
        super(message);
        this.field = field;
    }
    
  
    public String getField() {
        return field;
    }
}
