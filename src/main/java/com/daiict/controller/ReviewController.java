package com.daiict.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.ReviewDao;
import com.daiict.exceptionHandle.InvalidInputException;
import com.daiict.model.Admin;
import com.daiict.model.Course;
import com.daiict.model.Review;

@RestController
public class ReviewController {
	@Autowired
	ReviewDao reviewdao;

	// get employee by id
	@GetMapping("/search/{search_string}")
	public ResponseEntity<List<Review>> getReviewsByCompanyName(@PathVariable("search_string") String companyName) {

		List<Review> review = reviewdao.getReviewsByCompanyName(companyName);
		return new ResponseEntity<List<Review>>(review, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Review>> getAllreviewsForSearchString() {

		List<Review> review = reviewdao.getAllReviewsForSearchStirng();
		return new ResponseEntity<List<Review>>(review, HttpStatus.OK);
	}

	@GetMapping("/review")
	public ResponseEntity<List<Review>> getAllreviews() {

		List<Review> review = reviewdao.getAllReviews();
		return new ResponseEntity<List<Review>>(review, HttpStatus.OK);
	}

	@GetMapping("/review/company/{company_id}")
	public ResponseEntity<List<Review>> getAllreviewsByCompanyId(@PathVariable("company_id") int company_id) {
		List<Review> review = reviewdao.getAllReviewsByCompanyId(company_id);
		return new ResponseEntity<List<Review>>(review, HttpStatus.OK);

	}

	@GetMapping("/review/student/getEmail")
	public ResponseEntity<List<Map<Object, Object>>> getAllStudentEmailIdForReminder() {
		List<Map<Object, Object>> result = reviewdao.getAllStudentEmailIdForReminder();

		return new ResponseEntity<List<Map<Object, Object>>>(result, HttpStatus.OK);
	}

	@PostMapping(path = "/review", consumes = { "application/json" })
	public ResponseEntity<?> addReview(@RequestBody String review) {

		Object obj = JSONValue.parse(review);
		JSONObject jsonObject = (JSONObject) obj;
		long long_internship_id = (long) jsonObject.get("internship_id");
		int internship_id = Integer.parseInt(String.valueOf(long_internship_id));
//		System.out.println(jsonObject);
		String msg = reviewdao.addReview(internship_id, jsonObject.toString());
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);

	}

	@PutMapping(path = "/review/{review_id}", consumes = { "application/json" })
	public ResponseEntity<?> ReviewUpdateByAdmin(@PathVariable("review_id") int review_id, @RequestBody String review) {

		Object obj = JSONValue.parse(review);
		JSONObject jsonObject = (JSONObject) obj;

//		String long_admin_id = (String) jsonObject.get("admin_id");
		long long_review_status = (long) jsonObject.get("review_status");

		String admin_id = (String) jsonObject.get("admin_id");
		if (!admin_id.endsWith("@daiict.ac.in")) {

			throw new InvalidInputException("admin email id must be ends with @daiict.ac.in");
		}
		int review_status = Integer.parseInt(String.valueOf(long_review_status));
		String msg = reviewdao.updateReviewStatus(review_id, admin_id, review_status);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
