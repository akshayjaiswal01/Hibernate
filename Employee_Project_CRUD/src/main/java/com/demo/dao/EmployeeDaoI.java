package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDaoI 
{

	boolean save(Employee e);

	Employee findEmployeeById(int eid);

	boolean merge(Employee emp);

	List<Employee> findAllEmployees();

	boolean deleteById(int eid);

	boolean updateSalById(int eid, double sal);

	void closeMySessionfactory();

}
