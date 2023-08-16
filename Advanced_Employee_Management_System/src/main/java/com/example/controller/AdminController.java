package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.custom_exception.ResourceNotFoundException;
import com.example.pojo.Admin;
import com.example.pojo.Employee;
import com.example.pojo.Salary;
import com.example.service.IAdmin;



@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired 
	private IAdmin adminService;
	
//	@PostMapping("/verify/{otp}")
//	public ResponseEntity<?> userVerification(@RequestBody Admin request,@PathVariable String otp) throws ResourceNotFoundException{
//		return ResponseEntity.ok(adminService.registerAdmin(request,otp));
//	}
	
	@PostMapping("/signUp")
	public ResponseEntity<Admin>registerAdmin(@RequestBody Admin request)
	{
		System.out.println(request.getCompanyName()+request.getEmail());
		return ResponseEntity.ok(adminService.registerAdmin(request));
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<Employee>registerEmployee(@RequestBody Employee request,long id) throws ResourceNotFoundException
	{
		System.out.println(request.getCompanyName()+request.getEmail());
		return ResponseEntity.ok(adminService.registerEmployee(request,id));
	}
	
//	@PostMapping("/addSalary")
//	public ResponseEntity<Employee>addSalary(@RequestBody Salary request,long id)
//	{
//		return ResponseEntity.ok(adminService.addSalary(request,id));
//		
//	}
	
	@GetMapping("showallemployee/{Id}")
	public ResponseEntity<List<Employee>>showEmployee(@PathVariable long Id) throws ResourceNotFoundException
	{
		List<Employee> emp =adminService.showEmployee(Id);
		return ResponseEntity.ok(emp);
	}
	
	@PostMapping("/addsalary/{Id}")
	public ResponseEntity<Salary> addSalary(@RequestBody Salary sal,@PathVariable long Id) throws ResourceNotFoundException{
		System.out.println(Id);
		return ResponseEntity.ok(adminService.addSalary(sal,Id));
	}
	
	
}
