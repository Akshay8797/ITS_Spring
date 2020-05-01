package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
	
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.service.AdminService;

@RestController
@RequestMapping("/admin")

	public class AdminController {
	
	@Autowired
	private AdminService microService;
	
	@PostMapping(value="/scheduleHRInterview", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object scheduleHRInterview(@RequestBody ITS_TBL_Interview_Schedule interview,@RequestHeader(name="auth-token") String authToken)
	{
		return microService.scheduleHrInterview(interview);
	}
	
	@GetMapping("/rating/{panel}")
	public Object getRatingsByInterviewId(@PathVariable(value="panel")String panel,@RequestBody ITS_TBL_Interview_Schedule interview)
	{
		if(panel.equalsIgnoreCase("hr"))
		return microService.getHRRating(interview);
		else if(panel.equalsIgnoreCase("tech"))
		return microService.getTechRating(interview);
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Path variable\"}";	
	}
	
	@PostMapping(value="/results/set", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object setInterviewResults(@RequestBody ITS_TBL_Interview_Schedule interview,@RequestHeader(name="auth-token") String authToken)
	{
		return microService.setInterviewResult(interview);
	}
	
	@PostMapping(value="/results/share", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object shareInterviewResults(@RequestBody ITS_TBL_Interview_Schedule interview,@RequestHeader(name="auth-token") String authToken)
	{
		return microService.shareInterviewResult(interview);
	}
	
}
