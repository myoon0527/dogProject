package com.cos.puppyHouse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.puppyHouse.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByUserid(String userId);
	
	@Modifying
	@Query(value = "select count(userid) from users where userid= :id", nativeQuery=true)
	int idCheck(String id);
	
	
}
