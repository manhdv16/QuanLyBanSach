package com.dvm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvm.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
