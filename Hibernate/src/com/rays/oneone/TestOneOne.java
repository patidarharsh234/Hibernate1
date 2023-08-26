package com.rays.oneone;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestOneOne {

	public static void main(String[] args) {

		Address address = new Address();
		address.setId(1);
		address.setCity("indore");
		address.setState("mp");

		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("HARSH");
		emp.setLastName("PATIDAR");
		emp.setEmpAddress(address);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();

		sess.save(emp);
		tx.commit();
		sess.close();

	}

}
