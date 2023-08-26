package com.rays.cache;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class Cache_FirstLevelEnable {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session seson = sf.openSession();

		Transaction tx = seson.beginTransaction();

		UserDTO dto1 = (UserDTO) seson.get(UserDTO.class, 1);
		System.out.println(dto1.getId());
		System.out.println(dto1.getFirstName());
		System.out.println(dto1.getLastName());
		System.out.println(dto1.getLoginId());
		System.out.println(dto1.getPassword());

	  //	seson.evict(dto1);
		
		/*
			 * eska use karne se firstLevel_Cache_Fale_ho jata he,yha data remove kr deta
			 * he/then two times query fire karna padti
	   */	
		
		Session seson2 = sf.openSession();
		
		UserDTO dto2 = (UserDTO) seson.get(UserDTO.class, 1);
		System.out.println(dto2.getId());
		System.out.println(dto2.getFirstName());
		System.out.println(dto2.getLastName());
		System.out.println(dto2.getLoginId());
		System.out.println(dto2.getPassword());
		
		tx.commit();
		seson.close();
		

	}

}
