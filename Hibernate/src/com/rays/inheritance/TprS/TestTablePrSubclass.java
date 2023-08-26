package com.rays.inheritance.TprS;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestTablePrSubclass {
	public static void main(String[] args) {

		CreditCardPayment crd = new CreditCardPayment();
		crd.setAmount(1000);
		crd.setCcType("icici");
		crd.setPaymentType("by card");

		Cheque cheq = new Cheque();
		cheq.setAmount(2000);
		cheq.setBankName("Sbi");
		cheq.setChqNumber("66856790");
		cheq.setPaymentType("CHEQUE");

		Cash cash = new Cash();
		cash.setAmount(10000);
		cash.setPaymentType("CASH");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(crd);
		session.save(cheq);
		session.save(cash);
		tx.commit();
		session.close();

	}
}
