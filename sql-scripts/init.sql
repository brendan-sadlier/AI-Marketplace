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
    password VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    order_number INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(45) NOT NULL,
    price VARCHAR(45) NOT NULL,
    customer_id VARCHAR(45) NOT NULL,
    fulfilled BOOLEAN NOT NULL,
    date_ordered DATE NOT NULL
);

INSERT INTO products(sku, product_name, description, price, trained, trained_price, product_image) VALUES (111, "ChatGPT AI Model", "AI Model based on OpenAI's extremely popular ChatGPT", 200.00, 0, 500.00, "/images/products/111.png");