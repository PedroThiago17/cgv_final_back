package com.upn.cgvbackend.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upn.cgvbackend.persistence.entity.UserApp;
import com.upn.cgvbackend.persistence.repository.UserAppRepositoy;

@RestController
@RequestMapping("/api/v1/")
public class UserAppController {

	@Autowired
	private UserAppRepositoy userAppRepositoy;

	@GetMapping("/users")
	public List<UserApp> getAllUsersApp() {
		return userAppRepositoy.findAll();
	}

	@GetMapping("/user/{dni}")
	public UserApp findUserByDni(@PathVariable String dni) {
		return userAppRepositoy.findByDocumentUser(dni);
	}

	@PostMapping("/addUser")
	public ResponseEntity<Object> createEmployee(@Validated @RequestBody UserApp user) {
		if (Objects.isNull(userAppRepositoy.findByDocumentUser(user.getDocumentUser()))) {
			UserApp userAdd = userAppRepositoy.save(user);
			return ResponseEntity.ok(userAdd);
		} else
			return ResponseEntity.badRequest()
					.body("El usario con el DNI " + user.getDocumentUser() + " ya existe en el registro.");
	}
}
