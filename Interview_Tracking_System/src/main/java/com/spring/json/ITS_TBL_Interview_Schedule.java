package com.spring.json;

import java.time.LocalDate;
import java.time.LocalTime;

public class ITS_TBL_Interview_Schedule {
	private String InterviewID;
	private String CandidateID;
	private String Subject;
	private int TechID;
	private LocalDate InterviewDate;
	private LocalTime InterviewTime;
	private int TechRating;
	private int empHRID;
	private LocalDate empHRInterviewDate;
	private LocalDate empHRInterviewTime;
	private int HRRating;
	private String Result;
	private int ShareResult;
	
	public String getInterviewID() {
		return InterviewID;
	}
	public void setInterviewID(String interviewID) {
		InterviewID = interviewID;
	}
	public String getCandidateID() {
		return CandidateID;
	}
	public void setCandidateID(String candidateID) {
		CandidateID = candidateID;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public int getTechID() {
		return TechID;
	}
	public void setTechID(int techID) {
		TechID = techID;
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
	public int getEmpHRID() {
		return empHRID;
	}
	public void setEmpHRID(int empHRID) {
		this.empHRID = empHRID;
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
	@Override
	public boolean equals(Object obj) {
		ITS_TBL_Interview_Schedule its_schedule = (ITS_TBL_Interview_Schedule) obj;
		if (this.InterviewID.equals(its_schedule.InterviewID))
			return true;
		return false;
	}

}
