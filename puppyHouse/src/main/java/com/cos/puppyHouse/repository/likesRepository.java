package com.cos.puppyHouse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.puppyHouse.model.Community;
import com.cos.puppyHouse.model.Likes;
import com.cos.puppyHouse.model.Users;

public interface likesRepository extends JpaRepository<Likes, Integer>{
	
	@Modifying
	@Query(value = "update Likes likes set likes.likes_state = likes.likes_state + 1 where likes.CommunityId = :id", nativeQuery = true)
	void updateLikes_state(int id);
	
//	Optional<Likes> findByUserid(Users user, Community commu);
}
