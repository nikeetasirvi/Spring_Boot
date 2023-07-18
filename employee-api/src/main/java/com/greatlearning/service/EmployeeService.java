package com.greatlearning.service;

import java.util.List;
import java.util.Set;

import com.greatlearning.model.Employee;

public interface EmployeeService {
	
	Employee save(Employee employee);
	List<Employee> fetchAll();
	Employee findById(long id);
	String deleteById(long id);
	Set<Employee> fetchEmployeeByName(String name);
	Set<Employee> fetchEmployeeByAgeGTE(int age);
	Employee updateById(long id,Employee employee);
}
