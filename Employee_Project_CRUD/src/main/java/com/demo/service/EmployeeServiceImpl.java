package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.beans.Project;
import com.demo.dao.EmployeeDaoI;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.dao.ProjectDaoI;
import com.demo.dao.ProjectDaoImpl;

public class EmployeeServiceImpl implements EmployeeServiceI 
{
	private EmployeeDaoI edao;
	private ProjectDaoI pdao;
	
	public EmployeeServiceImpl()
	{
		edao = new EmployeeDaoImpl();
		pdao = new ProjectDaoImpl();
	}

	@Override
	public boolean addNewEmployee() 
	{
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Enter Employee ID: ");
//		int eid = sc.nextInt();
//		
//		sc.nextLine();
		System.out.println("Enter Employee Name: ");
		String ename = sc.nextLine();
		
		System.out.println("Enter Hiredate: ");
		String hiredate = sc.next();
		LocalDate ldt = LocalDate.parse(hiredate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println("Enter Salary: ");
		double sal = sc.nextDouble();
		
		Employee e = new Employee(ename, ldt, sal);
		
		return edao.save(e);
		
	}

	@Override
	public Employee findEmployeeById(int eid) {
		// TODO Auto-generated method stub
		return edao.findEmployeeById(eid);
	}

	@Override
	public boolean assignProjectsToEmployee(int eid) 
	{
		Scanner sc = new Scanner(System.in);
		
		Employee emp = edao.findEmployeeById(eid);
		if(emp == null)
		{
			return false;
		}
		
		if(emp.getPset() == null)
		{
			emp.setPset(new HashSet<>());
		}
		
		
			System.out.println("Employee ID : "+eid);
			System.out.println("Enter Project ID to assign: ");
			int pid = sc.nextInt();
			
			Project project = pdao.findProjectById(pid);
			
			if(project != null) 
			{
				emp.getPset().add(project);
				
				if(project.getEset() == null)
				{
					project.setEset(new HashSet<>());
				}
				project.getEset().add(emp);
				
			}
			else
			{
				System.out.println("Project not found with ID: "+pid);
			}
			
		
		
		return edao.merge(emp);
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		
		return edao.findAllEmployees();
	}

	@Override
	public boolean deleteById(int eid) 
	{
		
		return edao.deleteById(eid);
	}

	@Override
	public boolean updateSalById(int eid, double sal) 
	{
		
		return edao.updateSalById(eid, sal);
	}

	@Override
	public void closeMySessionfactory() 
	{
		edao.closeMySessionfactory();
		
	}
}
