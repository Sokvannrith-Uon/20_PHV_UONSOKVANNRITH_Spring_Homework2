create table if not exists courses
(
    course_id     serial primary key,
    course_name   varchar(50)  not null,
    description   varchar(100) not null,
    instructor_id int          not null,
    constraint fk_course
        foreign key (instructor_id)
            references instructors (instructor_id)
            ON DELETE CASCADE ON UPDATE CASCADE
);

