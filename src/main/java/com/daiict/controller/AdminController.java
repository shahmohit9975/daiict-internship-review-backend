package com.daiict.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.AdminDao;
import com.daiict.exceptionHandle.InvalidInputException;
import com.daiict.exceptionHandle.MissingHeaderInfoException;
import com.daiict.model.Admin;
import com.daiict.model.Features;
import com.sun.corba.se.impl.io.TypeMismatchException;

import javassist.tools.web.BadHttpRequest;

@RestController
public class AdminController {
	@Autowired
	AdminDao adminDao;

	@GetMapping(path = "/admin")
	public ResponseEntity<List<Admin>> getAllFeatures() {

		List<Admin> admin = adminDao.getAllAdmin();

		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}

	@PostMapping(path = "/admin")
	public ResponseEntity<?> saveAdmin(@Valid @RequestBody Admin admin) {

		if (!admin.getAdmin_id().endsWith("@daiict.ac.in")) {

			throw new InvalidInputException("admin email id must be ends with @daiict.ac.in");
		}
		String msg = adminDao.saveAdmin(admin);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
}
