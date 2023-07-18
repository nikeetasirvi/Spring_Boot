package com.greatlearning.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.aop.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
