package is.serenity.demo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;

import static is.serenity.demo.userinterfaces.IniciarSesionUserInterface.IMG_INICIO;

public class IniciarSesionQuestion {
    public static Question<Boolean> IniciarSesionQuestion(){
        return actor -> IMG_INICIO.resolveFor(actor).isVisible();
    }
}
