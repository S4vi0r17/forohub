CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(150) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);
