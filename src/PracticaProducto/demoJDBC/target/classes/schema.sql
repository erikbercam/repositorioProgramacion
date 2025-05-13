CREATE TABLE IF NOT EXISTS producto(
                                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         nombre VARCHAR(255),
    descripcion VARCHAR(255),
    precio DOUBLE,
    stock INT
    );