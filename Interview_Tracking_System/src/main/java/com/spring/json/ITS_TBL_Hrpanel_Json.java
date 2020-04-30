package com.spring.json;

public class ITS_TBL_Hrpanel_Json {
	private long empHRId;
	private String empHRName;

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