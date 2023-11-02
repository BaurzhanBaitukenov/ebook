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


-- Users Table
CREATE SEQUENCE books_id_seq;

CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY DEFAULT nextval('users_id_seq'),
    user_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    photoURL VARCHAR(10000),
    password VARCHAR(1000)
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