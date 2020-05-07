package com.spring.service;

import java.util.List;

import com.spring.entity.ITS_TBL_Techpanel_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;

public interface TechService {
	public List<ITS_TBL_Techpanel_Entity> getAllTechPanelCheck();
	public Object getAllTechPanel(String authToken);  
	public Object getAllInterviewCandidates(String authToken);
	public Object giveTechRating(ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id,String authToken);
	public Object getFinalResultsForTech(String authToken);
}
