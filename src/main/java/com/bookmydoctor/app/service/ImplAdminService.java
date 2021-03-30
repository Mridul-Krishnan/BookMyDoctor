package com.bookmydoctor.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmydoctor.app.dao.IAdminDao;
import com.bookmydoctor.app.model.Admin;

public class ImplAdminService implements IAdminService {

	@Autowired
	IAdminDao dao;
	
	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin removeAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin viewAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

}
