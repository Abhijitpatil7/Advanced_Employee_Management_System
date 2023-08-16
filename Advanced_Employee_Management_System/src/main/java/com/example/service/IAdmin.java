package com.example.service;

import java.util.List;

import com.example.custom_exception.ResourceNotFoundException;
import com.example.pojo.Admin;
import com.example.pojo.Employee;
import com.example.pojo.Salary;

public interface IAdmin {

	Admin registerAdmin(Admin admin);

//	Employee registerEmployee(Employee request);

	Employee registerEmployee(Employee request, long id) throws ResourceNotFoundException;

	List<Employee> showEmployee(long id) throws ResourceNotFoundException;

	Salary addSalary(Salary sal,long id) throws ResourceNotFoundException;

	

//	Admin registerAdmin(Admin request,String otp) throws ResourceNotFoundException;

}
