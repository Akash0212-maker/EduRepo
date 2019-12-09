package com.example.config;

import com.mysql.cj.jdbc.Driver;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DataBaseConfig {

	
	
	private String dbUrl;
	
	private String dbUser;
	
	private String dbPwd;
	
	
	
	@Bean("springDataSource")
	public SimpleDriverDataSource dataSource() {
		Driver driver=null;
		try {
			driver =  new com.mysql.cj.jdbc.Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Connection Problem : "+e.getMessage());
			e.printStackTrace();
		}
		return new SimpleDriverDataSource(driver,dbUrl,dbUser,dbPwd);
	}
	
}
