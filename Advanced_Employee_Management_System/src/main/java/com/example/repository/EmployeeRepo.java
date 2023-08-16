package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojo.Employee;
import com.example.pojo.Salary;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Salary save(Salary salary);

}
