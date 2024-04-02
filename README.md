API de Usuarios
Este es un servicio RESTful que proporciona operaciones para gestion de usuarios.

Requisitos previos
Java 8 o superior
Spring Boot
Maven o Gradle (para construir y ejecutar la aplicación)
Postman u otra herramienta similar para probar las API
Instalación y Ejecución
Clona este repositorio:
bash
Copy code
git clone https://github.com/rortizpe/api-rest-demo.git
Navega al directorio del proyecto:
bash
Copy code
cd nombre-del-directorio
Construye y ejecuta la aplicación:
Con Maven:
mvn spring-boot:run
Con Gradle:
gradle bootRun

La aplicación se ejecutará en http://localhost:8080 por defecto.

Uso
Crear un nuevo usuario
URL
POST /user
Parámetros de la solicitud
userRequest: Objeto JSON que representa los detalles del usuario a crear. Debe tener los campos name, email y password.
Encabezados de la solicitud
Authorization: El token de autorización para autenticar la solicitud.
Ejemplo de cuerpo de la solicitud
json
Copy code
{
"user": "raul",
"token": "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoicmF1bCIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE3MTIwNzY2NjEsImV4cCI6MTcxMjA3NzI2MX0.-9RDKmKIHdg_nAGU6bdCyLdLfL9qQ-W9WICcqxIiMPwDNV2uFXHIrm5StucD-C9BYBw61Hr3Cr23xoDougQCxQ"
}
Ejemplo de respuesta exitosa
Código de estado: 201 Created

json
{
"id": "123456",
"name": "John Doe",
"email": "johndoe@example.com",
"created_at": "2022-04-04T12:00:00Z",
"updated_at": "2022-04-04T12:00:00Z"
}
Ejemplo de respuesta de error
Código de estado: 400 Bad Request

json
{
"error": "InvalidRequest",
"message": "El campo 'email' es requerido"
}
Documentación de la API
Puedes acceder a la documentación de la API utilizando Swagger. Para hacerlo, navega a http://localhost:8080/swagger-ui.html en tu navegador.
