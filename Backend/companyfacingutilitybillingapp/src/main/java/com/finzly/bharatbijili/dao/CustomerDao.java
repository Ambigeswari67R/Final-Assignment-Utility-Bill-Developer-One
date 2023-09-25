package com.finzly.bharatbijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.bharatbijili.entity.Customer;

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

}
