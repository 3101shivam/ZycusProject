package com.student.student.Controller;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Students implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	/**
	 * 
	 */
	
	List<StudentDTO> studentList ;

	@JsonProperty(value="student")
	public List<StudentDTO> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(List<StudentDTO> studentList) {
		this.studentList = studentList;
	}
}
