package com.spring.json;

import java.time.LocalDate;
import java.time.LocalTime;

public class ITS_TBL_Interview_Schedule {
	private long interviewId;
	private String subject;
	private LocalDate interviewDate;
	private LocalTime interviewTime;
	private float techRating;
	private LocalDate empHRInterviewDate;
	private LocalTime empHRInterviewTime;
	private float empHRRating;
	private String result;
	private int shareResult;

	public ITS_TBL_Interview_Schedule(long interviewId, String subject, LocalDate interviewDate,
			LocalTime interviewTime, float techRating, LocalDate empHRInterviewDate, LocalTime empHRInterviewTime,
			float empHRRating, String result, int shareResult) {
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

	public ITS_TBL_Interview_Schedule(String subject, LocalDate interviewDate, LocalTime interviewTime,
			float techRating, LocalDate empHRInterviewDate, LocalTime empHRInterviewTime, float empHRRating,
			String result, int shareResult) {
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

	public ITS_TBL_Interview_Schedule() {
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

	public float getTechRating() {
		return techRating;
	}

	public void setTechRating(float techRating) {
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

	public float getEmpHRRating() {
		return empHRRating;
	}

	public void setEmpHRRating(float empHRRating) {
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
