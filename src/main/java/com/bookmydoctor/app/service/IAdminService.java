package com.bookmydoctor.app.service;

import com.bookmydoctor.app.model.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin removeAdmin(Admin admin);
	public Admin viewAdmin(Admin admin);
	
}
