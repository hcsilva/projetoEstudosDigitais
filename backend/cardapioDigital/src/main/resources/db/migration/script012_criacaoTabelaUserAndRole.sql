create table tb_user(
  id serial not null,
  username varchar(255) not null,
  password varchar(255) not null,
  primary key (id),
  unique (username)
);

create table tb_role(
  id serial not null,
  role_name varchar(255) not null,
  primary key (id),
  unique (role_name)
);

create table users_roles(
    user_id integer NOT NULL,
    role_id integer NOT NULL,
    CONSTRAINT fk_role_users_roles FOREIGN KEY (role_id)
        REFERENCES tb_role (id),
    CONSTRAINT fk_user_users_roles FOREIGN KEY (user_id)
        REFERENCES tb_user(id)
);