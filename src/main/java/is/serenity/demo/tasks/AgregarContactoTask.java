package is.serenity.demo.tasks;

import is.serenity.demo.exceptions.AbrirPaginaException;
import is.serenity.demo.exceptions.AgregarContactoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static is.serenity.demo.userinterfaces.AgregarContactoUserInterface.*;

public class AgregarContactoTask implements Task {

    public static AgregarContactoTask agregarContactoTask(){
        return Tasks.instrumented(AgregarContactoTask.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(LBL_INICIO, WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                    Click.on(LBL_INICIO),
                    Click.on(SPAN_ORGANIZATION),
                    Click.on(SPAN_CONCTACTS)
            );
        }
        catch (AgregarContactoException e){
            throw new AgregarContactoException(AgregarContactoException.ELEMENT_NOT_FUND);
        }
    }
}
