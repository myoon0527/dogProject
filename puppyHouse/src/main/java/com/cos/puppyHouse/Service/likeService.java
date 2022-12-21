package com.cos.puppyHouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.puppyHouse.model.Community;
import com.cos.puppyHouse.model.Like;
import com.cos.puppyHouse.model.Users;
import com.cos.puppyHouse.repository.commuRepository;
import com.cos.puppyHouse.repository.likeRepository;

@Service
public class likeService {
	
	@Autowired
	private likeRepository likeRepository;
	
	@Autowired
	private commuRepository commuRepository;
	
	@Transactional
	public void likes(int CommunityId, Like requestLike, Users user) {
		Community commu = commuRepository.findById(CommunityId)
				.orElseThrow(()->{
					return new IllegalArgumentException("좋아요 실패: 게시글 아이디를 찾을 수 없습니다.");
				});
		requestLike.setUsers(user);
		requestLike.setCommunity(commu);
		likeRepository.save(requestLike);
	}
}
