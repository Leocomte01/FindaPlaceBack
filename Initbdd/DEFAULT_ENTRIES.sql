INSERT INTO users (id, user_name, first_name, last_name, password, email) VALUES (1,'Popo', 'Paul', 'Harrohide', '0000', 'hehe@hehe.fr');
INSERT INTO users (id, user_name, first_name, last_name, password, email) VALUES (2, 'Elmatador', 'Leo', 'Comte', '0000', 'hehe2@hehe.fr');
INSERT INTO users (id, user_name, first_name, last_name, password, email) VALUES (3, 'Zaza92', 'Laura', 'Zablit', '0000', 'hehe3@hehe.fr');

INSERT INTO place (id, id_place_google, name, address, location, images, icon) VALUES (1, 'ChIJldbFmD5u5kcRN_hD8mPd5ZQ', 'Hard Rock Cafe Paris', 'Hard Rock Cafe, Boulevard Montmartre, Paris, France', '(48.8719442, 2.3416045)', null, null);

INSERT INTO review (id, comment, rate, place_id, date_publication, users_id) VALUES (1, 'Pas mal', 4, 1, '2023-10-15', 2);
INSERT INTO review (id, comment, rate, place_id, date_publication, users_id) VALUES (2, 'Pas trop mal', 3, 1, '2023-10-16', 2);

INSERT INTO following_relation(id, follower_id, following_id) VALUES (1,2,1);
INSERT INTO following_relation(id, follower_id, following_id) VALUES (2,2,3);


