## Author: Johan Gonzalez
  #Jsgonzalez@choucairtesting.com
  #language: es

  Característica: Yo como asesor
    necesito iniciar sesion en la pagina de ordenes
    Para poder generar ordenes

  @IniciarSesionExitoso
Esquema del escenario: Inicio de sesion exitoso
    Dado Que el asesor quiere iniciar sesion
    Cuando ingresa sus credenciales de autenticacion
      |usuario  |clave  |
      |<usuario>|<clave>|
    Entonces podra verificar su nombre de usuario
     Ejemplos:
    |usuario  |clave   |
    |admin    |serenity|

  @IniciarSesionFallida
Esquema del escenario: inicio de sesion fallido
    Dado Que el asesor quiere iniciar sesion
    Cuando ingresa sus credenciales de autenticacion
    |usuario  |clave  |
    |<usuario>|<clave>|
    Entonces Se visualiza la alerta "Usuario o contraseña invalido!"
    Ejemplos:
    |usuario  |clave   |
    |admin3   |serenity|