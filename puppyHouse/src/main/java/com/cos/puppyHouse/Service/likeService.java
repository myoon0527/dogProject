package com.cos.puppyHouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.puppyHouse.model.Community;
import com.cos.puppyHouse.model.Likes;
import com.cos.puppyHouse.model.Users;
import com.cos.puppyHouse.repository.commuRepository;
import com.cos.puppyHouse.repository.likesRepository;

@Service
public class likeService {
	
	@Autowired
	private likesRepository likesRepository;
	
	@Autowired
	private commuRepository commuRepository;
	
	//1
//	@Transactional
//	public boolean addLike(Users user, int likeid) {
//		Community commu = commuRepository.findById(likeid)
//				.orElseThrow(()->{
//					return new IllegalArgumentException("좋아요 실패");
//				});
//		if(isNotAlreadyLike(user, commu)) {
//			likesRepository.save(new Likes(commu, user));
//			return true;
//		}
//		return false;
//	}
//	
//	private boolean isNotAlreadyLike(Users user, Community commu) {
//		return likesRepository.findByUserid(user, commu).isEmpty();
//	}
	
	//2 좋아요 누르기
	@Transactional
	public void likes(int id, Users user) {
		Community commu = commuRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("좋아요 실패");
				});
		Likes requestLikes = new Likes();
		requestLikes.setUsers(user);
		requestLikes.setCommunity(commu);
		likesRepository.save(requestLikes);
	}
	@Transactional
	public void insertLikes(int id, int userid) {
		likesRepository.insertLikes(id, userid);
	}
}
