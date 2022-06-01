package com.upn.cgvbackend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upn.cgvbackend.persistence.entity.UserApp;

@Repository
public interface UserAppRepositoy extends JpaRepository<UserApp, Integer> {

	UserApp findByDocumentUser(String documentUser);
}
