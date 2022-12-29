package com.cos.puppyHouse.controller;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cos.puppyHouse.Service.PetService;
import com.cos.puppyHouse.model.Pet;
import com.cos.puppyHouse.repository.PetRepository;

@Controller
public class petController {

	@GetMapping("/petNote/petJoinForm")
	public String petJoinForm() {
		return "pet/petJoinForm";
	}
	
	@GetMapping ("/petNote/petUpdateForm")
	public String petUpdateForm() {
		return "pet/petUpdateForm";
	}
	
	@GetMapping ("/petNote/activity")
	public String activityDetail() {
		return "petNote/activityDetail";
	}
	
	@GetMapping ("/petNote/diary")
	public String diaryDetail() {
		return "petNote/diaryDetail";
	}
	
	@GetMapping ("/petNote/food")
	public String foodDetail() {
		return "petNote/foodDetail";
	}
	
	@GetMapping ("/petNote/health")
	public String healthDetail() {
		return "petNote/healthDetail";
	}
	
	@GetMapping ("/petNote/notice")
	public String noticeDetail() {
		return "petNote/petNoticeDetail";
	}
	
	
	@GetMapping ("/petNote/petJoinBtn")
	public String petJoinBtn() {
		return "petNote/petJoinBtn";
	}
	
	@GetMapping ("/petNote/petImg")
	public String petImg() {
		return "petNote/petImg";
	}
	
	
}