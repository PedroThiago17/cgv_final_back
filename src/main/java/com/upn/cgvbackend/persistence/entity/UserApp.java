package com.upn.cgvbackend.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_app")
public class UserApp {

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	@Column(name = "first_name_user", nullable = false)
	private String firstNameUser;

	@Column(name = "last_name_user", nullable = false)
	private String lastNameUser;

	@Column(name = "document_user", nullable = false, unique = true)
	private String documentUser;

	@Column(name = "birthday_user", nullable = false)
	private String birthdayeUser;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstNameUser() {
		return firstNameUser;
	}

	public void setFirstNameUser(String firstNameUser) {
		this.firstNameUser = firstNameUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getDocumentUser() {
		return documentUser;
	}

	public void setDocumentUser(String documentUser) {
		this.documentUser = documentUser;
	}

	public String getBirthdayeUser() {
		return birthdayeUser;
	}

	public void setBirthdayeUser(String birthdayeUser) {
		this.birthdayeUser = birthdayeUser;
	}

}
