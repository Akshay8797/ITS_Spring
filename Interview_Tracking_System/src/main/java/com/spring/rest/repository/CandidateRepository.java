package com.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.ITS_TBL_Candidate_Entity;

@Component
public interface CandidateRepository extends JpaRepository<ITS_TBL_Candidate_Entity, Long>{




	
	
}