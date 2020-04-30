package com.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "its_tbl_hrpanel")
public class ITS_TBL_Hrpanel_Entity {
	@Id
	@GeneratedValue
	@Column(name = "empHrId")
	private long empHrId;

	@Column(name = "empHrName")
	private String empHrName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "its_tbl_hrpanel_entity")
	private Set<ITS_TBL_Interview_Schedule_Entity> interviewSchedule;

	public ITS_TBL_Hrpanel_Entity(long empHrId, String empHrName) {
		this.empHrId = empHrId;
		this.empHrName = empHrName;
	}

	public ITS_TBL_Hrpanel_Entity(String empHrName) {
		this.empHrName = empHrName;
	}

	public long getEmpHrId() {
		return empHrId;
	}

	public void setEmpHrId(long empHrId) {
		this.empHrId = empHrId;
	}

	public String getEmpHrName() {
		return empHrName;
	}

	public void setEmpHrName(String empHrName) {
		this.empHrName = empHrName;
	}

}