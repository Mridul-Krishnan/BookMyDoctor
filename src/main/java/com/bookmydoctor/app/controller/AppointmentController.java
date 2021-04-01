package com.bookmydoctor.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmydoctor.app.exception.AppointmentException;
import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.Doctor;
import com.bookmydoctor.app.service.ImplAppointmentService;

//created by AJITH  and SHREYES

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	ImplAppointmentService service;

	@GetMapping("/getappointments/all")
	public List<Appointment> getAllAppointments() {
		return service.getAllAppointments();

	}

	@DeleteMapping("/deleteappointment/{Id}")
	public void deleteAppointment(@PathVariable("Id") int appointmentId) throws AppointmentException {
		if (Character.isAlphabetic(appointmentId))
			throw new AppointmentException("Enter only numbers");
		if (service.getAppointment(appointmentId) == null)
			throw new AppointmentException("ID doesn't exist");

		service.deleteAppointment(appointmentId);
	}

	@PutMapping("/updateappointment/")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws AppointmentException {
		if(!appointment.getAppointmentStatus().contains("Approved") || !appointment.getAppointmentStatus().contains("Cancelled") || !appointment.getAppointmentStatus().contains("Completed"))
			throw new AppointmentException("check again ");
		return service.updateAppointment(appointment);
	}

	@GetMapping("/getappointment/{Id}")
	public Optional<Appointment> getAppointment(@PathVariable(name = "Id") int appointmentId)
			throws AppointmentException {

		if (Character.isAlphabetic(appointmentId))
			throw new AppointmentException("Enter only numbers");
		return service.getAppointment(appointmentId);
	}

	@GetMapping("/getAppointmentByDoctor/{id}")
	public List<Appointment> getAppointmentByDoctor(@PathVariable(name = "id") int doctorId) {
		Doctor doctor = new Doctor();
		doctor.setDoctorId(doctorId);
		return service.getAppointments(doctor);
	}

	@GetMapping("/getAppointmentsByDate/{date}")
	public List<Appointment> getAppointmentsByDate(@PathVariable(name = "date") LocalDate date) {
		return service.getAppointments(date);
	}
}
