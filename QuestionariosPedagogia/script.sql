insert into questionariodeautoavaliacao (id, descricao) values (1, 'Auto Avaliação');
insert into grupoitemavaliacao  (id, descricao) values (1, 'Postura Profissional');
insert into grupoitemavaliacao  (id, descricao) values (2, 'Conteúdo');
insert into grupoitemavaliacao  (id, descricao) values (3, 'Metodologia / Recursos Didáticos');
insert into grupoitemavaliacao  (id, descricao) values (4, 'Avaliação');

insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '1.Pontualidade  (comparece às aulas no horário estabelecido)', 1);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '2.Assiduidade  (comparece às aulas regularmente)', 1);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '3.Demonstra postura profissional adequada  (apresentação pessoal, posicionamento em sala, linguagem, etc.)', 1);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '4.Apresenta algum problema de comunicação  (vícios de linguagem, dicção, etc.)', 1);

insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '1.Apresenta o programa previsto para cada disciplina no primeiro dia de aula letivo' , 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '2.Entrega o programa previsto para a disciplina e/ou disponibiliza no sistema acadêmico', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '3.Demonstra segurança na exposição dos conteúdos', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '4.Expõe com clareza o conteúdo, destacando conceitos importantes da disciplina', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '5.Estabelece relações entre os conteúdos de sua disciplina e os conteúdos das demais disciplinas', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '6.Adequa os conteúdos da disciplina à área do curso', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '7.Desenvolve os conteúdos previstos para o período, propostos no programa', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '8.Trabalha os conteúdos em consonância com as recentes inovações tecnológicas', 2);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '9.Expõe os conteúdos de forma aprofundada', 2);

insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '1.Comunica-se de forma clara facilitando a compreensão', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '2.Utiliza-se de recursos didáticos diversos', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '3.Incentiva/estimula a participação, expressão e discussão de ideias sobre o assunto em questão', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '4.Demonstra disponibilidade para esclarecer dúvidas', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '5.Demonstra domínio de turma', 3);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '6.Exige o cumprimento das atividades propostas na disciplina', 3);

insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '1.Apresenta e deixa claro procedimentos e critérios de avaliação', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '2.Utiliza instrumentos de avaliação compatíveis com os conhecimentos desenvolvidos na disciplina', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '3.Devolve os instrumentos avaliativos devidamente corrigidos ao final do bimestre', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '4.Analisa e comenta com os alunos os resultados de atividades avaliativas, corrigndo e esclarecendo dúvidas', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '5.Utiliza, no mínimo, 2 instrumentos avaliativos por bimestre', 4);
insert into itemdeautoavaliacao (modeloquestionario_id, texto, grupo_id) values (1, '6.Utiliza pelo menos 1 instrumento avaliativo individual por bimestre', 4);


insert into questionarioavaliacaodeturma (id, descricao) values (1, 'Avaliação de Turma - teste');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, '1.A Turma comparece às aulas no horário estabelecido?');
insert into itemavaliacaodaturma (modeloavaliacao_id, texto) values (1, '2.A Turma comparece às aulas diariamente?');
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
