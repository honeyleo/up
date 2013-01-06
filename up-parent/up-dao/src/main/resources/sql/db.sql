create table t_user (
       	id bigint(20) NOT NULL AUTO_INCREMENT,
        login_name varchar(255) not null unique,
        name varchar(64),
        password varchar(255),
        salt varchar(64),
        email varchar(128),
        status varchar(32),
        primary key (id)
);