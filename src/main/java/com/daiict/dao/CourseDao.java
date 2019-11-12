package com.daiict.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiict.model.Admin;
import com.daiict.model.Course;
import com.daiict.repository.CourseRepo;

@Service
public class CourseDao {

	@Autowired
	CourseRepo courseRepo;

	public List<Course> getCourse() {
		return courseRepo.findAll();
	}

	public String saveCourse(@Valid Course course) {
		courseRepo.save(course);
		return "course added...";
	}

}
