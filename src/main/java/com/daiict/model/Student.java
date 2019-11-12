package com.daiict.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@CrossOrigin
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Student {

	@Id
	@NotNull(message = "Please provide a student_id as string")
	@Column
	private String student_id;
	@NotNull(message = "Please provide a student_name as string")
	@Column(nullable = false, length = 20)
	private String student_name;
	@NotNull(message = "Please provide a student_contact_number as string")
	@Column(nullable = false, length = 11)
	private String student_contact_number;
//	@JoinColumn(name = "course_id")
//	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private Course course;
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "student_id")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
	private Set<Internship> internship;
//	@OneToMany(fetch = FetchType.LAZY, targetEntity = Feedback.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
	private Set<Feedback> feedback;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;

//	public Set<Internship> getInternship() {
//		return internship;
//	}

	public void setInternship(Set<Internship> internship) {
		this.internship = internship;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_contact_number() {
		return student_contact_number;
	}

	public void setStudent_contact_number(String student_contact_number) {
		this.student_contact_number = student_contact_number;
	}

//	public Course getCourse() {
//		return course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}

//	public Set<Feedback> getFeedback() {
//		return feedback;
//	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}

//	@Override
//	public String toString() {
//		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_contact_number="
//				+ student_contact_number + ", internship=" + internship + ", feedback=" + feedback + ", course="
//				+ course + "]";
//	}

}
