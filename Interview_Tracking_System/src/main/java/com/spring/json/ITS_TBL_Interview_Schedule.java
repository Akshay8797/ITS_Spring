package com.spring.json;

import java.time.LocalDate;
import java.time.LocalTime;

public class ITS_TBL_Interview_Schedule {
	private String interviewId;
	private String subject;
	private LocalDate interviewDate;
	private LocalTime interviewTime;
	private int techRating;
	private LocalDate empHRInterviewDate;
	private LocalDate empHRInterviewTime;
	private int empHRRating;
	private String result;
	private int shareResult;
	
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
	
	@Override
	public boolean equals(Object obj) {
		ITS_TBL_Interview_Schedule its_schedule = (ITS_TBL_Interview_Schedule) obj;
		if (this.interviewId.equals(its_schedule.interviewId))
			return true;
		return false;
	}
}
