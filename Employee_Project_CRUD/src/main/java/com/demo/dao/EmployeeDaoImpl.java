package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDaoI 
{
	static SessionFactory sf = null;
	
	static 
	{
		sf = HibernateUtil.getMySessionFactory();
	}
	
	@Override
	public boolean save(Employee e) 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.saveOrUpdate(e);
		tr.commit();
		session.close();
		return true;
	}

	@Override
	public Employee findEmployeeById(int eid) 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Employee e = session.get(Employee.class, eid); 
		
		tr.commit();
		session.close();
		return e;
	}

	@Override
	public boolean merge(Employee emp) 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.merge(emp);
		
		tr.commit();
		session.close();
		
		return true;
	}

	@Override
	public List<Employee> findAllEmployees() 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		List<Employee> elist = session.createQuery("from Employee",Employee.class).list();
		
		tr.commit();
		session.close();
		
		return elist;
	}

	
	@Override
	public boolean deleteById(int eid) 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		boolean flag = false;
		Employee emp = session.get(Employee.class, eid);
		if(emp != null)
		{
			session.delete(emp);
			flag = true;
		}
		tr.commit();
		session.close();
		return flag;
	}

	@Override
	public boolean updateSalById(int eid, double sal) 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Employee emp = session.get(Employee.class, eid);
		
		if(emp == null)
		{
			return false;
		}
		
		emp.setSal(sal);
		
		session.update(emp);
		
		tr.commit();
		session.close();
		
		return true;
	}

	@Override
	public void closeMySessionfactory() 
	{
		HibernateUtil.closeMySessionFactory();
		
	}

}
