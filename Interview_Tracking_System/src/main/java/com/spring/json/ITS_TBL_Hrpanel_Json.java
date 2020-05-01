package com.spring.json;

import java.util.List;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;

public class ITS_TBL_Hrpanel_Json {
	private long empHRId;
	private String empHRName;
	private List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList;
	
	public List<ITS_TBL_Interview_Schedule_Entity> getInterviewScheduleList() {
		return interviewScheduleList;
	}
	public void setInterviewScheduleList(List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList) {
		this.interviewScheduleList = interviewScheduleList;
	}


	public long getEmpHRId() {
		return empHRId;
	}
	public void setEmpHRId(long empHRId) {
		this.empHRId = empHRId;
	}
	public String getEmpHRName() {
		return empHRName;
	}
	public void setEmpHrName(String empHRName) {
		this.empHRName = empHRName;
	}
	@Override
	public String toString() {
		return "ITS_TBL_Hrpanel_Json [empHRId=" + empHRId + ", empHRName=" + empHRName + "]";
	}
}