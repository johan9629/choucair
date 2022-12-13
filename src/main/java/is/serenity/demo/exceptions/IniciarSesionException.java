package is.serenity.demo.exceptions;

public class IniciarSesionException extends RuntimeException {

    public static final String ELEMENT_NOT_FOUND = "No es posible iniciar sesion";

    public IniciarSesionException(String message) {
        super(message);
    }
}
