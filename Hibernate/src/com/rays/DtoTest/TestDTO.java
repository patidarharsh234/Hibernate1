package com.rays.dtotest;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class TestDTO {
	public static void main(String[] args) {
		
		UserDTO dto= new UserDTO();
		dto.setId(2);
		
		 dto.setFirstName("sourabh");
		 dto.setLastName("anjali");
		 dto.setLoginId("jate@345");
		 dto.setPassword("11223344");
		 
		
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
	      Session session=	sessionFactory.openSession();
		 
		Transaction tx= session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
		
		
	}

}
