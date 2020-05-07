package com.spring.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.*;
import com.spring.json.*;

public class UserProfileUtils {

	public static List<ITS_TBL_Candidate> convertUserEntityListToUserList(List<ITS_TBL_Candidate_Entity> candidateEntityList) {
		final List<ITS_TBL_Candidate> candidateList = new ArrayList<ITS_TBL_Candidate>();
		Consumer<ITS_TBL_Candidate_Entity> consumer = (ITS_TBL_Candidate_Entity candidateEntity)->candidateList.add(convertCandidateProfileEntityToCandidateProfile(candidateEntity));
		
		
		//consumer=((ITS_TBL_Candidate_Entity candidateEntity)->candidateList.add(convertCandidateProfileEntityToUserProfile(candidateEntity)));
		candidateEntityList.stream().forEach(consumer);
		return candidateList;
	}

	

public static ITS_TBL_Candidate convertCandidateProfileEntityToCandidateProfile(ITS_TBL_Candidate_Entity candidateProfile)
{
	
	return new ITS_TBL_Candidate(candidateProfile.getCandidateId(),candidateProfile.getPrimarySkills(),candidateProfile.getSecondarySkills(),candidateProfile.getExperience(),
			candidateProfile.getQualification(),candidateProfile.getDesignation(),candidateProfile.getNoticePeriod(),
			candidateProfile.getLocation(),candidateProfile.getShareDetails());
}

	
	

}
	
