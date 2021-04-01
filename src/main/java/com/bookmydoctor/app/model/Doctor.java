package com.bookmydoctor.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Mri scan
 *
 */
@Entity
public class Doctor {
	@Id
	@GeneratedValue
	private int doctorId;
	private String doctorName;
	private String speciality;
	private String location;
	private String hospitalName;
	private long mobileNo;
	private String email;
	private String password;
	private double chargesPerVisit;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name  = "availabilityId", referencedColumnName = "availabilityId")
	@JsonIgnoreProperties({"doctor"})
	private AvailabilityDates availabilityDates;
	
	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"doctor"})
	private List<Appointment> appointments;
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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
	public double getChargesPerVisit() {
		return chargesPerVisit;
	}
	public void setChargesPerVisit(double chargesPerVisit) {
		this.chargesPerVisit = chargesPerVisit;
	}
	
	
	
	public AvailabilityDates getAvailabilityDates() {
		return availabilityDates;
	}
	public void setAvailabilityDates(AvailabilityDates availabilityDates) {
		this.availabilityDates = availabilityDates;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	
	public Appointment addAppointment(Appointment appointment)
	{
		this.appointments.add(appointment);
		return appointment;
	}
	
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public Doctor(String doctorName, String speciality, String location, String hospitalName, long mobileNo,
			String email, String password, double chargesPerVisit) {
		super();
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.location = location;
		this.hospitalName = hospitalName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.chargesPerVisit = chargesPerVisit;
	}
	public Doctor(int doctorId, String doctorName, String speciality, String location, String hospitalName,
			long mobileNo, String email, String password, double chargesPerVisit) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.location = location;
		this.hospitalName = hospitalName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.chargesPerVisit = chargesPerVisit;
	}
	
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	
	
}
