package com.spring.service;

import com.spring.json.ITS_TBL_Interview_Schedule;

public interface AdminService {
	
	public Object scheduleHrInterview(ITS_TBL_Interview_Schedule interview);
	public Object getHRRating(ITS_TBL_Interview_Schedule interview);
	public Object getTechRating(ITS_TBL_Interview_Schedule interview);
	public Object setInterviewResult(ITS_TBL_Interview_Schedule interview);
	public Object shareInterviewResult(ITS_TBL_Interview_Schedule interview);	
}
