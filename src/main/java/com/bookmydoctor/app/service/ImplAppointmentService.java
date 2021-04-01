package com.bookmydoctor.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmydoctor.app.dao.IAppointmentDao;
import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.Doctor;

//created by AJITH  and SHREYES
@Service
public class ImplAppointmentService implements IAppointmentService {
	@Autowired
	private IAppointmentDao dao;

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Appointment> getAppointment(int appointmentId) {
		// TODO Auto-generated method stub
		return dao.findById(appointmentId);
	}

	@Override
	public void deleteAppointment(int appointmentId) {
		// TODO Auto-generated method stub
		dao.deleteById(appointmentId);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return dao.save(appointment);
	}

	@Override
	public List<Appointment> getAppointments(Doctor doc) {
		// TODO Auto-generated method stub
		List<Appointment> appointments = dao.findAll();
		appointments = appointments.stream().filter(i->i.getDoctor() != null).filter(i -> i.getDoctor().getDoctorId() == doc.getDoctorId())
				.collect(Collectors.toList());
		return appointments;
	}

	@Override
	public List<Appointment> getAppointments(LocalDate doc) {
		// TODO Auto-generated method stub
		List<Appointment> appointments = dao.findAll();
		appointments.sort((i, j) -> i.getAppointmentDate().compareTo(j.getAppointmentDate()));

		return appointments;
	}

}
