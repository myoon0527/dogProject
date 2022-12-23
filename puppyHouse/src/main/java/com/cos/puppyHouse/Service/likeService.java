package com.cos.puppyHouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.puppyHouse.repository.likesRepository;

@Service
public class likeService {
	
	@Autowired
	private likesRepository likesRepository;
	
	//좋아요 저장
	@Transactional
	public void insertLikes(int id, int userid) {
		likesRepository.insertLikes(id, userid);
		likesRepository.plusLikesCount(id);	
	}
	
	//좋아요 취소
	@Transactional
	public void deleteLikes(int id, int commuid) {
		likesRepository.deleteById(id);
		likesRepository.minusLikesCount(commuid);
	}
	
	
}
