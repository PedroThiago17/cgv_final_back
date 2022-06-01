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

	@GetMapping("/bonita")
	public String miBonitaIntro() {
		return "<b>Hola mi bonita, bienvenida a este pequeño jueguito :3</b></br></br> Es muy fácil, solo tendrás que colocar un dato en esta URL.</br> Por ejemplo: ...api/v1/bonita/<b>*dato*</b> y darle enter, y así hasta que logres adivinar :3 </br> Suerte mi amor <3";
	}

	@GetMapping("/bonita/{fecha}")
	public String miBonita(@PathVariable String fecha) {
		if (fecha.equals("10-05-2022")) {
			return "Muy bien mi amor <3 ! </br> Sabía que lo harías. Eres muy inteligente, bonita, hermosa, sexy :$ y sobre todo, muy inteligente. Eres puro arte <3</br> No olvides que te adoro mi hermosa, te adoro demasiado.</br> Gracias por participar xd";
		} else
			return "Te equivocaste :c </br> Pero no te preocupes mi amor! Te dejaré una pequeña pista...</br> <b>Es un dato muy importante para nosotros... usa guiones :3</b>";
	}
}
