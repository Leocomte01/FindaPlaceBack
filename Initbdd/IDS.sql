SELECT setval(pg_get_serial_sequence('following_relation', 'id'), coalesce(max(id)+1, 1), false) FROM following_relation;
SELECT setval(pg_get_serial_sequence('users', 'id'), coalesce(max(id)+1, 1), false) FROM users;
SELECT setval(pg_get_serial_sequence('review', 'id'), coalesce(max(id)+1, 1), false) FROM review;