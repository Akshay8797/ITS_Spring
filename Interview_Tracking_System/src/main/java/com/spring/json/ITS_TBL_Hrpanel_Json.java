package com.spring.json;

public class ITS_TBL_Hrpanel_Json {
	private long empHrId;
	public ITS_TBL_Hrpanel_Json(long empHrId, String empHrName) {
		super();
		this.empHrId = empHrId;
		this.empHrName = empHrName;
	}
	private String empHrName;
	
	public ITS_TBL_Hrpanel_Json() {}
	public long getEmpHrId() {
		return empHrId;
	}
	public void setEmpHrId(long empHRId) {
		this.empHrId = empHRId;
	}
	public String getEmpHrName() {
		return empHrName;
	}
	public void setEmpHrName(String empHrName) {
		this.empHrName = empHrName;
	}

}