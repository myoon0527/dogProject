package com.cos.puppyHouse.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.puppyHouse.Service.PetService;
import com.cos.puppyHouse.config.auth.PrincipalDetail;
import com.cos.puppyHouse.dto.ResponseDto;
import com.cos.puppyHouse.model.Pet;
import com.cos.puppyHouse.model.Users;

@RestController
public class PetApiController {
	@Autowired
	private PetService petService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PutMapping("/api/pet/{id}")
	public ResponseDto<Integer> save(@PathVariable int id, @RequestBody Pet pet, @RequestBody Users user){
		System.out.println("PetApiController 호출됨");
		
		petService.펫등록(pet);
		System.out.println(user.getUserid());
		System.out.println(user.getUserpassword());
		

		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}

}
