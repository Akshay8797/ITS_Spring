package com.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.ITS_TBL_Techpanel_Entity;
import com.spring.json.ITS_TBL_Techpanel_Json;


public class TechPanelUtils {
	public static List<ITS_TBL_Techpanel_Json> convertTechpanelToTechpanelList(List<ITS_TBL_Techpanel_Entity> TechpanelEntityList) {
		List<ITS_TBL_Techpanel_Json> scheduleList = new ArrayList<ITS_TBL_Techpanel_Json>();
		Consumer<ITS_TBL_Techpanel_Entity> consumer = (ITS_TBL_Techpanel_Entity scheduleEntity)->scheduleList.add(convertTechpanelEntityToTechpanel(scheduleEntity));
		TechpanelEntityList.stream().forEach(consumer);
		return scheduleList;
	}
	
	public static ITS_TBL_Techpanel_Json convertTechpanelEntityToTechpanel(ITS_TBL_Techpanel_Entity techpanelEntity) {
		return new ITS_TBL_Techpanel_Json(techpanelEntity.getTechId(),techpanelEntity.getTechName(),techpanelEntity.getSubjects());
	}

	public static ITS_TBL_Techpanel_Entity convertTechPanelToTechPanelEntity(ITS_TBL_Techpanel_Json techpanel) {
		return new ITS_TBL_Techpanel_Entity(techpanel.getTechId(),techpanel.getTechName(),techpanel.getSubjects());

	}

}
