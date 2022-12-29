package com.cos.puppyHouse.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@GetMapping("/auth/findUserId")
	public String findUserIdForm() {
		return "findUser/findUserId";
	}
	@GetMapping("/auth/findUserPassword")
	public String findUserPasswordForm() {
		return "findUser/findPassword";
	}
	@GetMapping("/auth/resetPassword2")
	public String resetPassword2() {
	    return "findUser/resetPassword2";
	}
	@GetMapping("/auth/resetUserPassword/{id}")
	public String resetUserPasswordForm(@PathVariable int id, Model model){
		System.out.println("selectedId"+id);
		model.addAttribute("selectedId",id);
		System.out.println(model.getAttribute("selectedId"));
		return "findUser/resetPassword";
	}
	
	@GetMapping("/auth/IdModal")
	public String IdModal() {
	    return "findUser/showId";
	}
	@GetMapping("/auth/testPage")
	public String testPage() {
		return "findUser/testPage";
	}
	@GetMapping("/auth/testModal")
	public String testModal() {
	    return "findUser/testModal";
	}
	
}
