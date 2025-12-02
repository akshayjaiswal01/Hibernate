package com.demo.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Cart;
import com.demo.beans.Items;

public class TestInsertData {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Items i1 = new Items(101, "table", 5000);
		Items i2 = new Items(102, "chair", 3000);
		Items i3 = new Items(103, "sofa", 50000);
		Items i4 = new Items(104, "laptop", 100000);
		Items i5 = new Items(105, "phone", 50000);
		Items i6 = new Items(106, "refrigerator", 45000);
		
		List<Items> ilist1 = new ArrayList<>();
		ilist1.add(i1);
		ilist1.add(i2);
		ilist1.add(i3);
		ilist1.add(i4);
		
		List<Items> ilist2 = new ArrayList<>();
		ilist2.add(i5);
		ilist2.add(i6);
		ilist2.add(i3);
		ilist2.add(i4);
		
		Cart c1 = new Cart("Jay", ilist1);
		Cart c2 = new Cart("Akshay", ilist2);
		
//		List<Cart> clist1 = new ArrayList<>();
//		clist1.add(c1);
//		
//		List<Cart> clist2 = new ArrayList<>();
//		clist2.add(c2);
		
		i1.setCarts(List.of(c1));
		i2.setCarts(List.of(c1));
		i3.setCarts(List.of(c1, c2));
		i4.setCarts(List.of(c1, c2));
		i5.setCarts(List.of(c2));
		i6.setCarts(List.of(c2));
		
		
		session.save(c1);
		session.save(c2);
		
		tr.commit();
		session.close();
		sf.close();
		
		
		
		

	}

}
