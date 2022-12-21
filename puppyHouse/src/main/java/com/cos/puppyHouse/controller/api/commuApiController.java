package com.cos.puppyHouse.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.puppyHouse.Service.commuService;
import com.cos.puppyHouse.config.auth.PrincipalDetail;
import com.cos.puppyHouse.dto.ResponseDto;
import com.cos.puppyHouse.model.Community;

@RestController
public class commuApiController {
	
	@Autowired
	private commuService commuService;
	
	@PostMapping("/api/commu")
	public ResponseDto<Integer> save(@RequestBody Community commu, @AuthenticationPrincipal PrincipalDetail principal) {
		commuService.write(commu, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/commu/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id) {
		commuService.delete(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/commu/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Community commu) {
		commuService.update(id,commu);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}