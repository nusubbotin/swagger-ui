alter table student ADD CONSTRAINT age CHECK (age > 16);
alter table student ADD CONSTRAINT uidx_name  UNIQUE (name);
alter table faculty ADD CONSTRAINT uidx_name_color UNIQUE (name, color);
alter table student ALTER column age set not null;
alter table student ALTER column age set default 20;

