DROP TABLE IF EXISTS customer_table;
DROP TABLE IF EXISTS item_table;
DROP TABLE IF EXISTS order_table;


CREATE TABLE customer_table
(
cust_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cust_name VARCHAR(50),
cust_email VARCHAR(100) NOT NULL UNIQUE,
cust_address VARCHAR(100) NOT NULL,
cust_blocked BOOL DEFAULT false,
cust_role VARCHAR(50)
);

CREATE TABLE item_table
(
phone_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
phone_model VARCHAR(50),
phone_release_year VARCHAR(50),
phone_colour VARCHAR(50),
phone_company VARCHAR(50)
);

CREATE TABLE order_table
(
order_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cust_id INT REFERENCES customer_table(cust_id),
phone_id INT,
order_date DATE,
return_date DATE,
phone_returned BOOL DEFAULT false,
rental_cost NUMERIC(5, 2),
FOREIGN KEY (phone_id) REFERENCES item_table(phone_id)
);

