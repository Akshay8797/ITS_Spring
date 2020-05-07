package com.spring.json;

import java.time.LocalDate;
import java.time.LocalTime;

public class ITS_TBL_Interview_Schedule {
	private long interviewId;
	private String subject;
	private LocalDate interviewDate;
	private LocalTime interviewTime;
	private Float techRating;
	private LocalDate empHRInterviewDate;
	private LocalTime empHRInterviewTime;
	private Float empHRRating;
	private String result;
	private int shareResult;
	
	
	public ITS_TBL_Interview_Schedule() {}
		
	public ITS_TBL_Interview_Schedule(Float techRating,String subject) {
		this.techRating=techRating;
		this.subject=subject;
		
	}
	
	
	
	public ITS_TBL_Interview_Schedule(long interviewId, String subject, LocalDate interviewDate,
		LocalTime interviewTime, Float techRating, LocalDate empHRInterviewDate, LocalTime empHRInterviewTime,
		Float empHRRating, String result, int shareResult) {
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
	public LocalTime getEmpHRInterviewTime() {
		return empHRInterviewTime;
	}
	public void setEmpHRInterviewTime(LocalTime empHRInterviewTime) {
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
	public int getShareResult() {
		return shareResult;
	}
	public void setShareResult(int shareResult) {
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
