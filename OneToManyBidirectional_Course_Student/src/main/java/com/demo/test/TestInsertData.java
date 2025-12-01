package com.demo.test;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Student;

public class TestInsertData {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Course c1 = new Course(1001, "PG-DAC", "6 Months", "20/08/2025");
		Course c2 = new Course(1002, "DBDA", "6 months", "20/08/2025");
		
		Student s1 = new Student(1, "Akshay", 3000, c1);
		Student s2 = new Student(106, "Jay", 2500, c1);
		
		Student s3 = new Student(4, "Abhi", 3000, c2);
		Student s4 = new Student(10, "Amol", 2500, c2);
		
//		c1.setSlist(Arrays.asList(s1, s2));
//		c2.setSlist(Arrays.asList(s3, s4));
		
		List<Student> slist1 = new ArrayList<>();
		
		slist1.add(s1);
		slist1.add(s2);
		
		List<Student> slist2 = new ArrayList<>();
		
		slist2.add(s3);
		slist2.add(s4);
		
		c1.setSlist(slist1);
		c2.setSlist(slist2);
		
		session.save(c1);
		session.save(c2);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
		
		tr.commit();
		
	
		sf.close();
		

	}

}
