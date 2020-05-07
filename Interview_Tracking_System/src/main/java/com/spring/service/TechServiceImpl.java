package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.entity.ITS_TBL_Techpanel_Entity;
import com.spring.entity.ITS_TBL_User_Credentials_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.rest.repository.InterviewScheduleRepository;
import com.spring.rest.repository.TechpanelRepository;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.InterviewScheduleUtils;

@Service
public class TechServiceImpl implements TechService {
	
	@Autowired
	private TechpanelRepository techRepository;
	@Autowired
	private InterviewScheduleRepository interviewCandidateRepo;
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public List<ITS_TBL_Techpanel_Entity> getAllTechPanelCheck() {
		return techRepository.findAll();
	}
	
	@Override
	public Object getAllTechPanel(String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		return techRepository.findAll();
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}

	
	
	
	@Override
	public Object getAllInterviewCandidates(String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		List<ITS_TBL_Interview_Schedule_Entity> interviewCandidateEntityList = interviewCandidateRepo.findByInterviewTimeIsNotNullAndfindByTechRatingIsNull();
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(interviewCandidateEntityList);	
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}

	
	
	@Override
	public Object giveTechRating(ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity its_tbl_interview_schedule_entity = interviewCandidateRepo.findById(Long.valueOf(id)).get();
		if(its_tbl_interview_schedule_entity.getTechRating()==0.0) {
			its_tbl_interview_schedule_entity.setTechRating(its_tbl_interview_schedule.getTechRating());
			its_tbl_interview_schedule_entity.setSubject(its_tbl_interview_schedule.getSubject());
			
		 interviewCandidateRepo.save(its_tbl_interview_schedule_entity);
		 return "{\"result\": \"Success \"}";	
		}else {
		return "{\"message\": \"Candidate is already assigned with some tech rating \"}";
		}
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		

	}
	
	@Override
	public Object getFinalResultsForTech(String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		List<ITS_TBL_Interview_Schedule_Entity> interviewCandidateEntityList = interviewCandidateRepo.findByCheckShareResult();
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(interviewCandidateEntityList);
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";

	}
	
}
