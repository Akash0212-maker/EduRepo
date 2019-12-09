package com.example.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	@Override
	public boolean doRegistration(User user) {
		// TODO Auto-generated method stub
		KeyHolder key = new GeneratedKeyHolder();
		String regNum=Utility.generateRegistrationNumber(user.getUserId());
	/*	orgObj.setOrgRegNumber(regNum);*/
		/*String sql= "insert into organisation_details(OrganisationName,OrgRegNum,EstDate,OrgOwnerName,InsEmailID,InstContactNumber,"
				+ "availForAdd,DocForReg,Address,Batch,StaffDetails) Values(?,?,?,?,?,?,?,?,?,?,?)";*/

		String sql=null;
		Object[] obj=null; /*{orgObj.getOrgName(),regNum,orgObj.getEstabDate(),orgObj.getOrgName(),orgObj.getOrgEmail(),orgObj.getOrgContactNumber(),orgObj.getAddver(),
				orgObj.getRegDocument(),orgObj.getAddr(),orgObj.getBatch(),orgObj.getFacultyDetails()};*/
		try {
			getJdbcTemplate().update(sql, obj,key);
		}catch(Exception ex) {
			ex.getStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Organisation getUserByRegNumber(long regNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organisation getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organisation getUserByBatch(int orgBatchID) {
		// TODO Auto-generated method stub
		return null;
	}

}
