package com.bookmydoctor.test.doctor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bookmydoctor.app.BookMyDoctorApplication;
import com.bookmydoctor.app.dao.IDoctorDao;
import com.bookmydoctor.app.model.Doctor;
import com.bookmydoctor.app.service.ImplDoctorService;

/**
 * @author Mridul
 *
 */
@SpringBootTest(classes = BookMyDoctorApplication.class)
public class DoctorTests {

	@MockBean
	IDoctorDao dao;

	@Autowired
	ImplDoctorService service;

	@Test
	@DisplayName("Test: Adding Doctor")
	void testAddDoctor() {
		Doctor doctor = new Doctor(123, "Bhishma", "Neuro", "Delhi", "XYZ", 9999999999L, "abc@xyz.com", "pass", 200);
		Mockito.when(dao.save(doctor)).thenReturn(doctor);
		assertEquals(service.addDoctor(doctor), doctor);
	}

	@Test
	@DisplayName("Test:Updating Doctor")
	void testUpdateDoctor() {
		Doctor doctor = new Doctor(123, "Bhishma", "Neuro", "Delhi", "XYZ", 9999999999L, "abc@xyz.com", "pass", 200);
		Mockito.when(dao.save(doctor)).thenReturn(doctor);
		assertEquals(service.updateDoctorProfile(doctor), doctor);

	}

	@Test
	@DisplayName("Test:Get all Doctors")
	void testGetDoctorList() {
		List<Doctor> list = new ArrayList<Doctor>();
		list.add(new Doctor(123, "Bhishma", "Neuro", "Delhi", "XYZ", 9999999999L, "abc@xyz.com", "pass", 200));
		list.add(new Doctor(124, "King", "Gastro", "Delhi", "fgh", 9999999999L, "xyz", "pass2", 333));
		Mockito.when(dao.findAll()).thenReturn(list);
		assertEquals(service.getDoctorList(), list);

	}

	@Test
	@DisplayName("Test:Get by Id")
	void testGetDoctorById() {
		Optional<Doctor> doctor = Optional
				.of(new Doctor(123, "Bhishma", "Neuro", "Delhi", "XYZ", 9999999999L, "abc@xyz.com", "pass", 200));

		Mockito.when(dao.findById(doctor.get().getDoctorId())).thenReturn(doctor);
		assertEquals(service.getDoctor(doctor.get().getDoctorId()), doctor.get());

	}

	@Test
	@DisplayName("Test: Get Doctors by speciality")
	void testGetDoctorBySpeciality() {
		List<Doctor> list = new ArrayList<Doctor>();
		list.add(new Doctor(123, "Bhishma", "Neuro", "Delhi", "XYZ", 9999999999L, "abc@xyz.com", "pass", 200));
		list.add(new Doctor(124, "King", "Gastro", "Delhi", "fgh", 9999999999L, "xyz@gh.com", "pass2", 333));
		list.add(new Doctor(124, "Arju", "Neuro", "Chennai", "IJK", 9999999999L, "xyy@gh.com", "pass3", 666));

		List<Doctor> list2 = new ArrayList<Doctor>();
		list2.add(list.get(0));
		list2.add(list.get(2));

		Mockito.when(dao.findBySpeciality("Neuro")).thenReturn(list2);
		assertEquals(service.getDoctorList("Neuro"), list2);

	}
	
	@Test
	@DisplayName("Test: Remove Doctor by int id")
	void testRemoveDoctor() {
		Optional<Doctor> doctor = Optional
				.of(new Doctor(123, "Bhishma", "Neuro", "Delhi", "XYZ", 9999999999L, "abc@xyz.com", "pass", 200));

		Mockito.when(dao.findById(doctor.get().getDoctorId())).thenReturn(doctor);
		assertEquals(service.removeDoctor(123), doctor.get());
		
	}
}
