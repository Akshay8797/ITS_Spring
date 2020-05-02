package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.rest.repository.InterviewScheduleRepository;
import com.spring.utils.InterviewScheduleUtils;

@Service
public class HrServiceImpl implements HrService {

	@Autowired
	private InterviewScheduleRepository hrcandidateRepo;
	
	@Override
	public List<ITS_TBL_Interview_Schedule> getAllHrCandidate() {
		List<ITS_TBL_Interview_Schedule_Entity> hrcandidateEntityList = hrcandidateRepo
				.findByTechRatingGreaterThan((Float)0.5f);
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(hrcandidateEntityList);
	}

}
