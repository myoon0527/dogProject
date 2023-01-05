package com.cos.puppyHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.puppyHouse.Service.NoticeService;
import com.cos.puppyHouse.model.NoticeRoleType;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/auth/news/{roles}")
	public String newsMain(@PageableDefault(size=10, sort="noticeId", direction=Sort.Direction.DESC) Pageable pageable, @PathVariable NoticeRoleType roles, Model model) {
		System.out.println("news롤 호출");
		int pageNumber = noticeService.글목록(pageable,roles).getPageable().getPageNumber();  //현재페이지
		int totalPages = noticeService.글목록(pageable,roles).getTotalPages(); //총 페이지 수
		int pageBlock = 10;  //숫자 블럭 수 1부터 10
		int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1;
		int endBlockPage = startBlockPage+pageBlock-1;
		endBlockPage = totalPages<endBlockPage? totalPages:endBlockPage;
		
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("notices", noticeService.글목록(pageable,roles));
		return "news/newsMain";
	}
	

	@GetMapping("/news/saveForm")
	public String saveForm() {
			return "news/newsSaveForm";
	}
	
	@GetMapping("/news/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("notice", noticeService.글상세보기(id));
		return "news/newsDetail";
	}
	
	@GetMapping("/news/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("notice", noticeService.글상세보기(id));
		return "news/newsUpdateForm";
	}
	
}
