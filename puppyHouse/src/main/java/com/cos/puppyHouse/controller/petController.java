package com.cos.puppyHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping ("/petNote/petNoteMain")
	public String petNoteMain() {
		return "petNote/petNoteMain";
	}

	

}