package com.bookmydoctor.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmydoctor.app.dao.IAdminDao;
import com.bookmydoctor.app.model.Admin;
@Service
public class ImplAdminService implements IAdminService {
	@Autowired
	private IAdminDao dao;

	@Override
	public Admin addAdmin(Admin admin) {
		
		return dao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		
		return dao.save(admin);
	}

	@Override
	public Admin removeAdmin(Admin admin) {
		
		dao.delete(admin);
		return admin;
	}

	@Override
	public Optional<Admin> viewAdmin(int adminId) {
		
		return dao.findById(adminId);
	}

	@Override
	public Admin removeAdmin(int adminId) {
		
		Admin admin = dao.findById(adminId).get();
		dao.deleteById(adminId);
		return admin;
	}

	@Override
	public Admin findByEmail(String email) {
		
		return dao.findByEmail(email).get(0);
	}

}
