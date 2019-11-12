package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Internship_type;

@RepositoryRestResource(collectionResourceRel = "internshipType", path = "internshipType")
public interface InternShipTypeRepo extends JpaRepository<Internship_type, Integer>{

}
