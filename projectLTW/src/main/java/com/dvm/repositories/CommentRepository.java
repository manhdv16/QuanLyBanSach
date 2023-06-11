package com.dvm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvm.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
