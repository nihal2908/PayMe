# SQL Queries 

```sql
CREATE DATABASE payMe;

USE payMe;


-- Users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(20),
    country VARCHAR(50)
);


-- Accounts table
CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    account_number VARCHAR(50) UNIQUE NOT NULL,
    currency VARCHAR(10) NOT NULL,
    balance DOUBLE DEFAULT 0.0,

    CONSTRAINT fk_account_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);


-- Payments table
CREATE TABLE payments (
    id INT AUTO_INCREMENT PRIMARY KEY,

    sender_id INT NOT NULL,
    sender_account_id INT NOT NULL,

    receiver_id INT NOT NULL,
    receiver_account_id INT NOT NULL,

    amount DOUBLE NOT NULL,

    CONSTRAINT fk_payment_sender_user
        FOREIGN KEY (sender_id)
        REFERENCES users(id),

    CONSTRAINT fk_payment_receiver_user
        FOREIGN KEY (receiver_id)
        REFERENCES users(id),

    CONSTRAINT fk_payment_sender_account
        FOREIGN KEY (sender_account_id)
        REFERENCES accounts(id),

    CONSTRAINT fk_payment_receiver_account
        FOREIGN KEY (receiver_account_id)
        REFERENCES accounts(id)
);
```