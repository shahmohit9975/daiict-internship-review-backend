package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Faculty;

@RepositoryRestResource(collectionResourceRel = "faculty", path = "faculty")
public interface FacultyRepo extends JpaRepository<Faculty, String> {

}
