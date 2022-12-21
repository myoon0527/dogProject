package com.cos.puppyHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.puppyHouse.model.Like;

public interface likeRepository extends JpaRepository<Like, Integer>{
	
	@Query(value = "insert into likes(CommunityId, UsersId) values(:CommunityId, :UsersId)", nativeQuery = true)
	int likes(int CommunityId, int UsersId);
	
	
	
}
