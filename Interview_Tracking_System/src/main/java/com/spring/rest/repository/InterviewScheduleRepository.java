package com.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
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
	
	
}
