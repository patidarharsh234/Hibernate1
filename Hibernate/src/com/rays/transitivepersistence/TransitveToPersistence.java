package com.rays.transitivepersistence;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.auction.Auction;
import com.rays.auction.Bid;

public class TransitveToPersistence {

	public static void main(String[] args) {
		Bid bid1 = new Bid();// yha se open transitve statment
		bid1.setId(5);
		bid1.setAmount(2000);
		bid1.setTimeStamp("xyz");// yha tak transitve statment

		SessionFactory sf = new Configuration().configure().buildSessionFactory();// start persistence state
		
		
		Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();

		Auction item = (Auction) sess.get(Auction.class, 1L);

		Set s = item.getBids();
     //bina hibernate ki medthods call kiye bager data add ho ra
		s.add(bid1);// close persistence state
		tx.commit();// start deteachment statment
		sess.close();// close deteachment statment

	}

}
