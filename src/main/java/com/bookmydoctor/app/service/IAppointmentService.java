package com.bookmydoctor.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.Doctor;
//created by AJITH  and SHREYES
public interface IAppointmentService{
	
	public List<Appointment> getAllAppointments();
	public Optional <Appointment> getAppointment(int appointmentId);
	public void deleteAppointment(int appointmentId);
	public Appointment updateAppointment(Appointment appointment);
	public List<Appointment> getAppointments(LocalDate doc);
	public List<Appointment> getAppointments(Doctor doc);

}
