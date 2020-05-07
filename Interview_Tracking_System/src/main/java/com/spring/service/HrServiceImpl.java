package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Hrpanel_Entity;
import com.spring.rest.repository.HrpanelRepository;
@Service
public class HrServiceImpl implements HrService{
	
		@Autowired
		private HrpanelRepository hrRepository;

		@Override
		public List<ITS_TBL_Hrpanel_Entity> getAllHrPanel() {
			// TODO Auto-generated method stub
			return hrRepository.findAll();
		}
		}
		
		

