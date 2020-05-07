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
				.findByTechRatingGreaterThan((Float) 3f);
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(hrcandidateEntityList);
	}

	@Override
	public String giveHRRating(ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id) {
		ITS_TBL_Interview_Schedule_Entity its_tbl_interview_schedule_entity = hrcandidateRepo.findById(Long.valueOf(id))
				.get();
		if (its_tbl_interview_schedule_entity.getEmpHRRating() == (Float) null
				&& its_tbl_interview_schedule_entity.getTechRating() >= 3f) {
			its_tbl_interview_schedule_entity.setEmpHRRating(its_tbl_interview_schedule.getEmpHRRating());
			its_tbl_interview_schedule_entity = hrcandidateRepo.save(its_tbl_interview_schedule_entity);
			return "{\"Result\" :\" Success\"}";
		} else if (its_tbl_interview_schedule_entity.getEmpHRRating() == (Float) null
				&& its_tbl_interview_schedule_entity.getTechRating() < 3f) {
			return "{\"Result\" :\" Candididate doesn't qualify the Tech Round\"}";
		} else
			return "{\"Result\" :\" Candididate is already assigned with HR Rating\"}";
	}

	@Override
	public List<ITS_TBL_Interview_Schedule> getResult() {
		List<ITS_TBL_Interview_Schedule_Entity> hrCandidateEntityList = hrcandidateRepo.findByShareResultIsNotNull();
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(hrCandidateEntityList);

	}
}
