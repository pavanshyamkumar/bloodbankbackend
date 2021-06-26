package com.examly.springapp.service.impl;




import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.blood.Category;
import com.examly.springapp.entity.blood.DonorsDetails;
import com.examly.springapp.repository.DonorDetailsRepository;
import com.examly.springapp.service.DonorDetalsService;

@Service
public class DonorDetailsServiceImpl implements DonorDetalsService  {
	
	
	@Autowired
	private DonorDetailsRepository donorDetailsRepository;

	@Override
	public DonorsDetails addDonar(DonorsDetails Donar) {
		// TODO Auto-generated method stub
		
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(Donar.getSampletakendate()); 
		c.add(Calendar.DATE, 90); 
		Date output = c.getTime();
		
		
		Donar.setExpiredate(output);
		
		Date today = new Date();
		
		long diff = output.getTime() - today.getTime();
		
		 long differenceInDays = (diff/ (1000 * 60 * 60 * 24))% 365;
		 
		 Donar.setNoofdaystoexpire(differenceInDays);
		
		
	
		
		
	
		
		return this.donorDetailsRepository.save(Donar);
	}

	@Override
	public DonorsDetails updateDonar(DonorsDetails Donar) {
		Calendar c = Calendar.getInstance();
		c.setTime(Donar.getSampletakendate()); 
		c.add(Calendar.DATE, 90); 
		Date output = c.getTime();
		
		
		Donar.setExpiredate(output);
		
		Date today = new Date();
		
		long diff = output.getTime() - today.getTime();
		
		 long differenceInDays = (diff/ (1000 * 60 * 60 * 24))% 365;
		 
		 Donar.setNoofdaystoexpire(differenceInDays);
		return this.donorDetailsRepository.save(Donar);
	}

	@Override
	public Set<DonorsDetails> getDonars() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.donorDetailsRepository.findAll());
	}

	@Override
	public DonorsDetails getDonar(Long donorid) {
		// TODO Auto-generated method stub
		return this.donorDetailsRepository.findById(donorid).get();
	}

	@Override
	public void donordelete(Long did) {
		
		DonorsDetails donordetails =new DonorsDetails();
		donordetails.setDid(did);
		
		this.donorDetailsRepository.delete(donordetails);
		
		
		
	}

	@Override
	public Set<DonorsDetails> getDonersofcategory(Category category) {
		
		return this.donorDetailsRepository.findByCategory(category);
	}

}
