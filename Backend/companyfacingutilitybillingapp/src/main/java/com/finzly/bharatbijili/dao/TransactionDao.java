package com.finzly.bharatbijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.bharatbijili.entity.Invoice;
import com.finzly.bharatbijili.entity.Transaction;

@Repository
public class TransactionDao {
	@Autowired
	SessionFactory factory;

	public String addTransaction(Transaction transaction) {
		try {
			Session session = factory.openSession();

			session.save(transaction);
			session.beginTransaction().commit();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Transaction successsfully added";
	}

	public List<Transaction> getAllTransaction() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		return criteria.list();
	}

	public List<Transaction> getTransactionByInvoiceId(Long invoiceId) {
		System.out.println(invoiceId);
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Transaction.class);
		criteria.createAlias("invoice", "i");
		criteria.add(Restrictions.eq("i.invoiceId", invoiceId));

		List<Transaction> transaction = criteria.list();

		return transaction;
	}

}
