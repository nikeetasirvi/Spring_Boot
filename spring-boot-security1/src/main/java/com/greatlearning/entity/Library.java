package com.greatlearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="library")
public class Library {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false)
	private long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="books", nullable = false)
	private String books;

	public Library() {}
	
	public Library(String name, String books) {
		this.name = name;
		this.books = books;
	}
	
}
