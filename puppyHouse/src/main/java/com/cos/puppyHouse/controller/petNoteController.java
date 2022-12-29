package com.cos.puppyHouse.controller;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cos.puppyHouse.Service.PetService;
import com.cos.puppyHouse.config.auth.PrincipalDetail;
import com.cos.puppyHouse.model.Pet;
import com.cos.puppyHouse.repository.PetRepository;

@Controller
public class petNoteController {
	
	@Autowired
	private PetService petService;
	
	
	@GetMapping("/petNote/pets")
	public String petsname(Model model) {
		model.addAttribute("petname",petService.강아지정보());
		return "petNote/PetNoteWrite";
		
	}
	
	@GetMapping("/petNote/petMain")
	public String petsMain(Model model) {
		model.addAttribute("petname",petService.강아지정보());
		return "petNote/petNoteMain";
		
	}
	
	
	@GetMapping("/petNote/{petId}")
	public String findById(@PathVariable int petId, Model model) {
		System.out.println("수첩상세보기 호출");
		//model.addAttribute("pet",petService.강아지목록()); 
		model.addAttribute("petId",petId);
		model.addAttribute("pets",petService.강아지수첩상세보기(petId));
		return "petNote/petNoteMain";
	}
	
//	@GetMapping("/reserve/{reservId}")
//	public String reservId(@PathVariable int reservId, Model model, @AuthenticationPrincipal PrincipalDetail principal) {
//		System.out.println("매니저 예약 강아지 controller 호출");
//		model.addAttribute("loginuserreserv",principal.getUser().getReserv());
//		model.addAttribute("reservId",reservId);
//		model.addAttribute("reserv",reserveService.예약강아지목록상세보기(reservId));
//		return "petNote/petNoteMain";
//	}
//	
	
	@Autowired
	private PetRepository petRepository;
	
	@RequestMapping(value ="/pet/saveImg", method = RequestMethod.POST)
	public String saveImg(Pet pet, @RequestParam(value = "file", required = false)MultipartFile multipartFile,  @AuthenticationPrincipal PrincipalDetail principal, Model model) throws Exception {
		System.out.println("saveImg 호출");
		
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
		
		pet.setImgName(destinationFileName);
		pet.setImgOriName(sourceFileName);
		pet.setImgUrl(fileUrl);
		pet.setUsers(principal.getUser());
		System.out.println("펫아이디"+pet.getPetId());
		petRepository.save(pet);
		model.addAttribute("pets",petService.강아지수첩상세보기(pet.getPetId()));
		
		return "pet/petJoinForm";
	}

}