-- Retrieve Employee Details
select e.emp_id, e.first_name, e.last_name, e.email, e.phone, e.hire_date, d.dept_id, d.dept_name, s.salary, s.bonus
from employee e
join department d on e.dept_id = d.dept_id
left join emp_salary s on e.emp_id = s.emp_id;

-- Find Employees with High Salaries	(average salary of all employees)
select e.emp_id, first_name, last_name, s.salary 
from employee e
join emp_salary s on e.emp_id = s.emp_id
where salary > (select avg(salary) from emp_salary);

-- Updating an Employee's Salary
update emp_salary set salary = salary + 5000 where emp_id = 1;

-- Deleting an Employee		To delete an employee and automatically delete related records from the attendance and salary tables
delete from employee where emp_id = 9;

-- Find Department-wise Employee Count
select d.dept_name, count(e.emp_id) as total_employees
from department d
left join employee e on d.dept_id = e.dept_id
group by d.dept_name;

-- Get Employees Who Were Present for More Than 1 Days
select e.first_name, e.last_name, count(a.att_id) as absent_days
from employee e
join emp_attendance a on a.emp_id = e.emp_id
where a.status = 'Present'
group by e.emp_id
having count(a.att_id) > 1;

-- Retrieving Top N Salaries
select e.first_name, e.last_name, s.salary
from employee e
join emp_salary s on s.emp_id = e.emp_id
order by s.salary desc
limit 5;

-- Department with Highest Average Salary
select d.dept_name, count(s.salary) as avg_salary
from department d
join employee e on e.dept_id = d.dept_id
join emp_salary s on s.emp_id = e.emp_id
group by d.dept_name
order by avg_salary desc
limit 2;

-- Employees Hired in the Last Year
select first_name, last_name, hire_date
from employee
where hire_date >= date_sub(curdate(), interval 1 year);

-- Find month start date by entering random date
select curdate(), date_sub(curdate(), interval day(curdate()) - 1 day) as month_start_date from dual;

-- Find total year of experience by using company joining date
select first_name, last_name, hire_date, timestampdiff(year, hire_date, curdate()) as total_experience from employee;

-- Employee Details Along with Total Salary (Including Bonus)
select e.first_name, e.last_name, (s.salary + s.bonus) as total_salary 
from employee e
join emp_salary s on s.emp_id = e.emp_id;

