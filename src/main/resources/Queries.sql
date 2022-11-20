------------------------------------------------------------------------------------------------------------------------
------------------------------------------------Consultas---------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------

-- Seleciona lista de pacientes
    SELECT p.paciente_id, p.nome_completo, p.email, p.telefone, p.bairro, p.cpf, p.data_cadastro, p.data_nascimento
    FROM smca.tb_paciente p;

-- Retorna a quantidade de registros por bairro
    select count(1) as qtdeCasos, bairro
    from  smca.tb_paciente
    group by bairro;

-- Tabela com o cadastro de usuários
    select * from tb_user;

--Tabela de regras
    select * from tb_role tr;

-- Tabela que associa usuários a regras
    select * from tb_users_roles tur ;

------------------------------------------------------------------------------------------------------------------------
------------------------------------------------Inserts---------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------

-- Tabela com o cadastro de usuários
    insert into tb_user values(1,'$2a$10$3rdzx6BKU7IPPJrlLfDZxewz8XkfxWzGfYlXQQKJ.cHb/qmsf/DBC','maria');
    insert into tb_user values(2,'$2a$10$3rdzx6BKU7IPPJrlLfDZxewz8XkfxWzGfYlXQQKJ.cHb/qmsf/DBC','joao');

--Tabela de regras
    insert into tb_role values(1,'ROLE_ADMIN');
    insert into tb_role values(2,'ROLE_USER');

-- Tabela que associa usuários a regras
    insert into tb_users_roles values(1,1);
    insert into tb_users_roles values(2,2);

