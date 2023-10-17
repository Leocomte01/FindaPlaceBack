INSERT INTO users (id, user_name, first_name, last_name, password, email) VALUES (1,'Popo', 'Paul', 'Harrohide', '0000', 'hehe@hehe.fr');
INSERT INTO users (id, user_name, first_name, last_name, password, email) VALUES (2, 'Elmatador', 'Leo', 'Comte', '0000', 'hehe2@hehe.fr');
INSERT INTO users (id, user_name, first_name, last_name, password, email) VALUES (3, 'Zaza92', 'Laura', 'Zablit', '0000', 'hehe3@hehe.fr');

INSERT INTO review (id, comment, rate, id_place_google, date_publication, users_id) VALUES (1, 'Pas mal', 4, 'E', '2023-10-15', 2);
INSERT INTO review (id, comment, rate, id_place_google, date_publication, users_id) VALUES (2, 'Pas trop mal', 4, 'E', '2023-10-16', 2);

INSERT INTO following_relation(id, follower_id, following_id) VALUES (1,2,1);
INSERT INTO following_relation(id, follower_id, following_id) VALUES (2,2,3);


