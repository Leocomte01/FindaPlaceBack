create table users
(
    id SERIAL PRIMARY KEY,
    user_name TEXT not null,
    first_name TEXT not null,
    last_name TEXT not null,
    password TEXT not null,
    email TEXT not null
);

create table review
(
    id SERIAL PRIMARY KEY,
    comment Text,
    rate int not null,
    id_place_google TEXT not null,
    date_publication DATE ,
    users_id int not null
);

create table following_relation
(
    id SERIAL PRIMARY KEY,
    follower_id  int,
    following_id int
)

