package com.bookmydoctor.app.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmydoctor.app.dao.IPatientDao;
import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.Doctor;
import com.bookmydoctor.app.model.Patient;

/**
 * @author Vibhrat & Prachi
 *
 */

@Service
public class ImplPatientService implements IPatientService {

	@Autowired
	private IPatientDao dao;
	
	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return dao.save(patient);
	}

	@Override
	public Patient editPatientProfile(Patient patient) {
		// TODO Auto-generated method stub
		return dao.save(patient);
	}

	
	@Override
	public  void removePatientDetails (int patientId) {
		// TODO Auto-generated method stub
		dao.deleteById(patientId);
	}

	@Override
	public Optional<Patient> getPatient(int patientId) {
		// TODO Auto-generated method stub
		return dao.findById(patientId);
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List <Doctor> getPatientListByDoctor(int patientId) {
		// TODO Auto-generated method stub
		List<Doctor> doctors = (List<Doctor>) dao.findById(patientId).get().getAppointment().getDoctor();
		doctors.sort((Doctor a, Doctor b)-> a.getDoctorName().compareTo(b.getDoctorName()));
		return doctors;
	}
	
	@Override
	public List<Appointment> getAppointmentByPatientId(int patientId) {
		// TODO Auto-generated method stub
		List<Appointment> appointments = dao.findAll().stream().map(i -> i.getAppointment()).collect(Collectors.toList());
		appointments.sort((Appointment i, Appointment j)-> i.getAppointmentDate().compareTo(j.getAppointmentDate()));
	return appointments;	
	}

}
