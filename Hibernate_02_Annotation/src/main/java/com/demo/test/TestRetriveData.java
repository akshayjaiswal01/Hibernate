package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;

public class TestRetriveData {

	public static void main(String[] args) 
	{
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		System.out.println("Before get");
		
		 //MyUser user = session.get(MyUser.class, 10);  
		
		MyUser user = session.load(MyUser.class, 10);  
		
		System.out.println("After get");
		
		
		tr.commit();
		
		System.out.println(user);
		
		session.close();
		sf.close();

	}

}
