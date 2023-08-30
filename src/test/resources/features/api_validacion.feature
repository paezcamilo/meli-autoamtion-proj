# author: Miguel Camilo Páez Pirazan
# date: 29/08/2023
# language: es

Característica: Validación de servicios REST.
  Como usuario quiero validar que los servicios REST estén respondiendo correctamente.

  @ValidarServicioRestPing
  Escenario: Verificar el código de respuesta retornado para el servicio PING
    Dado Camilo la URL del servicio rest "http://localhost:8085"
    Cuando Envío un GET request al endpoint "/ping"
    Entonces El código de respuesta debería ser 200
    Y El mensaje de respuesta debe ser "pong"

  @ValidarServicioRestPersons
  Escenario: Verificar el código de respuesta retornado y los usuarios existentes para el servicio Persons
    Dado Camilo la URL del servicio rest de persons "http://localhost:8085"
    Cuando Envío un GET request al endpoint de persons "/bff/persons"
    Entonces El código de respuesta para persons debería ser 200
    Y El mensaje de respuesta para persons debe ser "Lionel Andres"

  @ValidarServicioRestCountries
  Escenario: Verificar el código de respuesta retornado y los usuarios existentes para el servicio countries
    Dado Camilo la URL del servicio rest de countries "http://localhost:8085"
    Cuando Envío un GET request al endpoint de countries "/bff/countries"
    Entonces El código de respuesta para countries debería ser 200
    Y El mensaje de respuesta para countries debe ser "Colombia"