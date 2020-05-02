package com.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.ITS_TBL_Hrpanel_Entity;
import com.spring.json.ITS_TBL_Hrpanel_Json;

public class HrPanelUtils {
	
	public static List<ITS_TBL_Hrpanel_Json> convertHrpanelEntityListToHrpanelList(List<ITS_TBL_Hrpanel_Entity> HrpanelEntityList) {
		List<ITS_TBL_Hrpanel_Json> hrList = new ArrayList<ITS_TBL_Hrpanel_Json>();
		Consumer<ITS_TBL_Hrpanel_Entity> consumer = (ITS_TBL_Hrpanel_Entity hrEntity)->hrList.add(convertHrpanelEntityToHrpanel(hrEntity));
		HrpanelEntityList.stream().forEach(consumer);
		return hrList;
	}
	
	public static ITS_TBL_Hrpanel_Json convertHrpanelEntityToHrpanel(ITS_TBL_Hrpanel_Entity HrpanelEntity) {
		return new ITS_TBL_Hrpanel_Json(HrpanelEntity.getEmpHrId(),HrpanelEntity.getEmpHrName());
	}

	public static ITS_TBL_Hrpanel_Entity convertHrPanelToHrPanelEntity(ITS_TBL_Hrpanel_Json Hrpanel) {
		return new ITS_TBL_Hrpanel_Entity(Hrpanel.getEmpHrId(),Hrpanel.getEmpHrName());

	}


}
