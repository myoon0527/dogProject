package com.cos.puppyHouse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Transactional(readOnly=true)
	public Page<Community> list(Pageable pageable) {
		return commuRepository.findAll(pageable);
	}

	@Transactional(readOnly=true)
	public Community detail(int id) {
		return commuRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
				});
	}
	
	@Transactional
	public void delete(int id) {
		commuRepository.deleteById(id);
	}
	
	
	@Transactional
	public void update(int id, Community requestCommunity) {
		Community commu = commuRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다.");
				});
		commu.setTitle(requestCommunity.getTitle());
		commu.setContent(requestCommunity.getContent());
				
	}
}
