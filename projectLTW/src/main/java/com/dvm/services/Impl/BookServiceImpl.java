package com.dvm.services.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvm.converter.ImageConvert;
import com.dvm.entity.Book;
import com.dvm.entity.dto.BookDTO;
import com.dvm.repositories.BookRepository;
import com.dvm.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;
	
	ImageConvert imageConvert= null;
	
	@Override
	public Book save(BookDTO dto) throws IOException {
		String dtoCover="";
		if(dto.getCover()!=null) {
			dtoCover = imageConvert.convertMultipartFileToString(dto.getCover());
		}
		Book entity = new Book(dto.getTitle(), dto.getAuthor(), dto.getDescription(), dtoCover, 
				dto.getPubdate(), dto.getPagenumber(), dto.getCategory(), dto.getPrice());
		return bookRepository.save(entity);
	}	

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> findById(Integer id) {
		return bookRepository.findById(id);
	}
	
	@Override
	public boolean findByTitleAndAuthor(String title,String author) {
		for(Book x: findAll()) {
			if(x.getAuthor().equals(author)&& x.getTitle().equals(title)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public long count() {
		return bookRepository.count();
	}

	@Override
	public void delete(Book entity) {
		bookRepository.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		bookRepository.deleteById(id);
	}
	
	@Override
	public Book update(BookDTO dto,Integer id) throws IOException {
		String dtoCover=null;
		if(dto.getCover()!=null) {
			dtoCover = imageConvert.convertMultipartFileToString(dto.getCover());
		}
		
		Book book = findById(id).get();
		if(dto.getTitle()!=null) 				book.setTitle(dto.getTitle());
		if(dto.getAuthor()!= null) 				book.setAuthor(dto.getAuthor());
		if(dto.getDescription()!= null) 		book.setDescription(dto.getDescription());
		if(dtoCover !=null) 					book.setCover(dtoCover);
		if(dto.getPubdate()!= null) 			book.setPubdate(dto.getPubdate());
		if(dto.getPagenumber() !=null) 			book.setPagenumber(dto.getPagenumber());
		if(dto.getPrice()!= null)  				book.setPrice(dto.getPrice());
		if(dto.getCategory().getName()!= book.getCategory().getName()) 	book.setCategory(dto.getCategory());
		return bookRepository.save(book);
	}
	
	@Override
	public void updateSold(Integer id,Integer quantity) {
		Book book = findById(id).get();
		book.setSold(book.getSold()+quantity);
		bookRepository.save(book);
	}

}
