package com.spring.service;

import com.spring.json.ITS_TBL_Candidate;
import com.spring.json.ITS_TBL_User_Profile_Json;

public interface AdminService {
	
	public Object getInterviewByInterviewId(long interviewId,String authtoken);
	public Object shareDetails(long candidate_id,int number,String panel, String authtoken);
	public Object sendToTech(long candidateId,String date,String time,long interviewerId,String subject,String authtoken);
	public Object getFreeTechInterviewerList(String date,String tim,String authtokene);
	public Object getRatings(long interviewId,String authtoken);
	public Object setInterviewResult(long interviewId,String result,String authtoken);
	public Object shareInterviewResult(long interviewId,int shareResult,String authtoken);
	public Object sendToHr(long interviewId, String date, String time, long empHRId, String authToken);
	public Object getFreeHrInterviewerList(String date, String time, String authToken);	
	public Object getEligibleCandidates();
	public Object getCandidateForTechnical();
	public Object getRatedCandidates();
	public Object addCandidateUserProfile(ITS_TBL_User_Profile_Json candidate,long candidateId,String authToken);
	public Object addCandidate(ITS_TBL_Candidate candidate,String authToken);
	public Object search(ITS_TBL_Candidate candidateProfile,String authToken);
		
	
} 
