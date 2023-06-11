package com.dvm.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvm.entity.Book;
import com.dvm.entity.Comment;
import com.dvm.entity.User;
import com.dvm.services.BookService;
import com.dvm.services.CommentService;
import com.dvm.services.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class commentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	@PostMapping("/add-comment")
	public void addComment(@RequestParam(name= "rating") Integer rating, @RequestParam(name="content") String content) {
		User user = userService.findById((String)session.getAttribute("username")).get();
		Book book = bookService.findById((Integer)session.getAttribute("book_id")).get();
		Date date = new Date();
		Comment comment = new Comment(content, rating,date,user,book);
		commentService.save(comment);
	}
	
}
