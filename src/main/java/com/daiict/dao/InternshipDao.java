package com.daiict.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.daiict.model.Companies;
import com.daiict.model.Faculty;
import com.daiict.model.Internship;
import com.daiict.model.Internship_type;
import com.daiict.model.Job_profile;
import com.daiict.model.Location;
import com.daiict.model.Review;
import com.daiict.model.Student;
import com.daiict.repository.CompanyRepo;
import com.daiict.repository.FacultyRepo;
import com.daiict.repository.InternShipRepo;
import com.daiict.repository.InternShipTypeRepo;
import com.daiict.repository.JobProfileRepo;
import com.daiict.repository.LocationRepo;
import com.daiict.repository.StudentRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class InternshipDao {

	@Autowired
	InternShipRepo internShipRepo;
	@Autowired
	CompanyRepo companyRepo;
	@Autowired
	FacultyRepo facultyRepo;
	@Autowired
	InternShipTypeRepo internShipTypeRepo;
	@Autowired
	JobProfileRepo jobProfileRepo;
	@Autowired
	LocationRepo locationRepo;
	@Autowired
	StudentRepo studentRepo;

	public String updateStatus(int internship_id) throws ResourceNotFoundException {

		if (internShipRepo.existsById(internship_id)) {
			int id = internship_id;
			internShipRepo.updateStatus(id);
			return "updated";
		}

		throw new ResourceNotFoundException("internship id " + internship_id + "  is not valid");
	}

	public String addInternship(int company_id, String faculty_id, boolean isCompany, int internship_type_id,
			int job_profile_id, int location_id, String student_id, String string) {
		Internship internship = null;

		try {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			internship = gson.fromJson(string, Internship.class);
		} catch (Exception e) {
//			System.out.println("========");
			e.printStackTrace();
			return e.getMessage();
		}

		Internship_type internship_type = internShipTypeRepo.findById(internship_type_id).orElseThrow(
				() -> new ResourceNotFoundException("internship type id " + internship_type_id + " is not valid"));
		Job_profile job_profile = jobProfileRepo.findById(job_profile_id)
				.orElseThrow(() -> new ResourceNotFoundException("Job profile id " + job_profile_id + " is not valid"));
		Location location = locationRepo.findById(location_id)
				.orElseThrow(() -> new ResourceNotFoundException("location id " + location_id + " is not valid"));
		Student student = studentRepo.findById(student_id)
				.orElseThrow(() -> new ResourceNotFoundException("student id " + student_id + " is not valid"));

		Companies company = null;
		Faculty faculty = null;
		if (isCompany) {
			company = companyRepo.findById(company_id)
					.orElseThrow(() -> new ResourceNotFoundException("company id " + company_id + " is not valid"));
			internship.setCompanies(company);
		} else {
			faculty = facultyRepo.findById(faculty_id)
					.orElseThrow(() -> new ResourceNotFoundException("faculty id " + faculty_id + " is not valid"));
			internship.setFaculty(faculty);
		}

		internship.setInternship_type(internship_type);
		internship.setJob_profile(job_profile);
		internship.setLocation(location);
		internship.setStudent(student);
		internShipRepo.save(internship);

		return "added....";

	}

	public List<Internship> getAllIntenship() {

		return internShipRepo.findAll();
	}

}
