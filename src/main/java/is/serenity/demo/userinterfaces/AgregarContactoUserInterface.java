package is.serenity.demo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AgregarContactoUserInterface {
    public static final Target LBL_INICIO = Target.the("Icono inicio")
            .located(By.xpath("//i[@class='s-sidebar-band-icon fa fa-home']"));
    public static final Target SPAN_ORGANIZATION = Target.the("Icono organizacion")
            .located(By.xpath("//span[contains(text(),'Organization')]"));
    public static final Target SPAN_CONCTACTS = Target.the("Icono Contactos")
            .located(By.xpath("//span[contains(text(),'Contacts')]"));
    public static final Target BTN_NUEVO_CONTACTO = Target.the("Nuevo contacto")
            .located(By.xpath("//i[@class='fa fa-plus-circle text-green']"));
    public static final Target INP_NOMBRE = Target.the("Nombre")
            .located(By.name("FirstName"));
    public static final Target INP_APELLIDO = Target.the("Apellido")
            .located(By.name("LastName"));
    public static final Target INP_EMAIL = Target.the("Email")
            .located(By.name("Email"));
    public static final Target BTN_GUARDAR = Target.the("Boton guardar")
            .located(By.xpath("//i[@class='fa fa-check-circle text-purple']"));
    public static final Target SPAN_ID = Target.the("ID")
            .located(By.xpath("(//span[@class='slick-column-name'])[1]"));
    public static final Target DIV_CORREO = Target.the("Validacion de creación de contacto")
            .located(By.xpath("//div[contains(text(),'johan123@hotmail.com')]"));
}
