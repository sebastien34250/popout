package com.example.demo.connexion;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT DISTINCT user FROM User user WHERE lastname LIKE :lastname%")
	@Transactional(readOnly = true)
	Collection<User> findByLastName(@Param("lastname") String lastName);

	@Query("SELECT DISTINCT user FROM User user WHERE email LIKE :email% and password LIKE :mdp")
	@Transactional(readOnly = true)
	User findByMail(@Param("email") String email, @Param("mdp") String mdp);
	
}
