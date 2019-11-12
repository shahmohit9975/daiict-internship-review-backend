package com.daiict.controller;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.StudentDao;
import com.daiict.exceptionHandle.InvalidInputException;

@RestController
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@PostMapping(path = "/student", consumes = { "application/json" })
	public ResponseEntity<?> addStudent(@RequestBody String student) {
		Object obj = JSONValue.parse(student);
		JSONObject jsonObject = (JSONObject) obj;
		String student_id = (String) jsonObject.get("student_id");
		if (!student_id.endsWith("@daiict.ac.in")) {
			throw new InvalidInputException("Student email id must be ends with @daiict.ac.in");
		}
		long long_course_id = (long) jsonObject.get("course_id");
		int course_id = Integer.parseInt(String.valueOf(long_course_id));
		String msg = studentDao.addStudent(course_id, jsonObject.toString());
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);

	}
}
