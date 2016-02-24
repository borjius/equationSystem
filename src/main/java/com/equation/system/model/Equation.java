package com.equation.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String author;
	private String description;
	
	
	
	public Equation() {
		
	}

	public Equation(String author, String description) {
		super();
		this.author = author;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}
	
	

}
