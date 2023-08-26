package com.rays.querys.hql_sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class TestLike_Sql_HqlQuery {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		// Query query = session.createQuery(" from UserDTO where firstName like 'y%'");
		Query query = session.createSQLQuery("select * from userdto where firstName like 'y%'");

		List list = query.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			/*
			 * UserDTO dto=(UserDTO)it.next(); System.out.println(dto.getId());
			 * System.out.println(dto.getFirstName());
			 * System.out.println(dto.getLastName()); System.out.println(dto.getLoginId());
			 * System.out.println(dto.getPassword());
			 */

			Object[] dto = (Object[]) it.next();
			System.out.println(dto[0]);
			System.out.println(dto[1]);
			System.out.println(dto[2]);
			System.out.println(dto[3]);
			System.out.println(dto[4]);

		}

	}

}
