# 🌟 Spring Boot API Project

[![Java](https://img.shields.io/badge/Java-11+-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7.8-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

---

## 📄 Descripción

Esta aplicación es un **servicio RESTful** desarrollado con **Spring Boot**, que incluye integración con bases de datos MySQL (AWS Aurora) y documentación de API con **Swagger**.
Está diseñada para ser fácilmente desplegable, escalable y compatible con entornos de desarrollo modernos.

---

## 🛠 Tecnologías y Dependencias

### Core - Spring Boot 2.7.8

* `spring-boot-starter-data-jpa` – JPA y acceso a la base de datos.
* `spring-boot-starter-web` – Creación de endpoints REST.
* `spring-boot-starter-test` – Pruebas unitarias e integración.
* `spring-boot-starter-tomcat` – Servidor embebido Tomcat.

### Dependencias Externas

* `mysql-connector-j` – Conector JDBC para MySQL (versión gestionada por Spring).
* `httpclient5` – Cliente HTTP (v5.2.1).
* `springdoc-openapi-ui` – Documentación de API con Swagger (v1.8.0).
* `lombok` – Generación de código boilerplate (no utilizado directamente para evitar requerir instalación en IDE).

> La documentación de la API está disponible a nivel de proyecto mediante Swagger.

---

## ⚙ Configuración y Ejecución

### Requisitos

* Java 11 o superior.
* Maven 3.6+
* IDE recomendado: **Spring Tool Suite (STS)**

### Pasos para ejecutar

1. Clonar el proyecto:

   ```bash
   git clone <repo-url>
   ```
2. Importar el proyecto en tu IDE favorito.
3. Levantar la aplicación:

   ```bash
   mvn spring-boot:run
   ```
4. Acceder a la documentación de la API:

   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## 🗄 Base de Datos - MySQL (AWS Aurora)

* La configuración de conexión está en `application.properties`.
* Para pruebas locales, se incluye `script.sql` que contiene:

  * **DDL**: Creación de tablas.
  * **DML**: Datos iniciales para pruebas.

---

## 🚀 Ejemplos de Endpoints

| Método | Endpoint          | Descripción                  |
| ------ | ----------------- | ---------------------------- |
| GET    | `/api/v1/usuarios/`     | Listar los usuarios          |
| GET    | `/api/v1/usuarios/{id}` | Obtener usuario por ID       |
| POST   | `/api/v1/usuarios`      | Crear un nuevo usuario       |
| PUT    | `/api/v1/usuarios/{id}` | Actualizar usuario existente |
| DELETE | `/api/v1/usuarios/{id}` | Eliminar usuario             |

> Todos los endpoints están documentados en Swagger UI.

---

## ✅ Beneficios

* Documentación automática de API.
* Integración inmediata con MySQL y AWS Aurora.
* Compatible con entornos modernos y en la nube.
* Base sólida para extender funcionalidades de manera rápida.

---

## 📄 Licencia

Este proyecto está licenciado bajo **Apache 2.0**.
[Ver licencia](http://www.apache.org/licenses/LICENSE-2.0.html)
