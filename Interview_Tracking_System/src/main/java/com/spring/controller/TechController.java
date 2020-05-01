package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.service.TechService;

@RestController
@RequestMapping("/its")
@CrossOrigin(origins="*")
public class TechController {

	@Autowired
	private TechService techService;
	
	@GetMapping("/tech")
	public List<ITS_TBL_Interview_Schedule> getAllInterviewCandidates() {
		return techService.getAllInterviewCandidates();	
	}
	
	@PutMapping(value="/tech/{interviewId}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ITS_TBL_Interview_Schedule giveTechRating(@RequestBody ITS_TBL_Interview_Schedule its_tbl_interview_schedule, @PathVariable(value="interviewId") String id) {
		return techService.giveTechRating(its_tbl_interview_schedule, id);
	}
}
