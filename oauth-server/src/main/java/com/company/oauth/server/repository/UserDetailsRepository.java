package com.company.oauth.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.oauth.server.dto.User;


public interface UserDetailsRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String name);
}
