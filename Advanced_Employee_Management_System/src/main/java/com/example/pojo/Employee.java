package com.example.pojo;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Employee extends User  {
	
	
	private String Address;
	
	private LocalDate dateOfJoining;
	
	
	@ManyToOne
	private Admin admin;
	
	@OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Leaves> leave;
	
	@OneToOne(mappedBy = "emp",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private Salary salary;
	
	

	public Employee(String firstName, String lastName, String email, Long mobileNo, String password, UserRole role,
			String companyName, String address, LocalDate dateOfJoining, Admin admin) {
		super(firstName, lastName, email, mobileNo, password, role, companyName);
		Address = address;
		this.dateOfJoining = dateOfJoining;
		this.admin = admin;
		
	}
	public Employee() {
		super();
	}
	




	
	public Employee(long Id,String firstName, String lastName, String email, Long mobileNo, String password, UserRole role,
			String companyName, String address, LocalDate dateOfJoining, Admin admin) {
		super(Id,firstName, lastName, email, mobileNo, password, role, companyName);
		Address = address;
		this.dateOfJoining = dateOfJoining;
		this.admin = admin;
	}
	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}


	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public List<Leaves> getLeave() {
		return leave;
	}


	public void setLeave(List<Leaves> leave) {
		this.leave = leave;
	}


	public Salary getSalary() {
		return salary;
	}


	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	
	public void addSalary(Salary sal) {
		sal.setEmp(this);
		this.setSalary(sal);
		
	}
	
	



//	public List<Employee> findById(long id) {
//	
//		return null;
//	}




	
	
	
	
	

	

}
