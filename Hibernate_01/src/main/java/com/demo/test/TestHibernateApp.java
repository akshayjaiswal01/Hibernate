package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;
import com.demo.beans.Product;



public class TestHibernateApp {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		
		MyUser user1 = new MyUser(1, "Jay", "jay@gmail.com");
		MyUser user2 = new MyUser(2, "Abhi", "abhi@gmail.com");
		
		Product p1 = new Product(1, "table", 20, 4000);
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.save(user1);
		session.save(p1);
		
		tr.commit();
		
		session.close();
		sf.close();

	}

}
