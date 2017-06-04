#tipo telefone
CREATE TYPE tp_fone AS OBJECT(
cod INTEGER,
numero INTEGER,
MEMBER PROCEDURE exibe_fone (SELF tp_fone)
);
/
#tipo endereço
CREATE TYPE tp_endereco AS OBJECT(
cep INTEGER,
rua VARCHAR(20),
numero SMALLINT,
complemento VARCHAR(20),
bairro VARCHAR(15),
cidade varchar(15),
estado varchar(2),
MEMBER PROCEDURE exibe_endereco (SELF tp_endereco)
);
/

#tipo funcionario
CREATE TYPE tp_funcionario AS OBJECT(
cod varchar(10),
nome VARCHAR(30),
email varchar(30),
data_nascimento DATE,
data_admissao DATE,
telefone tp_fone,
endereco tp_endereco,
MEMBER PROCEDURE exibe_funcionario (SELF tp_funcionario)
);
/
#adicionando supervisor ao tipo funcionario
ALTER TYPE tp_funcionario ADD ATTRIBUTE(supervisor REF tp_funcionario) CASCADE;

#tabela funcionario
CREATE TABLE tb_funcionario OF tp_funcionario(
	cod PRIMARY KEY
);

#inserindo valor à tabela funcionario
INSERT INTO tb_funcionario VALUES(
	'func123',
	'fulano', 
	'fulano@cicrano.com',
	TO_DATE('10-10-1980','DD-MM-YYYY'),
	TO_DATE('03-03-2005','DD-MM-YYYY'),
	tp_fone(81,99999999),
	tp_endereco(54400000,'tal de alguma coisa',20,'bl.02 ap302','Esse bairro','raincife','pe')
);





