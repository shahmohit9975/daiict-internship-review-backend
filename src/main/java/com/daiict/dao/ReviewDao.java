package com.daiict.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.Sort;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.daiict.model.Admin;
import com.daiict.model.Internship;
import com.daiict.model.Review;
import com.daiict.repository.AdminRepo;
import com.daiict.repository.InternShipRepo;
import com.daiict.repository.ReviewRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class ReviewDao {

	@Autowired
	ReviewRepo reviewRepo;
	@Autowired
	InternShipRepo internShipRepo;
	@Autowired
	AdminRepo adminRepo;

	public List<Review> getReviewsByCompanyName(String companyName) {

		if (companyName == null || companyName.length() == 0) {

			return getAllReviews();

		}
		return reviewRepo.getAllReviewsByCompanyName(companyName);

	}

	public List<Review> getAllReviewsForSearchStirng() {

		return reviewRepo.getAllReviewsByDateDescendsingOrderWhereStatusIsTrue();

	}

	public List<Review> getAllReviews() {

		return reviewRepo.getAllReviewsByDateDescendsingOrder();

	}

	public List<Review> getAllReviewsByCompanyId(int company_id) {
		return reviewRepo.getAllReviewsByCompanyIdAndDateDescendsingOrder(company_id);
	}

	public String updateReviewStatus(int review_id, String admin_id, int review_status) {

		Admin admin = adminRepo.findById(admin_id)
				.orElseThrow(() -> new ResourceNotFoundException("admin id " + admin_id + " is not valid"));
		Review review = reviewRepo.findById(review_id)
				.orElseThrow(() -> new ResourceNotFoundException("review id" + review_id + " is not valid"));

		review.setAdmin(admin);
		review.setReview_status(review_status == 1 ? true : false);
		reviewRepo.save(review);
		return "updated...";
	}

	public String saveReview(Review review) {

		try {
//			System.out.println(review);
//			Internship i = internShipRepo.findById(review.getInternship()())
//					.orElseThrow(() -> new ResourceNotFoundException("Internship id is not valid"));
//			review.setInternship(i);
//			reviewRepo.save(review);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "added";
	}

	public String addReview(int internship_id, String jsonObject) {
		Review review = null;
		try {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			review = gson.fromJson(jsonObject, Review.class);
		} catch (Exception e) {
			return e.getMessage();
		}

		Internship internship = internShipRepo.findById(internship_id)
				.orElseThrow(() -> new ResourceNotFoundException("internship id " + internship_id + " is not valid"));
		review.setInternship(internship);
		reviewRepo.save(review);
		return "added";

	}

	public List<Map<Object, Object>> getAllStudentEmailIdForReminder() {

		return reviewRepo.getAllStudentEmailIdForReminder();
	}
}
