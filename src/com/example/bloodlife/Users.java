package com.example.bloodlife;

public class Users {
	private long id;
	private String user;
	private String city;
	private String phone;
	private String last_donated_date;
	private String email_id;
	private String blood_group;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmailId() {
		return this.email_id;
	}
	
	public void setEmailId(String email_id) {
		this.email_id = email_id;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getBloodGroup() {
		return this.blood_group;
	}
	
	public void setBloodGroup(String blood_group) {
		this.blood_group = blood_group;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhone() {
		return this.phone;		
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getLastDonatedDate() {
		return this.last_donated_date;
	}
	
	public void setLastDonatedDate(String last_donated_date) {
		this.last_donated_date = last_donated_date;
	}
	
	public String toString() {
		return user;
	}
}