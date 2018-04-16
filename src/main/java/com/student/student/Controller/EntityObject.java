package com.student.student.Controller;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class EntityObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	/**
	 * 
	 */
	
	Students students ;
	@JsonProperty(value="students")
	public Students getStudents() {
		return students;
	}
	public void setStudents(Students students) {
		this.students = students;
	}

	
	
	
	
}
