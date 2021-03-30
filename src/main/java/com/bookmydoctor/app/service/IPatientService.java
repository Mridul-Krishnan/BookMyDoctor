package com.bookmydoctor.app.service;


import java.util.List;
import java.util.Optional;

import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.Doctor;
import com.bookmydoctor.app.model.Patient;

/**
 * @author Vibhrat and Prachi
 *
 */
public interface IPatientService {

	public Patient addPatient(Patient patient);
	public Patient editPatientProfile(Patient patient);
	public void removePatientDetails(int patientId);
	public  Optional<Patient> getPatient(int patientId);
	public List<Patient> getAllPatient();
	public List<Doctor> getPatientListByDoctor(int patientId);

	List<Appointment> getAppointmentByPatientId(int patientId);
	
	
}
