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
public class Internship_type {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private int internship_type_id;
	@NotNull(message = "Please provide a internship_type_name as string")
	@Column(nullable = false, length = 20)
	private String internship_type_name;
	@NotNull(message = "Please provide a internship_type_duration as int")
	@Column(nullable = false, length = 10)
	private int internship_type_duration;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "internship_type")
	private Set<Internship> internship;

//	public Set<Internship> getInternship() {
//		return internship;
//	}

	public void setInternship(Set<Internship> internship) {
		this.internship = internship;
	}

	public int getInternship_type_id() {
		return internship_type_id;
	}

	public void setInternship_type_id(int internship_type_id) {
		this.internship_type_id = internship_type_id;
	}

	public String getInternship_type_name() {
		return internship_type_name;
	}

	public void setInternship_type_name(String internship_type_name) {
		this.internship_type_name = internship_type_name;
	}

	public int getInternship_type_duration() {
		return internship_type_duration;
	}

	public void setInternship_type_duration(int internship_type_duration) {
		this.internship_type_duration = internship_type_duration;
	}

//	@Override
//	public String toString() {
//		return "Internship_type [internship_type_id=" + internship_type_id + ", internship_type_name="
//				+ internship_type_name + ", internship_type_duration=" + internship_type_duration + ", internship="
//				+ internship + "]";
//	}

}
