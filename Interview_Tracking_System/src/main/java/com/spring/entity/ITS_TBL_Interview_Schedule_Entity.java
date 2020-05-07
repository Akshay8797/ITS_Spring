package com.spring.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ITS_TBL_Interview_Schedule")
public class ITS_TBL_Interview_Schedule_Entity {
	@Id
	@GeneratedValue 	
	@Column(name="InterviewID")
	private long interviewId;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="InterviewDate")
	private LocalDate interviewDate;
	
	@Column(name="InterviewTime")
	private LocalTime interviewTime;
	
	@Column(name="TechRating",nullable=false)
	private int techRating;
	
	@Column(name="empHRInterviewDate")
	private LocalDate empHRInterviewDate;
	
	@Column(name="empHRInterviewTime")
	private LocalTime empHRInterviewTime;
	
	@Column(name="empHRRating",nullable=false)
	private int empHRRating;
	
	@Column(name="Result")
	private String result;
	
	@Column(name="ShareResult")
	private int shareResult;
	
	@ManyToOne()
	@JoinColumn(name="CandidateId")
	private ITS_TBL_Candidate_Entity candidateEntity;
	
	@ManyToOne()
	@JoinColumn(name="empHRId")
	private ITS_TBL_Hrpanel_Entity hrEntity;
	
	@ManyToOne()
	@JoinColumn(name="TechId")
	private ITS_TBL_Techpanel_Entity TechEntity;
	
	

	public ITS_TBL_Candidate_Entity getCandidateEntity() {
		return candidateEntity;
	}

	public void setCandidateEntity(ITS_TBL_Candidate_Entity candidateEntity) {
		this.candidateEntity = candidateEntity;
	}

	public ITS_TBL_Hrpanel_Entity getHrEntity() {
		return hrEntity;
	}

	public void setHrEntity(ITS_TBL_Hrpanel_Entity hrEntity) {
		this.hrEntity = hrEntity;
	}

	public ITS_TBL_Techpanel_Entity getTechEntity() {
		return TechEntity;
	}

	public void setTechEntity(ITS_TBL_Techpanel_Entity techEntity) {
		TechEntity = techEntity;
	}
	
	public ITS_TBL_Interview_Schedule_Entity() {}

	public ITS_TBL_Interview_Schedule_Entity( long interviewId,String subject, LocalDate interviewDate,
		LocalTime interviewTime, Integer techRating, LocalDate empHRInterviewDate, LocalTime empHRInterviewTime,
		Integer empHRRating, String result, Integer shareResult) {
		super();
		this.interviewId=interviewId;
		this.subject = subject;
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.techRating = techRating;
		this.empHRInterviewDate = empHRInterviewDate;
		this.empHRInterviewTime = empHRInterviewTime;
		this.empHRRating = empHRRating;
		this.result = result;
		this.shareResult = shareResult;
	}
	
	public long getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(long interviewId) {
		this.interviewId = interviewId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public LocalDate getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}
	public LocalTime getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(LocalTime interviewTime) {
		this.interviewTime = interviewTime;
	}
	public int getTechRating() {
		return techRating;
	}
	public void setTechRating(Integer techRating) {
		this.techRating = techRating;
	}
	public LocalDate getEmpHRInterviewDate() {
		return empHRInterviewDate;
	}
	public void setEmpHRInterviewDate(LocalDate empHRInterviewDate) {
		this.empHRInterviewDate = empHRInterviewDate;
	}
	public LocalTime getEmpHRInterviewTime() {
		return empHRInterviewTime;
	}
	public void setEmpHRInterviewTime(LocalTime localTime) {
		this.empHRInterviewTime = localTime;
	}
	public Integer getEmpHRRating() {
		return empHRRating;
	}
	public void setEmpHRRating(Integer empHRRating) {
		this.empHRRating = empHRRating;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getShareResult() {
		return shareResult;
	}
	public void setShareResult(Integer shareResult) {
		this.shareResult = shareResult;
	}	
}
