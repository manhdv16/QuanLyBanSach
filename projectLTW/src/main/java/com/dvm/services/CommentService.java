package com.dvm.services;

import java.util.List;
import java.util.Optional;

import com.dvm.entity.Comment;

public interface CommentService {

	long count();

	Optional<Comment> findById(Integer id);

	List<Comment> findAll();

	Comment save(Comment entity);

	List<Comment> findAllByBookId(Integer book_id);

}
