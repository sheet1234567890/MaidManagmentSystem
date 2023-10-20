package com.adda.app.reposatory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adda.app.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.email=:email")
	public Optional<User> getUserByName(String email);
	@Query("SELECT u FROM User u WHERE u.email=:email")
	public User getUserByEmail(String email);
}
