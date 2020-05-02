package com.spring.json;

import java.time.LocalDate;
import java.time.LocalTime;

public class ITS_TBL_Interview_Schedule {
	private long interviewId;
	private String subject;
	private LocalDate interviewDate;
	private LocalTime interviewTime;
	private Integer techRating;
	private LocalDate empHRInterviewDate;
	private LocalDate empHRInterviewTime;
	private Integer empHRRating;
	private String result;
	private Integer shareResult;
	
	
	public ITS_TBL_Interview_Schedule() {}
	
	public ITS_TBL_Interview_Schedule(long interviewId, String subject, LocalDate interviewDate,
		LocalTime interviewTime, Integer techRating, LocalDate empHRInterviewDate, LocalDate empHRInterviewTime,
		Integer empHRRating, String result, Integer shareResult) {
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
	
	public ITS_TBL_Interview_Schedule(String subject, Integer techRating) {
		super();
		this.subject = subject;
		this.techRating = techRating;
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
	public Integer getTechRating() {
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
	public LocalDate getEmpHRInterviewTime() {
		return empHRInterviewTime;
	}
	public void setEmpHRInterviewTime(LocalDate empHRInterviewTime) {
		this.empHRInterviewTime = empHRInterviewTime;
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
	public Integer getShareResult() {
		return shareResult;
	}
	public void setShareResult(Integer shareResult) {
		this.shareResult = shareResult;
	}
	
	@Override
	public boolean equals(Object obj) {
		ITS_TBL_Interview_Schedule its_schedule = (ITS_TBL_Interview_Schedule) obj;
		if (this.interviewId==(its_schedule.interviewId))
			return true;
		return false;
	}
}
