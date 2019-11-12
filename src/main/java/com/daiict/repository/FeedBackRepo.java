package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Feedback;

@RepositoryRestResource(collectionResourceRel = "feedback", path = "feedback")
public interface FeedBackRepo extends JpaRepository<Feedback, Integer>{

}
