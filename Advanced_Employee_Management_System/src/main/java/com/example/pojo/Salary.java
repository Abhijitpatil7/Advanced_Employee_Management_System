package com.example.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long basic_salary;
	
	private long allowances;
	
	private long total_sal;
	
	@OneToOne
	private Employee emp;

	public Long getId() {	
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getBasic_salary() {
		return basic_salary;
	}

	public void setBasic_salary(long basic_salary) {
		this.basic_salary = basic_salary;
	}

	public long getAllowances() {
		return allowances;
	}

	public void setAllowances(long allowances) {
		this.allowances = allowances;
	}

	public long getTotal_sal() {
		return total_sal;
	}

	public void setTotal_sal(long total_sal) {
		this.total_sal = total_sal;
	}
	
	public long calculateTotal_sal(long basic_sal,long allowance) {
		return this.total_sal = basic_sal+allowance;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Salary(long basic_salary, long allowances, long total_sal, Employee emp) {
		super();
		this.basic_salary = basic_salary;
		this.allowances = allowances;
		this.total_sal = total_sal;
		this.emp = emp;
	}

	public Salary() {
		super();
	}


	
	
		

}
