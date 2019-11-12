package com.daiict.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.FeaturesDao;
import com.daiict.model.Admin;
import com.daiict.model.Course;
import com.daiict.model.Features;
import com.daiict.repository.FeatureRepo;

@RestController
public class FeatureController {

	@Autowired
	FeaturesDao featuresDao;

	@GetMapping(path = "/feature")
	public ResponseEntity<List<Features>> getAllFeatures() {

		List<Features> features = featuresDao.getAllFeatures();
		return new ResponseEntity<List<Features>>(features, HttpStatus.OK);
	}

	@PostMapping(path = "/feature", consumes = { "application/json" })
	public ResponseEntity<?> addFeature(@Valid @RequestBody Features feature) {

		String msg = featuresDao.addFeature(feature);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@PutMapping(path = "/feature/{feature_id}", consumes = { "application/json" })
	public ResponseEntity<?> FeatureUpdateById(@PathVariable("feature_id") int feature_id,
			@Valid @RequestBody Features feature) {

		String msg = featuresDao.UpdateFeature(feature_id, feature);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
