package com.rays.dtotest;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class TestGeatOllDataCreateQuery {
	
	public static void main(String[] args) {
		
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		                Session sess=     factory.openSession() ;   
		                
		            Query q=    sess.createQuery("from UserDTO");
		            
		            
		                
	                       List list= q.list();
	                        Iterator it= list.iterator();
	                        
	                        while(it.hasNext()) {
	                        UserDTO dto=(UserDTO) it.next();
	                        System.out.println(dto.getId());
	                        System.out.println(dto.getFirstName());
	                        System.out.println(dto.getLastName());
	                        System.out.println(dto.getLoginId());
	                        System.out.println(dto.getPassword());
	                        }
	                        
	                        sess.close();
	}                           

}
