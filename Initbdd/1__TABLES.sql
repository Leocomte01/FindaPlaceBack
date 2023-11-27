create table users
(
    id SERIAL PRIMARY KEY,
    user_name TEXT not null,
    first_name TEXT not null,
    last_name TEXT not null,
    password TEXT not null,
    email TEXT not null
);

create table place
(
    id SERIAL PRIMARY KEY,
    id_place_google TEXT not null,
    name TEXT not null,
    address TEXT not null,
    location TEXT not null,
    images TEXT,
    icon TEXT
);

create table review
(
    id SERIAL PRIMARY KEY,
    comment Text,
    rate int,
    place_id int not null,
    date_publication DATE ,
    users_id int not null
);

create table tags
(
    id      SERIAL PRIMARY KEY,
    name Text,
    color Text
);

create table review_tag
(
    review_id int,
    tag_id int
);

create table following_relation
(
    id SERIAL PRIMARY KEY,
    follower_id  int,
    following_id int
)