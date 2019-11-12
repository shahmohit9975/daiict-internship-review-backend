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

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@CrossOrigin
@Entity
public class Companies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, length = 10)
	private int company_id;
	@NotNull(message = "Please provide a company_name1 as string")
	@Column(nullable = false, length = 25)
	private String company_name1;
	@Column(length = 25)
	private String company_name2;
	@NotNull(message = "Please provide a company_url as string")
	@Column(nullable = false, length = 25)
	private String company_url;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "companies")
	private Set<Internship> internship;

//	public Set<Internship> getInternship() {
//		return internship;
//	}

	public void setInternship(Set<Internship> internship) {
		this.internship = internship;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getCompany_name1() {
		return company_name1;
	}

	public void setCompany_name1(String company_name1) {
		this.company_name1 = company_name1;
	}

	public String getCompany_name2() {
		return company_name2;
	}

	public void setCompany_name2(String company_name2) {
		this.company_name2 = company_name2;
	}

	public String getCompany_url() {
		return company_url;
	}

	public void setCompany_url(String company_url) {
		this.company_url = company_url;
	}

//	@Override
//	public String toString() {
//		return "Companies [company_id=" + company_id + ", company_name1=" + company_name1 + ", company_name2="
//				+ company_name2 + ", company_url=" + company_url + ", internship=" + internship + "]";
//	}

}
