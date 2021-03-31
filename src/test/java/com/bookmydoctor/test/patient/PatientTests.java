package com.bookmydoctor.test.patient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.bookmydoctor.app.dao.IPatientDao;
import com.bookmydoctor.app.model.Patient;
import com.bookmydoctor.app.service.ImplPatientService;

/**
 * @author Vibhrat & Prachi
 *
 */
@SpringBootTest
class PatientTests {
	
	@MockBean
	IPatientDao dao;
	
	@Autowired
	ImplPatientService service;

	@Test
	@DisplayName("Test case for adding ")
	void contextLoads() {
		
		Patient patient = new Patient (123,"Vibhrat",778899L,"email@gmail","password","O positive","Male",23,"Potheri");
		Mockito.when(dao.save(patient)).thenReturn(patient);
		assertEquals(service.addPatient(patient),patient);
	}

	@Test
	@DisplayName("find all")
     void findalltest() {
    	 List<Patient> patients = new ArrayList <Patient>();
    	 patients.add(new Patient (123,"Vibhrat",778899L,"email@gmail","password","O positive","Male",23,"Potheri"));
    	 patients.add(new Patient (234,"thampi",778899L,"email@gmail","password","O positive","Male",23,"Potheri"));
    	 
    	 Mockito.when(dao.findAll()).thenReturn(patients);
    	 assertEquals(service.getAllPatient(),patients);
     }
	
	@Test
	@DisplayName("Find by Id")
	void findbyId() {
		
   	 Optional <Patient> patient = Optional.of(new Patient(123,"Vibhrat",778899L,"email@gmail","password","O positive","Male",23,"Potheri"));
   	 Mockito.when(dao.findById(patient.get().getPatientId())).thenReturn(patient);
   	 assertEquals(service.getPatient(123), patient);
	}
	@Test
	@DisplayName("Delete by Id")
	 void deletebyid() {
		

		//Optional<Patient> patients = Optional.of(new Patient(123,"Vibhrat",778899,"email@gmail","password","O positive","Male",23,"Potheri"));
		 
		service.removePatientDetails(123);
		verify(dao,times(1)).deleteById(123);
		
		}
	
	@Test
	@DisplayName("Update")
	void update() {
		Patient patients = new Patient (123,"Vibhrat",778899,"email@gmail","password","O positive","Male",23,"Potheri");
		 
		Mockito.when(dao.save(patients)).thenReturn(patients);
		assertEquals(service.editPatientProfile(patients),patients);
	}
}
