
INSERT INTO tb_pessoa(nome, data_Nascimento) VALUES ('Brad Pitt', '1987-12-13');
INSERT INTO tb_pessoa(nome, data_Nascimento) VALUES ('Katy Perry', '1987-12-13');
INSERT INTO tb_pessoa(nome, data_Nascimento) VALUES ('Lana Del Rey', '1987-12-13');
INSERT INTO tb_pessoa(nome, data_Nascimento) VALUES ('Vin Diesel', '1987-12-13');
INSERT INTO tb_pessoa(nome, data_Nascimento) VALUES ('Gigi Hadid', '1987-12-13');

INSERT INTO tb_endereco(cep, logradouro, cidade, numero) VALUES ('34001-090','Rua Levy Firmino Alves', 'Nova Lima', 40);
INSERT INTO tb_endereco(cep, logradouro, cidade, numero) VALUES ('34001-091','Rua das Flores', 'Nova Lima', 56);
INSERT INTO tb_endereco(cep, logradouro, cidade, numero) VALUES ('34001-092','Rua Bernadino de Lima', 'Nova Lima', 41);
INSERT INTO tb_endereco(cep, logradouro, cidade, numero) VALUES ('34001-093','Rua Camargos', 'Nova Lima', 10);
INSERT INTO tb_endereco(cep, logradouro, cidade, numero) VALUES ('34001-094','Rua Oliveira', 'Nova Lima', 98);

INSERT INTO tb_pessoa_endereco (pessoa_id, endereco_id) VALUES (1, 1);
INSERT INTO tb_pessoa_endereco (pessoa_id, endereco_id) VALUES (2, 2);
INSERT INTO tb_pessoa_endereco (pessoa_id, endereco_id) VALUES (3, 3);
INSERT INTO tb_pessoa_endereco (pessoa_id, endereco_id) VALUES (4, 2);
INSERT INTO tb_pessoa_endereco (pessoa_id, endereco_id) VALUES (5, 3);