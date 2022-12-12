select * from test;


create table student (
                         id integer,
                         name varchar(100),
                         age integer
);

insert into student(id, name, age) values (1, 'test1', 11);
insert into student(id, name, age) values (2, 'test2', 12);
insert into student(id, name, age) values (3, 'test3', 13);
insert into student(id, name, age) values (4, 'test4', 14);
insert into student(id, name, age) values (5, 'Oootest5', 14);

select * from student;
select * from student where age between 10 and 20;
select name from student;
select * from student where name like '%O%'
select * from student where age < id;
select * from student order by age;
