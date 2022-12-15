package com.cos.puppyHouse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.puppyHouse.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByUserName(String userName);
}
