-- Books Table
CREATE TABLE IF NOT EXISTS books (
    id BIGINT PRIMARY KEY,
    book_name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    description TEXT,
    photoURL VARCHAR(10000),
    price INTEGER,
    demo_version VARCHAR(255)
);

-- also you use this for creating table
CREATE SEQUENCE books_id_seq;

CREATE TABLE IF NOT EXISTS books (
    id BIGINT PRIMARY KEY DEFAULT nextval('books_id_seq'),
    book_name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    description TEXT,
    photoURL VARCHAR(10000),
    price INTEGER,
    demo_version VARCHAR(255)
    );


-- for user id seq
CREATE SEQUENCE users_id_seq;

-- for roles id seq
CREATE SEQUENCE roles_id_seq;

-- create table for roles
CREATE TABLE roles (
    id BIGINT DEFAULT nextval('roles_id_seq') PRIMARY KEY,
    name TEXT
);

-- create table users
CREATE TABLE users (
    id BIGINT DEFAULT nextval('users_id_seq') PRIMARY KEY,
    username TEXT,
    email TEXT,
    photoURL TEXT,
    password TEXT
);

-- create relationship between user and role
CREATE TABLE user_roles (
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);




-- ALTER TABLE books
-- ALTER COLUMN photo_url TYPE VARCHAR(10000);
--
-- ALTER TABLE books
-- ALTER COLUMN id TYPE BIGINT;
--
-- ALTER TABLE books
--     RENAME COLUMN "photo_url" TO "photoURL"

-- Second