package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.example.beans.Address;
import com.example.beans.Advertisement;
import com.example.beans.OrgBatch;
import com.example.beans.Organisation;

public class OrganisationMapper implements RowMapper{

	@Autowired
	Organisation orgObj;

	@Override
	public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		orgObj.setOrgContactNumber(rs.getInt("InstContactNumber"));
		orgObj.setOrgEmail(rs.getString("InsEmailID"));
		orgObj.setEstabDate(rs.getDate("EstDate"));
		/*orgObj.setOrgRegNumber(rs.getLong("orgRegNumber"));*/
		orgObj.setOrgName(rs.getString("InstituteName"));
		orgObj.setAddr((Address) rs.getObject("Address"));
		if(rs.getObject("Batch")!=null)
			orgObj.setBatch((OrgBatch) rs.getObject("Batch"));
		if(rs.getObject("availForAdd")!=null)
			orgObj.setAddver((Advertisement) rs.getObject("availForAdd"));
		return orgObj;
	}

}
