
CREATE TABLE tarefas(
	Id INT NOT NULL primary key generated always as identity,
	Id_responsavel INT NOT NULL, 
	Titulo varchar(80),
	Descricao TEXT Not Null,
	Situacao BOOLEAN,	
	Prioridades char(8),
	Deadline date Not Null
	FOREIGN KEY (Id_responsavel) REFERENCES responsavel (Id)
);

CREATE TABLE responsavel
(
    id int NOT NULL primary key generated always as identity,
    nome varchar (60) NOT NULL
);

select* from tarefas;
		
INSERT INTO tarefas (id, id_responsavel, titulo, descricao, situacao, prioridades, Deadline) VALUES 
(3, 1, 'Testar jogos', 'Testar jogos de ação 3D', false, 'Média','2022-03-30');

INSERT INTO tarefas (id, id_responsavel, titulo, descricao, situacao, prioridades,Deadline) 
VALUES (1, 2, 'Criar paisagem', 'utilizar ferramenta específica para criação de paisagens',
		true, 'Baixa',2022-06-01);	
		
		




SELECT * from TAREFAS;
		


INSERT INTO tarefas (id, id_responsavel, titulo, descricao, situacao, prioridades,Deadline) 
VALUES (2, 2, 'Tarefa2', 'Executar curtas reuniões diariamente',
		true, 'Alta','2022-04-01');