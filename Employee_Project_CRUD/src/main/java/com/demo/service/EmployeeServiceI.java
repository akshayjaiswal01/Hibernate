package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeServiceI {

	boolean addNewEmployee();

	Employee findEmployeeById(int eid);

	boolean assignProjectsToEmployee(int eid);

	List<Employee> getAllEmployees();

	boolean deleteById(int eid);

	boolean updateSalById(int eid, double sal);

	void closeMySessionfactory();

}
