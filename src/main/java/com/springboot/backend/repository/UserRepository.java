package com.springboot.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.User;

public interface UserRepository extends JpaRepository<User, String> {
        boolean existsByUsername(String username);
        Optional<User> findByUsername(String username);
}
