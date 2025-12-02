package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.beans.Project;
import com.demo.service.EmployeeServiceI;
import com.demo.service.EmployeeServiceImpl;
import com.demo.service.ProjectServiceI;
import com.demo.service.ProjectServiceImpl;

public class TestCRUD {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		ProjectServiceI pservice = new ProjectServiceImpl();
		EmployeeServiceI eservice = new EmployeeServiceImpl();
		
		int choice = 0;
		
		do 
		{
			System.out.println("1. Add project");
			System.out.println("2. Add Employees");
			System.out.println("3. Find Project by ID");
			System.out.println("4. Find Employee by ID");
			System.out.println("5. Assign Project to Employee");
		    System.out.println("6. show all employees");
		    System.out.println("7. delete employee");
			System.out.println("8. update Employees salary");
		    System.out.println("9. exit");
		    
		    System.out.println("Enter your choice: ");
		    choice = sc.nextInt();
		    
		    switch(choice)
		    {
		    	case 1 ->
		    	{
		    		boolean status = pservice.addNewProject();
		    		if(status)
		    		{
		    			System.out.println("Project added successsfully");
		    		}
		    		else
		    		{
		    			System.out.println("Failed to add");
		    		}
		    	}
		    	
		    	case 2->
		    	{
		    		boolean status = eservice.addNewEmployee();
		    		if(status)
		    		{
		    			System.out.println("Employee added successsfully");
		    		}
		    		else
		    		{
		    			System.out.println("Failed to add");
		    		}
		    	}
		    	
		    	case 3 ->
		    	{
		    		System.out.println("Enter Project ID: ");
		    		int pid = sc.nextInt();
		    		
		    		Project p = pservice.findProjectById(pid);
		    		System.out.println(p);
		    	}
		    	
		    	case 4 ->
		    	{
		    		System.out.println("Enter Employee ID: ");
		    		int eid = sc.nextInt();
		    		
		    		Employee e = eservice.findEmployeeById(eid);
		    		System.out.println(e);
		    	}
		    	
		    	case 5 ->
		    	{
		    		System.out.println("Enter Employee ID: ");
		    		int eid = sc.nextInt();
		    		
		    		boolean status = eservice.assignProjectsToEmployee(eid);
		    		if(status)
		    		{
		    			System.out.println("Project assign successsfully");
		    		}
		    		else
		    		{
		    			System.out.println("Failed to assign");
		    		}
		    		
		    	}
		    	case 6->
		    	{
		    		List<Employee> elist = eservice.getAllEmployees();
		    		elist.stream().forEach(System.out::println);
		    	}
		    	
		    	case 7 ->
		    	{
		    		System.out.println("Enter Employee ID: ");
		    		int eid = sc.nextInt();
		    		
		    		boolean status = eservice.deleteById(eid);
		    		if(status)
		    		{
		    			System.out.println("Employee deleted successsfully");
		    		}
		    		else
		    		{
		    			System.out.println("Failed to delete");
		    		}
		    	}
		    	case 8 ->
		    	{
		    		System.out.println("Enter Employee ID: ");
		    		int eid = sc.nextInt();
		    		
		    		System.out.println("Enter New Salary: ");
		    		double sal = sc.nextDouble();
		    		
		    		boolean status = eservice.updateSalById(eid, sal);
		    		if(status)
		    		{
		    			System.out.println("Employee Salary updated successsfully");
		    		}
		    		else
		    		{
		    			System.out.println("Failed to update");
		    		}
		    	}
		    	
		    	case 9 ->
		    	{
		    		sc.close();
		    		eservice.closeMySessionfactory();
		    	}
		    }
		    		
		}
		while(choice != 9);

	}

}
