package com.ems.service;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        // Check if email already exists
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email already exists: " + employee.getEmail());
        }

        // Phone already exists check
        if (employeeRepository.existsByPhoneNumber(employee.getPhoneNumber())) {
            throw new RuntimeException("Phone number already exists: " + employee.getPhoneNumber());
        }

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = getEmployeeById(id);

        // EMAIL VALIDATION (avoid duplicate with other employees)
        if (!employee.getEmail().equals(employeeDetails.getEmail()) && employeeRepository.existsByEmail(employeeDetails.getEmail())) {

            throw new RuntimeException("Email already exists: " + employeeDetails.getEmail());
        }

        // PHONE VALIDATION (avoid duplicate with other employees)
        if (!employee.getPhoneNumber().equals(employeeDetails.getPhoneNumber()) && employeeRepository.existsByPhoneNumber(employeeDetails.getPhoneNumber())) {

            throw new RuntimeException("Phone number already exists: " + employeeDetails.getPhoneNumber());
        }

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setGender(employeeDetails.getGender());
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setPosition(employeeDetails.getPosition());
        employee.setSalary(employeeDetails.getSalary());
        employee.setAddress(employeeDetails.getAddress());

        return employeeRepository.save(employee);
    }

    public String deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        return "Employee with ID " + id + " deleted successfully";
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        List<Employee> employees = employeeRepository.findByDepartment(department);

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found for department: " + department);
        }

        return employees;
    }

    public List<Employee> getEmployeesByPosition(String position) {
        List<Employee> employees = employeeRepository.findByPosition(position);

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found for position: " + position);
        }

        return employees;
    }
}