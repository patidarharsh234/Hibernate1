package com.rays.dirtycheak;

import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.auction.Auction;

public class DirtyCheak {
	
	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
	Session sess=	sf.openSession();
	
	  Transaction tx=   sess.beginTransaction();
	    Auction item =  (Auction) sess.get(Auction.class, 1L);
	    item.setDescription("xyz");
	    tx.commit();
	    sess.close();
	     
	
	}

}
