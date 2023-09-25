package com.finzly.bharatbijili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.bharatbijili.entity.Invoice;
import com.finzly.bharatbijili.service.InvoiceService;

@RestController
@CrossOrigin
@RequestMapping("/invoices")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/getallinvoice")
	public List<Invoice> getAllInvoice() {
		return invoiceService.getAllInvoice();
	}

	@GetMapping("/{customerId}")
	public List<Invoice> getInvoiceByCustomerId(@PathVariable Long customerId) {
		return invoiceService.getInvoiceByCustomerId(customerId);
	}

	@GetMapping("/getinvoice/{invoiceId}")
	public List<Invoice> getInvoiceById(@PathVariable Long invoiceId) {
		return invoiceService.getInvoiceById(invoiceId);
	}

	@PostMapping("/createinvoice")
	public String createInvoice(@RequestBody Invoice invoice) {
		System.out.println(invoice.getCustomer());
		return invoiceService.createInvoice(invoice);
	}

//
//	@PutMapping("/{userId}")
//	public String updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
//		return invoiceService.updateUser(userId, updatedUser);
//	}
//
//	@DeleteMapping("/{userId}")
//	public String deleteUser(@PathVariable Long userId) {
//		return invoiceService.deleteUser(userId);
//	}

}
