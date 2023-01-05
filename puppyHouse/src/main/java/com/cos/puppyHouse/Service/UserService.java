package com.cos.puppyHouse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.puppyHouse.model.Pet;
import com.cos.puppyHouse.model.RoleType;
import com.cos.puppyHouse.model.Users;
import com.cos.puppyHouse.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Autowired
	private BCryptPasswordEncoder encodeer;
	
	
	@Transactional
	public void joinUser(Users user) {
		String rawPassword = user.getUserpassword();
		String encPassword = encodeer.encode(rawPassword);
		user.setUserpassword(encPassword);
		user.setRoles(RoleType.USER);
		userRepository.save(user);
	}
	
	@Transactional
	public void updateUser(Users user) {
		Users persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("회원 찾기 실패");
		});
		String rawPassword = user.getUserpassword();
		String encPassword = encodeer.encode(rawPassword);
		persistance.setUserpassword(encPassword);
		persistance.setPhone(user.getPhone());
		persistance.setEmail(user.getEmail());
		persistance.setAddr(user.getAddr());
		
	}
	@Transactional
	public void updateuser(Users user) {
		Users persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("회원 찾기 실패");
		});
		String rawPassword = user.getUserpassword();
		String encPassword = encodeer.encode(rawPassword);
		persistance.setUserpassword(encPassword);
		persistance.setPhone(user.getPhone());
		persistance.setEmail(user.getEmail());
		persistance.setAddr(user.getAddr());
		
	}
	@Transactional
	public Users oneUser(Users user) {
		Users persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("회원 찾기 실패");
		});
		return persistance;
		
	}
	}
