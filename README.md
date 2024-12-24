# ForoHub

ForoHub es una API REST desarrollada con Spring Boot como parte del Challenge #3 de la especialización Backend del programa Oracle Next Education (ONE). El proyecto implementa un sistema de foro que permite a los usuarios gestionar tópicos de discusión, con características de seguridad y autenticación. Esta iniciativa combina los conocimientos adquiridos en el programa ONE.

## Características

- Autenticación de usuarios con tokens JWT
- Operaciones CRUD para tópicos del foro
- Documentación de API con OpenAPI (Swagger)
- Base de datos PostgreSQL con migraciones Flyway

## Stack Tecnológico y Versiones

- Java 21
- Spring Boot 3.3.4
- Spring Security
- Flyway y PostgreSQL
- JWT (java-jwt 4.3.0)
- SpringDoc OpenAPI UI 2.1.0
- Lombok
- Maven

## Endpoints de la API

### Autenticación
- `POST /login` - Autenticar usuario y obtener token JWT
- `POST /signup` - Registrar nuevo usuario

### Temas
- `GET /topics` - Listar todos los temas (paginado)
- `GET /topics/{id}` - Obtener tema específico
- `POST /topics` - Crear nuevo tema (requiere autenticación)
- `PUT /topics/{id}` - Actualizar tema (requiere autenticación)
- `DELETE /topics/{id}` - Eliminar tema (requiere autenticación)

## Seguridad

- Autenticación sin estado mediante tokens JWT
- Protección de endpoints con Spring Security
- Encriptación de contraseñas con BCrypt
- Protección contra CORS y CSRF

## Documentación

La documentación de la API está disponible en:
- Interfaz Swagger: `/swagger-ui.html`
- Documentos OpenAPI: `/v3/api-docs`

## Instalación y Configuración

### Requisitos
- JDK 21
- PostgreSQL 16 o superior
- IntelliJ IDEA (recomendado)

### Pasos para la Instalación

1. Clonar el repositorio
```bash
git clone https://github.com/S4vi0r17/forohub.git
cd forohub
```

2. Configurar la base de datos
- Crear una base de datos PostgreSQL
- Configurar las credenciales en `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/nombre_db
    username: tu_usuario
    password: tu_contraseña
```

1. Compila y ejecuta la aplicación

La API estará disponible en `http://localhost:8080`

## Autor
- **Eder Gustavo Benites Pardave**
- Email: eder.benites@unmsm.edu.pe
- GitHub: [S4vi0r17](https://github.com/S4vi0r17)
- Proyecto: [ForoHub Repository](https://github.com/S4vi0r17/forohub)
