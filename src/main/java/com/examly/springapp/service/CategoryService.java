package com.examly.springapp.service;

import java.util.Set;

import com.examly.springapp.entity.blood.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Set<Category> getCategories();
	
	public Category getCategory(Long categoryid);
	
	public void deleteCategory(Long categoryid);

}
