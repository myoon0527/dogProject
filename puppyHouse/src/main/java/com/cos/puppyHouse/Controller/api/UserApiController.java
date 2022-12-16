package com.cos.puppyHouse.Controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.puppyHouse.Service.UserService;
import com.cos.puppyHouse.dto.ResponseDto;
import com.cos.puppyHouse.model.RoleType;
import com.cos.puppyHouse.model.Users;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody Users user) {
		System.out.println("UserApiController 호출됨");
		
		userService.joinUser(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
}
