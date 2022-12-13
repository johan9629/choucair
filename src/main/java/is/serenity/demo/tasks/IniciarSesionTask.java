package is.serenity.demo.tasks;

import is.serenity.demo.exceptions.IniciarSesionException;
import is.serenity.demo.models.IniciarSesionModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static is.serenity.demo.userinterfaces.IniciarSesionUserInterface.*;

public class IniciarSesionTask implements Task {

    private final IniciarSesionModel iniciarSesionModel;

    public IniciarSesionTask(IniciarSesionModel iniciarSesionModel) {
        this.iniciarSesionModel = iniciarSesionModel;
    }

    public static IniciarSesionTask iniciarSesionTask (IniciarSesionModel iniciarSesionModel){
        return Tasks.instrumented(IniciarSesionTask.class,iniciarSesionModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    WaitUntil.the(INP_USUARIO, WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                    Enter.theValue(iniciarSesionModel.getUsuario()).into(INP_USUARIO),
                    Enter.theValue(iniciarSesionModel.getClave()).into(INP_CONTRASENA),
                    Click.on(BTN_INGRESAR)
            );
        }
        catch (IniciarSesionException e){
            throw new IniciarSesionException(IniciarSesionException.ELEMENT_NOT_FOUND);
        }
    }

}
