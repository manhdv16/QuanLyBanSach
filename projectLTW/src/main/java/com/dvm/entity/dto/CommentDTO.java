package com.dvm.entity.dto;

public class CommentDTO {
	private Integer comment_id;
	private String content;
	private Integer rating;
	private String user_id;
	private Integer book_id;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public CommentDTO(String content, Integer rating, String user_id, Integer book_id) {
		super();
		this.content = content;
		this.rating = rating;
		this.user_id = user_id;
		this.book_id = book_id;
	}

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	
}
