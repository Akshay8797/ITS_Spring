package com.spring.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(name="TechRating")
	private Float techRating;
	
	@Column(name="empHRInterviewDate")
	private LocalDate empHRInterviewDate;
	
	@Column(name="empHRInterviewTime")
	private LocalDate empHRInterviewTime;
	
	@Column(name="empHRRating")
	private Float empHRRating;
	
	@Column(name="Result")
	private String result;
	
	@Column(name="ShareResult")
	private Integer shareResult;
	
	

	public ITS_TBL_Interview_Schedule_Entity(long interviewId, String subject, LocalDate interviewDate,
		LocalTime interviewTime, Float techRating, LocalDate empHRInterviewDate, LocalDate empHRInterviewTime,
		Float empHRRating, String result, Integer shareResult) {
		super();
		this.interviewId = interviewId;
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
	
	public ITS_TBL_Interview_Schedule_Entity() {
		super();
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
	public Float getTechRating() {
		return techRating;
	}
	public void setTechRating(Float techRating) {
		this.techRating = techRating;
	}
	public LocalDate getEmpHRInterviewDate() {
		return empHRInterviewDate;
	}
	public void setEmpHRInterviewDate(LocalDate empHRInterviewDate) {
		this.empHRInterviewDate = empHRInterviewDate;
	}
	public LocalDate getEmpHRInterviewTime() {
		return empHRInterviewTime;
	}
	public void setEmpHRInterviewTime(LocalDate empHRInterviewTime) {
		this.empHRInterviewTime = empHRInterviewTime;
	}
	public Float getEmpHRRating() {
		return empHRRating;
	}
	public void setEmpHRRating(Float empHRRating) {
		this.empHRRating = empHRRating;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getShareResult() {
		return shareResult;
	}
	public void setShareResult(Integer shareResult) {
		this.shareResult = shareResult;
	}	
}
