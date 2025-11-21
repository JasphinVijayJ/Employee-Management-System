package com.ems.repository;

import com.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phone);

    List<Employee> findByDepartment(String department);

    List<Employee> findByPosition(String position);
}
