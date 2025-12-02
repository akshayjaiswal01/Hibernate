package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.demo.beans.Employee;
import com.demo.beans.Project;
import com.demo.dao.EmployeeDaoI;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.dao.ProjectDaoI;
import com.demo.dao.ProjectDaoImpl;

public class ProjectServiceImpl implements ProjectServiceI 
{
	private ProjectDaoI pdao;
	private EmployeeDaoI edao;
	
	public ProjectServiceImpl()
	{
		pdao = new ProjectDaoImpl();
		edao = new EmployeeDaoImpl();
	}
	
	@Override
	public boolean addNewProject() 
	{
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Enter Project ID: ");
//		int pid = sc.nextInt();
//		
//		sc.nextLine();
		System.out.println("Enter Project Name: ");
		String pname = sc.nextLine();
		
		System.out.println("Enter Start Date (dd/mm/yyyy)");
		String date = sc.next();
		LocalDate ldt = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Project p = new Project(pname, ldt);
		
		return pdao.save(p);
		
	}

	@Override
	public Project findProjectById(int pid) 
	{
		return pdao.findProjectById(pid);
	}

	

	

}
