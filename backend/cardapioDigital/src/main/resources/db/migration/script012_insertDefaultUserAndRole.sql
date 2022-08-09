insert into tb_user values(nextval('tb_user_id_seq'), 'admin', '$2a$10$dZ3/ZupjPof.5pgQHdmX4.06ZrM1j8thxRcRdBiIOURrRjh7D.28K');
insert into tb_role values(nextval('tb_role_id_seq'), 'ADMIN');
insert into users_roles (user_id, role_id) (select (select id from tb_user where username = 'admin' ) as user, (select id from tb_role where role_name = 'ADMIN') as role)

