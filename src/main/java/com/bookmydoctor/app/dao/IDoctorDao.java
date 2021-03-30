package com.bookmydoctor.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmydoctor.app.model.Doctor;

@Repository
public interface IDoctorDao extends JpaRepository<Doctor, Integer> {

	public List<Doctor> findBySpeciality(String speciality);

}
