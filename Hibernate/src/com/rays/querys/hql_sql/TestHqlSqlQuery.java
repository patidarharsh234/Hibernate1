package com.rays.querys.hql_sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class TestHqlSqlQuery {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();
		//Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("select*from userdto");

		List list= query.list();
		Iterator it= list.iterator();
		
		
		while(it.hasNext()) {
			Object[] dto=(Object[])it.next();
			System.out.println(dto[0]);
			System.out.println(dto[1]);
			System.out.println(dto[2]);
			System.out.println(dto[3]);
			System.out.println(dto[4]);
		}
		
		
		
			        
			
			
			

	

		

	}

}
