-- User-service
CREATE TABLE IF NOT EXISTS roles
(
    role_id INT PRIMARY KEY,
    role_name VARCHAR(20) NOT NULL
);

-- User-service
CREATE TABLE IF NOT EXISTS users
(
    user_id GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    role_id INT DEFAULT 1,
    email VARCHAR(60) NOT NULL,
    username VARCHAR(60),
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    password VARCHAR(36) NOT NULL,
    age INT NOT NULL,
    city VARCHAR(60) NOT NULL,
    FOREIGN KEY (role_id)
        REFERENCES roles (role_id)
        ON DELETE CASCADE
);

INSERT INTO roles (role_name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (role_name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO users (role_id, email, username, password, age, city) VALUES (2, 'admin@gmail.com', 'admin' , 'admin', 18, 'Piemonte');
INSERT INTO users (role_id, email, username, password, age, city) VALUES ('user@gmail.com', 'newuser', 'newuser', 15, 'Napoli');


CREATE TYPE Subscription_Status AS ENUM('pending','active','cancelled','expired');
CREATE TYPE Subscription_Type AS ENUM('monthly','semiannual','annual');

-- Subscription-service
CREATE TABLE IF NOT EXISTS subscriptions
(
    subscription_id GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT NOT NULL,
    start_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    subscription_type Subscription_Type NOT NULL,
    subscription_status Subscription_Status NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Upload-service
CREATE TABLE IF NOT EXISTS objects
(
    object_id GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT NOT NULL,
    object_name VARCHAR(250) NOT NULL,
    object_entity VARCHAR(60) NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Payment-service
CREATE TABLE IF NOT EXISTS qr_codes
(
    qr_code_id GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    subscription_id INT NOT NULL,
    FOREIGN KEY (subscription_id)
        REFERENCES subscriptions (subscription_id)
        ON DELETE CASCADE
);

CREATE TYPE Payment_Status AS ENUM('paid','failed','pending');

CREATE TABLE IF NOT EXISTS payments
(
    payment_id GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    subscription_id INT NOT NULL,
    payment_date DATE NOT NULL,
    payment_status Payment_Status NOT NULL
    payment_amount INT NOT NULL,
    payment_method
);

-- Mail-service
CREATE TABLE IF NOT EXISTS mails
(
    mail_id GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    mail_type VARCHAR(100) NOT NULL,
    email VARCHAR(60) NOT NULL,
    sent_date DATE
);