package com.rays.update_mearge;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class Update_Mearge {
	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		   Session sess=  sf.openSession();
		    Transaction tx= sess.beginTransaction();
	UserDTO  current=(UserDTO) sess.get(UserDTO.class,1);
            //	sess.evict(current);//es point pr updat working-becouse data remove kar dega. 
	
	       UserDTO change=new UserDTO();
	       change.setId(1);
	       change.setFirstName("yash");
	       change.setLastName("patidar");
	       change.setLoginId("harsh@123");
	       change.setPassword("112233");
	       
	       
	       sess.merge(change);//update ki jagh ese run karenge to data update ho jayega.bina-evict ke.
	     //  sess.update(change);
           tx.commit();
           sess.close();
	
		       
	}

}
