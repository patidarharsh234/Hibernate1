package com.rays.dtotest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;




public class TestGetCreatQueryAuthenticate {
	public static void main(String[] args) {
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		               
		          Session sess=sf.openSession();
		        Query q =sess.createQuery("from UserDTO where loginId=? and password=?" );
		             
		          q.setString(0,"sourabh@345");
		          
		          q.setString(1,"11223344");
		          
		         List list  =  q.list();
		          
		          
		       if( list.size() >0) {
		    	 UserDTO dto=  (UserDTO) list.get(0);
		    	 System.out.println(dto.getId());
		    	 System.out.println(dto.getFirstName());
		    	 System.out.println(dto.getLastName());
		    	 System.out.println(dto.getLoginId());
		    	 System.out.println(dto.getPassword());
		       }else {
		    	   
		    	   System.out.println("invalidate email id or password..!!!");
		       }
		       sess.close();
		
	}

}
