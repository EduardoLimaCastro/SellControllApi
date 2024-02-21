CREATE TABLE site_users (
    id bigint NOT NULL auto_increment,
    login varchar(150) not null,
    password varchar(255) not null,

    primary key(id)
);