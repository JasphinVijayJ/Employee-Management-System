create database employee_management;
use employee_management;

create table department (
dept_id int primary key auto_increment,
dept_name varchar(50) unique not null);

select * from department;

create table employee (
emp_id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(50) unique not null,
phone varchar(50) unique not null,
hire_date date not null,
dept_id int,
foreign key (dept_id) references department(dept_id) on delete set null);

select * from employee;

create table emp_salary (
salary_id int primary key auto_increment,
emp_id int unique,
salary decimal(10,2) not null check (salary > 0),
bonus decimal(10,2) default 0,
foreign key (emp_id) references employee(emp_id) on delete cascade);

select * from emp_salary;

create table emp_attendance (
att_id int primary key auto_increment,
emp_id int,
att_date date not null,
status enum('Present', 'Absent', 'Leave') not null,
foreign key (emp_id) references employee(emp_id) on delete cascade);

select * from emp_attendance;

