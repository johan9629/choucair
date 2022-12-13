package is.serenity.demo.questions;

import is.serenity.demo.models.AgregarContactoModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import static is.serenity.demo.userinterfaces.AgregarContactoUserInterface.DIV_CORREO;
import static is.serenity.demo.userinterfaces.AgregarContactoUserInterface.SPAN_ID;

public class AgregarContactoQuestion implements Question<Boolean> {

    private String mensaje;

    public AgregarContactoQuestion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static AgregarContactoQuestion agregarContactoQuestion(String mensaje){
        return new AgregarContactoQuestion(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Click.on(SPAN_ID),
                Click.on(SPAN_ID)
        );
        return mensaje.equals(Text.of(DIV_CORREO).viewedBy(actor).asString());
    }
}
