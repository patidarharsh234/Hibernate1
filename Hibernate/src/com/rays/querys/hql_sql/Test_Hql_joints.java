package com.rays.querys.hql_sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.oneone.Address;
import com.rays.oneone.Employee;

public class Test_Hql_joints {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		 Query query = session.createQuery("E.id,E.firstName,E.lastName,A.city from Employee E ,Address A where A.Addressid=E.id");
		 

			List list = query.list();

			Iterator it = list.iterator();

			while (it.hasNext()) {
				Employee e= new Employee();
				System.out.println(e.getId());
				System.out.println(e.getFirstName());
				System.out.println(e.getLastName());
				
			}
		
		session.close();
		
		
		
	}

}
