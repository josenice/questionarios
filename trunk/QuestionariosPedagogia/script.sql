insert into questionariodeautoavaliacao (id, descricao) values (1, 'Auto Avalia��o');
insert into itemdeautoavaliacao (modeloquestionario_id, texto) values (1, 'Pontualidade');
insert into itemdeautoavaliacao (modeloquestionario_id, texto) values (1, 'Assiduidade');
insert into itemdeautoavaliacao (modeloquestionario_id, texto) values (1, 'Demonstra postura profissional adequada');
insert into itemdeautoavaliacao (modeloquestionario_id, texto) values (1, 'Apresenta algum problema de comunica��o');

insert into questionarioavaliacaodeturma (id, descricao) values (1, 'Avalia��o de Turma - teste');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, 'A Turma comparece �s aulas no hor�rio estabelecido?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, 'A Turma comparece �s aulas diariamente?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, 'A Turma possui um bom rendimento escolar?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, 'A Turma interessa-se e participa das aulas?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, 'A Turma comporta-se adequadamente em sala de aula?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, 'A Turma realiza as atividades propostas no prazo estabelecido?');
insert into usuarios (id, matricula, nome) values (1, '345', 'maria');
insert into usuarios (id, matricula, nome) values (2, '777', 'Pedro');
insert into professor (id) values (1);
insert into professor (id) values (2);
insert into semestreLetivo (id, ano, semestre) values (1, 2013, 2);
insert into bimestreletivo (id, bimestre, modeloautoavaliacao_id, modeloavaliacaodeturma_id, semestre_id) values (1, 1, 1, 1, 1);
insert into turmaSeriada (id, codigoSistemaAcademico) values (1, '23');
insert into diario (id, codigoSistemaAcademico, semestre_id, turma_id) values (1, '32', 1, 1);
insert into diario_professor (diario_id, professores_id) values (1, 1);
insert into turmaSeriada (id, codigoSistemaAcademico) values (2, '8877');
insert into diario (id, codigoSistemaAcademico, semestre_id, turma_id) values (2, '09090', 1, 2);
insert into diario_professor (diario_id, professores_id) values (2, 1);
insert into diario (id, codigoSistemaAcademico, semestre_id, turma_id) values (3, '08080', 1, 2);
insert into diario_professor (diario_id, professores_id) values (3, 2);
