package com.example.dao;

import com.example.beans.Organisation;
import com.example.beans.User;

public interface UserDao {

	public boolean doRegistration(User user);
	
	public User getUserByRegNumber(long regNumber);
	
	public User getUserByName(String name);
	

	
	
}
