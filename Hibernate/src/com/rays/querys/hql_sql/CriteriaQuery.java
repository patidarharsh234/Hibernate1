package com.rays.querys.hql_sql;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.rays.auction.Auction;
import com.rays.auction.Bid;
import com.rays.dto.UserDTO;

public class CriteriaQuery {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

//1-GET ALL PARTS-from-{CRITERIA}

		/*
		 * Criteria crit = session.createCriteria(UserDTO.class);
		 * 
		 * List<UserDTO> list = crit.list(); Iterator<UserDTO> it = list.iterator();
		 * while (it.hasNext()) { UserDTO dto = it.next();
		 * System.out.println(dto.getId()); System.out.println(dto.getFirstName());
		 * System.out.println(dto.getLastName()); System.out.println(dto.getLoginId());
		 * System.out.println(dto.getPassword()); }
		 */

//2-GET All(SELECTED COLUMS WITH THE HELP OF[PROJECTIONS.PROPERTY]) FROM-UserDTO={CRITERIA}	

		/*
		 * Criteria crit = session.createCriteria(UserDTO.class); ProjectionList p =
		 * Projections.projectionList(); p.add(Projections.property("id"));
		 * p.add(Projections.property("firstName")); crit.setProjection(p);
		 * 
		 * List list = crit.list(); Iterator it = list.iterator(); while (it.hasNext())
		 * { Object[] dto = (Object[]) it.next(); System.out.println(dto[0] + "  " +
		 * dto[1]);
		 * 
		 * }
		 */

//3-AGGREGATE FUNCTIONS=[ROWCOUNT()/COUNT("ID")/GROUPPROPERTY("firstName")] FROM-UserDTO={CRITERIA}		
// Other AGGREGATE
// FUNCTION=[PROJECTIONS.max///PROJECTIONS.min///PROJECTIONS.avg}

		/*
		 * Criteria crit = session.createCriteria(UserDTO.class); ProjectionList p =
		 * Projections.projectionList(); p.add(Projections.count("id"));
		 * p.add(Projections.rowCount());// rowcount means count(*)
		 * p.add(Projections.groupProperty("lastName"));// means Group by
		 * crit.setProjection(p);
		 * 
		 * List list = crit.list(); Iterator it = list.iterator(); while (it.hasNext())
		 * { Object[] dto = (Object[]) it.next(); System.out.println("id_COUNT=" +
		 * dto[0] + " |" + "name_COUNT_row=" + dto[1] + " |" + "NAME=" + dto[2]);
		 * 
		 * }
		 */

// 4-GET (RESTRICTION WITH LIKE-% AND eq-ID)
// firstName(COLUM_NAMES)-FROM-UserDTO={CRITERIA}
// (AND) Condition

		/*
		 * Criteria crit = session.createCriteria(UserDTO.class);
		 * crit.add(Restrictions.like("firstName", "k%"));
		 * crit.add(Restrictions.eq("id", 3));
		 * 
		 * 
		 * List<UserDTO> list = crit.list(); Iterator<UserDTO> it = list.iterator();
		 * while (it.hasNext()) { UserDTO dto = it.next();
		 * System.out.println(dto.getId()); System.out.println(dto.getFirstName());
		 * System.out.println(dto.getLastName()); System.out.println(dto.getLoginId());
		 * System.out.println(dto.getPassword()); }
		 */

// 5-GET (RESTRICTION WITH LIKE-% AND eq-ID) 
//SINGLE( OR )CONDITION

		/*
		 * Criteria crit = session.createCriteria(UserDTO.class);
		 * 
		 * 
		 * crit.add(Restrictions.or(Restrictions.like("firstName", "K%"),
		 * Restrictions.eq("id", 3)));
		 *
		 * 
		 * List<UserDTO> list = crit.list(); Iterator<UserDTO> it = list.iterator();
		 * while (it.hasNext()) { UserDTO dto = it.next();
		 * System.out.println(dto.getId()); System.out.println(dto.getFirstName());
		 * System.out.println(dto.getLastName()); System.out.println(dto.getLoginId());
		 * System.out.println(dto.getPassword()); }
		 */

//6-GET (RESTRICTION WITH LIKE-% AND eq-ID)		
//DOUBLE( OR )CONDITION ;

		/*
		 * Criteria crit = session.createCriteria(UserDTO.class);
		 * 
		 * 
		 * crit.add(Restrictions.or(Restrictions.eq("firstName", "komal"),
		 * Restrictions.or(Restrictions.like("firstName", "k%"), Restrictions.eq("id",
		 * 1))));
		 * 
		 * 
		 * List<UserDTO> list = crit.list(); Iterator<UserDTO> it = list.iterator();
		 * while (it.hasNext()) { UserDTO dto = it.next();
		 * System.out.println(dto.getId()); System.out.println(dto.getFirstName());
		 * System.out.println(dto.getLastName()); System.out.println(dto.getLoginId());
		 * System.out.println(dto.getPassword()); }
		 */

//7-GET (RESTRICTION WITH LIKE-% AND eq-ID)		
//DOUBLE (OR) CONDITION ke sath +(AND) CONDITION ;

		/*
		 * Criteria crit = session.createCriteria(UserDTO.class);
		 * 
		 * 
		 * 
		 * crit.add(Restrictions.eq("lastName", "patidar"));//one condition
		 * 
		 * crit.add(Restrictions.or(Restrictions.eq("firstName", "komal"), //scound
		 * condition OR CONDITON ke sath Restrictions.or(Restrictions.like("firstName",
		 * "k%"), Restrictions.eq("id", 1))));
		 * 
		 * 
		 * 
		 * List<UserDTO> list = crit.list(); Iterator<UserDTO> it = list.iterator();
		 * while (it.hasNext()) { UserDTO dto = it.next();
		 * System.out.println(dto.getId()); System.out.println(dto.getFirstName());
		 * System.out.println(dto.getLastName()); System.out.println(dto.getLoginId());
		 * System.out.println(dto.getPassword()); }
		 */

// 8- ORDER BY={CRITERIA}...
//others->
//	      1-GET MAX RECORDS=crit.setMaxResults(10);
//        2-GET FIRST FEW RECORD=crit.setFirstResult(11);
//		  3-CREATE ALIASES=crit.createAlias("UserDTO","P")

		/*
		 * Criteria crit = session.createCriteria(UserDTO.class);
		 * 
		 * crit.add(Restrictions.like("firstName", "y%"));
		 * crit.addOrder(Order.asc("firstName")); //
		 * crit.addOrder(Order.asc("lastName")); // crit.addOrder(Order.asc("id"));
		 * 
		 * 
		 * 
		 * List<UserDTO> list = crit.list(); Iterator<UserDTO> it = list.iterator();
		 * while (it.hasNext()) { UserDTO dto = it.next();
		 * System.out.println(dto.getId()); System.out.println(dto.getFirstName());
		 * System.out.println(dto.getLastName()); System.out.println(dto.getLoginId());
		 * System.out.println(dto.getPassword());
		 * 
		 * }
		 */

// 9-{CRITERIA}-Join

		Criteria crit = session.createCriteria(Auction.class);

		crit.setFetchMode("ITEME_ID", FetchMode.JOIN);
		crit.add(Restrictions.eq("id", 2L));

		List list = crit.list();
		Iterator it = list.iterator();

		Auction Aucti = (Auction) it.next();
		System.out.println(Aucti.getId() + " " + Aucti.getDescription());
		;

		Set s = Aucti.getBids();
		Iterator jointdata = s.iterator();
		
		while (jointdata.hasNext()) {

			Bid bid = (Bid) jointdata.next();

			System.out.println(bid.getId() + "  " + bid.getAmount() + "  " + bid.getTimeStamp());

		}

		session.close();
	}

}
