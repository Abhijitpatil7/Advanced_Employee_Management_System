package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojo.Salary;

public interface SalaryRepo extends JpaRepository<Salary, Long>{

}
