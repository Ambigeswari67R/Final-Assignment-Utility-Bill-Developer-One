package com.finzly.bharatbijili.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "employee_id", unique = true, nullable = false)
	private String employeeId;
	@Column(name = "otp", unique = true, nullable = false)
	private String otp;

	@OneToMany(mappedBy = "user")
	private List<Customer> customers;

	public User() {

	}

	public User(String employeeId, String otp) {
		this.employeeId = employeeId;
		this.otp = otp;
	}

	
//    public List<Customer> getCustomers() {
//        return customers;
//    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

//	public void setCustomers(List<Customer> customers) {
//        this.customers = customers;
//    }

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", employeeId=" + employeeId + ", otp=" + otp + "]";
	}

}
