package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Companies;

@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepo extends JpaRepository<Companies, Integer> {

}
