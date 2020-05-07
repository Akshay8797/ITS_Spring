package com.spring.json;

import java.time.LocalDate;
import java.time.LocalTime;

public class ITS_TBL_Interview_Schedule {
	private long interviewId;
	private String subject;
	private LocalDate interviewDate;
	private LocalTime interviewTime;
<<<<<<< HEAD
	private Float techRating;
	private LocalDate empHRInterviewDate;
	private LocalDate empHRInterviewTime;
	private Float empHRRating;
	private String result;
	private Integer shareResult;
	
	
	public ITS_TBL_Interview_Schedule() {}
	
	public ITS_TBL_Interview_Schedule(long interviewId, String subject, LocalDate interviewDate,
		LocalTime interviewTime, Float techRating, LocalDate empHRInterviewDate, LocalDate empHRInterviewTime,
		Float empHRRating, String result, Integer shareResult) {
=======
	private float techRating;
	private LocalDate empHRInterviewDate;
	private LocalTime empHRInterviewTime;
	private float empHRRating;
	private String result;
	private int shareResult;

	public ITS_TBL_Interview_Schedule(long interviewId, String subject, LocalDate interviewDate,
			LocalTime interviewTime, Float techRating, LocalDate empHRInterviewDate, LocalTime empHRInterviewTime,
			Float empHRRating, String result, int shareResult) {
>>>>>>> 3af5cd6d0bcf7e9b9c56c1dc220303c856b2f1e7
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
<<<<<<< HEAD
	
	public ITS_TBL_Interview_Schedule(String subject, Float techRating) {
		super();
		this.subject = subject;
		this.techRating = techRating;
	}
=======
>>>>>>> 3af5cd6d0bcf7e9b9c56c1dc220303c856b2f1e7

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
<<<<<<< HEAD
	public Float getTechRating() {
		return techRating;
	}
	public void setTechRating(Float techRating) {
=======

	public float getTechRating() {
		return techRating;
	}

	public void setTechRating(float techRating) {
>>>>>>> 3af5cd6d0bcf7e9b9c56c1dc220303c856b2f1e7
		this.techRating = techRating;
	}

	public LocalDate getEmpHRInterviewDate() {
		return empHRInterviewDate;
	}

	public void setEmpHRInterviewDate(LocalDate empHRInterviewDate) {
		this.empHRInterviewDate = empHRInterviewDate;
	}
<<<<<<< HEAD
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
=======

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
>>>>>>> 3af5cd6d0bcf7e9b9c56c1dc220303c856b2f1e7
		this.empHRRating = empHRRating;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
<<<<<<< HEAD
	public Integer getShareResult() {
		return shareResult;
	}
	public void setShareResult(Integer shareResult) {
=======

	public int getShareResult() {
		return shareResult;
	}

	public void setShareResult(int shareResult) {
>>>>>>> 3af5cd6d0bcf7e9b9c56c1dc220303c856b2f1e7
		this.shareResult = shareResult;
	}

	@Override
	public boolean equals(Object obj) {
		ITS_TBL_Interview_Schedule its_schedule = (ITS_TBL_Interview_Schedule) obj;
		if (this.interviewId == (its_schedule.interviewId))
			return true;
		return false;
	}
}
