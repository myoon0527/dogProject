package com.cos.puppyHouse.controller.api;


import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cos.puppyHouse.Service.commuService;
import com.cos.puppyHouse.config.auth.PrincipalDetail;
import com.cos.puppyHouse.dto.ResponseDto;
import com.cos.puppyHouse.model.Community;
import com.cos.puppyHouse.model.Reply;
import com.cos.puppyHouse.repository.commuRepository;

@RestController
public class commuApiController {
	
	@Autowired
	private commuService commuService;
	
	@Autowired
	private commuRepository commuRepository;
	
	//게시글 작성
	@PostMapping("/api/commu")
	public ResponseDto<Integer> save(@RequestBody Community commu, @AuthenticationPrincipal PrincipalDetail principal) {
		commuService.write(commu, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	//게시글 삭제
	@DeleteMapping("/api/commu/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id) {
		commuService.delete(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	//댓글 삭제
	@DeleteMapping("/api/commu/{commuid}/reply/{replyid}")
	public ResponseDto<Integer> replyDelete(@PathVariable int commuid, @PathVariable int replyid) {
		commuService.replyDelete(commuid ,replyid);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	//게시글 업데이트
	@PutMapping("/api/commu/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Community commu) {
		commuService.update(id,commu);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	//댓글 작성
	@PostMapping("/api/commu/{id}/reply")
	public ResponseDto<Integer> replySave(@PathVariable int id, @RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal) {
		System.out.println("replySave "+id);
		commuService.writeReply(id, reply, principal.getUser());
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	//이미지 업로드
	@PostMapping("/commu/saveImg")
	public String saveImg(Community commu, @RequestParam(value = "file", required = false)MultipartFile multipartFile, @AuthenticationPrincipal PrincipalDetail principal, Model model) throws Exception {
		
		String sourceFileName = multipartFile.getOriginalFilename(); //getOriginalFilename() 업로드되는 파일에서 확장자를 포함한 파일의 이름을 반환
		String sourceFileNameException = FilenameUtils.getExtension(sourceFileName).toLowerCase(); //getExtensio(): 파일명이 test.png 라면 "png" 가 리턴되고 "a/b/c.png" 의 경우에도 png만 리턴. 
		File destinationFile;																	//toLowerCase(): 문자열을 소문자로 변환해서 반환.
		String destinationFileName;
		String fileUrl = "C:\\image\\";  //서버 이미지 받기.(윈도우)
		
		do {
			destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameException;  //랜덤 문자열 생성
			destinationFile = new File(fileUrl + destinationFileName); //(파일 위치 + 랜덤 문자열) 객체생성
		} while (destinationFile.exists());
		
		destinationFile.getParentFile().mkdirs();  //부모 폴더 생성이 되지 않으면 파일 생성 오류 발생. 재귀적 부모 폴더 생성 코드 추가해준다.
		
		multipartFile.transferTo(destinationFile); //원하는 위치에 저장
		
		commu.setImgName(destinationFileName);
		commu.setImgOriName(sourceFileName);
		commu.setImgUrl(fileUrl);
		commu.setTitle("aa");
		commuService.write(commu, principal.getUser());
		
		return "commuBoard/commuMain";
	}
}