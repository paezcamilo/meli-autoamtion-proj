# author: Miguel Camilo Páez Pirazan
# date: 29/08/2023
# language: es

Característica: Validación de servicios REST.
  Como usuario quiero validar que los servicios REST estén respondiendo correctamente.

  @ValidarServicioRestPing
  Escenario: Verificar el código de respuesta retornado
    Dado Camilo la URL del servicio rest "http://localhost:8085"
    Cuando Envío un GET request al endpoint "/ping"
    Entonces El código de respuesta debería ser 200
    Y El mensaje de respuesta debe ser "pong"