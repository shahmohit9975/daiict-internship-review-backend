package com.daiict.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@CrossOrigin
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Job_profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, length = 10)
	private int job_profile_id;
	@NotNull(message = "Please provide a job_profile_name as string")
	@Column(nullable = false, length = 25)
	private String job_profile_name;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "job_profile")
	private Set<Internship> internship;

//	public Set<Internship> getInternship() {
//		return internship;
//	}

	public void setInternship(Set<Internship> internship) {
		this.internship = internship;
	}

	public int getJob_profile_id() {
		return job_profile_id;
	}

	public void setJob_profile_id(int job_profile_id) {
		this.job_profile_id = job_profile_id;
	}

	public String getJob_profile_name() {
		return job_profile_name;
	}

	public void setJob_profile_name(String job_profile_name) {
		this.job_profile_name = job_profile_name;
	}
//
//	@Override
//	public String toString() {
//		return "Job_profile [job_profile_id=" + job_profile_id + ", job_profile_name=" + job_profile_name
//				+ ", internship=" + internship + "]";
//	}

}
