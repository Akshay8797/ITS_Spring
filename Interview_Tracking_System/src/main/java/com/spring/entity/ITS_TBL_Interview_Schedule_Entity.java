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
@Table(name="its_tbl_interview_schedule")
public class ITS_TBL_Interview_Schedule_Entity {
	@Id
	@GeneratedValue 	
	@Column(name="InterviewID")
	private String InterviewID;
	
	@Column(name="Subject")
	private String Subject;
	
	@Column(name="InterviewDate")
	private LocalDate InterviewDate;
	
	@Column(name="InterviewTime")
	private LocalTime InterviewTime;
	
	@Column(name="TechRating")
	private int TechRating;
	
	@Column(name="empHRInterviewDate")
	private LocalDate empHRInterviewDate;
	
	@Column(name="empHRInterviewTime")
	private LocalDate empHRInterviewTime;
	
	@Column(name="HRRating")
	private int HRRating;
	
	@Column(name="Result")
	private String Result;
	
	@Column(name="ShareResult")
	private int ShareResult;

	public String getInterviewID() {
		return InterviewID;
	}

	public void setInterviewID(String interviewID) {
		InterviewID = interviewID;
	}

		public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public LocalDate getInterviewDate() {
		return InterviewDate;
	}

	public void setInterviewDate(LocalDate interviewDate) {
		InterviewDate = interviewDate;
	}

	public LocalTime getInterviewTime() {
		return InterviewTime;
	}

	public void setInterviewTime(LocalTime interviewTime) {
		InterviewTime = interviewTime;
	}

	public int getTechRating() {
		return TechRating;
	}

	public void setTechRating(int techRating) {
		TechRating = techRating;
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

	public int getHRRating() {
		return HRRating;
	}

	public void setHRRating(int hRRating) {
		HRRating = hRRating;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public int getShareResult() {
		return ShareResult;
	}

	public void setShareResult(int shareResult) {
		ShareResult = shareResult;
	}
	
}
