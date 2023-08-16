package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pojo.Admin;
import com.example.pojo.Employee;
import com.example.service.IAdmin;

public interface AdminRepo extends JpaRepository<Admin,Long> {

	Employee save(Employee emp);
	
	
	
}
