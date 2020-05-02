package com.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ITS_TBL_Hrpanel_Entity;

public interface HrpanelRepository extends JpaRepository<ITS_TBL_Hrpanel_Entity, Long> {

	List<ITS_TBL_Hrpanel_Entity> findByempHrId(long empHrId);

}
