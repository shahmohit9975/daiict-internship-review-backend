package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Features;

@RepositoryRestResource(collectionResourceRel = "feature", path = "feature")
public interface FeatureRepo extends JpaRepository<Features,Integer> {

}
