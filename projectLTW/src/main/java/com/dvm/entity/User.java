package com.dvm.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="user")
public class User {
	
	@Id
	@Column(name ="username", length = 50)
	private String username;
	
	@Column(name ="password", length = 50)
	private String password;
	
	@Column(name ="fullname", length = 50)
	private String fullname;
	
	@Column(name="email",length=50)
	private String email;
	
	@Column
	private boolean gender;
	
	@Column
	private String role;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Order> orders;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Comment> comments;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username) {
		super();
		this.username = username;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}