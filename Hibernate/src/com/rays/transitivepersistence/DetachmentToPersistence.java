package com.rays.transitivepersistence;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.auction.Auction;

public class DetachmentToPersistence {

	public static void main(String[] args) {

		// persistence State
		SessionFactory sf = new Configuration().configure().buildSessionFactory();// start persistence state
		Session sess1 = sf.openSession();

		Transaction tx1 = sess1.beginTransaction();

		Auction item = (Auction) sess1.get(Auction.class, 1L);

		sess1.close();// Detachment State

		item.setDescription("Auction update-Det.TO.Pers");

		Session sess2 = sf.openSession();// Detachment se Persistence State
		Transaction tx2 = sess2.beginTransaction();

		sess2.update(item);

		tx2.commit();
		sess2.close();

	}
}
