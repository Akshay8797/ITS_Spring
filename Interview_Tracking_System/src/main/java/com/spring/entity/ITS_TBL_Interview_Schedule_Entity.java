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
	private String interviewId;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="InterviewDate")
	private LocalDate interviewDate;
	
	@Column(name="InterviewTime")
	private LocalTime interviewTime;
	
	@Column(name="TechRating")
	private int techRating;
	
	@Column(name="empHRInterviewDate")
	private LocalDate empHRInterviewDate;
	
	@Column(name="empHRInterviewTime")
	private LocalDate empHRInterviewTime;
	
	@Column(name="empHRRating")
	private int empHRRating;
	
	@Column(name="Result")
	private String result;
	
	@Column(name="ShareResult")
	private int shareResult;
	
	

	public ITS_TBL_Interview_Schedule_Entity(String interviewId, String subject, LocalDate interviewDate,
		LocalTime interviewTime, int techRating, LocalDate empHRInterviewDate, LocalDate empHRInterviewTime,
		int empHRRating, String result, int shareResult) {
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
	
	public String getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(String interviewId) {
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
	public void setTechRating(int techRating) {
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
	public int getEmpHRRating() {
		return empHRRating;
	}
	public void setEmpHRRating(int empHRRating) {
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
	public void setShareResult(int shareResult) {
		this.shareResult = shareResult;
	}	
}
