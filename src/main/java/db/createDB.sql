DROP DATABASE IF EXISTS souvenirstore;

CREATE DATABASE souvenirstore;

USE souvenirstore;

CREATE TABLE producers ( 
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64) UNIQUE NOT NULL,
    country VARCHAR(64) NOT NULL 
);

CREATE TABLE souvenirs ( 
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64) UNIQUE NOT NULL,
    made_date DATE DEFAULT CURRENT_DATE,
    price DOUBLE DEFAULT 0.0,
    producer_id INT NOT NULL,
    FOREIGN KEY (producer_id) REFERENCES producers(id)
      ON DELETE CASCADE ON UPDATE CASCADE
);
