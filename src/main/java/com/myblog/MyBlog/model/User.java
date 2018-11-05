package com.myblog.MyBlog.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="user")
public class User {



	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable=false,length=30)
	@NotNull(message="is required!!")
	@Size(min=3,max=30, message="must be 3, 30 interval!")
	private String username;
	
	
	@Column(nullable=false,length=68)
	@NotNull(message=" is required!")
	@Size(min=6, message="must be longer than 5 char!!")
	private String password;
	
	@Column(nullable=false,length=68)
	@NotNull(message="is required!")
	@Size(min=6, message="must be longer than 5 char!")
	private String passwordCheck;
	
	@Column(nullable=false,length=50)
	@NotNull
	@Size(min=10,max=50,message="must be 10,50 interval!")
	private String email;
	
	@OneToMany(mappedBy="author")
	private Set<Post> posts = new HashSet<>();
	
	@ManyToMany(fetch= FetchType.EAGER, cascade= {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="user_role",
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
	public User() {
		
		
	}

	public User(Long id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
	
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", passwordCheck="
				+ passwordCheck + ", email=" + email + "]";
	}
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
}
