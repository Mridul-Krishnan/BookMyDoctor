package com.bookmydoctor.app.service;

import java.util.Optional;

import com.bookmydoctor.app.model.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin removeAdmin(Admin admin);
	public Optional<Admin> viewAdmin(int adminId);
	public Admin removeAdmin(int adminId);
	public Admin findByEmail(String email);
	
}
