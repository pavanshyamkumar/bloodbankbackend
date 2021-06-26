package com.examly.springapp.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.examly.springapp.entity.blood.Category;
import com.examly.springapp.entity.blood.DonorsDetails;

public interface DonorDetailsRepository extends JpaRepository<DonorsDetails,Long> {

	Set<DonorsDetails> findByCategory(Category category);
	

}
