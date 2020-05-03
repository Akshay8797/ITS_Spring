package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping(value="/interviewer/{panel}{date}{time}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getFreeInterviewerList(@RequestParam(required=true) String date,
			@RequestParam(required=true) String time,@RequestHeader(name="auth-token") String authToken,@PathVariable(value="panel")String panel){
		if(panel.equalsIgnoreCase("tech"))
		return adminService.getFreeTechInterviewerList(date, time,authToken);
		else if(panel.equalsIgnoreCase("hr"))
		return adminService.getFreeHrInterviewerList(date, time,authToken);
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";			
	}
	
	@PutMapping(value="/toTech",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object sendToTech(@RequestHeader (name="candidateId") String candidateId,@RequestHeader (name="date") String date,@RequestHeader (name="time") String time,@RequestHeader (name="interviewerId") String interviewerId,@RequestHeader (name="subject")String subject,@RequestHeader(name="auth-token") String authToken) {
		return adminService.sendToTech(candidateId, date, time, interviewerId, subject,authToken);
	}
	
	@PutMapping(value="/toHr",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object sendToHr(@RequestHeader (name="interviewId") long interviewId,@RequestHeader (name="date") String date,@RequestHeader (name="time") String time,@RequestHeader (name="empHrId") String empHrId,@RequestHeader(name="auth-token") String authToken) {
		return adminService.sendToHr(interviewId, date, time, empHrId,authToken);
	}
	
	
	@Autowired
	private AdminService microService;
	
	@GetMapping("/rating/{panel}")
	public Object getRatingsByInterviewId(@PathVariable(value="panel")String panel,@RequestBody ITS_TBL_Interview_Schedule interview,@RequestHeader(name="auth-token") String authToken)
	{
		if(panel.equalsIgnoreCase("hr"))
		return microService.getHRRating(interview,authToken);
		else if(panel.equalsIgnoreCase("tech"))
		return microService.getTechRating(interview,authToken);
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";	
	}
	
	@PostMapping(value="/results/set", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object setInterviewResults(@RequestBody ITS_TBL_Interview_Schedule interview,@RequestHeader(name="auth-token") String authToken)
	{
		return microService.setInterviewResult(interview,authToken);
	}
	
	@PostMapping(value="/results/share", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object shareInterviewResults(@RequestBody ITS_TBL_Interview_Schedule interview,@RequestHeader(name="auth-token") String authToken)
	{
		return microService.shareInterviewResult(interview,authToken);
	}

}
