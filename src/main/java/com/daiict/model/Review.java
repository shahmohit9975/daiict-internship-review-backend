package com.daiict.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@CrossOrigin
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, length = 10)
	@PrimaryKeyJoinColumn
	private int review_id;
	@NotNull(message = "Please provide a review_title as string")
	@Column(nullable = false, length = 100)
	private String review_title;
	@NotNull(message = "Please provide a review_descri as string")
	@Column(nullable = false, length = 50)
	private String review_descri;
	@Column
	private boolean review_status;
	@Column(length = 400)
	private String pros;
	@Column(length = 400)
	private String cons;
	@NotNull(message = "Please provide a rating as string like [ONE,TWO...,FIVE]")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Enum_rating rating;
	@NotNull(message = "Please provide a review_date in format like 2019-02-03 10:08:02")
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 2019-02-03 10:08:02
	@javax.persistence.Temporal(TemporalType.DATE)
	private Date review_date;
//	@ManyToOne
//	@JoinColumn(name = "admin_id")
//	private Admin admin_id;
	@JoinColumn(name = "internship_id")
	@OneToOne(fetch = FetchType.LAZY, targetEntity = Internship.class, cascade = CascadeType.ALL)
	private Internship internship;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	private Admin admin;

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_descri() {
		return review_descri;
	}

	public void setReview_descri(String review_descri) {
		this.review_descri = review_descri;
	}

	public boolean isReview_status() {
		return review_status;
	}

	public void setReview_status(boolean review_status) {
		this.review_status = review_status;
	}

	public String getPros() {
		return pros;
	}

	public void setPros(String pros) {
		this.pros = pros;
	}

	public String getCons() {
		return cons;
	}

	public void setCons(String cons) {
		this.cons = cons;
	}

	public Enum_rating getRating() {

		return rating;
	}

	public void setRating(Enum_rating rating) {
		this.rating = rating;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

//	public Admin getAdmin_id() {
//		return admin_id;
//	}
//
//	public void setAdmin_id(Admin admin_id) {
//		this.admin_id = admin_id;
//	}

	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", review_title=" + review_title + ", review_descri=" + review_descri
				+ ", review_status=" + review_status + ", pros=" + pros + ", cons=" + cons + ", rating=" + rating
				+ ", review_date=" + review_date + ", internship=" + internship + ", admin=" + admin + "]";
	}

}
