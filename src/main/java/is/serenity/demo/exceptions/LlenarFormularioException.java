package is.serenity.demo.exceptions;

public class LlenarFormularioException extends RuntimeException{

    public static final String ELEMENT_NOT_FOUND = "No se puede llenar el fomulario de creacion de contacto";

    public LlenarFormularioException(String message) {
        super(message);
    }
}
