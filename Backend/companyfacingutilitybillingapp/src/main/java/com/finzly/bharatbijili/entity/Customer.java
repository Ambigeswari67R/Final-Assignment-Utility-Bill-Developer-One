package com.finzly.bharatbijili.entity;

import javax.persistence.*;


@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "name")
	private String name;

	@Column(name = "unit_consumed")
	private double unitConsumed;

	@Column(name = "bill_due_date")
	private String billDueDate;

	@Column(name = "email")
	private String email;

	@Column(name = "telephone")
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Customer() {

	}

	public Customer(Long customerId, String name, double unitConsumed, String billDueDate, String email,
			String telephone) {
		this.customerId = customerId;
		this.name = name;
		this.unitConsumed = unitConsumed;
		this.billDueDate = billDueDate;
		this.email = email;
		this.telephone = telephone;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitConsumed() {
		return unitConsumed;
	}

	public void setUnitConsumed(double unitConsumed) {
		this.unitConsumed = unitConsumed;
	}

	public String getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Customer{" + "customerId='" + customerId + '\'' + ", name='" + name + '\'' + ", unitConsumed="
				+ unitConsumed + ", billDueDate=" + billDueDate + ", email='" + email + '\'' + ", telephone='"
				+ telephone + '\'' + '}';
	}
}
