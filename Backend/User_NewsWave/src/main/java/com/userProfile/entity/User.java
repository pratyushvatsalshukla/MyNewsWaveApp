package com.userProfile.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//@Blank use.

	@NotBlank(message = "Name is required")
	@Size(min=3, max=30, message = "Name must be between 3 and 30 characters")
	private String name;
	
	@NotBlank(message = "emailId is required")
	@Email
	private String emailId;

	@NotBlank(message = "Password is required")
	@Size(min=6, max=30, message = "Password must be between 6 and 30 characters")
	private String password;

	// @Transient to tell it that we do not need to save it in database
	@Transient
	private List<Wishlist> wishlist ;

	public User(int id, String name, String emailId, String password, List<Wishlist> wishlist) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.wishlist = wishlist;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Wishlist> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}
}
