package com.greatlearning.aop.config;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.greatlearning.aop.entity.AuditLog;
import com.greatlearning.aop.entity.Employee;
import com.greatlearning.aop.repository.AuditRepository;
import com.greatlearning.aop.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Aspect
@Slf4j
public class AspectConfig {

	@Autowired
	AuditRepository auditRepository;
	
	@Autowired
	EmployeeService employeeService;
	
	//pointcut expression = accessModifier returnType packageName.className.methodName(..)
	
	@Before("execution(public * com.greatlearning.aop.serviceImpl.*.*(..))")
	public void logBeforeAllMethods(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature().getName() + " Started");
	}
	
	@After("execution(public * com.greatlearning.aop.serviceImpl.*.*(..))")
	public void logAfterAllMethods(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature().getName() + " Ended");
	}
	
	@Around("execution(public * com.greatlearning.aop.serviceImpl.*.*(..))")
	public void logAroundAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		log.info(proceedingJoinPoint.getSignature().getName() + " Started");
		proceedingJoinPoint.proceed();
		log.info(proceedingJoinPoint.getSignature().getName() + " Ended");
	}
	
	@AfterReturning("execution(public * com.greatlearning.aop.serviceImpl.EmployeeServiceImpl.addEmployee(..))")
	public void logBeforeAddEmployee(JoinPoint joinPoint) {
		auditRepository.saveAndFlush(AuditLog.builder().createDate(new Date()).Description("Added "+joinPoint.getArgs()[0]).build());
	}
	
	@AfterThrowing("execution(public * com.greatlearning.aop.serviceImpl.EmployeeServiceImpl.updateEmployee(..))")
	public void logIfErrorWhileUpdating(JoinPoint joinPoint) {
		Employee employee = (Employee) joinPoint.getArgs()[0];
		auditRepository.saveAndFlush(AuditLog.builder()
				.createDate(new Date())
				.Description("Error while Updating bcoz there is no employee with id"+employee.getId()).build());
	}
}
