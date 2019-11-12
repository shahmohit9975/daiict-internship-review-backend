package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Course;

@RepositoryRestResource(collectionResourceRel = "course", path = "course")
public interface CourseRepo extends JpaRepository<Course, Integer>{

}
