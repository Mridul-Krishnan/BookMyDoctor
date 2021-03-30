package com.bookmydoctor.app.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.Patient;

/**
 * @author Vibhrat & Prachi
 *
 */
@Repository
public interface IPatientDao extends JpaRepository<Patient , Integer>{

	

	List<Appointment> getAppointmentByPatientId(int patientId);
	List<Patient> getPatientListByDoctor(int patientId);
	
}
