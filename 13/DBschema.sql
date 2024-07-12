CREATE DATABASE IF NOT EXISTS watch_store;

USE watch_store;

CREATE TABLE IF NOT EXISTS Manufacturer (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            name VARCHAR(255) NOT NULL,
                                            country VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Watch (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     brand VARCHAR(255) NOT NULL,
                                     type ENUM('quartz', 'mechanical') NOT NULL,
                                     price DECIMAL(10, 2) NOT NULL,
                                     quantity INT NOT NULL,
                                     manufacturer_id INT,
                                     FOREIGN KEY (manufacturer_id) REFERENCES Manufacturer(id)
);