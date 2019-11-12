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

import com.daiict.dao.AdminDao;
import com.daiict.dao.FacultyDao;
import com.daiict.exceptionHandle.InvalidInputException;
import com.daiict.model.Admin;
import com.daiict.model.Course;
import com.daiict.model.Faculty;

@RestController
public class FacultyController {

	@Autowired
	FacultyDao facultyDao;

	@GetMapping(path = "/faculty")
	public ResponseEntity<List<Faculty>> getAllFaculty() {

		List<Faculty> faculty = facultyDao.getAllFaculty();
		return new ResponseEntity<List<Faculty>>(faculty, HttpStatus.OK);
	}

	@PostMapping(path = "/faculty")
	public ResponseEntity<?> saveFaculty(@Valid @RequestBody Faculty faculty) {

		if (!faculty.getFaculty_id().endsWith("@daiict.ac.in")) {
			throw new InvalidInputException("faculty email id must be ends with @daiict.ac.in");
		}
		String msg = facultyDao.saveFaculty(faculty);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
}
