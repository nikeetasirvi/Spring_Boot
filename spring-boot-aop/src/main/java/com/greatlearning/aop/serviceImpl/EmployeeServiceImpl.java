package com.greatlearning.aop.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.aop.entity.Employee;
import com.greatlearning.aop.repository.EmployeeRepository;
import com.greatlearning.aop.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.saveAndFlush(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		boolean exist = employeeRepository.existsById(employee.getId());
		if(exist) {
			employeeRepository.saveAndFlush(employee);
		} else {
			throw new RuntimeException("There is no employee with id " + employee.getId());
		}
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}
	
	@Override
	public void deleteEmployeeByid(int id) {
		employeeRepository.deleteById(id);
	}
}
