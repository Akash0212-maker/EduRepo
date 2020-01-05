package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;


public class User {

	
	String userId;
	String name;
	int age;
	String contact;
	String email;
	@Autowired
	Address address;
	@Autowired
	Boolean isOrgOwner;
	String password;
	Organisation org;
	
	
	public void setOrg(Organisation org) {
		this.org = org;
	}
	public Boolean getIsOrgOwner() {
		return isOrgOwner;
	}
	public void setIsOrgOwner(Boolean isOrgOwner) {
		this.isOrgOwner = isOrgOwner;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Boolean getOrg() {
		return isOrgOwner;
	}
	public void setOrg(Boolean org) {
		this.isOrgOwner = org;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
