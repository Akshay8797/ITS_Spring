package com.spring.service;

import com.spring.json.ITS_TBL_Interview_Schedule;

public interface AdminService {
	
	public ITS_TBL_Interview_Schedule getInterviewByInterviewId(String interviewId);
}
