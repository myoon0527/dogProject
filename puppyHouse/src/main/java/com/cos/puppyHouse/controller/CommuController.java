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
	
	//커뮤니티 메인
	@GetMapping({"/auth/commuBoard/commuMain"})
	public String commuMain(Model model, @PageableDefault(size = 6, sort = "commuId", 
	direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("commu", commuService.list(pageable));
		return "commuBoard/commuMain";
	}
	
	
	//커뮤니티 게시글 작성
	@GetMapping("/commuBoard/commuSaveForm")
	public String commuSaveForm() {
		return "commuBoard/commuSaveForm";
	}
	
	
	//커뮤니티 게시글 자세히 보기
	@GetMapping("/auth/commuBoard/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("commu", commuService.detail(id));
		return "commuBoard/commuDetail";
	}
	
	
	//커뮤니티 게시글 수정
	@GetMapping("/commuBoard/{id}/commuUpdate")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("commu",commuService.detail(id));
		return "commuBoard/commuUpdate";
	}
	
	
	@GetMapping("/commuBoard/{id}")
	public String reply(@PathVariable int id, Model model) {
		model.addAttribute("commu", commuService.detail(id));
		return "commuBoard/commuDetail";
	}
}
