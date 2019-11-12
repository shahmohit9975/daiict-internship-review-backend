package com.daiict.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.daiict.model.Features;
import com.daiict.repository.FeatureRepo;

@Service
public class FeaturesDao {
	@Autowired
	FeatureRepo featureRepo;

	public String UpdateFeature(int feature_id, Features feature) {
		Features obj = featureRepo.findById(feature_id)
				.orElseThrow(() -> new ResourceNotFoundException("feature id " + feature_id + " is not valid"));

		obj.setFeature_name(feature.getFeature_name());
		obj.setFeature_route(feature.getFeature_route());
		obj.setIs_admin(feature.isIs_admin());
		obj.setIs_student(feature.isIs_student());

		featureRepo.save(obj);

		return "updated";
	}

	public List<Features> getAllFeatures() {
		return featureRepo.findAll();
	}

	public String addFeature(Features feature) {

		try {
			featureRepo.save(feature);

		} catch (Exception e) {
			return e.getMessage();
		}
		return "added...";
	}

}
