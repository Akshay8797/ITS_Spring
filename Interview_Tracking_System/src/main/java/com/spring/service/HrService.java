package com.spring.service;

import java.util.List;

import com.spring.json.ITS_TBL_Interview_Schedule;

public interface HrService {
	public List<ITS_TBL_Interview_Schedule> getAllHrCandidate(); 
	
	public String giveHRRating (ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id);

	public List<ITS_TBL_Interview_Schedule> getResult();
}
