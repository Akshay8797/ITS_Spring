package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.service.HrService;

@RestController
@RequestMapping("/hr")
@CrossOrigin(origins = "*")
public class HrController {
	@Autowired
	private HrService hrService;

	@GetMapping("/")
	public Object getAllHrCandidate(@RequestHeader(name="auth-token") String authToken) {
		return hrService.getAllHrCandidate(authToken);
	}
	
	@PostMapping(value = "/{interviewId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object giveHRRating(@RequestBody ITS_TBL_Interview_Schedule its_tbl_interview_schedule,
			@PathVariable(value = "interviewId") String id,@RequestHeader(name="auth-token") String authToken) {
		return hrService.giveHRRating(its_tbl_interview_schedule, id,authToken);
	}

	@GetMapping("/result")
	public Object getResult(@RequestHeader(name="auth-token") String authToken) {
		return hrService.getResult(authToken);
	}
}
