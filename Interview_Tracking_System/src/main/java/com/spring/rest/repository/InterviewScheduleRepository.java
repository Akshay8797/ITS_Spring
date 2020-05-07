package com.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;

@Component
public interface InterviewScheduleRepository extends JpaRepository<ITS_TBL_Interview_Schedule_Entity, Long>{

	ITS_TBL_Interview_Schedule_Entity findByInterviewId(long interviewId);
	List<ITS_TBL_Interview_Schedule_Entity> findByTechRatingGreaterThan(Float tr);

	

	List<ITS_TBL_Interview_Schedule_Entity> findByEmpHRRatingIsNull();
	List<ITS_TBL_Interview_Schedule_Entity> findByShareResultIsNotNull();
	List<ITS_TBL_Interview_Schedule_Entity> findByInterviewTimeIsNotNull();
	List<ITS_TBL_Interview_Schedule_Entity> findByTechRatingIsNotNull();
	@Query(value="SELECT * FROM ITS_TBL_Interview_Schedule i WHERE i.interview_time is NULL AND i.tech_rating is NULL" ,nativeQuery = true)
	List<ITS_TBL_Interview_Schedule_Entity> findByInterviewTimeIsNullAndfindByTechRatingIsNull();
	
	@Query(value="SELECT * FROM ITS_TBL_Interview_Schedule i WHERE i.emphrinterview_time is NULL AND i.tech_rating >3.0" ,nativeQuery = true)
	List<ITS_TBL_Interview_Schedule_Entity> findByHRInterviewTimeIsNullAndfindByTechRatingIsGreaterThan3();
	
	//List<ITS_TBL_Interview_Schedule_Entity> findByTechRatingGreaterThan(float f);
	
	
}
