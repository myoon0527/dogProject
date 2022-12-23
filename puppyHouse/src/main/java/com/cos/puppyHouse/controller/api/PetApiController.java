package com.cos.puppyHouse.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.puppyHouse.Service.PetService;
import com.cos.puppyHouse.config.auth.PrincipalDetail;
import com.cos.puppyHouse.dto.ResponseDto;
import com.cos.puppyHouse.model.Pet;

@RestController
public class PetApiController {
	@Autowired
	private PetService petService;
	
	@PutMapping("/api/pet")
	public ResponseDto<Integer> save(@RequestBody Pet pet){
		System.out.println("PetApiController 호출됨");
		
		petService.펫등록(pet);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}

}
