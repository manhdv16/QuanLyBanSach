package com.dvm.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dvm.converter.ImageConvert;
import com.dvm.entity.Book;
import com.dvm.entity.Category;
import com.dvm.entity.dto.BookDTO;
import com.dvm.entity.dto.bookdto1;
import com.dvm.services.BookService;
import com.dvm.services.CategoryService;

@CrossOrigin
@RestController
public class adminRController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	CategoryService categoryService;
	
	ImageConvert imageConvert= null;
	
	@ModelAttribute(name = "Category")
	public List<Category> getAll() {
		return categoryService.findAll();
	}
	
	@GetMapping("get-book-details/{book_id}")
    public bookdto1 getBookDetails(@PathVariable("book_id") Integer book_id) {
        Optional<Book> optionalBook = bookService.findById(book_id);
        Book book = optionalBook.get();   
        bookdto1 book1 = new bookdto1(book.getTitle(), book.getAuthor(), book.getDescription()
        		, book.getCover(), book.getPubdate(), book.getPagenumber(), book.getPrice(), book.getCategory().getName());     
        return book1;   
    }
	@PostMapping("/add-book")
	public ResponseEntity<?> addBook(@RequestParam(name = "title") String title,
			@RequestParam(name = "author") String author, @RequestParam(name = "description" ,required = false) String description,
			@RequestParam(name = "image", required = false) MultipartFile image,
			@RequestParam(name = "publicationDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date publicationDate,
			@RequestParam(name = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(name = "category_id") Integer category_id, 
			@RequestParam(name = "price",required = false) Integer price) throws IOException {
		
		if(bookService.findByTitleAndAuthor(title, author)) {
			BookDTO dto = new BookDTO(title, author, description, image, publicationDate, pageNumber,
				 price,categoryService.findById(category_id));
			return new ResponseEntity<>(bookService.save(dto) , HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Sách đã tồn tại.");
	}
	
	@PutMapping("edit-book/{book_id}")
	public ResponseEntity<?> editBook(@PathVariable Integer book_id, @RequestParam(name = "title",required = false) String title,
	@RequestParam(name = "author",required = false) String author, @RequestParam(name = "description",required = false) String description,
	@RequestParam(name = "image",required = false) MultipartFile image,
	@RequestParam(name = "publicationDate",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date publicationDate,
	@RequestParam(name = "pageNumber",required = false) Integer pageNumber,
	@RequestParam(name = "category_id",required = false) Integer category_id, 
	@RequestParam(name = "price",required = false) Integer price) throws IOException{
		
		BookDTO dto = new BookDTO(title, author, description, image, publicationDate, pageNumber,
				price,categoryService.findById(category_id));
		return new ResponseEntity<>(bookService.update(dto,book_id), HttpStatus.OK);
	}
	
	@DeleteMapping("delete-book/{book_id}")
	public void books(@PathVariable("book_id") Integer book_id) {
		bookService.deleteById(book_id);
	}
}
