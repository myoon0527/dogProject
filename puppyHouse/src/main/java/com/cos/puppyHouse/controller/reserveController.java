package com.cos.puppyHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class reserveController {
	@GetMapping("/auth/reserveMain")
	public String reserveMain() {
		return "reserve/reserveMain";
	}
	
	@GetMapping("/reserve/reserveForm")
	public String reserveForm() {
		return "reserve/reserveForm";
	}
	
	@GetMapping("/reserve/myReserve")
	public String myReserve() {
		return "reserve/myReserve";
	}

}