package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.User;

public class TestInsertdata {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Address addr = new Address(1, "S.B.Road", "pune", "425011"); 
		
		User user1 = new User(101, "Jay", "j@gmail.com", addr);
		
		session.save(user1);
		
		tr.commit();
		
		session.close();
		sf.close();

	}

}
