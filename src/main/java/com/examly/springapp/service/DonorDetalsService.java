package com.examly.springapp.service;

import java.util.Set;

import com.examly.springapp.entity.blood.Category;
import com.examly.springapp.entity.blood.DonorsDetails;

public interface DonorDetalsService {
	
	public DonorsDetails addDonar(DonorsDetails Donar);
	
	public DonorsDetails updateDonar(DonorsDetails Donar);
	
	public Set<DonorsDetails> getDonars();
	
	public DonorsDetails getDonar(Long donorid);
	
	public void donordelete(Long id);
	
	public Set<DonorsDetails> getDonersofcategory(Category category);

}
