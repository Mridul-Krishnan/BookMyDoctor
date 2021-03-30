package com.bookmydoctor.app.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmydoctor.app.exception.PatientException;
import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.Patient;
import com.bookmydoctor.app.service.ImplPatientService;

/**
 * @author Vibhrat & Prachi
 *
 */

@RestController
@RequestMapping(path = "/patient")
public class PatientController {
	
	@Autowired
	ImplPatientService service;

	
	@PostMapping("/addPatient")
	public Patient addPatient (@RequestBody Patient patient)throws PatientException{
		if(!patient.getPatientName().matches("[A-Z][a-b ]+"))
			throw new PatientException("Name must contain alphabets only");
		if (!patient.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			throw new PatientException("Enter a valid Email");
		if(!patient.getGender().contains("male"+"Female"))
			throw new PatientException("Enter correct Gender ");
		if (!patient.getBloodGroup().matches("^(A|B|AB|O)[+-]?$"))
			throw new PatientException("Enter a Valid Blood group");
		String phone= String.valueOf(patient.getMobileNo());
		if (phone.length()==10)
			throw new PatientException("Enter valid MobileNo");
		return service.addPatient(patient);
	}
	@GetMapping ("/getPatient/all")
	public List<Patient> getallPatient (@RequestBody Patient patient) {
	
		return service.getAllPatient();
	}
	@GetMapping("/getPatient/{id}")
	public Optional<Patient> getPatient(@PathVariable ("id") int patientId) throws PatientException{
		if (!Character.isAlphabetic(patientId)) {
			throw new PatientException("Enter Numbers Only");
		}
				
		return service.getPatient(patientId);
	}
	
	@PutMapping("/updatePatient")
	public Patient editPatientProfile (@RequestBody Patient patient) {
		if(!patient.getPatientName().matches("[A-Z][a-b ]+"))
			throw new PatientException("Name must contain alphabets only");
		return service.editPatientProfile(patient);
	}
	
	@DeleteMapping("deletePatient/{id}")
	public String removePatientProfile (@PathVariable(name = "id") int patientId) throws PatientException{
		Optional <Patient> patient = service.getPatient(patientId);
		if (!Character.isAlphabetic(patientId)) 
			throw new PatientException ("Enter Id in Numbers only");
		if(service.getPatient(patientId) == null)
			throw new PatientException("Doctor doesn't exist");
		service.removePatientDetails(patientId);
		return "Deleted" + patient;
		
	}
	@GetMapping("/listbydate")
	public List<Appointment> getAppointmentByPatientId(int patientId){
		return service.getAppointmentByPatientId(patientId);
	}
	
}
