package com.main.lead.models;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Component
public class LeadDTO {

	@NotNull(message = "LeadId is mandatory")
	private Long leadId;

	@NotBlank(message = "firstName is mandatory")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "firstName should contain only alphabets")
	private String firstName;

	@NotBlank(message = "middleName is mandatory")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "middleName should contain only alphabets")
	private String middleName;

	@NotBlank(message = "lastName is mandatory")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "lastName should contain only alphabets")
	private String lastName;

	@NotBlank(message = "mobileNumber is mandatory")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "mobileNumber should be number and starts with 6, 7, 8, or 9")
	private String mobileNumber;

	@JsonProperty("Gender")
	@NotNull(message = "gender is mandatory")
	@Pattern(regexp = "^(Male|Female|Others)$", message = "gender should be Male, Female, or Others")
	private String Gender;

	@JsonProperty("DOB")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "DOB is mandatory")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate DOB;

	@NotNull(message = "email is mandatory")
	@Email(message = "email should be in proper email form")
	private String email;

	public Long getLeadId() {
		return leadId;
	}

	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "LeadDTO [leadId=" + leadId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + ", gender=" + getGender() + ", dob=" + DOB + ", email="
				+ email + "]";
	}

}
