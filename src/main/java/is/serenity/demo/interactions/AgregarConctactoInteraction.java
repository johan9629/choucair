package is.serenity.demo.interactions;

import io.vavr.control.Try;
import is.serenity.demo.exceptions.LlenarFormularioException;
import is.serenity.demo.models.AgregarContactoModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static is.serenity.demo.userinterfaces.AgregarContactoUserInterface.*;

public class AgregarConctactoInteraction implements Interaction {

    private AgregarContactoModel agregarContactoModel;

    public AgregarConctactoInteraction(AgregarContactoModel agregarContactoModel) {
        this.agregarContactoModel = agregarContactoModel;
    }

    public static AgregarConctactoInteraction agregarConctactoInteraction (AgregarContactoModel agregarContactoModel){
        return Tasks.instrumented(AgregarConctactoInteraction.class,agregarContactoModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_NUEVO_CONTACTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_NUEVO_CONTACTO),
                    Enter.theValue(agregarContactoModel.getFirstName()).into(INP_NOMBRE),
                    Enter.theValue(agregarContactoModel.getLastName()).into(INP_APELLIDO),
                    Enter.theValue(agregarContactoModel.getEmail()).into(INP_EMAIL),
                    Click.on(BTN_GUARDAR)
            );
        }
        catch (LlenarFormularioException e){
            throw new LlenarFormularioException(LlenarFormularioException.ELEMENT_NOT_FOUND);
        }
    }
}
