package com.cos.puppyHouse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.puppyHouse.Service.commuService;

@Controller
public class CommuController {
	
	@Autowired
	private commuService commuService;
	
	@GetMapping({"/auth/commuBoard/commuMain"})
	public String commuMain(Model model) {
		model.addAttribute("commu", commuService.list());
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
