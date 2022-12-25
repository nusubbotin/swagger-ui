-- liquibase formatted sql

-- changeSet: subbotin:1
create index student_name_idx on student (name);

-- changeSet: subbotin:2
create index faculty_name_color_idx on faculty(name, color);


