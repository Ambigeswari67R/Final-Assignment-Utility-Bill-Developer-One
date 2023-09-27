package com.finzly.bharatbijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.bharatbijili.entity.Customer;
import com.finzly.bharatbijili.entity.User;

@Repository
public class CustomerDao {
	@Autowired
	SessionFactory factory;

	public List<Customer> getAllCustomer() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();
	}

	public String addCustomer(Customer customer) {
		Session session = factory.openSession();
		session.save(customer);
		session.beginTransaction().commit();
		System.out.println(customer.getCustomerId());
		return "{\"result\":\"OK\",\"custId\":" + customer.getCustomerId() + "}";
	}

	public String deleteCustomer(Long customerId,Customer customer) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Customer customerToDelete = session.get(Customer.class, customerId);

			if (customerToDelete != null) {
				session.delete(customerToDelete);
				tx.commit();
				return "{\"result\":\"OK\",\"customerId\":" + customer.getCustomerId() + "}";
			} else {
				return "customer with ID " + customerId + " not found";
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return "Error deleting customer: " + e.getMessage();
		} finally {
			session.close();
		}
	}

}
