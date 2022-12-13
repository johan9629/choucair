package is.serenity.demo.exceptions;

public class AgregarContactoException extends RuntimeException{
    public static final String ELEMENT_NOT_FUND = "No se logro agregar un nuevo contacto";

    public AgregarContactoException(String message) {
        super(message);
    }
}
