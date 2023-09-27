package com.finzly.bharatbijili.service;

import java.util.List;

import javax.transaction.Transactional;

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


	 @Transactional
	public Invoice updatePayment(Long invoiceId, String paymentStatus,Invoice invoice) {
		 System.out.println("hello");
		 Invoice invoice1 = invoiceDao.findById(invoiceId);
        if (invoice1 == null) {
            //throw new EntityNotFoundException("Invoice not found with ID: " + invoiceId);
        }
        

        invoice1.setPaymentStatus(paymentStatus);
        //invoice1.setAmountDue(invoice.getAmountDue());
        return invoiceDao.save(invoice1);
	}

}
