package com.dvm.entity.dto;

import java.util.Date;

public class bookdto1 {
	private Integer book_id;
	private String title;
	private String author;
	private String description;
	private String cover;
	private Date pubdate;
	private Integer pagenumber;
	private Integer price;
	private Integer sold;
	private String categoryName;
	
	public bookdto1() {
		// TODO Auto-generated constructor stub
	}

	public bookdto1(String title, String author, String description, String cover, Date pubdate,
			Integer pagenumber, Integer price, String categoryName) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.cover = cover;
		this.pubdate = pubdate;
		this.pagenumber = pagenumber;
		this.price = price;
		this.categoryName = categoryName;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public Integer getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(Integer pagenumber) {
		this.pagenumber = pagenumber;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
