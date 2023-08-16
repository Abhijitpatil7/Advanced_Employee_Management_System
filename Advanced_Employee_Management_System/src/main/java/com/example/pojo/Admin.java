package com.example.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Admin")
public class Admin extends User{
	
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Employee> emp;

//	public Admin(String firstName, String lastName, String email, String mobileNo, String password, UserRole role,
//			String companyName, List<Employee> emp) {
//		super(firstName, lastName, email, mobileNo, password, role, companyName);
//		this.emp = emp;
//	}

	public Admin(String firstName, String lastName, String email, Long mobileNo, String password, UserRole role,
			String companyName) {
		super(firstName, lastName, email, mobileNo, password, role, companyName);
		
	}
	
	public Admin() {
		super();
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	
	public void addEmployee(Employee emp1) {
		emp.add(emp1);
		emp1.setAdmin(this);
	}
	
	
	
	

}

