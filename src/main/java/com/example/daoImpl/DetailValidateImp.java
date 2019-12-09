package com.example.daoImpl;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.beans.User;
import com.example.dao.DetailValidateDao;

@Repository
public class DetailValidateImp extends JdbcDaoSupport implements DetailValidateDao {

	@Autowired
	@Qualifier("springDataSource")
	private DataSource dataSource;

	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public boolean isAlreadyRegistered(User user) {
		// TODO Auto-generated method stub
		String sql = "select UserName from User where userId = ?";
		Object[] param = {user.getUserId()};
		String name =getJdbcTemplate().queryForObject(sql,String.class ,param);
		if(name!=null&&!name.isEmpty())
			return true;
		else
			return false;
	}

}
