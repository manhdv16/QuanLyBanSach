package com.dvm.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvm.entity.Comment;
import com.dvm.repositories.CommentRepository;
import com.dvm.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public Optional<Comment> findById(Integer id) {
		return commentRepository.findById(id);
	}

	@Override
	public long count() {
		return commentRepository.count();
	}

	@Override
	public List<Comment> findAllByBookId(Integer book_id) {
		List<Comment> list = new ArrayList<>();
		for(Comment x: findAll()) {
			if(x.getBook().getBook_id().equals(book_id)) {
				list.add(x);
			}
		}
		return list;
	}
	
	
}
