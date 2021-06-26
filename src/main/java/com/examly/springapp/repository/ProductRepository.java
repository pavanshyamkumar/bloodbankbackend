package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	Product findByName(String name);

}
