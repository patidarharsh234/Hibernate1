package com.rays.cache;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
 
import com.rays.dto.UserDTO;



public class Cache_SecoundLevelEnable {
public static void main(String[] args) {
	

	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	Session seson = sf.openSession();

	Transaction tx = seson.beginTransaction();

	UserDTO dto1 = (UserDTO) seson.get(UserDTO.class, 2);
	System.out.println(dto1.getId());
	System.out.println(dto1.getFirstName());
	System.out.println(dto1.getLastName());
	System.out.println(dto1.getLoginId());
	System.out.println(dto1.getPassword());

	seson.evict(dto1); //->clear only one particular object from the session
	//seson.clear(); //->clear all data from the session
	
	
		/*
		 * secound Level Cache enable karne par evict method use karne par bhi yh
		 * session ke secound object se data le aaye ga and two times query fire nahi
		 * karega.
		 */ 	
	
	Session seson2 = sf.openSession();
	
	UserDTO dto2 = (UserDTO) seson.get(UserDTO.class, 2);
	System.out.println(dto2.getId());
	System.out.println(dto2.getFirstName());
	System.out.println(dto2.getLastName());
	System.out.println(dto2.getLoginId());
	System.out.println(dto2.getPassword());
	
	tx.commit();
	seson.close();
}
}
