package com.integrify.libbook.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "ISBN")
	private Long isbn;
	@Column(nullable = false, name = "Title")
	private String title;

	@Column(nullable = false, name = "Author")
	private String author;

	@Column(nullable = false, name = "category_id")
	private Long categoryId; // Use a numeric data type for category_id

	@Column(nullable = false, name = "Description")
	private String description;

	@Column(nullable = false, name = "Edition")
	private String edition;

	@Column(nullable = false, name = "Price")
	private Double price;

	@Column(nullable = false, name = "ImageURL")
	private String imageURL;

	@Column(nullable = false, name = "added_on")
	private String addedOn;

	// Constructors, getters, setters, and other methods go here...

	// Getters and setters using JavaBean naming conventions
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}
}