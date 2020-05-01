package com.spring.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITS_TBL_Tech_Panel")
public class ITS_TBL_Techpanel_Entity {
	@Id
	@GeneratedValue
	@Column(name = "techId")
	private long techId;

	@Column(name = "techName")
	private String techName;

	public List<ITS_TBL_Interview_Schedule_Entity> getInterviewScheduleList() {
		return interviewScheduleList;
	}
	public void setInterviewScheduleList(List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList) {
		this.interviewScheduleList = interviewScheduleList;
	}
	@Column(name = "Subjects")
	private String subjects;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="candidateEntity")
	private List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList;
	
	public ITS_TBL_Techpanel_Entity(long techId, String techName, String subjects) {
		this.techId = techId;
		this.techName = techName;
		this.subjects = subjects;
	}
	public ITS_TBL_Techpanel_Entity(String techName, String subjects) {
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
}