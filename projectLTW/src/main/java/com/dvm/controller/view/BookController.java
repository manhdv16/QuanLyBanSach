package com.dvm.controller.view;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dvm.entity.Book;
import com.dvm.entity.Comment;
import com.dvm.repositories.OrderRepository;
import com.dvm.services.BookService;
import com.dvm.services.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/home")
	public String homeView(Model model) {
		String role = (String)session.getAttribute("role");
		model.addAttribute("books", bookService.findAll());
		if(role!=null && role.equals("admin")) {
			return "listBook";
		}else {
			session.getAttribute("fullname");
			session.getAttribute("username");
			model.addAttribute("fullname",(String)session.getAttribute("fullname") );
			model.addAttribute("loggedIn", session.getAttribute("loggedIn"));
			return "listBook";
		}
	}
	
	@GetMapping("/home/book-detail/{book_id}")
	public String getBook(Model model, @PathVariable Integer book_id) {	
		
		Optional<Book> optionalBook = bookService.findById(book_id);
		if (optionalBook.isPresent()) {
			List<Comment> list = commentService.findAllByBookId(book_id);
			model.addAttribute("comments", list);
		    Book book = optionalBook.get();
		    session.setAttribute("book_id", book_id);
		    model.addAttribute("book", book);
		} else {
		}	
		return "book-detail";
	}
	
	
	
}
