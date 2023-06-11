package com.dvm.entity;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer book_id;
	
	@NotNull
	@Column(name = "title",length=50)
	private String title;
	
	@NotNull
	@Column(name = "author",length=50)
	private String author;
	
	@Column(name = "description",length=500)
	private String description;
	
	@Column(name = "cover",length=500)
	private String cover;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date pubdate;
	
	@Column
	private Integer pagenumber;
	
	@Column
	private Integer price;
	
	@Column(columnDefinition = "integer default 0")
	private Integer sold = 0;
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
	private Set<Order> orders;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="category_id")
	private Category category;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String author, String description, String cover, Date pubdate, Integer pagenumber,
			Category category, Integer price) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.cover = cover;
		this.pubdate = pubdate;
		this.pagenumber = pagenumber;
		this.category = category;
		this.price = price;
	}

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	
}
