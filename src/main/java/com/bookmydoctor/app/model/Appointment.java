package com.bookmydoctor.app.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//created by AJITH  and SHREYES

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue
	private int appointmentId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId")
	@JsonIgnoreProperties({"appointments"})
	private Doctor doctor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"appointment"})
	private Patient patient;
	
	private LocalDateTime appointmentDate;
	private String appointmentStatus;//approved ,cancelled,completed
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentDate, String appointmentStatus) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
	}
	public Appointment(int appointmentId, Doctor doctor, Patient patient, LocalDateTime appointmentDate,
			String appointmentStatus) {
		super();
		this.appointmentId = appointmentId;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
	}
	
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	
}
