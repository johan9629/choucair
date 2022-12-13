package is.serenity.demo.exceptions;

public class AbrirPaginaException extends RuntimeException{
    public static final String ELEMENT_NOT_FOUND = "No se encontro la url";

    public AbrirPaginaException(String message) {
        super(message);
    }
}
