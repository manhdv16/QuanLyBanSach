package com.dvm.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.dvm.entity.Book;
import com.dvm.entity.dto.BookDTO;

public interface BookService {

	void delete(Book entity);

	long count();

	Optional<Book> findById(Integer id);

	List<Book> findAll();

	Book save(BookDTO dto) throws IOException;

	void deleteById(Integer id);

	Book update(BookDTO dto,Integer id) throws IOException;

	boolean findByTitleAndAuthor(String title, String author);

	void updateSold(Integer id, Integer quantity);
	
}
