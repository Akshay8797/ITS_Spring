package com.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.ITS_TBL_Candidate_Entity;
import com.spring.json.ITS_TBL_Candidate;

public class CandidateUtils {
			
		public static List<ITS_TBL_Candidate> convertCandidateEntityListToCandidateList(List<ITS_TBL_Candidate_Entity> candidateEntityList) {
			List<ITS_TBL_Candidate> candidateList = new ArrayList<ITS_TBL_Candidate>();
			Consumer<ITS_TBL_Candidate_Entity> consumer = (ITS_TBL_Candidate_Entity candidateEntity)->candidateList.add(convertCandidateEntityToCandidate(candidateEntity));
			candidateEntityList.stream().forEach(consumer);
			return candidateList;
		}
		
		public static ITS_TBL_Candidate convertCandidateEntityToCandidate(ITS_TBL_Candidate_Entity candidateEntity) {
			return new ITS_TBL_Candidate(candidateEntity.getCandidateId(),candidateEntity.getPrimarySkills(), candidateEntity.getSecondarySkills()
					, candidateEntity.getExperience(), candidateEntity.getQualification(),candidateEntity.getDesignation(),
					candidateEntity.getNoticePeriod(),candidateEntity.getLocation(),candidateEntity.getShareDetails());
		}

		public static ITS_TBL_Candidate_Entity convertCandidateToCandidateEntity(ITS_TBL_Candidate candidate) {
			return new ITS_TBL_Candidate_Entity(candidate.getCandidateId(),candidate.getPrimarySkills(),candidate.getSecondarySkills(), 
					candidate.getExperience(), candidate.getQualification(),candidate.getDesignation(),
					candidate.getNoticePeriod(),candidate.getLocation(),candidate.getShareDetails());

		}
		
		
	


}