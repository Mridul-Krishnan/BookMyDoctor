package com.bookmydoctor.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmydoctor.app.model.Appointment;
//created by AJITH  and SHREYES

@Repository
public interface IAppointmentDao extends JpaRepository<Appointment,Integer>{

}
