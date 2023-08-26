package com.rays.querys.hql_sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class AggregateFunction_Count {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

//1-HQL- ONLY ONE DIGIT COME TOTAL COUNT OF ROW-BY{AGGREGATE FUNTION(COUNT(*)}

		/*
		 * Query q = session.createQuery("select count(*)from UserDTO");
		 * 
		 * List count = q.list();
		 * 
		 * Object val = (Object) count.get(0); System.out.println(val);
		 */

//2-HQL-GROUP BY-firstNAME-BY {AGGREGATE FUNTION(COUNT(*)}	

		/*
		 * Query q = session.
		 * createQuery("select firstName, count(*)from UserDTO GROUP By firstName");
		 * 
		 * // Query q = session.createQuery("select p.firstName, count(*)from UserDTO p
		 * // GROUP By p.firstName");
		 * 
		 * List count = q.list(); Iterator it = count.iterator();
		 * 
		 * while (it.hasNext()) { Object[] dto = (Object[]) it.next();
		 * System.out.println(dto[0]+"  "+"nameCount="+dto[1]);
		 * 
		 * }
		 */

	}
}
