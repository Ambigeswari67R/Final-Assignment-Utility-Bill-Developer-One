package com.finzly.bharatbijili.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.bharatbijili.dao.TransactionDao;
import com.finzly.bharatbijili.entity.Transaction;

@Service
public class TransactionService {
	@Autowired
	private TransactionDao transactionDao;

	public String addTransaction(Transaction transaction) {
		return transactionDao.addTransaction(transaction);
	}

	public List<Transaction> getAllTransaction() {
		return transactionDao.getAllTransaction();
	}

	public List<Transaction> getTransactionByInvoiceId(Long invoiceId) {
		System.out.println(invoiceId);

		return transactionDao.getTransactionByInvoiceId(invoiceId);
	}

}
