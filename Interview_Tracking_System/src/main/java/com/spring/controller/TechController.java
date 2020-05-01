package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
