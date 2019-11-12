package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Location;

@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface LocationRepo  extends JpaRepository<Location, Integer>{

}
