package com.dvm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dvm.entity.User;
import com.dvm.services.BookService;
import com.dvm.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/login")
	public String Showlogin() {
		return "login";
	}
	@GetMapping("/logout")
	public String logout() {
		session.removeAttribute("loggedIn");
		session.removeAttribute("username");
		session.removeAttribute("fullname");
		session.removeAttribute("role");
		return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String showRegisterUserPage() {
		return "register";
	}
	
	@PostMapping("/home")
	public String checkLogin(Model model,@RequestParam("username")String username,
			@RequestParam("password")String password) {
		if(userService.checkLogin(username, password)){
			session.setAttribute("username",username);
			session.setAttribute("fullname", userService.findById(username).get().getFullname());
			session.setAttribute("loggedIn", true);		
			String role = userService.findById(username).get().getRole();
			session.setAttribute("role", role);
			
			model.addAttribute("username", username);
			model.addAttribute("fullname",session.getAttribute("fullname") );
			model.addAttribute("loggedIn", session.getAttribute("loggedIn"));
			model.addAttribute("books", bookService.findAll());

			if(role.equals("admin")) {
				return "redirect:/admin";
			}else {
				return "listBook";
			}
			
		}else {
			model.addAttribute("ERROR", "Tài khoản hoặc mật khẩu không đúng.");
			return "login";
		}	
	}
	
	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(Model model,@ModelAttribute("USER") User user) {
		if(userService.checkUserExisted(user.getUsername())) {
			userService.save(user);
			model.addAttribute("user", user);
			return "sucess-register";
		}else {
			model.addAttribute("errorRegister", "Tên tài khoản đã tồn tại.");
			return "register";
		}
		
	}
}
