package com.examly.springapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.entity.blood.Category;
import com.examly.springapp.entity.blood.DonorsDetails;
import com.examly.springapp.service.DonorDetalsService;

@RestController
@RequestMapping("/donor")
@CrossOrigin("*")
public class DonorDetailsControler {
	
	
	@Autowired
	private DonorDetalsService donardetalisService;
	
	
	@PostMapping("/")
	public ResponseEntity<DonorsDetails> add(@RequestBody DonorsDetails Donar)
	{
		return ResponseEntity.ok(this.donardetalisService.addDonar(Donar));
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getallusers()
	{
		return ResponseEntity.ok(this.donardetalisService.getDonars());
	}
	
	@PutMapping("/")
	public ResponseEntity<DonorsDetails> updatedonor(@RequestBody DonorsDetails Donar)
	{
		return ResponseEntity.ok(this.donardetalisService.updateDonar(Donar));
	}
	
	@GetMapping("/category/{categoryid}")
	public ResponseEntity<?> getDonorsofCategory(@PathVariable("categoryid") Long categoryid)
	{
		Category category=new Category();
		category.setCid(categoryid);
		java.util.Set<DonorsDetails> donorsofCategory=this.donardetalisService.getDonersofcategory(category);
		
		return ResponseEntity.ok(donorsofCategory);
	}
	
	@GetMapping("/{did}")
	public DonorsDetails getbyid(@PathVariable("did") Long did)
	{
		return this.donardetalisService.getDonar(did);
	}
	
	@DeleteMapping("/{donorid}")
	public void delete(@PathVariable("donorid") Long did)
	{
		
		this.donardetalisService.donordelete(did);
	}

}
