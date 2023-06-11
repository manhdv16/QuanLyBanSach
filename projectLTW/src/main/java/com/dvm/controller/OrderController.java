package com.dvm.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dvm.entity.Book;
import com.dvm.entity.Order;
import com.dvm.entity.User;
import com.dvm.repositories.OrderRepository;
import com.dvm.services.BookService;
import com.dvm.services.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/home/buy/{book_id}")
	public String enterQuantity(Model model, @PathVariable Integer book_id) {
		Optional<Book> optionalBook = bookService.findById(book_id);
		model.addAttribute("book", optionalBook.get());
		session.setAttribute("book", optionalBook.get());
		session.setAttribute("book_id", book_id);
		session.setAttribute("bookcover",optionalBook.get().getCover());
		model.addAttribute("bookcover", optionalBook.get().getCover());
		return "order";
	}
	
	@PostMapping("/order-detail")
	public String orderDetail(Model model,@RequestParam("quantity") Integer quantity) {
		Integer book_id =  (Integer) session.getAttribute("book_id");
		Optional<Book> optionalBook = bookService.findById(book_id);
		model.addAttribute("book", optionalBook.get());
		session.setAttribute("quantity", quantity);
		model.addAttribute("quantity", (Integer)session.getAttribute("quantity"));
		return "order-detail";
	}
	
	@PostMapping("/order-success")
	public String placeOrder(@ModelAttribute("order") Order order,@RequestParam("total_amount") Integer totalAmount) {
		Integer book_id =  (Integer) session.getAttribute("book_id");
		Date today= new Date();
		Integer quantity= (Integer)session.getAttribute("quantity");
		order.setQuantity(quantity);
        order.setOrder_date(today);
        order.setUser(new User((String)session.getAttribute("username")));
        order.setTotal_amount(totalAmount);
        order.setBook(bookService.findById(book_id).get());
	    orderRepository.save(order);	    
	    bookService.updateSold(book_id, quantity);
	    return "order-success";
	}	
	
	@GetMapping("/my-orders")
	public String getAllOrder(Model model) {
		model.addAttribute("orders", orderService.findAllByIdUsername((String)session.getAttribute("username")));
		return "myOrders";
	}
	
	@GetMapping("/order-detail/{order_id}")
	public String viewOrderById(Model model, @RequestParam("order_id") Integer order_id) {
		
		model.addAttribute("order", orderService.findById(order_id).get());
		return "order-detail";
	}
	
	@PostMapping("/cancel-order")
	public String cancelOrder(Model model,@RequestParam("order_id") Integer order_id) {
		orderService.deleteById(order_id);
		model.addAttribute("orders", orderService.findAllByIdUsername((String)session.getAttribute("username")));
		return "redirect:/my-orders";
	}
	
	
}
