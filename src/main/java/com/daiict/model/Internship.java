package com.daiict.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;
@CrossOrigin
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Internship {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private int internship_id;
//	@ManyToOne
//	@JoinColumn(name = "student_id")
//	private Student student;
//	@ManyToOne
//	@JoinColumn(name = "internship_type_id")
//	private Internship_type internship_type;
//
//	@ManyToOne
//	@JoinColumn(name = "company_id")
//	private Companies companies;
//	@ManyToOne
//	@JoinColumn(name = "faculty_id")
//	private Faculty faculty;
//	@ManyToOne
//	@JoinColumn(name = "location_id")
//	private Location location;
//	@ManyToOne
//	@JoinColumn(name = "job_profile_id")
//	private Job_profile job_profile;
	@NotNull(message = "Please provide a stipend as int")
	@Column(nullable = false, length = 6)
	private int stipend;
	@NotNull(message = "Please provide a ctc as int")
	@Column(nullable = false, length = 3)
	private int ctc;
	@NotNull(message = "Please provide a added_on in format like 2019-02-03 10:08:02")
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 2019-02-03 10:08:02
	@javax.persistence.Temporal(TemporalType.DATE)
	private Date added_on;
	@NotNull(message = "Please provide a start date in format like 2019-02-03 10:08:02")
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 2019-02-03 10:08:02
	@javax.persistence.Temporal(TemporalType.DATE)
	private Date start_date;
	@NotNull(message = "Please provide a offer_file as string")
	@Column(nullable = false, length = 200)
	private String offer_file;
	@Column
	private boolean approved_status;

//	private int location_id;
//	private int student_id;
//	private int internship_type_id;
//	private int faculty_id;
//	private int job_profile_id;
//	private int company_id;

//	@OneToOne(targetEntity = Review.class)
//	private Review review;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Companies companies;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "internship_type_id")
	private Internship_type internship_type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_profile_id")
	private Job_profile job_profile;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location location;

	public int getInternship_id() {
		return internship_id;
	}

	public void setInternship_id(int internship_id) {
		this.internship_id = internship_id;
	}

	public int getStipend() {
		return stipend;
	}

	public void setStipend(int stipend) {
		this.stipend = stipend;
	}

	public int getCtc() {
		return ctc;
	}

	public void setCtc(int ctc) {
		this.ctc = ctc;
	}

	public Date getAdded_on() {
		return added_on;
	}

	public void setAdded_on(Date added_on) {
		this.added_on = added_on;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getOffer_file() {
		return offer_file;
	}

	public void setOffer_file(String offer_file) {
		this.offer_file = offer_file;
	}

	public boolean isApproved_status() {
		return approved_status;
	}

	public void setApproved_status(boolean approved_status) {
		this.approved_status = approved_status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Companies getCompanies() {
		return companies;
	}

	public void setCompanies(Companies companies) {
		this.companies = companies;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Internship_type getInternship_type() {
		return internship_type;
	}

	public void setInternship_type(Internship_type internship_type) {
		this.internship_type = internship_type;
	}

	public Job_profile getJob_profile() {
		return job_profile;
	}

	public void setJob_profile(Job_profile job_profile) {
		this.job_profile = job_profile;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

//	@Override
//	public String toString() {
//		return "Internship [internship_id=" + internship_id + ", stipend=" + stipend + ", ctc=" + ctc + ", added_on="
//				+ added_on + ", start_date=" + start_date + ", offer_file=" + offer_file + ", approved_status="
//				+ approved_status + ", student=" + student + ", companies=" + companies + ", faculty=" + faculty
//				+ ", internship_type=" + internship_type + ", job_profile=" + job_profile + ", location=" + location
//				+ "]";
//	}

}
