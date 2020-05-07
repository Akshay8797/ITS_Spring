package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Hrpanel_Entity;
import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.entity.ITS_TBL_User_Credentials_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.rest.repository.HrpanelRepository;
import com.spring.rest.repository.InterviewScheduleRepository;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.InterviewScheduleUtils;

@Service
public class HrServiceImpl implements HrService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private InterviewScheduleRepository hrcandidateRepo;
	@Override
	public Object getAllHrCandidate(String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		List<ITS_TBL_Interview_Schedule_Entity> hrcandidateEntityList = hrcandidateRepo
				.findByTechRatingGreaterThan((Float) 3f);
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(hrcandidateEntityList);
		}
			else
			{
				  return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";	
			}	
	}

	@Override
	public Object giveHRRating(ITS_TBL_Interview_Schedule its_tbl_interview_schedule, String id,String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
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
		else
		{
			  return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";	
		}	
	}

	@Override
	public Object getResult(String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		List<ITS_TBL_Interview_Schedule_Entity> hrCandidateEntityList = hrcandidateRepo.findByCheckShareHrResult();
		return InterviewScheduleUtils.convertScheduleEntityListToScheduleList(hrCandidateEntityList);
		}
		else
		{
			  return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";	
		}	
	}

	@Autowired
	private HrpanelRepository hrRepository;

	@Override
	public List<ITS_TBL_Hrpanel_Entity> getAllHrPanels() {
		return hrRepository.findAll();
	}

	@Override
	public Object getAllHrPanel(String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		return hrRepository.findAll();
		}
		else
		{
			  return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";	
		}	
			}
}
