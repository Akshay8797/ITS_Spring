package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.rest.repository.InterviewScheduleRepository;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private InterviewScheduleRepository scheduleRepository;
	
	@Override
	public Object scheduleHrInterview(ITS_TBL_Interview_Schedule interview) {
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=scheduleRepository.findByInterviewId(interview.getInterviewId());
		if (scheduleEntity!=null) 
			{
			scheduleEntity.setEmpHRInterviewDate(interview.getEmpHRInterviewDate());
			scheduleEntity.setEmpHRInterviewTime(interview.getInterviewTime());
			return scheduleRepository.save(scheduleEntity);
			}
			else
				return "{\"result\": \"failure\",\"message\": \"Invalid request\"}";
			
		}
	
	@Override
	public Object getHRRating(ITS_TBL_Interview_Schedule interview)
	{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=scheduleRepository.findByInterviewId(interview.getInterviewId());
		if (scheduleEntity!=null) 
			{
			return scheduleEntity.getEmpHRRating();
			}
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
	}
	@Override
	public Object getTechRating(ITS_TBL_Interview_Schedule interview)
	{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=scheduleRepository.findByInterviewId(interview.getInterviewId());
		if (scheduleEntity!=null) 
			{
			return scheduleEntity.getTechRating();
			}
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
	}
	
	public Object setInterviewResult(ITS_TBL_Interview_Schedule interview)
	{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=scheduleRepository.findByInterviewId(interview.getInterviewId());
		if (scheduleEntity!=null) 
		{
		 scheduleEntity.setResult(interview.getResult());
		 return scheduleRepository.save(scheduleEntity);		
		}
	return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
	}
	
	public Object shareInterviewResult(ITS_TBL_Interview_Schedule interview) {
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=scheduleRepository.findByInterviewId(interview.getInterviewId());
		if (scheduleEntity!=null) 
		{
		 scheduleEntity.setShareResult(interview.getShareResult());
		 return scheduleRepository.save(scheduleEntity);		
		}
	return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		
	}
		
	
}
