package com.cos.puppyHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.puppyHouse.Service.PetService;
import com.cos.puppyHouse.Service.petBoardService;
import com.cos.puppyHouse.model.PetBoardRoleType;

@Controller
public class petBoardController {

	@Autowired
	private petBoardService petBoardService;
	
	@Autowired
	private PetService petService;

	@GetMapping("/petNote/petNotice/FOOD/{petId}")
	public String petBoardFOOD(@PageableDefault(size = 4, sort = "petBoardId", direction = Sort.Direction.DESC) Pageable pageable,@PathVariable int petId, Model model) {
		System.out.println("petBoard 호출");
		int pageNumber = petBoardService.글목록(pageable, PetBoardRoleType.FOOD).getPageable().getPageNumber(); // 현재페이지
		int totalPages = petBoardService.글목록(pageable, PetBoardRoleType.FOOD).getTotalPages(); // 총 페이지 수
		int pageBlock = 4; // 숫자 블럭 수 1부터 10
		int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
		int endBlockPage = startBlockPage + pageBlock - 1;
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;
		
		model.addAttribute("pets",petService.강아지수첩상세보기(petId));
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("petnotices", petBoardService.글목록(pageable, PetBoardRoleType.FOOD));
		

		return "petNote/foodDetail";
	}
	
	@GetMapping("/petNote/petNotice/NOTE/{petId}")
	public String petBoardNOTE(@PageableDefault(size = 4, sort = "petBoardId", direction = Sort.Direction.DESC) Pageable pageable,@PathVariable int petId, Model model) {
		System.out.println("petBoard 호출");
		int pageNumber = petBoardService.글목록(pageable, PetBoardRoleType.NOTE).getPageable().getPageNumber(); // 현재페이지
		int totalPages = petBoardService.글목록(pageable, PetBoardRoleType.NOTE).getTotalPages(); // 총 페이지 수
		int pageBlock = 4; // 숫자 블럭 수 1부터 10
		int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
		int endBlockPage = startBlockPage + pageBlock - 1;
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

		model.addAttribute("pets",petService.강아지수첩상세보기(petId));
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("petnotices", petBoardService.글목록(pageable, PetBoardRoleType.NOTE));

		return "petNote/petNoticeDetail";
	}
	
	@GetMapping("/petNote/petNotice/ACTIVITY/{petId}")
	public String petBoardACTIVITY(@PageableDefault(size = 4, sort = "petBoardId", direction = Sort.Direction.DESC) Pageable pageable,@PathVariable int petId, Model model) {
		System.out.println("petBoard 호출");
		int pageNumber = petBoardService.글목록(pageable, PetBoardRoleType.ACTIVITY).getPageable().getPageNumber(); // 현재페이지
		int totalPages = petBoardService.글목록(pageable, PetBoardRoleType.ACTIVITY).getTotalPages(); // 총 페이지 수
		int pageBlock = 4; // 숫자 블럭 수 1부터 10
		int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
		int endBlockPage = startBlockPage + pageBlock - 1;
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

		model.addAttribute("pets",petService.강아지수첩상세보기(petId));
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("petnotices", petBoardService.글목록(pageable, PetBoardRoleType.ACTIVITY));

		return "petNote/activityDetail";
	}
	
	@GetMapping("/petNote/petNotice/HEALTH/{petId}")
	public String petBoardHEALTH(@PageableDefault(size = 4, sort = "petBoardId", direction = Sort.Direction.DESC) Pageable pageable,@PathVariable int petId, Model model) {
		System.out.println("petBoard 호출");
		int pageNumber = petBoardService.글목록(pageable, PetBoardRoleType.HEALTH).getPageable().getPageNumber(); // 현재페이지
		int totalPages = petBoardService.글목록(pageable, PetBoardRoleType.HEALTH).getTotalPages(); // 총 페이지 수
		int pageBlock = 4; // 숫자 블럭 수 1부터 10
		int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
		int endBlockPage = startBlockPage + pageBlock - 1;
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

		model.addAttribute("pets",petService.강아지수첩상세보기(petId));
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("petnotices", petBoardService.글목록(pageable, PetBoardRoleType.HEALTH));

		return "petNote/healthDetail";
	}
	
	@GetMapping("/petNote/petNotice/DIARY/{petId}")
	public String petBoardDIARY(@PageableDefault(size = 4, sort = "petBoardId", direction = Sort.Direction.DESC) Pageable pageable,@PathVariable int petId, Model model) {
		System.out.println("petBoard 호출");
		int pageNumber = petBoardService.글목록(pageable, PetBoardRoleType.DIARY).getPageable().getPageNumber(); // 현재페이지
		int totalPages = petBoardService.글목록(pageable, PetBoardRoleType.DIARY).getTotalPages(); // 총 페이지 수
		int pageBlock = 4; // 숫자 블럭 수 1부터 10
		int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
		int endBlockPage = startBlockPage + pageBlock - 1;
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

		model.addAttribute("pets",petService.강아지수첩상세보기(petId));
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("petnotices", petBoardService.글목록(pageable, PetBoardRoleType.DIARY));

		return "petNote/diaryDetail";
	}

}
