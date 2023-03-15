CREATE DATABASE IF NOT EXISTS brs;

USE brs;

CREATE TABLE IF NOT EXISTS products (
    sku INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(45) NOT NULL,
    description VARCHAR(140) NOT NULL,
    price DOUBLE NOT NULL,
    trained BOOLEAN NOT NULL,
    trained_price DOUBLE NOT NULL,
    product_image VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(45) NOT NULL,
    username VARCHAR(45) NOT NULL UNIQUE,
    email VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(128) NOT NULL,
    salt VARCHAR(128) NOT NULL,
    administrator BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    order_number INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    sku INT NOT NULL,
    price DOUBLE NOT NULL,
    user_id INT NOT NULL,
    fulfilled BOOLEAN NOT NULL
);

INSERT INTO users(id, full_name, username, email, password, salt, administrator) VALUES (1, "Admin", "admin01", "admin@bogrollsupreme.eth", "admin01", "Adminadmin01", 1);
INSERT INTO products(sku, product_name, description, price, trained, trained_price, product_image) VALUES (111, "ChatGPT AI Model", "AI Model based on OpenAI's extremely popular ChatGPT", 200.00, 0, 500.00, "/images/products/111.png");
INSERT INTO orders(order_number, sku, price, user_id, fulfilled) VALUES (102, 111, 800, 23, 0);
INSERT INTO orders(order_number, sku, price, user_id, fulfilled) VALUES (101, 111, 500, 13, 0);