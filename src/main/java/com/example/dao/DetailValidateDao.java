package com.example.dao;

import com.example.beans.User;

public interface DetailValidateDao {

	public boolean isAlreadyRegistered(User user);
	
}
