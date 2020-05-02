package com.spring.json;

public class ITS_TBL_Techpanel_Json {
	private long techId;
	private String techName;
	private String subjects;

	public ITS_TBL_Techpanel_Json() {};
		
	public ITS_TBL_Techpanel_Json(long techId, String techName, String subjects) {
		super();
		this.techId = techId;
		this.techName = techName;
		this.subjects = subjects;
	}
	public long getTechId() {
		return techId;
	}
	public void setTechId(long techId) {
		this.techId = techId;
	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	
	public ITS_TBL_Techpanel_Json(String techName, String subjects) {
		super();
		this.techName = techName;
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return "ITS_TBL_Techpanel_Json [techId=" + techId + ", techName=" + techName + ", subjects=" + subjects + "]";
	}
}