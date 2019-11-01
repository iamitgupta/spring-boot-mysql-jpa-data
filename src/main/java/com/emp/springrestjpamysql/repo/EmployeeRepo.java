package com.emp.springrestjpamysql.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.springrestjpamysql.beans.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findByName(String name);

}
