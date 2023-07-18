package com.greatlearning.library.serviceimpl;

import org.springframework.stereotype.Service;

import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceimpl implements ExampleService {
	
	@Override
	public GreatLearning get() {
		log.info("inside get() method");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("Learn controllers in spring boot");
		greatLearning.setCourseType("Information Technology");
		greatLearning.setInstructorName(FullName.builder().firstName("Nikeeta").lastName("Sirvi").build());
		return greatLearning;
	}

	@Override
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		log.info("inside customInfo() method");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName(courseName);
		greatLearning.setCourseType(courseType);
		greatLearning.setInstructorName(FullName.builder().firstName(firstName).lastName(lastName).build());
		return greatLearning;
	}
}
