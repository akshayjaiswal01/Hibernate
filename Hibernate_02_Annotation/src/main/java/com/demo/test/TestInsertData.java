package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;
import com.demo.beans.Product;

public class TestInsertData 
{
	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		MyUser user1 = new MyUser(101, "Jay", "jay@gmail.com");
		MyUser user2 = new MyUser(102, "Akshay", "akshay@gmail.com");
		
		Product p1 = new Product(1, "Table", 15, 5000);
		Product p2 = new Product(2, "Chair", 10, 6000);
		
		session.save(user1);
		session.save(user2);
		session.save(p1);
		session.save(p2);
		
		tr.commit();
		
		session.close();
		sf.close();
		
		
	}
}
