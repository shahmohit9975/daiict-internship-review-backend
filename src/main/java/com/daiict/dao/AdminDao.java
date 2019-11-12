package com.daiict.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiict.model.Admin;
import com.daiict.repository.AdminRepo;

@Service
public class AdminDao {

	@Autowired
	AdminRepo adminRepo;

	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}

	public @Valid String saveAdmin(@Valid Admin admin) {
		adminRepo.save(admin);
		return "added";

	}

}
