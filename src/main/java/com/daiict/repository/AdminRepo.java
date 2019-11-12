package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Admin;

@RepositoryRestResource(collectionResourceRel = "admin", path = "admin")
public interface AdminRepo extends JpaRepository<Admin, String> {

}
