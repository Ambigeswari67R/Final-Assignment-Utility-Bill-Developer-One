package com.finzly.bharatbijili.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.bharatbijili.dao.InvoiceDao;
import com.finzly.bharatbijili.entity.Invoice;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceDao invoiceDao;

	public List<Invoice> getAllInvoice() {
		return invoiceDao.getAllInvoice();
	}

	public List<Invoice> getInvoiceByCustomerId(Long customerId) {
		return invoiceDao.getInvoiceByCustomerId(customerId);
	}

	public String createInvoice(Invoice invoice) {
		return invoiceDao.createInvoice(invoice);
	}

	public List<Invoice> getInvoiceById(Long invoiceId) {
		return invoiceDao.getInvoiceById(invoiceId);
	}

}
