package com.daiict.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.FeedBackDao;
import com.daiict.exceptionHandle.InvalidInputException;
import com.daiict.model.Admin;
import com.daiict.model.Course;
import com.daiict.model.Feedback;

@RestController
public class FeedBackController {

	@Autowired
	FeedBackDao feedBackDao;

	@GetMapping(path = "/feedback")
	public ResponseEntity<List<Feedback>> getAllFeedBack() {
		List<Feedback> feedback = feedBackDao.getAllFeedback();
		return new ResponseEntity<List<Feedback>>(feedback, HttpStatus.OK);
	}

	@PostMapping(path = "/feedback", consumes = { "application/json" })
	public ResponseEntity<?> addFeedback(@RequestBody String feedback) {

		Object obj = JSONValue.parse(feedback);
		JSONObject jsonObject = (JSONObject) obj;

		String student_id = (String) jsonObject.get("student_id");
		if (!student_id.endsWith("@daiict.ac.in")) {

			throw new InvalidInputException("student id must be ends with @daiict.ac.in");
		}
		String msg = feedBackDao.addFeedBack(student_id, jsonObject.toString());
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
}
