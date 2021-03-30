package com.bookmydoctor.app.service;

import java.util.List;

import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.AvailabilityDates;
import com.bookmydoctor.app.model.Doctor;

public interface IDoctorService {

	public Doctor addDoctor(Doctor bean);
	public Doctor updateDoctorProfile(Doctor bean);
	public AvailabilityDates addAvailability(AvailabilityDates bean);
	public AvailabilityDates updateAvailability(AvailabilityDates bean);
	public Doctor getDoctor(int doctorId);
	public Doctor removeDoctor(int doctorId);
	public List<Doctor> getDoctorList();
	public List<Doctor> getDoctorList(String speciality);
	List<Appointment> getAppointmentsByDoctorId(int doctorId);
	
}
