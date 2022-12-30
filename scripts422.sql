create table car(
  id    integer primary key,
  marca varchar(255),
  model varchar(255),
  price decimal
);


create table people(
    id   integer primary key,
    name varchar(255),
    age integer,
    license boolean,
    car_id integer,

    foreign key (car_id) references car(id)
);


select s.name student_name, s.age student_age, f.name fac_name
from student s
join faculty f on f.id = s.faculty_id;

select distinct s.name student_name, s.age student_age
from avatar av
join student s on s.id = av.student_id