CREATE TABLE IF NOT EXISTS PERSON (
    cc INT not null,
    nombre VARCHAR(50) not null,
    apellido1 VARCHAR(20) not null,
    apellido2 VARCHAR(20) not null,
    edad INT not null,
    genero VARCHAR(1) not null,
    estado VARCHAR(1) not null,
    PRIMARY KEY (cc)
    );

CREATE TABLE IF NOT EXISTS VEHICULO (
    placa VARCHAR(6) not null,
    tipo VARCHAR(5) not null,
    cilindraje INT not null,
    modelo INT not null,
    marca VARCHAR(20) not null,
    ciudad VARCHAR(20) not null,
    estado VARCHAR(1) not null,
    PRIMARY KEY (placa)
    );

INSERT INTO PERSON  (cc, nombre, apellido1, apellido2, edad, genero, estado)
    VALUES
        (42369785, 'Armando', 'Paredes', 'largas', 35, 'M', 'A'),
        (32968322, 'Estela', 'Manco', 'Cuervo', 40, 'F', 'A'),
        (1125365788, 'Efrain', 'Salazar', 'Perez', 20, 'M', 'I');

INSERT INTO VEHICULO  (placa, tipo, cilindraje, modelo, marca, ciudad, estado)
    VALUES
        ('AMD256', 'carro', 1400, 2016, 'Chevrolet Aveo', 'Medellin', 'A'),
        ('RTI526', 'carro', 2500, 2020, 'Toyota Runner', 'Pereira', 'A'),
        ('FYZ95B','Moto', 199, 2014, 'Bajaj Pulsar', 'Medellin', 'I');
