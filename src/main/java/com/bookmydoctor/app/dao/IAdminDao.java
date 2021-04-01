package com.bookmydoctor.app.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;
import com.bookmydoctor.app.model.Admin;

@Repository
public interface IAdminDao extends JpaRepository<Admin , Integer> {
	
	public List<Admin> findByEmail(String email);

}
