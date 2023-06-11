package com.dvm.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dvm.entity.Book;
import com.dvm.entity.Category;
import com.dvm.services.BookService;
import com.dvm.services.CategoryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class adminController {

	@Autowired
	BookService bookService;

	@Autowired
	CategoryService categoryService;
	HttpSession session;
	@GetMapping("admin")
	public String adminView(Model model,HttpServletRequest request) {
		session = request.getSession();
		String role = (String) session.getAttribute("role");
		if(role!=null && role.equals("admin")) {
			List<Book> book = bookService.findAll();
			model.addAttribute("books", book);
			return "admin";
		}else {
			return "redirect:/login";
		}
	}

	@ModelAttribute(name = "Category")
	public List<Category> getAll() {
		return categoryService.findAll();
	}
	
}
