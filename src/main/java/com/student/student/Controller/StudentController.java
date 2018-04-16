package com.student.student.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.student.entity.EntityObject;
import com.student.student.entity.StudentDTO;

@RestController
public class StudentController {

	@RequestMapping(value = "/rest/parseList", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = "application/json")
	public ResponseEntity<List<StudentDTO>> postStudent(@RequestParam(value = "startRollNo") String startRollNo,
			@RequestParam(value = "endRollNo") String endRollNo, @RequestBody EntityObject studentObject) {

		List<StudentDTO> list = new ArrayList<StudentDTO>();

		Integer startIndex = getIndex(startRollNo);
		Integer endIndex = getIndex(endRollNo);
		prepareListOfEligibleStudents(studentObject, list, startIndex, endIndex);

		return new ResponseEntity<List<StudentDTO>>(list, HttpStatus.OK);

	}

	private Integer getIndex(String rollNo) {

		return Integer.valueOf(rollNo.substring(1));

	}

	private void prepareListOfEligibleStudents(EntityObject studentObject, List<StudentDTO> list, Integer startIndex,
			Integer endIndex) {
		
		for (StudentDTO studentDTO : studentObject.getStudents().getStudentList()) {
			int roll = Integer.valueOf(studentDTO.getRollNo().substring(1));

			if (roll >= startIndex && roll <= endIndex) {
				list.add(studentDTO);
			}
		}
	}
}
