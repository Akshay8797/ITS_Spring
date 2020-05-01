package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;

import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.rest.repository.InterviewScheduleRepository;
import com.spring.utils.InterviewScheduleUtils;


@Service
public class TechServiceImpl implements TechService {

	@Autowired
	private InterviewScheduleRepository interviewCandidateRepo;
	
	

	@Override
	public List<ITS_TBL_Interview_Schedule> getAllInterviewCandidates() {
		List<ITS_TBL_Interview_Schedule_Entity> interviewCandidateEntityList = interviewCandidateRepo.findAll();
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(interviewCandidateEntityList);
		
	}



	@Override
	public ITS_TBL_Interview_Schedule giveTechRating(ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id) {
		ITS_TBL_Interview_Schedule_Entity its_tbl_interview_schedule_entity = interviewCandidateRepo.findById(Long.valueOf(id)).get();
		if(its_tbl_interview_schedule_entity != null) {
			its_tbl_interview_schedule_entity.setTechRating(its_tbl_interview_schedule.getTechRating());;
			its_tbl_interview_schedule_entity.setSubject(its_tbl_interview_schedule.getSubject());;
			
			its_tbl_interview_schedule_entity = interviewCandidateRepo.save(its_tbl_interview_schedule_entity);
			return InterviewScheduleUtils.convertScheduleEntityToSchedule(its_tbl_interview_schedule_entity);
		}
		return null;
	}


}