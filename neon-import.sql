-- Import schema + data from local retailstore_test → Neon (retail_store)
-- Paste toàn bộ file này vào Neon Console → SQL Editor → Run

DROP TABLE IF EXISTS authorities CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS customer CASCADE;

CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE
);

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

INSERT INTO users (username, password, enabled) VALUES
('retailstoreapp', '$2a$10$r15G8Qmg4atnWxVDRpX/pe9vKfxJXU2eJSQbnWeSrrj.7FSidLeJ6', true),
('admin', '$2a$10$WWVXuRiSInEZx/fgY3rVQuHEO5Y6sydJChH4yel0GEZfeFcb5ix6m', true),
('retailstoreappv2', '$2a$10$r15G8Qmg4atnWxVDRpX/pe9vKfxJXU2eJSQbnWeSrrj.7FSidLeJ6', true),
('adminv2', '$2a$10$WWVXuRiSInEZx/fgY3rVQuHEO5Y6sydJChH4yel0GEZfeFcb5ix6m', true);

INSERT INTO authorities (id, username, authority) VALUES
(1, 'retailstoreapp', 'ROLE_USER'),
(2, 'admin', 'ROLE_ADMIN'),
(3, 'admin', 'ROLE_USER'),
(4, 'retailstoreappv2', 'ROLE_USER'),
(5, 'adminv2', 'ROLE_ADMIN'),
(6, 'adminv2', 'ROLE_USER');

INSERT INTO customer (id, username, password, role) VALUES
(1, 'thangnxc', '$2a$10$B3eKRKwrQlksgwCdUNfD../6aYQdVTpoohRO23VYzSS2K5VXtioue', 'ROLE_ADMIN'),
(3, 'thang2', '$2a$10$VQ1Nchx0PZwzsRjZFdAfHe3y/As12MJPM0AVRYLajwy57qeFgaRse', 'user'),
(4, 'thang3', '$2a$10$0H26cGiaeQB9gHjUSIhqpOiJWl.1Ba/AnT9bzcoM64wpteIcyE656', 'user'),
(5, 'thang3', '$2a$10$RZqgsRjutOnOBnjrckihVOurx5IoYjti3oQuJgQKa1/2qPG42lFB6', 'user');

SELECT setval('authorities_id_seq', (SELECT COALESCE(MAX(id), 1) FROM authorities));
SELECT setval('customer_id_seq', (SELECT COALESCE(MAX(id), 1) FROM customer));
