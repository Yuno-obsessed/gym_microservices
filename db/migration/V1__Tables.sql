-- User-service
CREATE TABLE IF NOT EXISTS roles
(
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(20) NOT NULL
);

-- User-service
CREATE TABLE IF NOT EXISTS users
(
    user_id SERIAL PRIMARY KEY,
    role_id INT NOT NULL,
    email VARCHAR(60) NOT NULL,
    username VARCHAR(60),
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    password VARCHAR(36) NOT NULL,
    age INT NOT NULL,
    country VARCHAR(60) NOT NULL,
    FOREIGN KEY (role_id)
        REFERENCES roles (role_id)
        ON DELETE CASCADE
);

INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (role_name) VALUES ('ROLE_USER');

INSERT INTO users (role_id, email, username, password, age, country) VALUES (1, 'admin@gmail.com', 'admin' , 'admin', 18, 'Italy');
INSERT INTO users (role_id, email, username, password, age, country) VALUES (2, 'user@gmail.com', 'newuser', 'newuser', 15, 'USA');


CREATE TYPE Order_Status AS ENUM('paid','failed','pending');

-- Order-service
CREATE TABLE IF NOT EXISTS orders
(
    order_id SERIAL PRIMARY KEY,
    order_status Order_Status NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

CREATE TYPE Subscription_Status AS ENUM('active','cancelled','expired');
CREATE TYPE Subscription_Type AS ENUM('monthly','semiannual','annual');

-- Subscription-service
CREATE TABLE IF NOT EXISTS subscriptions
(
    subscription_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    order_id INT NOT NULL,
    start_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    subscription_type Subscription_Type NOT NULL,
    subscription_status Subscription_Status NOT NULL,
    FOREIGN KEY (order_id)
        REFERENCES orders (order_id)
        ON DELETE CASCADE,
    FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Upload-service
CREATE TABLE IF NOT EXISTS objects
(
    object_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    object_name VARCHAR(250) NOT NULL,
    object_entity VARCHAR(60) NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Order-service
CREATE TABLE IF NOT EXISTS qr_codes
(
    qr_code_id SERIAL PRIMARY KEY,
    subscription_id INT NOT NULL,
    FOREIGN KEY (subscription_id)
        REFERENCES subscriptions (subscription_id)
        ON DELETE CASCADE
);

CREATE TYPE Payment_Status AS ENUM('paid','failed','pending');

CREATE TABLE IF NOT EXISTS payments
(
    payment_id SERIAL PRIMARY KEY,
    subscription_id INT NOT NULL,
    payment_date DATE NOT NULL,
    payment_status Payment_Status NOT NULL
    payment_amount INT NOT NULL,
    payment_method
)
-- Mail-service
CREATE TABLE IF NOT EXISTS mails
(
    mail_id SERIAL PRIMARY KEY,
    mail_type VARCHAR(100) NOT NULL,
    email VARCHAR(60) NOT NULL,
    sent_date DATE
);