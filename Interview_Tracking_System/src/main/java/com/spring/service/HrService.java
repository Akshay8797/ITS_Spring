package com.spring.service;

import java.util.List;

import com.spring.entity.ITS_TBL_Hrpanel_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;

public interface HrService {
	public Object getAllHrCandidate(String authToken);

	public Object giveHRRating(ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id,String authToken);

	public Object getAllHrPanel(String authToken);

	public Object getResult(String authToken);
	
	public List<ITS_TBL_Hrpanel_Entity> getAllHrPanels();

	
}
