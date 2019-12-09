package com.example.dao;

import com.example.beans.Organisation;
import com.example.beans.User;

public interface UserDao {

	public boolean doRegistration(User user);
	
	public Organisation getUserByRegNumber(long regNumber);
	
	public Organisation getUserByName(String name);
	
	public Organisation getUserByBatch(int orgBatchID);
	
	
}
