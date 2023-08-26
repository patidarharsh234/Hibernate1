package com.rays.querys.hql_sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class TestGetSomeColumns {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Query query = session.createQuery("select p.id,p.firstName,p.lastName from UserDTO p");

		// Query query = session.createSQLQuery("select p.id,p.firstName,p.lastName from
		// UserDTO p");

		List list = query.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			/*
			 * Object[] obj = (Object[]) it.next(); System.out.println(obj[0]);
			 * System.out.println(obj[1]); System.out.println(obj[2]);
			 */

			UserDTO dto = (UserDTO) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());

		}
	}

}
