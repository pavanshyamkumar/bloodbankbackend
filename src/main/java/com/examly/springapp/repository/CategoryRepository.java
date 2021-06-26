package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.entity.blood.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	

}
