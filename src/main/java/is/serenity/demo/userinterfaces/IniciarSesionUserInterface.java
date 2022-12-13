package is.serenity.demo.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IniciarSesionUserInterface {
    public static final Target IMG_PAGINA = Target.the("Imagen inicio")
            .located(By.xpath("//img[@class='rounded-circle p-1']"));
    public static final Target INP_USUARIO = Target.the("Usuario")
            .located(By.id("LoginPanel0_Username"));
    public static final Target INP_CONTRASENA = Target.the("contraseña")
            .located(By.id("LoginPanel0_Password"));
    public static final Target BTN_INGRESAR = Target.the("Boton ingresar")
            .located(By.id("LoginPanel0_LoginButton"));
    public static final Target IMG_INICIO = Target.the("Imagen inicio")
            .located(By.xpath("//img[@class='s-sidebar-band-logo']"));
    public static final Target DIV_INCIAR_SESION = Target.the("Alerta de inicio de sesion")
            .located(By.id("toast-container"));

}
