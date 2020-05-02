package com.spring.service;

import java.util.List;

import com.spring.json.ITS_TBL_Interview_Schedule;


public interface TechService {

	public List<ITS_TBL_Interview_Schedule> getAllInterviewCandidates();
	public ITS_TBL_Interview_Schedule giveTechRating(ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id);
	public List<ITS_TBL_Interview_Schedule> getFinalResultsForTech();


}
