package com.greatlearning.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.model.Employee;
import com.greatlearning.service.EmployeeService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@GetMapping
	public List<Employee> findAllEmployees() {
		return employeeService.fetchAll();
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployeeById(@PathVariable("id") long id,@RequestBody Employee employee) {
		return employeeService.updateById(id,employee);
	}
	
	@GetMapping("/name/{name}")
	public Set<Employee> findEmployeeByName(@PathVariable("name") String name) {
		return employeeService.fetchEmployeeByName(name);
	}

	@GetMapping("/age/{age}")
	public Set<Employee> findEmployeeByAgeGTE(@PathVariable("age") int age) {
		return employeeService.fetchEmployeeByAgeGTE(age);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable("id") long id) {
		return employeeService.deleteById(id);
	}
	
	@GetMapping("/{id}")
	@ApiResponses({
		@ApiResponse(
				description = "Fetches the employee with the id passed",
				responseCode = "200"),
		@ApiResponse(
				description = "You are not authenticated user",
				responseCode = "401"),
		@ApiResponse(
				description = "You are not authorized user",
				responseCode = "403")
	})
	public Employee findEmployeeById(@PathVariable("id") long id) {
		return employeeService.findById(id);
	}

}
