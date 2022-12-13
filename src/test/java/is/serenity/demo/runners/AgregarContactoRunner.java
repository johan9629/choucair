package is.serenity.demo.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/is.serenity.demo.features/AgregarContacto.feature",
        glue = "is.serenity.demo.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class AgregarContactoRunner {
}
