package com.bookmydoctor.app.service;

import java.time.LocalDate;
import java.util.List;

import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.Doctor;

public interface IAppointmentService {
	
	public List<Appointment> getAllAppointments();
	public Appointment getAppointment(int appointmentId);
	public boolean deleteAppointment(int appointmentId);
	public boolean updateAppointment(Appointment bean);
	public List<Appointment> getAppointments(Doctor doc);
	public List<Appointment> getAppointments(LocalDate doc);

}
