package com.main.lead.enitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Digits;

@Entity
@Table(name="lead",uniqueConstraints = @UniqueConstraint(columnNames = "leadId"))
public class LeadEntity {
	
	@Id
	@Column(name = "leadId", nullable = false, unique = true)
	@Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Value must be an integer")
    private Long leadId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String mobileNumber;
	
	private String Gender;
	
	private String DOB;
	
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dob) {
		this.DOB = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getLeadId() {
		return leadId;
	}

	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}

	@Override
	public String toString() {
		return "LeadEnitiy [leadId=" + getLeadId() + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", gender=" + Gender + ", dob=" + DOB
				+ ", email=" + email + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
