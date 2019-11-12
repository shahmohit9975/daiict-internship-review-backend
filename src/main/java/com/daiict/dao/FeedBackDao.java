package com.daiict.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.daiict.model.Feedback;
import com.daiict.model.Internship;
import com.daiict.model.Review;
import com.daiict.model.Student;
import com.daiict.repository.FeedBackRepo;
import com.daiict.repository.StudentRepo;
import com.google.gson.Gson;

@Service
public class FeedBackDao {

	@Autowired
	FeedBackRepo feedBackRepo;
	@Autowired
	StudentRepo studentRepo;

	public String addFeedBack(String student_id, String string) {
		Feedback feedback = null;
		Set<Feedback> hsFeedback = new HashSet<Feedback>();
		try {
			feedback = new Gson().fromJson(string, Feedback.class);
		} catch (Exception e) {
			return e.getMessage();
		}
//		try {

		Student student = studentRepo.findById(student_id)
				.orElseThrow(() -> new ResourceNotFoundException("Student id " + student_id + " is not valid"));
//			if (studentRepo.findById(student_id) != null) {
//				Student student = studentRepo.getOne(student_id);
		hsFeedback.add(feedback);
		student.setFeedback(hsFeedback);
//		studentRepo.save(student);
		feedback.setStudent(student);
		feedBackRepo.save(feedback);
//		System.out.println(student.toString());
//		System.out.println(feedback.toString());
		return "added";
//			}

//		} catch (Exception e) {
//			return e.getMessage();
//		}
//		return "student id is not valid";
	}

	public List<Feedback> getAllFeedback() {

		return feedBackRepo.findAll();
	}
}
