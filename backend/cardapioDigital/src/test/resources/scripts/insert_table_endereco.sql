insert into empresa (id, razao_social, cnpj, descricao, site, telefone_contato, email, idioma, fuso) values
(999, 'empresa teste', '12346', 'descricao empresa teste', 'wwww.empresateste.com.br', '(54)991786534', 'empresa@teste.com.br', 'PT', 'Z');

insert into endereco (id, id_empresa, cep, logradouro, numero, bairro, complemento, cidade, estado, pais) values
(999, 999, '95010000', 'Avenida Julio de Castilhos', 100, 'Centro', 'Complemento', 'Caxias do Sal', 'RS', 'Brasil');