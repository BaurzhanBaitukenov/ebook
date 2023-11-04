INSERT INTO books (id, book_name, author, description, photoURL, price, demo_version)
VALUES (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 'A story about the decadence of the Jazz Age in America', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcJ5R8qQntTfn0pZCtEWWy67byJPctsIR9bQ&usqp=CAU', 15, 'Demo available');

INSERT INTO users (id, username, email, photourl, password)
VALUES (1, 'baur', 'bbaitukenov@gmail.com', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcJ5R8qQntTfn0pZCtEWWy67byJPctsIR9bQ&usqp=CAU', '$2a$10$KuxYzwhKGdKCS9cuUc4PhuLMiJj7NaWvxpT/jI4coYOklksmmHjG.');

INSERT INTO user_roles(
    user_id, role_id)
VALUES (1, 1);