package com.example.demo.connexion;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("SELECT DISTINCT user FROM User user WHERE lastname LIKE :lastname%")
	@Transactional(readOnly = true)
	Collection<User> findByLastName(@Param("lastname") String lastName);

}
