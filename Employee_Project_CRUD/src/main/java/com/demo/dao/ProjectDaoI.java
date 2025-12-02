package com.demo.dao;

import java.util.Set;

import com.demo.beans.Employee;
import com.demo.beans.Project;

public interface ProjectDaoI {

	boolean save(Project p);

	Project findProjectById(int pid);

	

}
