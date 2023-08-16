package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.custom_exception.ResourceNotFoundException;
import com.example.pojo.Admin;
import com.example.pojo.Employee;
import com.example.pojo.Salary;
import com.example.pojo.UserRole;
import com.example.repository.AdminRepo;
//import com.example.service.IEmail.IEmailService;
import com.example.repository.EmployeeRepo;
import com.example.repository.SalaryRepo;



@Service
public class AdminService implements IAdmin {
	
	@Autowired	
	private AdminRepo adminrepo;
	

	@Autowired	
	private EmployeeRepo emprepo;
	
	@Autowired
	private SalaryRepo salrepo;
	


	@Override
	public Admin registerAdmin (Admin ad ) {
		Admin admin =new Admin(ad.getFirstName(), ad.getLastName(), ad.getEmail(), ad.getMobileNo(),ad.getPassword(),ad.getRole(), ad.getCompanyName());
		return adminrepo.save(admin);
	}

//	@Override
//	public Employee registerEmployee(Employee request) {
//		Employee emp=new Employee(request.getFirstName(), request.getLastName(), request.getEmail(), request.getMobileNo(), request.getPassword(), request.getRole(), request.getCompanyName(), request.getAddress(), request.getDateOfJoining(), request.getAdmin());
//		return adminrepo.save(emp);
//	}
	
//	@Autowired
//	private IEmailService emailService;
	
//	@Override
//	public Admin registerAdmin(Admin request, String otp) throws ResourceNotFoundException {
//			emailService.getVerify(request,otp);
//			Admin admin=new Admin(request.getFirstName(), request.getLastName(),request.getEmail(),request.getMobileNo(),request.getPassword(), request.getRole(), request.getCompanyName()
//					);
//			return adminrepo.save(admin);
//		}
	
	@Override
	public Employee registerEmployee(Employee request, long id) throws ResourceNotFoundException {
		Admin admin = adminrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User Found"));
		Employee emp =new Employee(request.getFirstName(), request.getLastName(), request.getEmail(), request.getMobileNo(), request.getPassword(), request.getRole(), request.getCompanyName(), request.getAddress(), request.getDateOfJoining(), request.getAdmin());
		admin.addEmployee(emp);
		emp.setAdmin(emp.getAdmin());
		return adminrepo.save(emp);
	}

	@Override
	public List<Employee> showEmployee(long id) throws ResourceNotFoundException {
		
		List<Employee> list =emprepo.findAll();
		for (Employee employee : list) {
			if(employee.getAdmin().getId()==id) {
				return list;
			}
		}
	return null;
	}

	@Override
	public Salary addSalary(Salary sal,long id) throws ResourceNotFoundException {	
	long total_sal=sal.calculateTotal_sal(sal.getBasic_salary(), sal.getAllowances());
	Employee emp=emprepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User Found"));
	Salary sal1= new Salary(sal.getBasic_salary(), sal.getAllowances(), total_sal, emp);
//	sal.setEmp(sal.getEmp());
//	emp.addSalary(sal);
	return salrepo.save(sal1);
	}

	
	
	

	}
		


