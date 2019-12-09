package com.example.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class OrgBatch {

	int batchID;
	String course;
	String batchDetails;
	Date batchStartDate;
	Date batchEndDate;
	int seatsAvailable;
	@Autowired
	Organisation orgID;
	
	
	
}
