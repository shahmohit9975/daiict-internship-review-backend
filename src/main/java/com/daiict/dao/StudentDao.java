package com.daiict.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.daiict.model.Course;
import com.daiict.model.Feedback;
import com.daiict.model.Internship;
import com.daiict.model.Review;
import com.daiict.model.Student;
import com.daiict.repository.CourseRepo;
import com.daiict.repository.StudentRepo;
import com.google.gson.Gson;

@Service
public class StudentDao {

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	CourseRepo courseRepo;

	public String addStudent(int course_id, String jsonObject) {

		Student student = null;
		Set<Student> hsStudent = new HashSet<Student>();
		try {
			student = new Gson().fromJson(jsonObject, Student.class);
		} catch (Exception e) {
			return e.getMessage();
		}

		Course course = courseRepo.findById(course_id)
				.orElseThrow(() -> new ResourceNotFoundException("course id " + course_id + " is not valid"));

		hsStudent.add(student);
		course.setStudents(hsStudent);
		courseRepo.save(course);
		student.setCourse(course);
		studentRepo.save(student);
//		System.out.println(student.toString());
//		System.out.println(feedback.toString());
//		
////		course.set
//		review.setInternship(internship);
//		reviewRepo.save(review);
		return "added";
	}

}
