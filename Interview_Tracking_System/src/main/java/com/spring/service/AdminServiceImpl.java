package com.spring.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Candidate_Entity;
import com.spring.entity.ITS_TBL_Hrpanel_Entity;
import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.entity.ITS_TBL_Techpanel_Entity;
import com.spring.entity.ITS_TBL_User_Credentials_Entity;
import com.spring.entity.ITS_TBL_User_Profile_Entity;
import com.spring.json.ITS_TBL_Candidate;
import com.spring.json.ITS_TBL_User_Profile_Json;
import com.spring.rest.repository.CandidateRepository;
import com.spring.rest.repository.CandidateUserProfileRepository;
import com.spring.rest.repository.HrpanelRepository;
import com.spring.rest.repository.InterviewScheduleRepository;
import com.spring.rest.repository.TechpanelRepository;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.CandidateUtils;
import com.spring.utils.HrPanelUtils;
import com.spring.utils.InterviewScheduleUtils;
import com.spring.utils.TechPanelUtils;
import com.spring.utils.UserProfileUtils;
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
	private CandidateUserProfileRepository userProfilerepo;
	
	@Autowired
	private InterviewScheduleRepository interviewScheduleRepository;
	
	/*USE FOR TEST-ADD CANDIDATE
	
	"primarySkills":"Coder",
	"secondarySkills":"Coder",
	"experience":"2",
	"qualification":"Coder",
	"designation":"Coder",
	"noticePeriod":"3",
	"location":"Coder"
	USE FOR TEST-ADD CANDIDATE USER profile
	
	"firstName":"Arka",
	"lastName":"Arka",
	"dateOfBirth":"2020-02-01",
	"gender":"male",
	"street":"Bally",
	"location":"Bally",
	"city":"Bally",
	"state":"WB",
	"pincode":"711201",
	"mobileNo":"9002828",
	"emailId":"garnasdkjas@gmail.com"	
	
	 * /
	/*------------------------------Add candidate and user profile---------------------------------*/
	@Override
	public Object addCandidate(ITS_TBL_Candidate candidate,String authToken) {
     List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Candidate_Entity newCandidate=new ITS_TBL_Candidate_Entity();
		newCandidate.setPrimarySkills(candidate.getPrimarySkills());
		newCandidate.setSecondarySkills(candidate.getSecondarySkills());
		newCandidate.setExperience(candidate.getExperience());
		newCandidate.setQualification(candidate.getQualification());
		newCandidate.setDesignation(candidate.getDesignation());
		newCandidate.setNoticePeriod(candidate.getNoticePeriod());
		newCandidate.setLocation(candidate.getLocation());
		newCandidate.setShareDetails(0);
		ITS_TBL_Candidate_Entity enti=candidateRepository.save(newCandidate);
		 long id=enti.getCandidateId();
		return id;
		}
		else
		{
			  return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";	
		}
	}
	@Override
	public Object addCandidateUserProfile(ITS_TBL_User_Profile_Json candidate,long candidateId,String authToken)
	{
List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		
		if(userList!=null && userList.size()!=0)
		{
		List<ITS_TBL_Candidate_Entity> candidate_Entity=candidateRepository.findByCandidateId(candidateId);
		ITS_TBL_Candidate_Entity candidateSelect=candidate_Entity.get(0);
		ITS_TBL_User_Profile_Entity newCandidateProfile=new ITS_TBL_User_Profile_Entity();
		newCandidateProfile.setCandidate(candidateSelect);
		newCandidateProfile.setFirstName(candidate.getFirstName());
		newCandidateProfile.setLastName(candidate.getLastName());
		newCandidateProfile.setDateOfBirth(candidate.getDateOfBirth());
		newCandidateProfile.setGender(candidate.getGender());
		newCandidateProfile.setStreet(candidate.getStreet());
		newCandidateProfile.setLocation(candidate.getLocation());
		newCandidateProfile.setCity(candidate.getCity());
		newCandidateProfile.setState(candidate.getState());
		newCandidateProfile.setPincode(candidate.getPincode());
		newCandidateProfile.setMobileNo(candidate.getMobileNo());
		newCandidateProfile.setEmailId(candidate.getEmailId());
		candidateSelect.setUser(newCandidateProfile);
		userProfilerepo.save(newCandidateProfile);
		return CandidateUtils.convertCandidateEntityToCandidate(candidateSelect);
		}
		else
		{
		  return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}
		
	}
	
	public Object search(ITS_TBL_Candidate candidateProfile,String authToken)
	{
	List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		
		if(userList!=null && userList.size()!=0)
		{
	 String qualification=candidateProfile.getQualification();
	 String skills=candidateProfile.getPrimarySkills();
	 int experience=candidateProfile.getExperience();
	 List<ITS_TBL_Candidate_Entity> listcan=candidateRepository.findByQualificationAndPrimarySkillsAndExperience(qualification, skills,experience);
	 
	 return UserProfileUtils.convertUserEntityListToUserList(listcan);
		}
		else
		{
		  return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}

	}
	/*------------------------------------------------------------------------------------------------------*/
	
	/*--------Rated Candidates---------*/
	@Override
	public Object getRatedCandidates() {
		List<ITS_TBL_Interview_Schedule_Entity> interviewList=schdeduleRepository.findAll();
		List<ITS_TBL_Interview_Schedule_Entity> eligibleList= interviewList.stream()
				.filter(interview->interview.getTechRating()>=0&&interview.getEmpHRRating()>=0).collect(Collectors.toList());
		List<Long> eligibleCandidateInterviewIdList=new ArrayList<Long>();
		List<String> noEligibleCandidateInterviewIdList=new ArrayList<String>();
		noEligibleCandidateInterviewIdList.add("No eligible candidates");
		for(int i=0;i<eligibleList.size();i++)
		{
				eligibleCandidateInterviewIdList.add(eligibleList.get(i).getInterviewId());
			
		}
		
		if(eligibleCandidateInterviewIdList.size()!=0)
		{
		return eligibleCandidateInterviewIdList;
		}
		else
		return noEligibleCandidateInterviewIdList;
		
	}
	
	/*--------AD-003------------*/
	@Override
	public Object shareDetails(long id,int number,String panel,String authToken) {
	List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
	System.out.print(number);
	if(userList!=null && userList.size()!=0)
	{
	if(panel.equalsIgnoreCase("tech"))
	{
		ITS_TBL_Candidate_Entity  candidateEntity= candidateRepository.findByCandidateId(id).get(0);
		candidateEntity.setShareDetails(Integer.valueOf(number));
		ITS_TBL_Candidate_Entity  candidateEntity_new=candidateRepository.save(candidateEntity);
		return CandidateUtils.convertCandidateEntityToCandidate(candidateEntity_new);
	}
		else if(panel.equalsIgnoreCase("hr"))
		{
			ITS_TBL_Interview_Schedule_Entity interview=interviewScheduleRepository.findByInterviewId(id);
			ITS_TBL_Candidate_Entity  candidateEntity=interview.getCandidateEntity();
			candidateEntity.setShareDetails(Integer.valueOf(number));
			ITS_TBL_Candidate_Entity  candidateEntity_new=candidateRepository.save(candidateEntity);
			return CandidateUtils.convertCandidateEntityToCandidate(candidateEntity_new);
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
	}
	else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
	}
	/*--------------------------*/
	
	/*-----------------------------------GET FREE PANEL--------------------------------------*/
	
	/*-------------------------------------FOR TECH------------------------------------------*/
	@Override
	public Object getFreeTechInterviewerList(String date,String time,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate=LocalDate.parse(date,newPattern);
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
	
	/*------------------------GET ELIGIBLE CANDIDATES FOR TECHNICAL INTERVIEW-------------------------------------------------*/
	
	public Object getCandidateForTechnical() {
		List<ITS_TBL_Candidate_Entity> allCandidates=candidateRepository.findAll();
		List<ITS_TBL_Candidate_Entity> eligibleCandidates = new ArrayList<ITS_TBL_Candidate_Entity>();
		allCandidates.stream().forEach(p -> {
			if(p.getInterviewScheduleList().size()==0) {
				if(!eligibleCandidates.contains(p))  
					eligibleCandidates.add(p);
			}
		});
		
		return CandidateUtils.convertCandidateEntityListToCandidateList(eligibleCandidates);
	}
	
	/*----------------------------------------------FOR FREE HR PANEL---------------------------------------------------------------------*/

	@Override
	public Object getFreeHrInterviewerList(String date,String time,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate=LocalDate.parse(date,newPattern);
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
		
	/*------------------------------------------------------------------------------------------------------------------------------*/

	/*--------------------------------------------------AD-004---------------------------------------------------------------------*/
	@Override
	public Object sendToTech(long candidateId,String date,String time,long interviewerId,String subject,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity newInterview= new ITS_TBL_Interview_Schedule_Entity();
		DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate=LocalDate.parse(date,newPattern);
		LocalTime localTime=LocalTime.parse(time);
		newInterview.setCandidateEntity(candidateRepository.findByCandidateId(candidateId).get(0));
		newInterview.setInterviewDate(localDate);
		newInterview.setInterviewTime(localTime);
		newInterview.setTechEntity(techRepository.findByTechId(interviewerId).get(0));
		newInterview.setSubject(subject);
		interviewScheduleRepository.save(newInterview);
		return InterviewScheduleUtils.convertScheduleEntityToSchedule(newInterview);		
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		
	}
	/*------------------------------------------------------------------------------------------------------------------------------*/
	
	/*--------------------------------------------------GET TECH CLEARED-----------------------------------------------------------*/
	public Object getEligibleCandidates() {
		List<ITS_TBL_Interview_Schedule_Entity> interviewList=schdeduleRepository.findAll();
		List<ITS_TBL_Interview_Schedule_Entity> eligibleList= interviewList.stream().filter(interview->interview.getTechRating()>3).collect(Collectors.toList());
		List<Long> eligibleCandidateInterviewIdList=new ArrayList<Long>();
		List<String> noEligibleCandidateInterviewIdList=new ArrayList<String>();
		noEligibleCandidateInterviewIdList.add("No eligible candidates");
		for(int i=0;i<eligibleList.size();i++)
		{
			if(eligibleList.get(i).getHrEntity()==null)
			{
				eligibleCandidateInterviewIdList.add(eligibleList.get(i).getInterviewId());
			}
		}
		
		if(eligibleCandidateInterviewIdList.size()!=0)
		{
		return eligibleCandidateInterviewIdList;
		}
		else
		return noEligibleCandidateInterviewIdList;
	}
	/*--------------------------------------------------------------------------------------------------------------------------*/
	
	
	/*---------------------------------------------------AD-005-----------------------------------------------------------------*/
	@Override
	public Object sendToHr(long interviewId,String date,String time,long empHRId,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		ITS_TBL_Interview_Schedule_Entity newInterview= schdeduleRepository.findByInterviewId(interviewId);
		int checkTechclear=newInterview.getTechRating();
		if(userList!=null && userList.size()!=0 && newInterview!=null)
		{
		if(checkTechclear>3)
		{
		DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate=LocalDate.parse(date,newPattern);
		LocalTime localTime=LocalTime.parse(time);
		newInterview.setEmpHRInterviewDate(localDate);
		newInterview.setEmpHRInterviewTime(localTime);
		newInterview.setHrEntity(hrRepository.findByempHrId(empHRId).get(0));
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
	/*--------------------------------------------------------------------------------------------------------------------------*/
	
	/*---------------------------------------------------AD-006-----------------------------------------------------------------*/
	
	/*-------------------------------------Get Ratings------------------------------------------*/
	@Override
	public Object getRatings(long interviewId,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interviewId);
		return "{\"TechRating\": "+scheduleEntity.getTechRating()+",\"HrRating\": "+scheduleEntity.getEmpHRRating()+"}";
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
	}
		
	
	/*---------------------------------------------------AD-007-----------------------------------------------------------------*/
	public Object setInterviewResult(long interviewId,String result,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interviewId);
		 scheduleEntity.setResult(result);
		 interviewScheduleRepository.save(scheduleEntity);	
		 return InterviewScheduleUtils.convertScheduleEntityToSchedule(scheduleEntity);
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
	}
	/*--------------------------------------------------------------------------------------------------------------------------*/
	

	/*---------------------------------------------------AD-008-----------------------------------------------------------------*/
	public Object shareInterviewResult(long interviewId,int shareResult,String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interviewId);
		 scheduleEntity.setShareResult(shareResult);
		 return interviewScheduleRepository.save(scheduleEntity);		
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
		
	}
	/*--------------------------------------------------------------------------------------------------------------------------*/

	
	
	@Override
	public Object getInterviewByInterviewId(long interviewId,String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
			return InterviewScheduleUtils.convertScheduleEntityToSchedule(schdeduleRepository.findByInterviewId(interviewId));
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}

}
