package com.finzly.bharatbijili.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.bharatbijili.entity.Customer;
import com.finzly.bharatbijili.entity.Invoice;
import com.finzly.bharatbijili.entity.User;

@Repository
public class InvoiceDao {
	@Autowired
	SessionFactory factory;
	@PersistenceContext
    private EntityManager entityManager;

	public List<Invoice> getAllInvoice() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Invoice.class);
		return criteria.list();
	}

	public List<Invoice> getInvoiceByCustomerId(Long customerId) {
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Invoice.class);
		criteria.createAlias("customer", "c");
		criteria.add(Restrictions.eq("c.customerId", customerId));

		List<Invoice> invoices = criteria.list();

		return invoices;
	}

	public String createInvoice(Invoice invoice) {
		Session session = factory.openSession();
		invoice.setPaymentStatus("NOT PAID");
		// invoice.setAmountDue(0);
		session.save(invoice);
		session.beginTransaction().commit();
		return "{\"result\":\"OK\"}";
	}

	public List<Invoice> getInvoiceById(Long invoiceId) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Invoice.class);
		criteria.add(Restrictions.eq("invoiceId", invoiceId));
		return criteria.list();
	}

	public Invoice findById(Long invoiceId) {
        return entityManager.find(Invoice.class, invoiceId);
    }

    public Invoice save(Invoice invoice) {
        return entityManager.merge(invoice);
    }

	

}
