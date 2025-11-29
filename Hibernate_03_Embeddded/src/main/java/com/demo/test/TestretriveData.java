package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.User;

public class TestretriveData {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		System.out.println("Before get");
		//User user = session.get(User.class, 15);
		
		User user = session.load(User.class, 15);
		
		System.out.println("Aftyer get");
		
		tr.commit();
		System.out.println(user);
		
		session.close();
		sf.close();

	}

}
