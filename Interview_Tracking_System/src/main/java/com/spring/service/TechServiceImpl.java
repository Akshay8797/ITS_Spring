package com.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.entity.ITS_TBL_Techpanel_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.rest.repository.InterviewScheduleRepository;
import com.spring.rest.repository.TechRepository;
//import com.spring.rest.repository.TechRepository;
import com.spring.utils.InterviewScheduleUtils;

@Service
public class TechServiceImpl implements TechService {

	@Autowired
	private InterviewScheduleRepository interviewCandidateRepo;
	
	@Override
	public List<ITS_TBL_Interview_Schedule> getAllInterviewCandidates() {
		List<ITS_TBL_Interview_Schedule_Entity> interviewCandidateEntityList = interviewCandidateRepo.findByInterviewTimeIsNotNull();
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(interviewCandidateEntityList);				
	}
	
	@Override
	public String giveTechRating(ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id) {
		ITS_TBL_Interview_Schedule_Entity its_tbl_interview_schedule_entity = interviewCandidateRepo.findById(Long.valueOf(id)).get();
		if(its_tbl_interview_schedule_entity.getTechRating()==null) {
			its_tbl_interview_schedule_entity.setTechRating(its_tbl_interview_schedule.getTechRating());
			its_tbl_interview_schedule_entity.setSubject(its_tbl_interview_schedule.getSubject());
			
		 interviewCandidateRepo.save(its_tbl_interview_schedule_entity);
		 return "{\"result\": \"Success \"}";	
		}else {
		return "{\"message\": \"Candidate is already assigned with some tech rating \"}";
		}
	}
	
	@Override
	public List<ITS_TBL_Interview_Schedule> getFinalResultsForTech() {
		List<ITS_TBL_Interview_Schedule_Entity> interviewCandidateEntityList = interviewCandidateRepo.findByShareResultIsNotNull();
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(interviewCandidateEntityList);
		
	}
	
	


}