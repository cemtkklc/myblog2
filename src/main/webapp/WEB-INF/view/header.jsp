<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

		
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath}/"><i class="fab fa-blogger-b"></i> MyBlog</a>
				</div>
			
			<ul class="nav navbar-nav mr-auto">
				<li class="nav-item" href="#">
					<a class="nav-link" href="${pageContext.request.contextPath}/"><i class="fas fa-home"></i> Home</a>
				</li>
				<security:authorize access="isAuthenticated()">
					<li class="nav-item" href="#">
						<a class="nav-link" href="${pageContext.request.contextPath}/post/myposts"><i class="fas fa-user"></i> My Posts</a>
					</li>
					
					<li class="nav-item" href="#">
						<a class="nav-link" href="${pageContext.request.contextPath}/post/createpost"><i class="fas fa-pen"></i> Create Post</a>
					</li>
				</security:authorize>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					  <i class="fas fa-list-ul"></i>
					  Categories
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					  <a class="dropdown-item" href="${pageContext.request.contextPath}/post/getCategory?categoryName=news"><i class="fas fa-newspaper"></i> News</a>
					  <a class="dropdown-item" href="${pageContext.request.contextPath}/post/getCategory?categoryName=economy"><i class="fas fa-dollar-sign"></i> Economy</a>
					  <a class="dropdown-item" href="${pageContext.request.contextPath}/post/getCategory?categoryName=politics"><i class="fas fa-balance-scale"></i> Politics</a>
					  <a class="dropdown-item" href="${pageContext.request.contextPath}/post/getCategory?categoryName=science"><i class="fas fa-microscope"></i> Science</a>
					  <a class="dropdown-item" href="${pageContext.request.contextPath}/post/getCategory?categoryName=technology"><i class="fas fa-laptop"></i> Technology</a>
					  <a class="dropdown-item" href="${pageContext.request.contextPath}/post/getCategory?categoryName=cultureart"><i class="fas fa-book-reader"></i> Culture & Art</a>
					  <a class="dropdown-item" href="${pageContext.request.contextPath}/post/getCategory?categoryName=others"><i class="fas fa-arrow-alt-circle-right"></i> Others</a>
					</div>
				</li>
				<li class="nav-item" href="#">
					<a class="nav-link" href="#"><i class="fas fa-info-circle"></i> About</a>
				</li>
				<li class="nav-item" href="#">
					<a class="nav-link" href="#"><i class="fas fa-envelope"></i> Contact</a>
				</li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li class="nav-item px-1">
					<form class="form-inline" action="#">
						<input class="form-control" type="text" placeholder="Search"/>
						<button class="btn btn-outline-success" type="submit"><i class="fas fa-search"></i>Search</button>
					</form>
				</li>
							
				<security:authorize access="!isAuthenticated()">
					<li class="nav-item  px-1">
						<a href="${pageContext.request.contextPath}/register" class="btn btn-outline-info btn-md " id="navbarDropdown" role="button"  aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-plus"></i>Sign Up</a>
						
					</li>
				</security:authorize>
				<security:authorize access="!isAuthenticated()">
				<li class="nav-item dropdown px-1">
					<a href="#" class="btn btn-outline-danger btn-md dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-sign-in-alt"></i>Login </a>
					<ul class="dropdown-menu" role="menu">
						<div class="container-fluid">
							<div class="row">
								<div class="col-lg-12">
								  <div class="text-center">
									<h3><b>Login</b></h3></div>
								  <form:form id="ajax-login-form" action="${pageContext.request.contextPath}/authUser" method="POST" role="form" autocomplete="off">
										<div class="form-group">
										  <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username">
										</div>
										
										<div class="form-group">
										  <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
										</div>
										
										<div class="form-group">
										  <div class="row">
											<div class="col-lg-12">
											  <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-info" value="Login">
											</div>
										  </div>
										</div>
									
								   </form:form>
								</div>
							</div>
						</div>
					</ul>
				</li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="nav-item px-1">
						<form:form method="post" action="/logout">
							<button type="submit" class="btn btn-outline-danger"><i class="fas fa-sign-out-alt"></i> Logout </button>
						</form:form>	
					</li>
				</security:authorize>
			
			</ul>
			
			
			</div>
		</nav>
		<br>
	