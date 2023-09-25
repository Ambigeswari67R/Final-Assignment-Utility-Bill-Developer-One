package com.finzly.bharatbijili.entity;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id")
	private Long invoiceId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "amount_due")
	private double amountDue;

	@Column(name = "due_date")
	private Date dueDate;

	private String paymentStatus;

	public Invoice() {

	}

	public Invoice(Customer customer, double amountDue, Date dueDate, String paymentStatus) {
		this.customer = customer;
		this.amountDue = amountDue;
		this.dueDate = dueDate;
		this.paymentStatus = paymentStatus;
	}

	

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Invoice{" + "invoiceId=" + invoiceId + ", amountDue=" + amountDue + ", dueDate=" + dueDate + '}';
	}

}
