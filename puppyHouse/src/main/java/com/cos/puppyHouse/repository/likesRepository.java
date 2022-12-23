package com.cos.puppyHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cos.puppyHouse.model.Likes;

public interface likesRepository extends JpaRepository<Likes, Integer>{
	
	@Modifying
	@Query(value = "update Likes likes set likes.likes_state = likes.likes_state + 1 where likes.CommunityId = :id", nativeQuery = true)
	void updateLikes_state(int id);
	
	@Modifying
	@Query(value = "INSERT INTO likes(id, CommunityId, UsersId) VALUES(USER_SEQ7.nextval, :CommunityId, :UsersId)", nativeQuery = true)
	void insertLikes(@Param("CommunityId") int commuid, @Param("UsersId") int userid);
}
