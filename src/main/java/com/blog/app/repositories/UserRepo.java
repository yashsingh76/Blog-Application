package com.blog.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entities.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
