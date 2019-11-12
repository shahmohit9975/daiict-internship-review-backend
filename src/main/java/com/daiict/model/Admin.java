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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.daiict.exceptionHandle.RecordNotFoundException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@CrossOrigin
public class Admin {

	@Id
	@NotNull(message = "Please provide a admin id as string")
	@Column
	private String admin_id;
	@NotNull(message = "Please provide a admin_name as string")
	@Column(nullable = false, length = 20)
	private String admin_name;
	@NotNull(message = "Please provide a admin_role as string")
	@Column(nullable = false, length = 20)
	private String admin_role;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "admin")
	private Set<Review> review;

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) throws Exception {

		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_role() {
		return admin_role;
	}

	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}

//	public Set<Review> getReview() {
//		return review;
//	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}

//	@Override
//	public String toString() {
//		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_role=" + admin_role + ", review="
//				+ review + "]";
//	}

}
