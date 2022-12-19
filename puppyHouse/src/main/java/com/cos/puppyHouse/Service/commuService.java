package com.cos.puppyHouse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.puppyHouse.model.Community;
import com.cos.puppyHouse.model.Users;
import com.cos.puppyHouse.repository.commuRepository;

@Service
public class commuService {
	
	@Autowired
	private commuRepository commuRepository;
	
	@Transactional
	public void write(Community commu, Users user) {
		commu.setCount(0);
		commu.setUsers(user);
		commuRepository.save(commu);
	}
	
	public List<Community> list() {
		return commuRepository.findAll();
	}
}
