package com.finzly.bharatbijili.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.bharatbijili.dao.CustomerDao;
import com.finzly.bharatbijili.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	public String addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	public String deleteCustomer(Long customerId,Customer customer ) {
		return customerDao.deleteCustomer(customerId,customer);
	}

}
