-- ============================
-- DADOS DE CATÁLOGO
-- ============================

-- Níveis de Acesso
INSERT INTO access_level (id, level, description) VALUES (1, 10, 'Administrador');
INSERT INTO access_level (id, level, description) VALUES (2, 5, 'Coordenador');
INSERT INTO access_level (id, level, description) VALUES (3, 1, 'Professor');
INSERT INTO access_level (id, level, description) VALUES (4, 1, 'Auxiliar');

-- Modalidades
INSERT INTO modality (id, name) VALUES (1, 'Presencial');
INSERT INTO modality (id, name) VALUES (2, 'EAD');
INSERT INTO modality (id, name) VALUES (3, 'Híbrido');

-- Eixos Tecnológicos
INSERT INTO tech_axis (id, name) VALUES (1, 'Informática');
INSERT INTO tech_axis (id, name) VALUES (2, 'Gestão e Negócios');
INSERT INTO tech_axis (id, name) VALUES (3, 'Controle e Processos Industriais');
INSERT INTO tech_axis (id, name) VALUES (4, 'Infraestrutura');

-- Periodicidade
INSERT INTO periodicity (id, description) VALUES (1, 'Semestral');
INSERT INTO periodicity (id, description) VALUES (2, 'Anual');
INSERT INTO periodicity (id, description) VALUES (3, 'Modular');

-- ============================
-- CURSOS
-- ============================

INSERT INTO course (id, name, description, modality_id, periodicity_id) VALUES 
(1, 'Tecnologia em Análise e Desenvolvimento de Sistemas', 'Formação de desenvolvedores de software', 1, 1);

INSERT INTO course (id, name, description, modality_id, periodicity_id) VALUES 
(2, 'Gestão de Tecnologia da Informação', 'Gestão de projetos e infraestrutura de TI', 1, 1);

INSERT INTO course (id, name, description, modality_id, periodicity_id) VALUES 
(3, 'Tecnologia em Redes de Computadores', 'Especialização em redes e telecomunicações', 1, 1);

INSERT INTO course (id, name, description, modality_id, periodicity_id) VALUES 
(4, 'Tecnologia em Segurança da Informação', 'Proteção e segurança de sistemas', 2, 1);

-- ============================
-- DISCIPLINAS
-- ============================

-- Disciplinas de Informática - TADS
INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(1, 'Programação Orientada a Objetos', 'POO', 1, 1);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(2, 'Banco de Dados', 'BD', 1, 1);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(3, 'Engenharia de Software I', 'ES1', 1, 1);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(4, 'Estruturas de Dados', 'ED', 1, 1);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(5, 'Desenvolvimento Web', 'WEB', 1, 1);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(6, 'Programação para Dispositivos Móveis', 'MOBILE', 1, 1);

-- Disciplinas de Gestão
INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(7, 'Gestão de Projetos', 'GP', 2, 1);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(8, 'Governança de TI', 'GTI', 2, 1);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(9, 'Empreendedorismo Digital', 'EMPR', 2, 1);

-- Disciplinas de Redes
INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(10, 'Redes de Computadores I', 'REDES1', 4, 1);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(11, 'Administração de Sistemas Linux', 'LINUX', 4, 1);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(12, 'Segurança de Redes', 'SECREDES', 4, 1);

-- Disciplinas de Segurança
INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(13, 'Criptografia e Segurança', 'CRIPTO', 1, 2);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(14, 'Ethical Hacking', 'HACK', 1, 2);

INSERT INTO subject (id, name, acronym, tech_axis_id, modality_id) VALUES 
(15, 'Auditoria de Sistemas', 'AUDIT', 2, 2);

-- ============================
-- COURSE_SUBJECT (com semester_number e practical_lessons_count)
-- ============================

-- TADS - 1º Semestre
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (1, 1, 1, 4);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (1, 2, 1, 2);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (1, 4, 1, 2);

-- TADS - 2º Semestre
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (1, 3, 2, 2);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (1, 5, 2, 4);

-- TADS - 3º Semestre
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (1, 6, 3, 4);

-- GTI
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (2, 7, 1, 2);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (2, 8, 2, 2);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (2, 9, 3, 2);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (2, 2, 1, 2);

-- Redes
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (3, 10, 1, 4);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (3, 11, 2, 4);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (3, 12, 3, 2);

-- Segurança
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (4, 13, 1, 2);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (4, 14, 2, 4);
INSERT INTO course_subject (course_id, subject_id, semester_number, practical_lessons_count) VALUES (4, 15, 3, 2);

-- ============================
-- SEMESTRES ACADÊMICOS
-- ============================

INSERT INTO academic_semester (id, academic_year, status, course_id) VALUES (1, 2025, 'ATIVO', 1);
INSERT INTO academic_semester (id, academic_year, status, course_id) VALUES (2, 2025, 'ATIVO', 2);
INSERT INTO academic_semester (id, academic_year, status, course_id) VALUES (3, 2025, 'ATIVO', 3);
INSERT INTO academic_semester (id, academic_year, status, course_id) VALUES (4, 2025, 'PLANEJAMENTO', 4);
INSERT INTO academic_semester (id, academic_year, status, course_id) VALUES (5, 2026, 'PLANEJAMENTO', 1);
INSERT INTO academic_semester (id, academic_year, status, course_id) VALUES (6, 2026, 'PLANEJAMENTO', 2);

-- ============================
-- TURNOS E HORÁRIOS
-- ============================

-- Turnos (ShiftSchedule)
INSERT INTO shift_schedule (id, shift_description, start_time, lesson_count, lesson_duration) VALUES 
(1, 'Manhã (07:00)', 700, 6, 50);

INSERT INTO shift_schedule (id, shift_description, start_time, lesson_count, lesson_duration) VALUES 
(2, 'Tarde (13:00)', 1300, 6, 50);

INSERT INTO shift_schedule (id, shift_description, start_time, lesson_count, lesson_duration) VALUES 
(3, 'Noite (19:00)', 1900, 4, 50);

-- Detalhes dos horários de aula (ShiftScheduleDetail)
-- Manhã
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (1, 1, '07:00:00', '07:50:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (1, 2, '07:50:00', '08:40:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (1, 3, '09:00:00', '09:50:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (1, 4, '09:50:00', '10:40:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (1, 5, '11:00:00', '11:50:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (1, 6, '11:50:00', '12:40:00');

-- Tarde
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (2, 1, '13:00:00', '13:50:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (2, 2, '13:50:00', '14:40:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (2, 3, '15:00:00', '15:50:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (2, 4, '15:50:00', '16:40:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (2, 5, '17:00:00', '17:50:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (2, 6, '17:50:00', '18:40:00');

-- Noite
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (3, 1, '19:00:00', '19:50:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (3, 2, '19:50:00', '20:40:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (3, 3, '21:00:00', '21:50:00');
INSERT INTO shift_schedule_detail (shift_schedule_id, lesson_number, start_time, end_time) VALUES (3, 4, '21:50:00', '22:40:00');

-- ============================
-- SALAS
-- ============================

INSERT INTO classroom (id, name, location, physical_resources, software_resources, capacity, template, practical) VALUES 
(1, 'Sala 101', 'Bloco A - 1º Andar', 'Projetor;Quadro Branco;Ar Condicionado', 'Navegador;Office', 40, false, false);

INSERT INTO classroom (id, name, location, physical_resources, software_resources, capacity, template, practical) VALUES 
(2, 'Laboratório 201', 'Bloco A - 2º Andar', 'Computadores;Projetor;Quadro', 'IDE;SGBD;Git', 30, false, true);

INSERT INTO classroom (id, name, location, physical_resources, software_resources, capacity, template, practical) VALUES 
(3, 'Laboratório 202', 'Bloco A - 2º Andar', 'Computadores;Bancadas;Projetor', 'IDE;Docker;Kubernetes', 25, false, true);

INSERT INTO classroom (id, name, location, physical_resources, software_resources, capacity, template, practical) VALUES 
(4, 'Sala 103', 'Bloco A - 1º Andar', 'Projetor;Sistema de Som;Quadro', 'Office;Navegador', 50, false, false);

INSERT INTO classroom (id, name, location, physical_resources, software_resources, capacity, template, practical) VALUES 
(5, 'Lab Redes 301', 'Bloco B - 3º Andar', 'Switches;Roteadores;Cabos;Computadores', 'Wireshark;Packet Tracer', 20, false, true);

INSERT INTO classroom (id, name, location, physical_resources, software_resources, capacity, template, practical) VALUES 
(6, 'Auditório Principal', 'Bloco C', 'Projetor;Microfones;Sistema de Som', 'Navegador', 100, false, false);

-- ============================
-- USUÁRIOS
-- ============================

INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES 
(1, 'Carlos Admin', 'admin@fatec.sp.gov.br', 'admin123', 1);

INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES 
(2, 'Maria Coordenadora', 'maria.coord@fatec.sp.gov.br', 'coord123', 2);

INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES 
(3, 'Prof. João Silva', 'joao.silva@fatec.sp.gov.br', 'prof123', 3);

INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES 
(4, 'Profa. Ana Santos', 'ana.santos@fatec.sp.gov.br', 'prof123', 3);

INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES 
(5, 'Prof. Pedro Costa', 'pedro.costa@fatec.sp.gov.br', 'prof123', 3);

INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES 
(6, 'Profa. Julia Lima', 'julia.lima@fatec.sp.gov.br', 'prof123', 3);

INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES 
(7, 'Prof. Roberto Alves', 'roberto.alves@fatec.sp.gov.br', 'prof123', 3);

INSERT INTO tbl_user (id, name, email, password, access_level_id) VALUES 
(8, 'Profa. Carla Souza', 'carla.souza@fatec.sp.gov.br', 'prof123', 3);

-- ============================
-- USER_SUBJECT (Professores x Disciplinas)
-- ============================

-- Prof. João ensina POO e Estruturas de Dados
INSERT INTO user_subject (user_id, subject_id) VALUES (3, 1);
INSERT INTO user_subject (user_id, subject_id) VALUES (3, 4);

-- Profa. Ana ensina Banco de Dados e Desenvolvimento Web
INSERT INTO user_subject (user_id, subject_id) VALUES (4, 2);
INSERT INTO user_subject (user_id, subject_id) VALUES (4, 5);

-- Prof. Pedro ensina Engenharia de Software e Gestão de Projetos
INSERT INTO user_subject (user_id, subject_id) VALUES (5, 3);
INSERT INTO user_subject (user_id, subject_id) VALUES (5, 7);

-- Profa. Julia ensina Dispositivos Móveis e Governança
INSERT INTO user_subject (user_id, subject_id) VALUES (6, 6);
INSERT INTO user_subject (user_id, subject_id) VALUES (6, 8);

-- Prof. Roberto ensina Redes e Linux
INSERT INTO user_subject (user_id, subject_id) VALUES (7, 10);
INSERT INTO user_subject (user_id, subject_id) VALUES (7, 11);

-- Profa. Carla ensina Segurança
INSERT INTO user_subject (user_id, subject_id) VALUES (8, 12);
INSERT INTO user_subject (user_id, subject_id) VALUES (8, 13);
INSERT INTO user_subject (user_id, subject_id) VALUES (8, 14);

-- ============================
-- COURSE_USER (Usuários x Cursos)
-- ============================

-- Coordenadora Maria coordena TADS e GTI
INSERT INTO course_user (user_id, course_id, role) VALUES (2, 1, 'COORDENADOR');
INSERT INTO course_user (user_id, course_id, role) VALUES (2, 2, 'COORDENADOR');

-- Prof. João leciona em TADS
INSERT INTO course_user (user_id, course_id, role) VALUES (3, 1, 'PROFESSOR');

-- Profa. Ana leciona em TADS
INSERT INTO course_user (user_id, course_id, role) VALUES (4, 1, 'PROFESSOR');

-- Prof. Pedro leciona em TADS e GTI
INSERT INTO course_user (user_id, course_id, role) VALUES (5, 1, 'PROFESSOR');
INSERT INTO course_user (user_id, course_id, role) VALUES (5, 2, 'PROFESSOR');

-- Profa. Julia leciona em GTI
INSERT INTO course_user (user_id, course_id, role) VALUES (6, 2, 'PROFESSOR');

-- Prof. Roberto leciona em Redes
INSERT INTO course_user (user_id, course_id, role) VALUES (7, 3, 'PROFESSOR');

-- Profa. Carla leciona em Segurança e Redes
INSERT INTO course_user (user_id, course_id, role) VALUES (8, 3, 'PROFESSOR');
INSERT INTO course_user (user_id, course_id, role) VALUES (8, 4, 'PROFESSOR');

-- ============================
-- DISPONIBILIDADES DE PROFESSORES
-- ============================

-- Prof. João - Segunda, Quarta e Sexta (manhã)
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (1, 1, 3);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (1, 2, 3);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (3, 1, 3);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (3, 2, 3);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (5, 1, 3);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (5, 2, 3);

-- Profa. Ana - Terça e Quinta (tarde)
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (2, 3, 4);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (2, 4, 4);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (4, 3, 4);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (4, 4, 4);

-- Prof. Pedro - Segunda a Sexta (noite)
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (1, 1, 5);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (2, 1, 5);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (3, 1, 5);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (4, 1, 5);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (5, 1, 5);

-- Profa. Julia - Segunda a Quarta (manhã e tarde)
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (1, 1, 6);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (1, 3, 6);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (2, 1, 6);
INSERT INTO user_availability (weekday, lesson_number, user_id) VALUES (3, 3, 6);

-- ============================
-- SCHEDULES (AULAS AGENDADAS)
-- ============================

-- Segunda-feira - Manhã - TADS
INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(1, 1, 1, 2, 1, 1, 3);

INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(2, 1, 1, 2, 1, 1, 3);

-- Terça-feira - Tarde - TADS
INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(3, 2, 2, 2, 1, 2, 4);

INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(4, 2, 2, 2, 1, 2, 4);

-- Quarta-feira - Manhã - TADS
INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(1, 3, 1, 2, 1, 4, 3);

INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(2, 3, 1, 2, 1, 4, 3);

-- Quinta-feira - Tarde - TADS
INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(3, 4, 2, 3, 1, 5, 4);

INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(4, 4, 2, 3, 1, 5, 4);

-- Sexta-feira - Noite - GTI
INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(1, 5, 3, 1, 2, 7, 5);

INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(2, 5, 3, 1, 2, 7, 5);

-- Segunda-feira - Manhã - Redes
INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(1, 1, 1, 5, 3, 10, 7);

INSERT INTO schedule (lesson_number, weekday, shift_schedule_id, classroom_id, academic_semester_id, subject_id, professor_id) VALUES 
(2, 1, 1, 5, 3, 10, 7);

COMMIT;

