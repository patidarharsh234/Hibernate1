package com.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestAuction {
	public static void main(String[] args) {

		Bid bid1 = new Bid();

		bid1.setId(1);
		bid1.setAmount(200);
		bid1.setTimeStamp("x");

		Bid bid2 = new Bid();

		bid2.setId(2);
		bid2.setAmount(2000);
		bid2.setTimeStamp("xx");

		Bid bid3 = new Bid();

		bid3.setId(3);
		bid3.setAmount(2000);
		bid3.setTimeStamp("xxx");

		Set bids = new HashSet();

		bids.add(bid1);
		bids.add(bid2);
		bids.add(bid3);

		Auction item = new Auction();

		item.setId(1);
		item.setDescription("description");
		item.setBids(bids);
		

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();

		Transaction tx = sess.beginTransaction();
		sess.save(item);
		tx.commit();

		sess.close();

	}

}
