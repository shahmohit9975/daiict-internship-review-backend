package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Job_profile;

@RepositoryRestResource(collectionResourceRel = "jobProfile", path = "jobProfile")
public interface JobProfileRepo extends JpaRepository<Job_profile, Integer> {

}
