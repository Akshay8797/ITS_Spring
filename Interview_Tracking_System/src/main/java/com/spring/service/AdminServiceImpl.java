package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.rest.repository.InterviewScheduleRepository;
import com.spring.utils.InterviewScheduleUtils;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private InterviewScheduleRepository schdeduleRepository;

	@Override
	public ITS_TBL_Interview_Schedule getInterviewByInterviewId(String interviewId) {
		
		return InterviewScheduleUtils.convertScheduleEntityToSchedule(
				schdeduleRepository.findByInterviewId(interviewId));
	}
}
