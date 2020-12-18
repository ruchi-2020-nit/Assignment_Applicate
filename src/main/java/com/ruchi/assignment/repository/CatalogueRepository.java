package com.ruchi.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ruchi.assignment.domain.Catalogue;



@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
	
	
	@Query("SELECT t FROM Catalogue t WHERE " + "LOWER(t.SKU_dis) LIKE LOWER(CONCAT('%',:product, '%'))")
	public List<Catalogue> findByText(@Param("product") String product);
}