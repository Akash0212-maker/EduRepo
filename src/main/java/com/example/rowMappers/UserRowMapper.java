package com.example.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.beans.Address;
import com.example.beans.Organisation;
import com.example.beans.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();
		Address address=new Address();
		Organisation org;
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		user.setEmail(rs.getString("email"));
		user.setContact(rs.getString("contact"));
		if(rs.getBoolean("org")) {
			user.setIsOrgOwner(rs.getBoolean("org"));
			org = new Organisation();
			user.setOrg(org);
		}
		address.setCity(rs.getString("city"));
		address.setCountry(rs.getString("country"));
		address.setHouseNo(rs.getString("Hno"));
		address.setPincode(rs.getLong("pincode"));
		address.setState(rs.getString("state"));
		user.setAddress(address);

		// TODO Auto-generated method stub
		return user;
	}

}
