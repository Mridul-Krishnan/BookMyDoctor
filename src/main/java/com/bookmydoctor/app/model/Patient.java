package com.bookmydoctor.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Patient {
	
	@Id
	@GeneratedValue
	private int patientId;
	private String patientName;
	private long mobileNo;
	private String email;
	private String password;
	private String bloodGroup;
	private String gender;
	private int age;
	private String address;
	@OneToOne
	@JoinColumn(name = "feedbackId", referencedColumnName = "feedbackId")
	@JsonIgnoreProperties(value = {"doctor"})
	private FeedBack feedback;

	@OneToOne
	@JoinColumn(name = "appointmentId", referencedColumnName = "appointmentId")
	@JsonIgnoreProperties({"patient"})
	private Appointment appointment;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public FeedBack getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedBack feedback) {
		this.feedback = feedback;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointement) {
		this.appointment = appointement;
	}

	public Patient(String patientName, long mobileNo, String email, String password, String bloodGroup, String gender,
			int age, String address, FeedBack feedback, Appointment appointement) {
		super();
		this.patientName = patientName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.feedback = feedback;
		this.appointment = appointement;
		this.feedback.setDoctor(this.appointment.getDoctor());
	}

	public Patient(int patientId, String patientName, long mobileNo, String email, String password, String bloodGroup,
			String gender, int age, String address, FeedBack feedback, Appointment appointement) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.feedback = feedback;
		this.appointment = appointement;
	}
	public Patient(int patientId, String patientName, long mobileNo, String email, String password, String bloodGroup,
			String gender, int age, String address) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}
	public Patient() {
		// TODO Auto-generated constructor stub

	}
}
