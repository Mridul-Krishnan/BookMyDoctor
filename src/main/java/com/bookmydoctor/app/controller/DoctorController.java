package com.bookmydoctor.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmydoctor.app.exception.DoctorException;
import com.bookmydoctor.app.model.Appointment;
import com.bookmydoctor.app.model.AvailabilityDates;
import com.bookmydoctor.app.model.Doctor;
import com.bookmydoctor.app.service.ImplDoctorService;

@RestController
@RequestMapping("/bookmydoctor")
public class DoctorController {

	@Autowired
	private ImplDoctorService service;
	
	@GetMapping("/getDoctors")
	public List<Doctor> getDoctorsList()
	{
		return service.getDoctorList();
	}
	
	@GetMapping("/getDoctorById/{id}")
	public Doctor getDoctorById(@PathVariable(name = "id") int doctorId)
	{
		if(doctorId>100 || doctorId<1 )
			throw new DoctorException("Invalid Id number");
		if(service.getDoctor(doctorId) == null)
			throw new DoctorException("Doctor doesn't exist");
		
		return service.getDoctor(doctorId);
	}
	
	@GetMapping("/getDoctorsBySpec/{speciality}")
	public List<Doctor> getDoctorsBySpeciality(@PathVariable(name = "speciality") String speciality)
	{
		return service.getDoctorList(speciality);
	}
	
	@GetMapping("/getAppointmentsByDoctorId/{id}")
	public List<Appointment> getAppointmentsByDoctorId(@PathVariable(name = "id") int doctorId)
	{
		if(doctorId>100 || doctorId<1 )
			throw new DoctorException("Invalid Id number");
		if(service.getDoctor(doctorId) == null)
			throw new DoctorException("Doctor doesn't exist");
		
		return service.getAppointmentsByDoctorId(doctorId);
	}
	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor)
	{
		if(!doctor.getDoctorName().matches("[A-Z][a-z ]+"))
			throw new DoctorException("Doctor Name must be made of alphabets");
		
		if(doctor.getDoctorId()>100 || doctor.getDoctorId()<1 )
			throw new DoctorException("Invalid Id number");
		
		if(!doctor.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			throw new DoctorException("Invalid Email ID");
		
		if(!doctor.getHospitalName().matches("[A-Z][a-z ]+"))
			throw new DoctorException("Hospital Name must be made of alphabets");
		
		if(doctor.getChargesPerVisit()<100 || doctor.getChargesPerVisit()>1000)
			throw new DoctorException("Invalid Charges, should be between 100 and 1000");
		
		return service.addDoctor(doctor);
	}
	
	@PostMapping("/addAvailabilty")
	public AvailabilityDates addDates(@RequestBody AvailabilityDates availabilityDates)
	{
		return service.addAvailability(availabilityDates);
	}
	
	@PutMapping("/updateDoctor")
	public Doctor updateDoctor(@RequestBody Doctor doctor)
	{
		return service.updateDoctorProfile(doctor);
	}
	
	@PutMapping("/updateAvailability")
	public AvailabilityDates updateDates(@RequestBody AvailabilityDates availabilityDates)
	{
		return service.addAvailability(availabilityDates);
	}
	
	@DeleteMapping("/deleteDoctor/{id}")
	public Doctor deleteDoctor(@PathVariable(name = "id") int doctorId)
	{
		if(doctorId>100 || doctorId<1 )
			throw new DoctorException("Invalid Id number");
		if(service.getDoctor(doctorId) == null)
			throw new DoctorException("Doctor doesn't exist");
		
		return service.removeDoctor(doctorId);
	}
}
