package com.rays.cache;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;


public class Cache_QueryCach {

	public static void main(String[] args) {
		
		

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session seson = sf.openSession();

		Query q1 = seson.createQuery("from UserDTO where id=1");
		q1.setCacheable(true);
		List<UserDTO> list1 = q1.list();
		Iterator<UserDTO> it1 = list1.iterator();
           
		while(it1.hasNext()) {
			
		UserDTO dto=it1.next();
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		}
	
		Query q2=seson.createQuery("from UserDTO where id=1");
		q2.setCacheable(true);
		
		List<UserDTO> list2 = q2.list();
		Iterator<UserDTO> it2 = list2.iterator();
           
		while(it2.hasNext()) {
			
		UserDTO dto1=it2.next();
		System.out.println(dto1.getId());
		System.out.println(dto1.getFirstName());
		System.out.println(dto1.getLastName());
		}
		
		seson.close();
		}
	}

