package com.daiict.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.daiict.model.Internship;

@RepositoryRestResource(collectionResourceRel = "internship", path = "internship")
public interface InternShipRepo extends JpaRepository<Internship, Integer> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE internship i SET i.approved_status=true where i.internship_id=?1", nativeQuery = true)
	void updateStatus(int internship_id);

//	@Query(value = "SELECT i.internship_id,i.added_on,i.approved_status,i.ctc,i.offer_file,i.start_date,i.stipend,i.student_id,i.internship_type_id,i.faculty_id,i.job_profile_id,i.company_id,i.location_id FROM internship as i;", nativeQuery = true)
//	List<Internship> getAllInternshipRecords();

}
