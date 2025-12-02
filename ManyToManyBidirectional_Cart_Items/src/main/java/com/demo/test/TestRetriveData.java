package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Cart;
import com.demo.beans.Items;

public class TestRetriveData {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Cart c = session.get(Cart.class, 53);
		System.out.println(c);
		
		
		Items i = session.get(Items.class, 103);
		System.out.println(i);
		System.out.println(i.getCarts());
		
		
		tr.commit();
		session.close();
		sf.close();

	}

}
