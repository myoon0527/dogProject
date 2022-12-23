package com.cos.puppyHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommuController {
	
	@GetMapping("/commuBoard/commuMain")
	public String commuMain()	{
		return "commuBoard/commuMain";
	}
	
	@GetMapping("/commuBoard/commuSaveForm")
	public String commuSaveForm() {
		return "commuBoard/commuSaveForm";
	}
	
	/*
	@GetMapping("/commuBoard/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("commuBoard", communityService.detail(id));
		return "commuBoard/detail";
	}
	*/
}
