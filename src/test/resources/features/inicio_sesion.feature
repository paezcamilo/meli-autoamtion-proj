# author: Miguel Camilo Páez Pirazan
# date: 20/08/2023
# language: es

Característica: Creación y validación de usuarios.
  Como usuario quiero poder crear usuarios y validar, si es mayor de edad, menor de edad o ya ha sido creado.

  @CreaciónDeUsuarioMayorDeEdad
  Escenario: Creación de usuario exitoso por ser mayor de edad
    Dado Pepito navega a la página de crear persona
    Cuando Crea el usuario porque es mayor de edad
    Entonces debería ver el mensaje de usuario creado satisfactoriamente

  @CreaciónDeUsuarioMenorDeEdad
  Escenario: Creación de usuario no exitoso por ser menor de edad
    Dado Pepito navega a la página de crear persona menor de edad
    Cuando Intenta crear el usuario con datos de menor de edad
    Entonces debería ver el mensaje de usuario error por ser menor de edad

  @CreaciónDeUsuarioConMismoNombre
  Escenario: Creación de usuario no exitoso por tener el mismo nombre de un usuario ya creado
    Dado Pepito navega a la página de crear persona con el mismo nombre
    Cuando Intenta crear el usuario con datos de un usuario ya existente
    Entonces debería ver el mensaje de usuario error por ser un usuario ya existente