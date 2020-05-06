package com.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.ITS_TBL_USER_CREDENTIALS_ENTITY;

@Component
public interface UserRepository extends JpaRepository<ITS_TBL_USER_CREDENTIALS_ENTITY, String> {

	ITS_TBL_USER_CREDENTIALS_ENTITY findByuserid(String userid);

	ITS_TBL_USER_CREDENTIALS_ENTITY findBysessionid(String authToken);

}
