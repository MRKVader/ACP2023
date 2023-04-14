CREATE DATABASE ACP12;

create table addresses(
int id primary
city varchar (20)
street varchar (20)
house_num int
)

CREATE TABLE students(
id int PRIMARY,
name VARCHAR(20),
age int,
birthday DATE NOT NULL,
salary DOUBLE,
address_id int,
FOREIGN KEY (address_id) REFERENCES addresses(id),
)

CREATE TABLE

insert into addresses(id, city) values(1, 'Kyiv')
insert into addresses(id, city) values(2, 'Odessa')
insert into addresses(id, city) values(3, 'Kharkiv')
insert into addresses(id, city, street) values(4, 'Kyiv', 'Val')
insert into addresses(id, city) values(5, 'Lviv')
insert into addresses(id, city,street) values(6, 'Lviv', 'Gala')
insert into addresses(id, city) values(7, 'Poltava')


select * from addresses
select * from students
select * from students, addresses

insert into students(id, name, birthday, address_id) values(1, 'Oleg', now(), 1)
insert into students(id, name, birthday, salary, address_id) values(2, 'Vitalii', now(), 7000, 2)
insert into students(id, name, birthday, salary, address_id) values(3, 'Olga', now(), 6000, 3)
insert into students(id, name, birthday, salary, address_id) values(4, 'Ivan', now(), 4000, 4)
insert into students(id, name, birthday, salary, address_id) values(5, 'Sasha', now(), 6500, 5)
insert into students(id, name, birthday, salary, address_id) values(6, 'Vasya', now(), 7500,6)
insert into students(id, name, birthday, salary, address_id) values(7, 'Dima', now(), 6800, 7)
