-- database

CREATE DATABASE BeitechJavaTestDB;

-- switch to created database

USE BeitechJavaTestDB;

-- tables
-- Table: customer
CREATE TABLE customer (
    customer_id int(10) NOT NULL,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (customer_id)
);

-- Table: customer_available_products
CREATE TABLE customer_available_products (
    customer_id int(10) NOT NULL,
    product_id int(10) NOT NULL,
    CONSTRAINT AvailableProducts PRIMARY KEY (customer_id,product_id)
);

-- Table: orden
CREATE TABLE orden (
    orden_id int(10) NOT NULL AUTO_INCREMENT,
    delivery_address varchar(100) NOT NULL,
    customer_id int(10) NOT NULL,
    date date NOT NULL,
    CONSTRAINT orden_pk PRIMARY KEY (orden_id)
);

-- Table: orden_detail
CREATE TABLE orden_detail (
    product_description varchar(255) NOT NULL,
    orden_id int(10) NOT NULL,
    product_id int(10) NOT NULL,
    quantity int(10) NOT NULL,
    CONSTRAINT ProductOrder PRIMARY KEY (orden_id,product_id)
);

-- Table: product
CREATE TABLE product (
    product_id int(10) NOT NULL,
    name varchar(255) NOT NULL,
    price int(10) NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (product_id)
);

-- foreign keys
-- Reference: customer_available_products_customer (table: customer_available_products)
ALTER TABLE customer_available_products ADD CONSTRAINT customer_available_products_customer FOREIGN KEY customer_available_products_customer (customer_id)
    REFERENCES customer (customer_id);

-- Reference: customer_available_products_product (table: customer_available_products)
ALTER TABLE customer_available_products ADD CONSTRAINT customer_available_products_product FOREIGN KEY customer_available_products_product (product_id)
    REFERENCES product (product_id);

-- Reference: order_customer (table: orden)
ALTER TABLE orden ADD CONSTRAINT order_customer FOREIGN KEY order_customer (customer_id)
    REFERENCES customer (customer_id);

-- Reference: order_detail_order (table: orden_detail)
ALTER TABLE orden_detail ADD CONSTRAINT order_detail_order FOREIGN KEY order_detail_order (orden_id)
    REFERENCES orden (orden_id);

-- Reference: product_order_detail (table: orden_detail)
ALTER TABLE orden_detail ADD CONSTRAINT product_order_detail FOREIGN KEY product_order_detail (product_id)
    REFERENCES product (product_id);



-- add data 

-- costumer table

INSERT INTO customer (customer_id, name, email) VALUES (123, "Juan Camilo", "juan.camilo@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (456, "Luis Daniel", "luis.daniel@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (789, "Oscar Andres", "oscar.andres@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (159, "Dana Lucia", "dana.lucia@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (753, "Gabriel Armando", "gabriel.armando@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (111, "Laura Daniela", "laura.daniela@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (222, "Fabio Jose", "fabio.jose@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (333, "Claudia Particia", "claudia.patricia@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (444, "Maria Victoria", "maria.victoria@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (555, "Maria Alejandra", "maria.alejandra@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (666, "Karen Isabel", "karen.isabel@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (777, "Juan Carlos", "juan.carlos@mail.com");

-- product table

INSERT INTO product (product_id, name, price) VALUES (1234, "Sofa", 80000);
INSERT INTO product (product_id, name, price) VALUES (2345, "Cama", 500000);
INSERT INTO product (product_id, name, price) VALUES (3456, "Armario Grande", 1000000);
INSERT INTO product (product_id, name, price) VALUES (4567, "Armario Pequeño", 400000);
INSERT INTO product (product_id, name, price) VALUES (5678, "Computador de Escritorio", 1800000);
INSERT INTO product (product_id, name, price) VALUES (6789, "Computador Portatil", 1200000);
INSERT INTO product (product_id, name, price) VALUES (9999, "Mesa Comedor", 500000);
INSERT INTO product (product_id, name, price) VALUES (8888, "Puerta Madera", 100000);
INSERT INTO product (product_id, name, price) VALUES (7777, "SofaCama", 80000);
INSERT INTO product (product_id, name, price) VALUES (6666, "Estanteria Grande", 900000);
INSERT INTO product (product_id, name, price) VALUES (5555, "TV LED 44'", 900000);
INSERT INTO product (product_id, name, price) VALUES (4444, "Mesa de Noche", 80000);
INSERT INTO product (product_id, name, price) VALUES (3333, "Reloj Despertador", 20000);
INSERT INTO product (product_id, name, price) VALUES (2222, "Ventilador", 80000);
INSERT INTO product (product_id, name, price) VALUES (1111, "Puerta Seguridad Acero", 600000);
INSERT INTO product (product_id, name, price) VALUES (4587, "Reja para Jardin 1m", 40000);

-- available products

INSERT INTO customer_available_products (customer_id, product_id) VALUES (123, 1234);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (123, 2345);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (123, 3456);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (123, 4567);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (123, 5678);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (123, 6789);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (123, 9999);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (456, 4587);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (456, 1111);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (789, 2222);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (789, 3333);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (159, 4444);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (159, 5555);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (753, 6666);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (753, 7777);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (111, 8888);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (111, 9999);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (222, 4444);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (222, 2222);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (222, 8888);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (222, 3456);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (222, 4587);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (222, 3333);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (222, 5555);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (222, 1111);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (222, 9999);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (333, 4587);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (333, 6666);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (444, 5555);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (444, 4587);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (555, 6666);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (555, 3456);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (666, 4587);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (666, 3456);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (777, 4587);
INSERT INTO customer_available_products (customer_id, product_id) VALUES (777, 9999);


-- End of file.


