package com.cos.puppyHouse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.puppyHouse.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByUserid(String userId);
	
	
	Users findByUsernameAndPhone(String username, String phone);
	
	//@Modifying
	//@Query("select * from users where USERID=? AND USERNAME=? AND PHONE=?")
	Users findByUseridAndUsernameAndPhone(String userid, String username, String phone);
	

}
