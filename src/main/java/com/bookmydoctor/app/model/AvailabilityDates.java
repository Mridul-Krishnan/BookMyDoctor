package com.bookmydoctor.app.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AvailabilityDates {

	
	@Id
	@GeneratedValue
	private int availabilityId;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId")
	private Doctor doctor;
	private LocalDate fromDate;
	private LocalDate toDate;
	public int getAvailabilityId() {
		return availabilityId;
	}
	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public AvailabilityDates(Doctor doctor, LocalDate fromDate, LocalDate toDate) {
		super();
		this.doctor = doctor;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public AvailabilityDates(int availabilityId, Doctor doctor, LocalDate fromDate, LocalDate toDate) {
		super();
		this.availabilityId = availabilityId;
		this.doctor = doctor;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public AvailabilityDates() {

	}
	
	
	
}
