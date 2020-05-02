package com.spring.service;

import java.util.List;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.utils.InterviewScheduleUtils;

public interface HrService {
	public List<ITS_TBL_Interview_Schedule> getAllHrCandidate(); 
	
	public ITS_TBL_Interview_Schedule giveHRRating (ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id);

	public List<ITS_TBL_Interview_Schedule> getResult();

}