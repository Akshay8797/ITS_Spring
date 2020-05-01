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
		List<ITS_TBL_Interview_Schedule_Entity> hrcandidateEntityList = interviewCandidateRepo.findAll();
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(hrcandidateEntityList);
	}


}