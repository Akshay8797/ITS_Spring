package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Techpanel_Entity;
import com.spring.rest.repository.TechpanelRepository;

@Service
public class TechServiceImpl implements TechService {
	
	@Autowired
	private TechpanelRepository techRepository;
	
	@Override
	public List<ITS_TBL_Techpanel_Entity> getAllTechPanel() {
		return techRepository.findAll();
	}
	
}
