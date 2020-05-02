package com.spring.service;

import com.spring.json.ITS_TBL_Interview_Schedule;

public interface AdminService {
	
	public Object getInterviewByInterviewId(long interviewId,String authtoken);
	public Object shareDetails(String candidate_id,String authtoken);
	public Object sendToTech(String candidateId,String date,String time,String interviewerId,String subject,String authtoken);
	public Object getFreeTechInterviewerList(String date,String tim,String authtokene);
	public Object getHRRating(ITS_TBL_Interview_Schedule interview,String authtoken);
	public Object getTechRating(ITS_TBL_Interview_Schedule interview,String authtoken);
	public Object setInterviewResult(ITS_TBL_Interview_Schedule interview,String authtoken);
	public Object shareInterviewResult(ITS_TBL_Interview_Schedule interview,String authtoken);
	public Object sendToHr(long interviewId, String date, String time, String empHRId, String authToken);
	public Object getFreeHrInterviewerList(String date, String time, String authToken);	

} 
