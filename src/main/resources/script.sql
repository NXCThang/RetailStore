CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL);


CREATE TABLE authorities(
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_usernameFOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE);

CREATE TABLE customer(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(500) NOT NULL,
    role VARCHAR(50) NOT NULL);

INSERT INTO customer (id, username, password, role) VALUES ('1', 'thangnxc', 'password', 'ROLE_ADMIN');