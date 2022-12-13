package is.serenity.demo.tasks;

import is.serenity.demo.exceptions.AbrirPaginaException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AbrirPaginaTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        Properties properties = new Properties();

        try{
            properties.load(new FileInputStream(new File("serenity.properties")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //actor.attemptsTo(Open.url(properties.getProperty("webdriver.base.url")));
        try {
            actor.attemptsTo(Open.url(properties.getProperty("webdriver.base.url")));
        }
        catch (AbrirPaginaException e){
            throw new AbrirPaginaException(AbrirPaginaException.ELEMENT_NOT_FOUND);
        }
    }

    public static AbrirPaginaTask abrirPaginaTask(){
        return Tasks.instrumented(AbrirPaginaTask.class);
    }
}
