package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITS_TBL_USER_PROFILE")
public class ITS_TBL_User_Profile_Entity {
	
	@Id
	@Column(name="CandidateId")
	private String candidateId;
	
	@Column(name="Firstname")
	private String firstName;
	
	@Column(name="Lastname")
	private String lastName;
	
	@Column(name="DateOfBirth")
	private LocalDate dateOfBirth;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Street")
	private String street;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Pincode")
	private String pincode;
	
	@Column(name="MobileNo")
	private String mobileNo;
	
	@Column(name="EmailId")
	private String emailId;

	public ITS_TBL_User_Profile_Entity() {
		
	}
	
	public ITS_TBL_User_Profile_Entity( String firstName, String lastName, LocalDate dateOfBirth,
			String gender, String street, String location, String city, String state, String pincode, String mobileNo,
			String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "ITS_TBL_User_Profile_Entity [candidateId=" + candidateId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", street=" + street
				+ ", location=" + location + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + "]";
	}	
}
