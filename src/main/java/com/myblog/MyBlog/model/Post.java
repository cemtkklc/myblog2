package com.myblog.MyBlog.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, length=300)
	private String title;
	@Column(nullable=false,length=500)
	private String body;
	@Column(nullable=false)
	private Date date = new Date();
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="author_id")
	private User author;
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="category_id")
	private Category category;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="image_id")
	private Image image;

	public Post(Long id, String title, String body, Date date, User author, Category category,Image image) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.author = author;
		this.category = category;
		this.image= image;
	}
	
	public Post() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	
	
	
	
}
