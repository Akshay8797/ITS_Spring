package com.spring.rest.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.entity.ITS_TBL_Techpanel_Entity;

public interface TechRepository extends JpaRepository<ITS_TBL_Techpanel_Entity, Long>{

	List<ITS_TBL_Techpanel_Entity> findByTechId(long interviewerId);
	
}



