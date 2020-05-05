package com.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;

@Component
public interface InterviewScheduleRepository extends JpaRepository<ITS_TBL_Interview_Schedule_Entity, Long>{

	ITS_TBL_Interview_Schedule_Entity findByInterviewId(String interviewId);
	List<ITS_TBL_Interview_Schedule_Entity> findByShareResultIsNotNull();
	List<ITS_TBL_Interview_Schedule_Entity> findByTechRatingIsNull();
	


	
	
}