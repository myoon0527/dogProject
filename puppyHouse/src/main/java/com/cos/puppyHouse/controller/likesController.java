package com.cos.puppyHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.puppyHouse.Service.likeService;
import com.cos.puppyHouse.config.auth.PrincipalDetail;
import com.cos.puppyHouse.dto.ResponseDto;
import com.cos.puppyHouse.repository.commuRepository;
import com.cos.puppyHouse.repository.likesRepository;

@RestController
public class likesController {
	

	@Autowired
	private likeService likeService;
	
	//좋아요 누르기
	@PostMapping("/api/like/{id}")
	public ResponseDto<Integer> addLike(@PathVariable int id,@AuthenticationPrincipal PrincipalDetail principal) {
	System.out.println("api/like/ : "+ id +"," + principal.getUser());
		//likeService.likes(id,principal.getUser());
		likeService.insertLikes(id, principal.getUser().getId());
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
