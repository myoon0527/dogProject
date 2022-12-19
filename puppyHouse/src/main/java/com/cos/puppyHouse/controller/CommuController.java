package com.cos.puppyHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.puppyHouse.Service.commuService;

@Controller
public class CommuController {
	
	@Autowired
	private commuService commuService;
	
	@GetMapping({"/auth/commuBoard/commuMain"})
	public String commuMain(Model model, @PageableDefault(size = 6, sort = "commuId", 
	direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("commu", commuService.list(pageable));
		return "commuBoard/commuMain";
	}
	
	@GetMapping("/commuBoard/commuSaveForm")
	public String commuSaveForm() {
		return "commuBoard/commuSaveForm";
	}
	
	
	@GetMapping("/auth/commuBoard/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("commuBoard", commuService.detail(id));
		return "commuBoard/commuDetail";
	}
	
}
