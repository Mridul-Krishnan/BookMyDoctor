package com.bookmydoctor.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmydoctor.app.dao.IDoctorDao;
import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.AvailabilityDates;
import com.bookmydoctor.app.model.Doctor;

/**
 * @author Mri scan
 *
 */
@Service
public class ImplDoctorService implements IDoctorService{

	@Autowired
	private IDoctorDao dao;
	
	@Override
	public Doctor addDoctor(Doctor bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public Doctor updateDoctorProfile(Doctor bean) {
		// TODO Auto-generated method stub
		return dao.save(bean);
	}

	@Override
	public AvailabilityDates addAvailability(AvailabilityDates bean) {
		// TODO Auto-generated method stub
		
		Doctor doctor = bean.getDoctor();
		doctor.setAvailabilityDates(bean);
		dao.save(doctor);
		return bean ;
	}

	@Override
	public AvailabilityDates updateAvailability(AvailabilityDates bean) {
		// TODO Auto-generated method stub
		Doctor doctor = bean.getDoctor();
		doctor.setAvailabilityDates(bean);
		dao.save(doctor);
		return bean ;
	}

	@Override
	public Doctor getDoctor(int doctorId) {
		// TODO Auto-generated method stub
		return dao.findById(doctorId).get();
	}

	@Override
	public Doctor removeDoctor(int doctorId) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctor = dao.findById(doctorId);
		dao.deleteById(doctorId);
		return doctor.get();
	}

	@Override
	public List<Doctor> getDoctorList() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Doctor> getDoctorList(String speciality) {
		// TODO Auto-generated method stub
		return dao.findBySpeciality(speciality);
	}
	@Override
	public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
		// TODO Auto-generated method stub
		List<Appointment> appointments = dao.findById(doctorId).get().getAppointments();
		appointments.sort(( Appointment i, Appointment j)-> i.getAppointmentDate().compareTo(j.getAppointmentDate()));
		return appointments;
	}

	
	
}
