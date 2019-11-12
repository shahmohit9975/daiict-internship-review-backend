package com.daiict.repository;

import java.util.List;
import java.util.Map;

import org.aspectj.weaver.tools.Trace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.daiict.model.Review;

@RepositoryRestResource(collectionResourceRel = "review", path = "review")
public interface ReviewRepo extends JpaRepository<Review, Integer> {

//	@Query(value = "select emp.id, emp.expertise,emp.emp_name,dep.name from employee as emp join department as dep on emp.department_id=dep.department_id", nativeQuery = true)
//	List<Map<Object, Object>> save_emp();

	@Query(value = "select * FROM review as r where review_status=1 ORDER by review_date DESC", nativeQuery = true)
	List<Review> getAllReviewsByDateDescendsingOrderWhereStatusIsTrue();

//	@Query(value = "select rev.review_id,rev.cons,rev.pros,rev.rating,rev.review_date,rev.review_descri,rev.review_status,rev.review_title,rev.admin_id,rev.internship_id  from review as rev join internship as inShip on(rev.internship_id=inShip.internship_id) join companies as com on(com.company_id=inShip.company_id) WHERE com.company_name1=?1  OR com.company_name2=?1 and rev.review_status=1 ORDER by rev.review_date DESC", nativeQuery = true)
	@Query(value = "select *  from review as rev join internship as inShip on(rev.internship_id=inShip.internship_id) join companies as com on(com.company_id=inShip.company_id) WHERE (com.company_name1=?1  OR com.company_name2=?1) and rev.review_status=1 ORDER by rev.review_date DESC", nativeQuery = true)
	List<Review> getAllReviewsByCompanyName(String companyName);

	@Query(value = "select * FROM review ORDER by review_date DESC", nativeQuery = true)
	List<Review> getAllReviewsByDateDescendsingOrder();

	@Query(value = "SELECT * from review as rev join internship as inShip on(rev.internship_id=inShip.internship_id) join companies as com \r\n"
			+ "on(com.company_id=inShip.company_id) WHERE com.company_id=?1 ORDER BY rev.review_date DESC", nativeQuery = true)
	List<Review> getAllReviewsByCompanyIdAndDateDescendsingOrder(int company_id);

//	@Query(value = "UPDATE review SET review_status=?3, admin_id=?2 where review_id=?1", nativeQuery = true)
	@Modifying
	@Transactional
	@Query(value = "UPDATE review r SET r.review_status=:review_status, r.admin_id=:admin_id where r.review_id=:review_id", nativeQuery = true)
	void updateReviewStatus(@Param("review_id") int review_id, @Param("admin_id") int admin_id,
			@Param("review_status") int review_status);

	@Query(value = " SELECT stu.student_id from student as stu join internship as intern on(stu.student_id=intern.student_id) WHERE intern.internship_id not in(SELECT rev.internship_id from review as rev)", nativeQuery = true)
	List<Map<Object, Object>> getAllStudentEmailIdForReminder();

//	@Modifying
//	@Transactional
//	@Query(value = "UPDATE SAMPLE_TABLE st SET st.status=:flag WHERE se.referenceNo in :ids")
//	public int updateStatus(@Param("flag")String flag, @Param("ids")List<String> references);
}
