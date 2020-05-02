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
	private InterviewScheduleRepository hrCandidateRepo;
	
	@Override
	public List<ITS_TBL_Interview_Schedule> getAllHrCandidate() {
		List<ITS_TBL_Interview_Schedule_Entity> hrcandidateEntityList = hrCandidateRepo.findByTechRatingGreaterThan(2.5f);
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(hrcandidateEntityList);
	}
	@Override
	public ITS_TBL_Interview_Schedule giveHRRating(ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id) {
		ITS_TBL_Interview_Schedule_Entity its_tbl_interview_schedule_entity = hrCandidateRepo.findById(Long.valueOf(id)).get();
		if(its_tbl_interview_schedule_entity != null  && its_tbl_interview_schedule_entity.getTechRating()> 2.5f ) {
			its_tbl_interview_schedule_entity.setEmpHRRating(its_tbl_interview_schedule.getEmpHRRating());
			its_tbl_interview_schedule_entity = hrCandidateRepo.save(its_tbl_interview_schedule_entity);
			return InterviewScheduleUtils.convertScheduleEntityToSchedule(its_tbl_interview_schedule_entity);
		}
		else {
			return null;
		}
	}
	@Override
	public List<ITS_TBL_Interview_Schedule> getResult() {
		List<ITS_TBL_Interview_Schedule_Entity> hrResultList = hrCandidateRepo.findByShareResultIsNotNull();
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(hrResultList);
		}
}
