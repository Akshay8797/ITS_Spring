package com.spring.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Candidate_Entity;
import com.spring.entity.ITS_TBL_Hrpanel_Entity;
import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.entity.ITS_TBL_Techpanel_Entity;
import com.spring.entity.ITS_TBL_User_Credentials_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.rest.repository.CandidateRepository;
import com.spring.rest.repository.HrpanelRepository;
import com.spring.rest.repository.InterviewScheduleRepository;
import com.spring.rest.repository.TechpanelRepository;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.CandidateUtils;
import com.spring.utils.HrPanelUtils;
import com.spring.utils.InterviewScheduleUtils;
import com.spring.utils.TechPanelUtils;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private InterviewScheduleRepository schdeduleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private CandidateRepository candidateRepository;
	
	@Autowired
	private TechService techService;
	
	@Autowired
	private TechpanelRepository techRepository;
	
	@Autowired
	private HrpanelRepository hrRepository;
	
	@Autowired
	private HrService hrservice;
	
	
	@Autowired
	private InterviewScheduleRepository interviewScheduleRepository;
	
	@Override
	public Object getInterviewByInterviewId(long interviewId,String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList.get(0).getUserType().equalsIgnoreCase("Admin"))
		{
			return InterviewScheduleUtils.convertScheduleEntityToSchedule(schdeduleRepository.findByInterviewId(interviewId));
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}

	@Override
	public Object shareDetails(String candidate_id,String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList.get(0).getUserType().equalsIgnoreCase("Admin"))
		{
		ITS_TBL_Candidate_Entity  candidateEntity= candidateRepository.findByCandidateId(candidate_id).get(0);
		candidateEntity.setShareDetails(3);
		ITS_TBL_Candidate_Entity  candidateEntity_new=candidateRepository.save(candidateEntity);
		return CandidateUtils.convertCandidateEntityToCandidate(candidateEntity_new);
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}
	
	
	@Override
	public Object sendToTech(String candidateId,String date,String time,String interviewerId,String subject,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.get(0).getUserType().equalsIgnoreCase("Admin"))
		{
		ITS_TBL_Interview_Schedule_Entity newInterview= new ITS_TBL_Interview_Schedule_Entity();
		LocalDate localDate=LocalDate.parse(date);
		LocalTime localTime=LocalTime.parse(time);
		newInterview.setCandidateEntity(candidateRepository.findByCandidateId(candidateId).get(0));
		newInterview.setInterviewDate(localDate);
		newInterview.setInterviewTime(localTime);
		newInterview.setTechEntity(techRepository.findByTechId(Long.valueOf(interviewerId)).get(0));
		newInterview.setSubject(subject);
		interviewScheduleRepository.save(newInterview);
		return InterviewScheduleUtils.convertScheduleEntityToSchedule(newInterview);		
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		
	}
	
	@Override
	public Object sendToHr(long interviewId,String date,String time,String empHRId,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList.get(0).getUserType().equalsIgnoreCase("Admin"))
		{
		ITS_TBL_Interview_Schedule_Entity newInterview= schdeduleRepository.findByInterviewId(interviewId);
		int checkTechclear=newInterview.getTechRating();
		if(checkTechclear>3)
		{
		LocalDate localDate=LocalDate.parse(date);
		LocalTime localTime=LocalTime.parse(time);
		newInterview.setEmpHRInterviewDate(localDate);
		newInterview.setEmpHRInterviewTime(localTime);
		newInterview.setHrEntity(hrRepository.findByempHrId(Long.valueOf(empHRId)).get(0));
		interviewScheduleRepository.save(newInterview);
		return InterviewScheduleUtils.convertScheduleEntityToSchedule(newInterview);		
		}
		else
		{
		return "{\"result\": \"failure\",\"message\": \"Candidate not eligile\"}";
		}
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		
	}
	
	
	@Override
	public Object getFreeTechInterviewerList(String date,String time,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null)
		{
		LocalDate localDate=LocalDate.parse(date);
		LocalTime localTime=LocalTime.parse(time);
		List<ITS_TBL_Techpanel_Entity> interviewList = new ArrayList<ITS_TBL_Techpanel_Entity>();
		List<ITS_TBL_Techpanel_Entity> techPanelList=techService.getAllTechPanel();
		techPanelList.stream().forEach(p1-> {
			
			if(p1.getInterviewScheduleList().size()==0)
			{
				if(!interviewList.contains(p1))  
					interviewList.add(p1);
			}
			else 
			{   
				Predicate<ITS_TBL_Interview_Schedule_Entity> pre=p->{
					//System.out.println(Math.abs(ChronoUnit.MINUTES.between(localTime, p.getInterviewTime())));
					if(p.getInterviewDate().equals(localDate)&&Math.abs(ChronoUnit.MINUTES.between(localTime, p.getInterviewTime()))<=119) {
						return true;
					}
					
					else
					{
						return false;
					}
				};
				if(!p1.getInterviewScheduleList().stream().filter(pre).findAny().isPresent())
				{
					interviewList.add(p1);
				}
				
			}
		});
		return TechPanelUtils.convertTechpanelToTechpanelList(interviewList) ;
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
	}
	
	@Override
	public Object getFreeHrInterviewerList(String date,String time,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null)
		{
		LocalDate localDate=LocalDate.parse(date);
		LocalTime localTime=LocalTime.parse(time);
		List<ITS_TBL_Hrpanel_Entity> interviewList = new ArrayList<ITS_TBL_Hrpanel_Entity>();
		List<ITS_TBL_Hrpanel_Entity> HrPanelList=hrservice.getAllHrPanel();
		HrPanelList.stream().forEach(p1-> {
			
			if(p1.getInterviewScheduleList().size()==0)
			{
				if(!interviewList.contains(p1))  
					interviewList.add(p1);
			}
			else 
			{   
				Predicate<ITS_TBL_Interview_Schedule_Entity> pre=p->{
					System.out.println((p1.getEmpHrName()));
					if(p.getEmpHRInterviewDate().equals(localDate)&&Math.abs(ChronoUnit.MINUTES.between(localTime, p.getEmpHRInterviewTime()))<=119) {
						return true;
					}
					else
					{
						return false;
					}
				};
				if(!p1.getInterviewScheduleList().stream().filter(pre).findAny().isPresent())
				{
					interviewList.add(p1);
				}
				
			}
		});
		return HrPanelUtils.convertHrpanelEntityListToHrpanelList(interviewList) ;
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
	}
	
	
	
	@Override
	public Object getHRRating(ITS_TBL_Interview_Schedule interview,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interview.getInterviewId());
			return scheduleEntity.getEmpHRRating();
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
		
		
	}
	@Override
	public Object getTechRating(ITS_TBL_Interview_Schedule interview,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interview.getInterviewId());
			return scheduleEntity.getTechRating();
			
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
	}
	
	public Object setInterviewResult(ITS_TBL_Interview_Schedule interview,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interview.getInterviewId());
		 scheduleEntity.setResult(interview.getResult());
		 return interviewScheduleRepository.save(scheduleEntity);		
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
	}
	
	public Object shareInterviewResult(ITS_TBL_Interview_Schedule interview,String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interview.getInterviewId());
		 scheduleEntity.setShareResult(interview.getShareResult());
		 return interviewScheduleRepository.save(scheduleEntity);		
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
		
	}

}
