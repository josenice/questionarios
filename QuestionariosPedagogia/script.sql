insert into questionariodeautoavaliacao (id, descricao) values (1, 'Auto Avalia��o');
insert into grupoitemavaliacao  (id, descricao) values (1, 'Postura Profissional');
insert into grupoitemavaliacao  (id, descricao) values (2, 'Conte�do');
insert into grupoitemavaliacao  (id, descricao) values (3, 'Metodologia / Recursos Did�ticos');
insert into grupoitemavaliacao  (id, descricao) values (4, 'Avalia��o');

insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '1.Pontualidade  (comparece �s aulas no hor�rio estabelecido)', 1);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '2.Assiduidade  (comparece �s aulas regularmente)', 1);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '3.Demonstra postura profissional adequada  (apresenta��o pessoal, posicionamento em sala, linguagem, etc.)', 1);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '4.Apresenta algum problema de comunica��o  (v�cios de linguagem, dic��o, etc.)', 1);

insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '1.Apresenta o programa previsto para cada disciplina no primeiro dia de aula letivo' , 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '2.Entrega o programa previsto para a disciplina e/ou disponibiliza no sistema acad�mico', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '3.Demonstra seguran�a na exposi��o dos conte�dos', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '4.Exp�e com clareza o conte�do, destacando conceitos importantes da disciplina', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '5.Estabelece rela��es entre os conte�dos de sua disciplina e os conte�dos das demais disciplinas', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '6.Adequa os conte�dos da disciplina � �rea do curso', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '7.Desenvolve os conte�dos previstos para o per�odo, propostos no programa', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '8.Trabalha os conte�dos em conson�ncia com as recentes inova��es tecnol�gicas', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '9.Exp�e os conte�dos de forma aprofundada', 2);

insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '1.Comunica-se de forma clara facilitando a compreens�o', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '2.Utiliza-se de recursos did�ticos diversos', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '3.Incentiva/estimula a participa��o, express�o e discuss�o de ideias sobre o assunto em quest�o', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '4.Demonstra disponibilidade para esclarecer d�vidas', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '5.Demonstra dom�nio de turma', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '6.Exige o cumprimento das atividades propostas na disciplina', 3);

insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '1.Apresenta e deixa claro procedimentos e crit�rios de avalia��o', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '2.Utiliza instrumentos de avalia��o compat�veis com os conhecimentos desenvolvidos na disciplina', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '3.Devolve os instrumentos avaliativos devidamente corrigidos ao final do bimestre', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '4.Analisa e comenta com os alunos os resultados de atividades avaliativas, corrigndo e esclarecendo d�vidas', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '5.Utiliza, no m�nimo, 2 instrumentos avaliativos por bimestre', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '6.Utiliza pelo menos 1 instrumento avaliativo individual por bimestre', 4);


insert into questionarioavaliacaodeturma (id, descricao) values (1, 'Avalia��o de Turma - teste');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, '1.A Turma comparece �s aulas no hor�rio estabelecido?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, '2.A Turma comparece �s aulas diariamente?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, '3.A Turma possui um bom rendimento escolar?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, '4.A Turma interessa-se e participa das aulas?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, '5.A Turma comporta-se adequadamente em sala de aula?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, '6.A Turma realiza as atividades propostas no prazo estabelecido?');
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
