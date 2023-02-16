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
    username VARCHAR(60) NOT NULL,
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


-- Order-service
CREATE TABLE IF NOT EXISTS orders
(
    order_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Subscription-service
CREATE TABLE IF NOT EXISTS subscriptions
(
    subscription_id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    expiry_date DATE,
    FOREIGN KEY (order_id)
        REFERENCES orders (order_id)
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

-- Mail-service
CREATE TABLE IF NOT EXISTS mails
(
    mail_id SERIAL PRIMARY KEY,
    mail_type VARCHAR(100) NOT NULL,
    email VARCHAR(60) NOT NULL,
    sent_date DATE
);