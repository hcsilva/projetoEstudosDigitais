create table empresa (
  id serial not null,
  razao_social varchar(150) not null,
  cnpj int,
  logo oid,
  imagem_capa oid,
  descricao varchar(300),
  site varchar(100),
  instagram varchar(100),
  facebook varchar(100),
  whatsapp varchar(20),
  telefone_contato varchar(20) not null,
  email varchar(50) not null,
  idioma varchar(5) not null,
  fuso varchar(10) not null,
  primary key (id)
);

create table endereco (
  id serial not null,
  id_empresa int not null,
  logradouro varchar not null,
  numero int not null,
  bairro varchar not null,
  complemento varchar,
  cep int not null,
  cidade varchar not null,
  estado varchar not null,
  pais varchar not null,
  primary key (id),
  constraint fk_endereco_empresa foreign key (id_empresa) references empresa
);

create table horario_funcionamento (
  id serial not null,
  id_empresa int not null,
  segunda_ini numeric(5, 2),
  segunda_fim numeric(5, 2),
  segunda_ini_2 numeric(5, 2),
  segunda_fim_2 numeric(5, 2),
  terca_ini numeric(5, 2),
  terca_fim numeric(5, 2),
  terca_ini_2 numeric(5, 2),
  terca_fim_2 numeric(5, 2),
  quarta_ini numeric(5, 2),
  quarta_fim numeric(5, 2),
  quarta_ini_2 numeric(5, 2),
  quarta_fim_2 numeric(5, 2),
  quinta_ini numeric(5, 2),
  quinta_fim numeric(5, 2),
  quinta_ini_2 numeric(5, 2),
  quinta_fim_2 numeric(5, 2),
  sexta_ini numeric(5, 2),
  sexta_fim numeric(5, 2),
  sexta_ini_2 numeric(5, 2),
  sexta_fim_2 numeric(5, 2),
  sabado_ini numeric(5, 2),
  sabado_fim numeric(5, 2),
  sabado_ini_2 numeric(5, 2),
  sabado_fim_2 numeric(5, 2),
  domingo_ini numeric(5, 2),
  domingo_fim numeric(5, 2),
  domingo_ini_2 numeric(5, 2),
  domingo_fim_2 numeric(5, 2),
  primary key (id),
  constraint fk_horario_funcionamento_empresa foreign key (id_empresa) references empresa
);

create table forma_pagamento (
  id serial not null,
  id_empresa int not null,
  dinheiro boolean default false,
  cartao_credito boolean default false,
  cartao_debito boolean default false,
  vale_refeicao boolean default false,
  visivel boolean default false,
  primary key (id),
  constraint fk_forma_pagamento_empresa foreign key (id_empresa) references empresa
);

create table links (
  id serial not null,
  id_empresa int not null,
  descricao varchar(300) not null,
  link varchar(100) not null,
  primary key (id),
  constraint fk_links_empresa foreign key (id_empresa) references empresa
);

create table categoria (
  id serial not null,
  id_empresa int not null,
  descricao varchar(100) not null,
  descricao_detalhada varchar(250) not null,
  label_mini_prato varchar(30),
  status boolean default false,
  primary key (id),
  constraint fk_categoria_empresa foreign key (id_empresa) references empresa
);

create table item_categoria (
  id serial not null,
  id_empresa int not null,
  id_categoria int not null,
  descricao_detalhada varchar(250) not null,
  descricao_simples varchar(100) not null,
  foto oid,
  preco numeric(5, 2) not null,
  preco_mini_prato numeric(5, 2),
  serve_quantidade_pessoas int default 1,
  sem_lactose boolean default false,
  vegetariano boolean default false,
  sem_gluten boolean default false,
  vegano boolean default false,
  destaque boolean default false,
  primary key (id),
  constraint fk_item_categoria_empresa foreign key (id_empresa) references empresa,
  constraint fk_item_categoria_categoria foreign key (id_categoria) references categoria
);

create table item_extras (
  id serial not null,
  id_empresa int not null,
  id_item_categoria int not null,
  descricao_detalhada varchar(250) not null,
  primary key (id),
  constraint fk_item_categoria_empresa foreign key (id_empresa) references empresa,
  constraint fk_item_extras_item_categoria foreign key (id_item_categoria) references item_categoria
);