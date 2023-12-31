package com.greatlearning.hibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	//bydefault fetchType is lazy
//	@ManyToMany
//	@JoinTable(
//			name = "COURSE_ENROLLED_BY_STUDENTS", 
//			joinColumns = @JoinColumn(name ="COURSE_ID"),
//			inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
//	private List<Student> students = new ArrayList<>();
	
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
}