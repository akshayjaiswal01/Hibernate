package com.demo.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Employee;
import com.demo.beans.Project;

public class ProjectDaoImpl implements ProjectDaoI 
{
	static SessionFactory sf = null;
	
	static
	{
		sf = HibernateUtil.getMySessionFactory();
	}
	
	@Override
	public boolean save(Project p) 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.save(p);
		
		tr.commit();
		session.close();
		return true;
	}

	@Override
	public Project findProjectById(int pid) 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Project p = session.get(Project.class, pid);
		
		
		
		return p;
	}

	

	
	
}
