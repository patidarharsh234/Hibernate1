package com.rays.namedqueries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestNamedQueries {
	public static void main(String[] args) {

		/*
		 * NamedQueries nq = new NamedQueries(); nq.setFirstName("harsh");
		 * nq.setLastName("patidar");
		 * 
		 * SessionFactory sessionFactory = new
		 * Configuration().configure().buildSessionFactory(); Session session =
		 * sessionFactory.openSession();
		 * 
		 * Transaction tx = session.beginTransaction(); session.save(nq); tx.commit();
		 * session.close();
		 */

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query q = session.getNamedQuery("alluser");

		List<NamedQueries> list = q.list();
		Iterator it = list.iterator();

		while (it.hasNext()) {
			NamedQueries nq = (NamedQueries) it.next();
			System.out.println(nq.getId());
			System.out.println(nq.getFirstName());
			System.out.println(nq.getLastName());

		}

	}

}
