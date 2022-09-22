insert into empresa (id, razao_social, cnpj, descricao, site, telefone_contato, email, idioma, fuso) values
(999, 'empresa teste', '12346', 'descricao empresa teste', 'wwww.empresateste.com.br', '(54)991786534', 'empresa@teste.com.br', 'PT', 'Z');

insert into categoria (id, id_empresa, descricao, descricao_detalhada, label_mini_prato, status) values
(999, 999,  'descricao simples teste', 'descricao detalhada teste', 'label mini prato teste', true);