package com.example.pojo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@MappedSuperclass
public class User  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	@Length(min = 3, max = 20, message = "Invalid len of Name")
	@Column(length = 20)
	@NotBlank(message = "firstName is required")
	private String firstname;
	
	@Length(min = 3, max = 20, message = "Invalid len of Name")
	@Column(length = 20)
	@NotBlank(message = "lastName is required")
	private String lastname;
	
	@Email
	@NotBlank(message = "email is required")
	private String email;
	
	
	private Long mobileNo;
	
	@NotBlank(message = "password is required")
//	@JsonIgnore
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	 
	@NotBlank(message = "CompanyName is required")
	private String companyname;


	public User(String firstName, String lastName, String email, Long mobileNo, String password, UserRole role,
			String companyName) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.role = role;
		this.companyname = companyName;
	}
	
	


	public User(Long id,
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "firstName is required") String firstname,
			@Length(min = 3, max = 20, message = "Invalid len of Name") @NotBlank(message = "lastName is required") String lastname,
			@Email @NotBlank(message = "email is required") String email, Long mobileNo,
			@NotBlank(message = "password is required") String password, UserRole role,
			@NotBlank(message = "CompanyName is required") String companyname) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;	
		this.role = role;
		this.companyname = companyname;
	}




	public User() {
		
	}

	


	public Long getId() {
		return Id;
	}




	public void setId(Long id) {
		Id = id;
	}




	public String getFirstName() {
		return firstname;
	}


	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}


	public String getLastName() {
		return lastname;
	}


	public void setLastName(String lastName) {
		this.lastname = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserRole getRole() {
		return role;
	}


	public void setRole(UserRole role) {
		this.role = role;
	}


	public String getCompanyName() {
		return companyname;
	}


	public void setCompanyName(String companyName) {
		this.companyname = companyName;
	}




	


}

