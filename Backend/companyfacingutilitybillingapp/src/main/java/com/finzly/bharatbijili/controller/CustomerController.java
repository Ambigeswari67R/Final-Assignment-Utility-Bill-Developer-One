package com.finzly.bharatbijili.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.bharatbijili.entity.Customer;
import com.finzly.bharatbijili.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("getcustomer")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@PostMapping
	public String addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);

	}
	@DeleteMapping("/{customerId}")
	public String deleteCustomer(@PathVariable Long customerId,Customer customer) {
		return customerService.deleteCustomer(customerId,customer);
	}

}
