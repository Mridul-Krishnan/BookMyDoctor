package com.bookmydoctor.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmydoctor.app.exception.AdminException;
import com.bookmydoctor.app.model.Admin;
import com.bookmydoctor.app.service.ImplAdminService;

@RestController
@RequestMapping("/bookmydoctor")
public class AdminController {
	@Autowired
	private ImplAdminService service;

	@GetMapping("/add admin")
	public Admin addAdmin(@RequestBody Admin admin) {

		if (admin.getAdminId() > 100 || admin.getAdminId() < 1)
			throw new AdminException("Invalid Id number");

		if (!admin.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			throw new AdminException("Invalid Email ID");

		if (!admin.getPassword().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			throw new AdminException("Invalid Password");

		return service.addAdmin(admin);
	}

	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return service.updateAdmin(admin);
	}

	@DeleteMapping("/deleteAdmin/{id}")
	public Admin deleteAdmin(@PathVariable(name = "id") int adminId) {
		if (adminId > 100 || adminId < 1)
			throw new AdminException("Invalid Id number");
		if (service.viewAdmin(adminId).isEmpty())
			throw new AdminException("Admin doesn't exist");

		return service.removeAdmin(adminId);

	}

	@GetMapping("/findByEmail/{email}")
	public Admin findByEmail(@PathVariable(name = "email") String email) {
		return service.findByEmail(email);
	}

}
