package com.rays.get_load;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class Test_Get_load {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();

		//UserDTO items = (UserDTO) sess.get(UserDTO.class, 4);//Sout-null print ho ra
		UserDTO items = (UserDTO) sess.load(UserDTO.class, 4);//objectNoteFoundExceptio
		System.out.println(items);
		sess.close();

	}

}