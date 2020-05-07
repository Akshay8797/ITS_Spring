package com.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.ITS_TBL_User_Profile_Entity;

@Component
public interface CandidateUserProfileRepository  extends JpaRepository<ITS_TBL_User_Profile_Entity, Long> {

}
