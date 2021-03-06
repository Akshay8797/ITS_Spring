package com.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="its_tbl_candidate")
public class ITS_TBL_Candidate_Entity {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (candidateId ^ (candidateId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ITS_TBL_Candidate_Entity other = (ITS_TBL_Candidate_Entity) obj;
		if (candidateId != other.candidateId)
			return false;
		return true;
	}
	@Id
	@GeneratedValue 	
	@Column(name="CandidateId")
	private long candidateId;
	
	@Column(name="PrimarySkills")
	private String primarySkills;
	
	@Column(name="SecondarySkillS")
	private String secondarySkills;
	
	@Column(name="Experience")
	private int experience;
	
	@Column(name="Qualification")
	private String qualification;
	
	@Column(name="Designation")
	private String designation;
	
	@Column(name="NoticePeriod")
	private int noticePeriod;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="ShareDetails")
	private int shareDetails;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="candidateEntity")
	private List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList;
	
	@OneToOne(mappedBy = "candidate",cascade = CascadeType.ALL)
    private ITS_TBL_User_Profile_Entity user;
	
	public ITS_TBL_User_Profile_Entity getUser() {
		return user;
	}

	public void setUser(ITS_TBL_User_Profile_Entity user) {
		this.user = user;
	}

	public ITS_TBL_Candidate_Entity() {}
	
	public ITS_TBL_Candidate_Entity(long candidateId, String primarySkills, String secondarySkills, int experience,
		String qualification, String designation, int noticePeriod, String location, int shareDetails) {
		super();
		this.candidateId = candidateId;
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
		this.noticePeriod = noticePeriod;
		this.location = location;
		this.shareDetails = shareDetails;
	}
	
	public long getCandidateId() {
		return candidateId;
	}
	
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
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
	public int getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getShareDetails() {
		return shareDetails;
	}
	public void setShareDetails(int shareDetails) {
		this.shareDetails = shareDetails;
	}
	public List<ITS_TBL_Interview_Schedule_Entity> getInterviewScheduleList() {
		return interviewScheduleList;
	}
	public void setInterviewScheduleList(List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList) {
		this.interviewScheduleList = interviewScheduleList;
	}

}
