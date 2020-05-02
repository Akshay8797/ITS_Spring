package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.ITS_TBL_Hrpanel_Json;
import com.spring.service.HrService;

@RestController
@RequestMapping("/its")
public class HrController {
	@Autowired
	private HrService hrService;
	
	@GetMapping("/hr")
	public List<ITS_TBL_Hrpanel_Json> getAllHrPanel() {
		return hrService.getAllHrPanel();
	}
}
