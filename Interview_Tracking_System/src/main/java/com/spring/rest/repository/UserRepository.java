package com.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.ITS_TBL_User_Credentials_Entity;

@Component
public interface UserRepository extends JpaRepository<ITS_TBL_User_Credentials_Entity, Long> {

	List<ITS_TBL_User_Credentials_Entity> findByuserid(String userid);

	List<ITS_TBL_User_Credentials_Entity> findBysessionId(String sessionId);

}
