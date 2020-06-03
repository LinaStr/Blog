INSERT INTO Users(username, password, name)
    VALUES('mama', '{bcrypt}$2y$12$A7x.2lPxE6YdV8ed6OYbDucRiod32wqMF9JNerE.wq4glQWaIjRnO', 'Mamukas');

INSERT INTO Users(username, password, name)
    VALUES('tete', '{bcrypt}$2y$12$A7x.2lPxE6YdV8ed6OYbDucRiod32wqMF9JNerE.wq4glQWaIjRnO', 'Tetukas');

INSERT INTO Roles(role_id, role) VALUES(1, 'CUSTOMER');
INSERT INTO Roles(role_id, role) VALUES(2, 'ADMIN');

INSERT INTO Users_Roles(user_id, role_id) VALUES(1, 1);
INSERT INTO Users_Roles(user_id, role_id) VALUES(2, 2);

INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(1, 'komentaras', 1);
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(2, 'komentaras', 2);
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(1, 'komentaras', 1);
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(2, 'komentaras', 2);
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(3, 'komentaras', 2);
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(4, 'komentaras', 1);
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(1, 'komentaras', 1);
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(1, 'komentaras', 2);
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(1, 'komentaras', 2);
INSERT INTO Comments (blog_entry_id, comment_text, user_id) VALUES(1, 'komentaras', 1);

--INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
--INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
--INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
--INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
--INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
--INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
--INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
--
--INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');
--INSERT INTO Blog_Entry (title, blog_content) VALUES('Atsuktuvas', 'Puikiai suka');

--INSERT INTO Products(title, description, price) VALUES('Graztas', 'Puikiai grezia', 150.50);
--INSERT INTO Products(title, description, price) VALUES('Plaktukas', 'Puikiai kala', 12.50);
--INSERT INTO Products(title, description, price) VALUES('Vinis', 'Puikiai laiko', 1.50);

--


--INSERT INTO Users(username, password) VALUES('user', '{bcrypt}$2y$12$A7x.2lPxE6YdV8ed6OYbDucRiod32wqMF9JNerE.wq4glQWaIjRnO');
--INSERT INTO Authorities(username, authority) VALUES('user', 'ROLE_USER');
