package com.spring.json;

public class ITS_TBL_Candidate {

private String CandidateId; 
private String primarySkills;
private String secondarySkills;
private int experience;
private String qualification;
private String designation;
private int noticeperiod;
private String location;
private int shareDetails;

public String getPrimarySkills() {
	return primarySkills;
}
public void setPrimarySkills(String primarySkills) {
	this.primarySkills = primarySkills;
}
public String getSecondarySkills() {
	return secondarySkills;
}
public void setSecondarySkills(String secondarySkills) {
	this.secondarySkills = secondarySkills;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public int getNoticeperiod() {
	return noticeperiod;
}
public void setNoticeperiod(int noticeperiod) {
	this.noticeperiod = noticeperiod;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCandidateId() {
	return CandidateId;
}
public void setCandidateId(String candidateId) {
	CandidateId = candidateId;
}
public int getShareDetails() {
	return shareDetails;
}
public void setShareDetails(int shareDetails) {
	this.shareDetails = shareDetails;
}

}
