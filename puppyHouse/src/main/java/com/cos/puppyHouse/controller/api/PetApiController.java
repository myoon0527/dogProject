package com.cos.puppyHouse.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cos.puppyHouse.Service.PetService;
import com.cos.puppyHouse.config.auth.PrincipalDetail;
import com.cos.puppyHouse.dto.ResponseDto;
import com.cos.puppyHouse.model.Pet;

@RestController
public class PetApiController {
	@Autowired
	private PetService petService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/api/pet", method = { RequestMethod.PUT })
//	public ResponseDto<Integer> save(@RequestParam("petId")String petId,@RequestParam("petName")String petName,@RequestParam("petage")String petage,@RequestParam("species")String species,@RequestParam("gender")String gender,@RequestParam("neutered")String neutered,@RequestParam("weight")String weight,@RequestParam("etc")String etc,@RequestParam("allergy")String allergy,@RequestParam("passwrd")String passwrd,@AuthenticationPrincipal PrincipalDetail principal){
	public ResponseDto<Integer> save(@RequestBody Pet pet,  @AuthenticationPrincipal PrincipalDetail principal){
//		Pet pet =new Pet(Integer.parseInt(petId),petName,species,Integer.parseInt(petage),gender,weight,allergy,etc,neutered);
		System.out.println("PetApiController 호출됨");
		petService.펫등록(pet);
		
//		
//		//세션 등록
//		Authentication authentication =
//				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(principal.getUser().getUserid(), principal.getCredentials().toString()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);

		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}

}