package com.spring.json;

public class ITS_TBL_Hrpanel_Json {
	private long empHrId;
	private String empHrName;

	public long getEmpHrId() {
		return empHrId;
	}

	public void setEmpHrId(long empHrId) {
		this.empHrId = empHrId;
	}

	public String getEmpHrName() {
		return empHrName;
	}

	public void setEmpHrName(String empHrName) {
		this.empHrName = empHrName;
	}

	@Override
	public String toString() {
		return "ITS_TBL_Hrpanel_Json [empHrId=" + empHrId + ", empHrName=" + empHrName + "]";
	}

}