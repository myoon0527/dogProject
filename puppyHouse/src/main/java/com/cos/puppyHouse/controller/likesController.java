package com.cos.puppyHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cos.puppyHouse.Service.likeService;
import com.cos.puppyHouse.config.auth.PrincipalDetail;
import com.cos.puppyHouse.dto.ResponseDto;
import com.cos.puppyHouse.model.Likes;
import com.cos.puppyHouse.repository.commuRepository;
import com.cos.puppyHouse.repository.likesRepository;

@Controller
public class likesController {
	
	@Autowired
	private likesRepository likesRepository;
	
	@Autowired
	private commuRepository commuRepository;
	
	@Autowired
	private likeService likeService;
	
	//좋아요 누르기
	@PostMapping("/api/like/{id}")
	public ResponseDto<Integer> addLike(@PathVariable int id, @RequestBody Likes likes, @AuthenticationPrincipal PrincipalDetail principal) {
		likeService.likes(id, likes, principal.getUser());
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
