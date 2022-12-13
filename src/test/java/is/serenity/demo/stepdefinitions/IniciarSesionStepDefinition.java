package is.serenity.demo.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import is.serenity.demo.models.IniciarSesionModel;
import is.serenity.demo.questions.IniciarSesionErrorQuestion;
import is.serenity.demo.questions.IniciarSesionQuestion;
import is.serenity.demo.tasks.AbrirPaginaTask;
import is.serenity.demo.tasks.IniciarSesionTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class IniciarSesionStepDefinition {

    @Managed (driver = "Chrome")
    private WebDriver webDriver;
    private Actor ordenes = Actor.named("ordenes");

    @Before
    public void prepareActorStage(){
        OnStage.setTheStage(new OnlineCast());
        ordenes.can(BrowseTheWeb.with(webDriver));
    }

    @Dado("^Que el asesor quiere iniciar sesion$")
    public void queElAsesorQuiereIniciarSesion() {
        ordenes.wasAbleTo(AbrirPaginaTask.abrirPaginaTask());
    }

    @Cuando("^ingresa sus credenciales de autenticacion$")
    public void ingresaSusCredencialesDeAutenticacion(List<IniciarSesionModel> iniciarSesionModels) {
        ordenes.attemptsTo(IniciarSesionTask.iniciarSesionTask(iniciarSesionModels.get(0)));
    }

    @Entonces("^podra verificar su nombre de usuario$")
    public void podraVerificarSuNombreDeUsuario() {
        ordenes.should(seeThat(IniciarSesionQuestion.IniciarSesionQuestion()));
    }

    @Entonces("^Se visualiza la alerta \"([^\"]*)\"$")
    public void seVisualizaLaAlerta(String mensaje) {
        ordenes.should(seeThat(IniciarSesionErrorQuestion.iniciarSesionErrorQuestion(mensaje)));
    }


}
