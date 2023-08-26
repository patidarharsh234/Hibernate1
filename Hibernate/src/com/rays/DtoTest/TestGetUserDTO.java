package com.rays.dtotest;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class TestGetUserDTO {
	public static void main(String[] args) {
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		       Session sess =sf.openSession();
		               UserDTO obj=   (UserDTO) sess.get(UserDTO.class,3);
		                System.out.println(obj.getId());
		                System.out.println(obj.getFirstName());
		                System.out.println(obj.getLastName());
		                System.out.println(obj.getLoginId());
		                System.out.println(obj.getPassword());
		                sess.close();
		
		
		
		
	}

}
