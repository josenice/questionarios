insert into anoletivo (id, ano) values (1, 2014);
insert into questionario (id, descricao, tipoquestionario) values (1, 'Avaliacao da Turma', 'AVALIACAO_TURMA');
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id) values (1, 'A Turma comparece às aulas no horário estabelecido?', true, 1);
insert into campotextual (id, descricao, itemavaliacao_id) values (1, 'Alunos com destaques positivos para o item', 1);
insert into campotextual (id, descricao, itemavaliacao_id) values (2, 'Alunos com problema no item', 1);

insert into itemavaliacao (id, texto, usarfrequencia, questionario_id) values (2, 'A Turma comparece às aulas diariamente?', true, 1);
insert into campotextual (id, descricao, itemavaliacao_id) values (3, 'Alunos com destaque positivo para o item', 2);
insert into campotextual (id, descricao, itemavaliacao_id) values (4, 'Alunos com problema no item', 2);

insert into itemavaliacao (id, texto, usarfrequencia, questionario_id) values (3, 'A Turma possui um bom rendimento?', true, 1);
insert into campotextual (id, descricao, itemavaliacao_id) values (5, 'Alunos com destaque possitivo para o item', 3);
insert into campotextual (id, descricao, itemavaliacao_id) values (6, 'Alunos com problema no item', 3);

insert into itemavaliacao (id, texto, usarfrequencia, questionario_id) values (4, 'A Turma interessa-se e participa das aulas?', true, 1);
insert into campotextual (id, descricao, itemavaliacao_id) values (7, 'Alunos com destaque possitivo para o item', 4);
insert into campotextual (id, descricao, itemavaliacao_id) values (8, 'Alunos com problema no item', 4);

insert into itemavaliacao (id, texto, usarfrequencia, questionario_id) values (5, 'A Turma comporta-se adequadamente na sala de aula?', true, 1);
insert into campotextual (id, descricao, itemavaliacao_id) values (9, 'Alunos com destaque possitivo para o item', 5);
insert into campotextual (id, descricao, itemavaliacao_id) values (10, 'Alunos com problema no item', 5);

insert into itemavaliacao (id, texto, usarfrequencia, questionario_id) values (6, 'A Turma realiza as atividades propostas no prazo estabelecido?', true, 1);
insert into campotextual (id, descricao, itemavaliacao_id) values (11, 'Alunos com destaque possitivo para o item', 6);
insert into campotextual (id, descricao, itemavaliacao_id) values (12, 'Alunos com problema no item', 6);

insert into itemavaliacao (id, texto, usarfrequencia, questionario_id) values (7, 'Outros aspectos que você deseja enfatizar:', false, 1);
insert into campotextual (id, descricao, itemavaliacao_id) values (13, NULL, 7);

insert into bimestreletivo (id, bimestre, ano_id, modeloautoavaliacao_id, modeloavaliacaodeturma_id) values (1, 1, 1, NULL, 1);

insert into usuarios (id, matricula, nome) values (1, '12345', 'marta');
insert into professor (id, usuario_id) values (1, 1);
insert into turmaseriada (id, codigoSistemaAcademico) values (1, '09999');
insert into diario (id, codigosistemaacademico, anoletivo_id, turma_id) values (1, '09000', 1, 1);
insert into diario_professor (diario_id, professores_id) values (1, 1);

insert into turmaseriada (id, codigosistemaAcademico) values (2, '08000');
insert into diario (id, codigosistemaacademico, anoletivo_id, turma_id) values (2, '08000', 1, 2);
insert into diario_professor (diario_id, professores_id) values (2, 1);

insert into turmaseriada (id, codigosistemaAcademico) values (3, '07000');
insert into diario (id, codigosistemaAcademico, anoletivo_id, turma_id) values (3, '07000', 1, 3);
insert into diario_professor (diario_id, professores_id) values (3, 1);









