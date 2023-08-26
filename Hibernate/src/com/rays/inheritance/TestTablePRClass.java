package com.rays.inheritance;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestTablePRClass {
	public static void main(String[] args) {

		CreditCardPayment crd = new CreditCardPayment();
		crd.setAmount(2000);
		crd.setCcType("Hdfc");
		crd.setPaymentType("by card");

		Cheque cheq = new Cheque();
		cheq.setAmount(3000);
		cheq.setBankName("Sbi");
		cheq.setChqNumber("66856790");
		cheq.setPaymentType("CHEQUE");

		Cash cash = new Cash();
		cash.setAmount(5000);
		cash.setPaymentType("CASH");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(crd);
		session.save(cheq);
		session.save(cash);
		tx.commit();
		session.close();
	}
}
