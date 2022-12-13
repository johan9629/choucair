package is.serenity.demo.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import is.serenity.demo.interactions.AgregarConctactoInteraction;
import is.serenity.demo.models.AgregarContactoModel;
import is.serenity.demo.questions.AgregarContactoQuestion;
import is.serenity.demo.tasks.AgregarContactoTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AgregarContactoStepDefinition {

    @Managed(driver = "Chrome")
    private WebDriver webDriver;
    private Actor ordenes = Actor.named("ordenes");

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
        ordenes.can(BrowseTheWeb.with(webDriver));
    }

    @Dado("^que el administrador quiere crear un nuevo contacto$")
    public void queElAdministradorQuiereCrearUnNuevoContacto() {
        ordenes.wasAbleTo(AgregarContactoTask.agregarContactoTask());
    }


    @Cuando("^diligencia los campos del contacto$")
    public void diligenciaLosCamposDelContacto(List<AgregarContactoModel> agregarContactoModels) {
        ordenes.attemptsTo(AgregarConctactoInteraction.agregarConctactoInteraction(agregarContactoModels.get(0)));
    }

    @Entonces("^se visualizara el contacto con first name \"([^\"]*)\"$")
    public void seVisualizaraElContactoConFirstName(String mensaje) {
        ordenes.should(seeThat(AgregarContactoQuestion.agregarContactoQuestion(mensaje)));
    }

}
