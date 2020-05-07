package com.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.ITS_TBL_Techpanel_Entity;

@Component
public interface TechpanelRepository extends JpaRepository<ITS_TBL_Techpanel_Entity, Long>{

	
	List<ITS_TBL_Techpanel_Entity> findByTechId(long interviewerId);
	
	
}
