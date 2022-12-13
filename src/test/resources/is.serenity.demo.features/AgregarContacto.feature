##Author: Johan Gonzalez
  #Jsgonzalez@choucairtesting.com
  #language:es

Característica: Yo como administrador
  Nesecito agregar un nuevo contacto
  para crear nuevas ordenes con este contacto

Antecedentes: Se inicia sesion del portal
  Dado Que el asesor quiere iniciar sesion
  Cuando ingresa sus credenciales de autenticacion
    |usuario  |clave   |
    |admin    |serenity|

  @NuevoContactoExitoso
Esquema del escenario: Crear un nuevo contacto
    Dado que el administrador quiere crear un nuevo contacto
    Cuando diligencia los campos del contacto
    |firstName  |lastName  |email  |
    |<firstName>|<lastName>|<email>|
    Entonces se visualizara el contacto con first name "johan123@hotmail.com"
    Ejemplos:
    |firstName|lastName|email               |
    |Johan    |Gonzalez|johan123@hotmail.com|