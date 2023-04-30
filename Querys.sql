CREATE DATABASE college;

CREATE TABLE students
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    document  VARCHAR(100) NOT NULL,
    full_name VARCHAR(100) NOT NULL
);

INSERT INTO students(document, full_name)
VALUES ('1094945862', 'Sandy Dahiana'),
       ('1094931275', 'Julián Andrés Rodríguez'),
       ('43365923', 'Diana Margarita Arboleda'),
       ('28994397', 'Fanny Yaneth Guerra');

SELECT *
from students;

CREATE TABLE subject
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(100) NOT NULL,
    credits INT          NOT NULL
);

INSERT INTO subject(name, credits)
VALUES ('Técnicas de Programación', 4),
       ('Inglés II', 2),
       ('Argumentación y Lectoescritura', 2),
       ('Matemáticas discretas', 3),
       ('Lógica y Representación', 3);

SELECT *
from subject;

CREATE TABLE student_subject
(
    id                INT PRIMARY KEY AUTO_INCREMENT,
    id_student        INT NOT NULL,
    id_subject        INT NOT NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO student_subject(id_student, id_subject)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 2),
       (2, 5),
       (3, 3),
       (3, 4),
       (4, 1),
       (4, 3),
       (4, 4),
       (4, 5);

SELECT *
FROM student_subject;


# Query personalizado en la relación muchos a muchos
SELECT stu.id as idStudent,
       stu.document,
       stu.full_name,
       ss.id  as idStudentSubject,
       ss.registration_date,
       sub.id as idSubject,
       sub.name,
       sub.credits
FROM students stu
         INNER JOIN student_subject ss ON ss.id_student = stu.id
         INNER JOIN subject sub ON ss.id_subject = sub.id
WHERE stu.id=2;


