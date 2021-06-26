package com.examly.springapp.entity.blood;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "donordetails")
public class DonorsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long did;

	private String name;

	private String age;

	private String address;

	private String phone;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date sampletakendate;

	@Temporal(TemporalType.DATE)
	private Date expiredate;

	private Long noofdaystoexpire;

	private String city;
	private String state;
	private String sex;

	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	public DonorsDetails() {

	}

	public DonorsDetails(Long did, String name, String age, String address, String phone, Date sampletakendate,
			Date expiredate, Long noofdaystoexpire, String city, String state, String sex, Category category) {
		super();
		this.did = did;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.sampletakendate = sampletakendate;
		this.expiredate = expiredate;
		this.noofdaystoexpire = noofdaystoexpire;
		this.city = city;
		this.state = state;
		this.sex = sex;
		this.category = category;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getSampletakendate() {
		return sampletakendate;
	}

	public void setSampletakendate(Date sampletakendate) {
		this.sampletakendate = sampletakendate;
	}

	public Date getExpiredate() {
		return expiredate;
	}

	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
	}

	public Long getNoofdaystoexpire() {
		return noofdaystoexpire;
	}

	public void setNoofdaystoexpire(Long noofdaystoexpire) {
		this.noofdaystoexpire = noofdaystoexpire;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
