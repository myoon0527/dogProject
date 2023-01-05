package com.cos.puppyHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.puppyHouse.Service.NoticeService;
import com.cos.puppyHouse.Service.PetService;

@Controller
public class petController {
	
	@Autowired
	private PetService petService;
	
	@GetMapping ("/petNote/petUpdateForm/{petId}")
	public String petUpdateForm(@PathVariable int petId, Model model) {
		model.addAttribute("pet", petService.강아지수첩상세보기(petId));
		return "pet/petUpdateForm";
	}
	
	@GetMapping ("/petNote/petImg")
	public String petImg() {
		return "petNote/petImg";
	}
	
	@GetMapping ("/petNote/petJoinBtn")
	public String petJoinBtn() {
		return "petNote/petJoinBtn";
	}
	
}