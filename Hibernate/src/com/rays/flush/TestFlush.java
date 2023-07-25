package com.rays.flush;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.auction.Bid;
import com.rays.dto.UserDTO;

public class TestFlush {
	public static void main(String[] args) {
        
		UserDTO dto =new UserDTO();
		   dto.setId(6);
		   dto.setFirstName("anjali");
		   dto.setLastName("o meri anjali");
		   dto.setLoginId("anjali@gmail.com");
		   dto.setPassword("password");
		   


		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(dto);
		
	//	sess.flush();
		
		System.out.println(dto.getId());//bina flush ke id  dto.setId(4) yhi se leleta he 
		tx.commit();
		sess.close();
		

	}
	//bina flush ke id print--->>bina flush ke id  dto.setId(4) yhi se leleta he 
/*	 *4
     * Hibernate: insert into USERDTO (FIRSTNAME, LASTNAME, LOGINID, PASSWORD, ID) values (?, ?, ?, ?, ?)
*/  
	
	//flush force fully data commit kar deata he---->>>>data commit karvane ka work karta he
	//flush condition me data database le kr aata he or print karvata
	
/*   *Hibernate: insert into USERDTO (FIRSTNAME, LASTNAME, LOGINID, PASSWORD, ID) values (?, ?, ?, ?, ?)
	 *5                 */
	
}
