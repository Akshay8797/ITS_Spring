package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_Hrpanel_Entity;
import com.spring.json.ITS_TBL_Hrpanel_Json;
import com.spring.rest.repository.HrpanelRepository;
import com.spring.utils.HrPanelUtils;
@Service
public class HrServiceImpl implements HrService{
	
		@Autowired
		private HrpanelRepository hrRepository;

		public List<ITS_TBL_Hrpanel_Json> getAllHrPanel() {
			List<ITS_TBL_Hrpanel_Entity> hrEntityList = hrRepository.findAll();
			return HrPanelUtils.convertHrpanelEntityListToHrpanelList(hrEntityList);
		}
}
/*List<UserEntity> userEntityList = userRepository.findAll();
		return UserUtils.convertUserEntityListToUserList(userEntityList);*/
		
		

