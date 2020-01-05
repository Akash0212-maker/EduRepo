package com.example.daoImpl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.beans.Organisation;
import com.example.beans.User;
import com.example.dao.UserDao;
import com.example.utility.Utility;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	
	@Autowired
	@Qualifier("springDataSource")
	private DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public boolean doRegistration(User user) {
		// TODO Auto-generated method stub
		KeyHolder key = new GeneratedKeyHolder();
		int row;
		String sql= "insert into user() Values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] obj=null; 
		try {
			row=getJdbcTemplate().update(sql);
		}catch(Exception ex) {
			ex.getStackTrace();
			return false;
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public User getUserByRegNumber(long regNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String name) {
	
		String sql =  "select * from [user] join address on [user].address_id=address.id where user_unique_id=?";
		return getJdbcTemplate().queryForObject(sql, new Object[] {name},(RowMapper<User>) new User());

	}

}
