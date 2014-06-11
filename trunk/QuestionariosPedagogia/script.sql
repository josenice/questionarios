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


insert into questionario (id, descricao, tipoquestionario) values (2, 'Auto Avaliacao Docente', 'AUTO_AVALIACAO_DOCENTE');
insert into grupoitemavaliacao (id, descricao) values (1, 'Postura Profissional');
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (8, 'Pontualidade (comparece às aulas no horário estabelecido)', true, 2, 1);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (9, 'Assiduidade (comparece às aulas regularmente)', true, 2, 1);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (10, 'Demonstra postura profissional adequada (apresentação pessoal, posicionamento em sala, linguagem, etc.)', true, 2, 1);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (11, 'Apresenta algum problema de comunicação (vícios de linguagem, dicção, etc.)', true, 2, 1);

insert into grupoitemavaliacao (id, descricao) values (2, 'Conteúdo');
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (12, 'Apresenta o programa previsto para a disciplina no primeiro dia de aula do período letivo', true, 2, 2);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (13, 'Entrega o Programa previsto para a disciplina e/ou disponibiliza no sistema acadêmico', true, 2, 2);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (14, 'Demonstra segurança na exposição dos conteúdos', true, 2, 2);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (15, 'Expõe com clareza o conteúdo, destacando conceitos importantes da disciplina', true, 2, 2);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (16, 'Estabelece relações entre os conteúdos de sua disciplina e os conteúdos das demais disciplinas', true, 2, 2);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (17, 'Adequa os conteúdos da disciplina à área do curso', true, 2, 2);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (18, 'Desenvolve os conteúdos previstos para o período, propostos no programa', true, 2, 2);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (19, 'Trabalha os conteúdos em consonância com as resentes inovações tecnológicas (contextualização)', true, 2, 2);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (20, 'Expõe os conteúdos de forma aprofundada', true, 2, 2);


insert into grupoitemavaliacao (id, descricao) values (3, 'Metodologia / Recursos Didáticos');
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (21, 'Comunica-se de forma adequada clara facilitando a compreensão', true, 2, 3);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (22, 'Utiliza-se de recursos didáticos diversos', true, 2, 3);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (23, 'Incentiva/estimula a participação, expressão e discussão de ideias sobre o assunto em questão', true, 2, 3);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (24, 'Demonstra disponibilidade para esclarecer dúvidas', true, 2, 3);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (25, 'Demonstra domínio de turma', true, 2, 3);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (26, 'Exige o cumprimento das atividades propostas na disciplina (prazos de entrega de trabalho/participação na aula/etc.)', true, 2, 3);

insert into grupoitemavaliacao (id, descricao) values (4, 'Avaliação');
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (27, 'Apresenta e deixa claro procedimentos e critérios de avaliação', true, 2, 4);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (28, 'Utiliza instrumentos de avaliação compatíveis com os conhecimentos desenvolvidos na disciplina', true, 2, 4);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (29, 'Desenvolve os instrumentos avaliativos devidamente corrigidos ao final do bimestre', true, 2, 4);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (30, 'Analisa e comenta com os alunos os resultados de atividades avaliativas, corrigindo erros e esclarecendo dúvidas', true, 2, 4);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (31, 'Utiliza, no mínimo, 2 instrumentos avaliativos por bimestre', true, 2, 4);
insert into itemavaliacao (id, texto, usarfrequencia, questionario_id, grupo_id) values (32, 'Utiliza pelo menos 1 instrumento avaliativo individual por bimestre', true, 2, 4);
insert into campotextual (id, descricao, itemavaliacao_id) values (33, 'Outros aspectos que você deseja enfatizar:', 2);

insert into bimestreletivo (id, bimestre, ano_id, questionarioautoavaliacaodocente_id, questionarioavaliacaodeturma_id) values (1, 1, 1, 2, 1);