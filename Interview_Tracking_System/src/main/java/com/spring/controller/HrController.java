package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.service.HrService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class HrController {
	@Autowired
	private HrService hrService;

	@GetMapping("/hr")
	public List<ITS_TBL_Interview_Schedule> getAllHrCandidate() {
		return hrService.getAllHrCandidate();
	}
	
	@PostMapping(value = "/hr/{interviewId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String giveHRRating(@RequestBody ITS_TBL_Interview_Schedule its_tbl_interview_schedule,
			@PathVariable(value = "interviewId") String id) {
		return hrService.giveHRRating(its_tbl_interview_schedule, id);
	}

	@GetMapping("/result")
	public List<ITS_TBL_Interview_Schedule> getResult() {
		return hrService.getResult();
	}
}
