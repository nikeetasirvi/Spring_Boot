package com.greatlearning.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	
//	@OneToOne
//	private Passport passport;
		
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;

	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + "]";
//	}

	//when we were using lazy then the above string cannot work because we dont get password in it so the below toString is used with lazy
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
}