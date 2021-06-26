package com.examly.springapp.entity;

public class JwtResponce {
	
	String tocken;

	public JwtResponce(String tocken) {
		
		this.tocken = tocken;
	}

	public JwtResponce() {
		
	}

	public String getTocken() {
		return tocken;
	}

	public void setTocken(String tocken) {
		this.tocken = tocken;
	}
	
	
	
	
	

}
