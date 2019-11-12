
package com.daiict.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiict.model.Faculty;
import com.daiict.repository.FacultyRepo;

@Service
public class FacultyDao {
	@Autowired
	FacultyRepo facultyRepo;

	public List<Faculty> getAllFaculty() {
		return facultyRepo.findAll();
	}

	public String saveFaculty(@Valid Faculty faculty) {
		facultyRepo.save(faculty);
		return "faculty added";
	}
}
