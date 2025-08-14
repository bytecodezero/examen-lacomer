-- Crear base de datos (ajusta el nombre si quieres)
CREATE DATABASE IF NOT EXISTS lacomer
-- Usar la base de datos
USE lacomer;

CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(100) NOT NULL,
    apellido_materno VARCHAR(100),
    correo VARCHAR(150) NOT NULL UNIQUE,
    codigo_postal VARCHAR(10) NOT NULL,
    estado VARCHAR(100),
    municipio VARCHAR(100),
    colonia VARCHAR(150)
)

INSERT INTO usuarios (nombre, apellido_paterno, apellido_materno, correo, codigo_postal)
VALUES ('Oscar', 'Muñoz', 'Abarca', 'oscar@mail.com', '11410');

SELECT * FROM usuarios