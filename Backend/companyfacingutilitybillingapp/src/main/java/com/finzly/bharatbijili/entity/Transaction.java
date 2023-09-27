package com.finzly.bharatbijili.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long transactionId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
	private Invoice invoice;

	@Column(name = "transaction_date")
	private Date date;

	@Column(name = "transaction_amount")
	private double amount;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "discount")
	private String discount;

	public Transaction() {
		
	}

	public Transaction(Long transactionId, Customer customer, Invoice invoice, Date date, double amount,
			String paymentMethod, String discount) {
		super();
		this.transactionId = transactionId;
		this.customer = customer;
		this.invoice = invoice;
		this.date = date;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.discount = discount;
	}

	

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Transaction{" + "transactionId=" + transactionId + ", date=" + date + ", amount=" + amount
				+ ", paymentMethod='" + paymentMethod + '\'' + '}';
	}
}
