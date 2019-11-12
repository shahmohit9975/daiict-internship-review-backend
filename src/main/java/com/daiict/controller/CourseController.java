package com.daiict.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.CourseDao;
import com.daiict.model.Admin;
import com.daiict.model.Course;

@RestController
public class CourseController {

	@Autowired
	CourseDao courseDao;

	@GetMapping(path = "/course")
	public ResponseEntity<List<Course>> getAllCourse() {

		List<Course> course = courseDao.getCourse();
		return new ResponseEntity<List<Course>>(course, HttpStatus.OK);
	}

	@PostMapping(path = "/course")
	public ResponseEntity<?> saveCourse(@Valid @RequestBody Course course) {
		String msg = courseDao.saveCourse(course);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
}
