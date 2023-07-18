package com.greatlearning.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.EmployeeRepository;
import com.greatlearning.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee findById(long id) {
		return this.employeeRepository.findById(id).get();
	}

	@Override
	public String deleteById(long id) {
		this.employeeRepository.deleteById(id);
		return "Deleted by id";
	}

	@Override
	public Set<Employee> fetchEmployeeByName(String name) {
		return this.employeeRepository.findByNameLike(name);
	}

	@Override
	public Set<Employee> fetchEmployeeByAgeGTE(int age) {
		return this.employeeRepository.findByAgeGreaterThanEqual(age);
	}

	@Override
	public Employee updateById(long id,Employee emp) {
		Employee employee = this.employeeRepository.findById(id).get();
		employee = emp;
		employeeRepository.save(employee);
		return employee;
	}
}
