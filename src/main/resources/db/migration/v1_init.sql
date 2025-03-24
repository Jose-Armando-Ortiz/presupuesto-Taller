CREATE DATABASE IF NOT EXISTS vehiculos_db;
USE vehiculos_db;

CREATE TABLE IF NOT EXISTS vehiculos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vehiculo_modelo VARCHAR(255) NOT NULL,
    total_chaperia DOUBLE NOT NULL,
    total_pintura DOUBLE NOT NULL,
    total DOUBLE NOT NULL
);
