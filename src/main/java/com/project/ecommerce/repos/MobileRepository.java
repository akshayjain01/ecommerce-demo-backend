package com.project.ecommerce.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.ecommerce.model.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {

	@Query("SELECT p FROM Mobile p WHERE p.brand LIKE CONCAT('%',:s,'%') or p.model LIKE CONCAT('%',:s,'%') or p.memories LIKE CONCAT('%',:s,'%')") 
	List<Mobile> findBySearch(@Param("s") String input);
	
	@Query(nativeQuery = true, value = "SELECT * FROM Mobile p WHERE p.brand LIKE CONCAT('%',:s,'%') or p.model LIKE CONCAT('%',:s,'%') or p.memories LIKE CONCAT('%',:s,'%') limit :entries OFFSET :page") 
	List<Mobile> findBySearch(@Param("s") String input,@Param("page") int page,@Param("entries") int entries);
	
	@Query(nativeQuery = true, value = "SELECT * FROM Mobile ORDER BY id limit :entries OFFSET :page") 
	List<Mobile> findAll(@Param("page") int page,@Param("entries") int entries);

}
