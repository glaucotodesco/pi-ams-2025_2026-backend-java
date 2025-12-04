-- Dados de catálogo
INSERT INTO access_level (id, level, description) VALUES (1, 10, 'Administrador');
INSERT INTO access_level (id, level, description) VALUES (2, 5, 'Coordenador');
INSERT INTO access_level (id, level, description) VALUES (3, 1, 'Professor');

INSERT INTO modality (id, name) VALUES (1, 'Presencial');
INSERT INTO modality (id, name) VALUES (2, 'EAD');

INSERT INTO tech_axis (id, name) VALUES (1, 'Informática');
INSERT INTO tech_axis (id, name) VALUES (2, 'Gestão');

INSERT INTO periodicity (id, description) VALUES (1, 'Semestral');
INSERT INTO periodicity (id, description) VALUES (2, 'Anual');

-- Cursos
INSERT INTO course (id, name, description) VALUES (1, 'Tecnologia em Análise e Desenvolvimento de Sistemas', 'TADS - Curso de Desenvolvimento');
INSERT INTO course (id, name, description) VALUES (2, 'Gestão de Tecnologia da Informação', 'GTI - Curso de Gestão');

-- Disciplinas
INSERT INTO subject (id, name, acronym, practical_lesson_count, semester_number) VALUES (1, 'Programação I', 'PROG1', 2, 1);
INSERT INTO subject (id, name, acronym, practical_lesson_count, semester_number) VALUES (2, 'Banco de Dados', 'BD', 2, 2);
INSERT INTO subject (id, name, acronym, practical_lesson_count, semester_number) VALUES (3, 'Engenharia de Software', 'ES', 1, 3);
INSERT INTO subject (id, name, acronym, practical_lesson_count, semester_number) VALUES (4, 'Tópicos de Gestão', 'TG', 0, 1);

-- Associação Course <-> Subject (tabela de join course_subject)
INSERT INTO course_subject (course_id, subject_id) VALUES (1, 1);
INSERT INTO course_subject (course_id, subject_id) VALUES (1, 2);
INSERT INTO course_subject (course_id, subject_id) VALUES (1, 3);
INSERT INTO course_subject (course_id, subject_id) VALUES (2, 4);

-- Semestres acadêmicos
INSERT INTO academic_semester (id, academic_year, status, course_id) VALUES (1, 2025, 'ATIVO', 1);
INSERT INTO academic_semester (id, academic_year, status, course_id) VALUES (2, 2025, 'ATIVO', 2);

-- Turnos (ShiftSchedule)
INSERT INTO shift_schedule (id, shift_description, start_time, lesson_count, lesson_duration) VALUES (1, 'Manhã (07:00)', 700, 6, 50);
INSERT INTO shift_schedule (id, shift_description, start_time, lesson_count, lesson_duration) VALUES (2, 'Tarde (13:00)', 1300, 6, 50);

-- Salas
INSERT INTO classroom (id, name, location, physical_resources, software_resources, capacity, template, practical) VALUES (1, 'Sala 101', 'Bloco A', 'Projetor;Quadro', 'IDE;Office', 40, false, true);
INSERT INTO classroom (id, name, location, physical_resources, software_resources, capacity, template, practical) VALUES (2, 'Laboratório 202', 'Bloco B', 'Computadores;Bancadas', 'IDE;SGBD', 30, false, true);

-- Usuários (senhas fictícias em texto plano apenas para testes)
INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES (1, 'Admin Local', 'admin@example.com', 'admin123', 1);
INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES (2, 'Prof. João', 'joao.prof@example.com', 'prof123', 3);
INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES (3, 'Coordenadora', 'coord@example.com', 'coord123', 2);

-- Disponibilidades de usuário
INSERT INTO user_availability (id, weekday, lesson_number, user_id) VALUES (1, 1, 3, 2);
INSERT INTO user_availability (id, weekday, lesson_number, user_id) VALUES (2, 3, 2, 2);

-- Schedules (aulas agendadas)
INSERT INTO schedule (id, lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES (1, 1, 1, 1, 1, 1, 1, 2);
INSERT INTO schedule (id, lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES (2, 2, 1, 1, 2, 1, 2, 2);

-- Marcações adicionais de testes
INSERT INTO course (id, name, description) VALUES (3, 'Curso de Teste', 'Curso criado para testes');
INSERT INTO subject (id, name, acronym, practical_lesson_count, semester_number) VALUES (5, 'Teste Integrado', 'TI', 0, 1);
INSERT INTO course_subject (course_id, subject_id) VALUES (3, 5);

COMMIT;

