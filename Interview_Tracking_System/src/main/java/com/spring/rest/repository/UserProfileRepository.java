package com.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ITS_TBL_User_Profile_Entity;

public interface UserProfileRepository  extends JpaRepository<ITS_TBL_User_Profile_Entity,Long> {

}
