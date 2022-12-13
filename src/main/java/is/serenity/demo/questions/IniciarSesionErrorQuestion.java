package is.serenity.demo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static is.serenity.demo.userinterfaces.IniciarSesionUserInterface.DIV_INCIAR_SESION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarSesionErrorQuestion implements Question<Boolean> {

    private String mensaje;

    public IniciarSesionErrorQuestion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static IniciarSesionErrorQuestion iniciarSesionErrorQuestion(String mensaje){
        return new IniciarSesionErrorQuestion(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                Switch.toActiveElement()
        );
        return mensaje.equals(Text.of(DIV_INCIAR_SESION).viewedBy(actor).asString());
    }
}
