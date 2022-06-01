package com.upn.cgvbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upn.cgvbackend.persistence.entity.UserApp;
import com.upn.cgvbackend.persistence.repository.UserAppRepositoy;

@RestController
@RequestMapping("/api/v1/userApp/")
public class UserAppController {

	@Autowired
	private UserAppRepositoy userAppRepositoy;

	@GetMapping("/users")
	public List<UserApp> getAllUsersApp() {
		return userAppRepositoy.findAll();
	}

	@PostMapping("/addUser")
	public UserApp createEmployee(@Validated @RequestBody UserApp user) {
		return userAppRepositoy.save(user);
	}
}
