package com.finzly.bharatbijili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.bharatbijili.entity.Invoice;
import com.finzly.bharatbijili.entity.Transaction;
import com.finzly.bharatbijili.service.TransactionService;

@RestController
@CrossOrigin
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

	@PostMapping
	public String addTransaction(@RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}

	@GetMapping("/getalltransaction")
	public List<Transaction> getAllTransaction() {
		return transactionService.getAllTransaction();
	}

	@GetMapping("/gettransactionbyinvoice/{invoiceId}")
	public List<Transaction> getTransactionByInvoiceId(@PathVariable Long invoiceId) {
		System.out.println(invoiceId);
		return transactionService.getTransactionByInvoiceId(invoiceId);
	}

}
