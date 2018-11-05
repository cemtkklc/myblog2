<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="head.jsp"></jsp:include>
		<Title>Register</Title>
	</head>
	<body>
		<div class="container-fluid">
			<jsp:include page="header.jsp"></jsp:include>
		
			<div class="row">
				<div class="col-lg-6 mx-auto">
									  <div class="text-center">
										<h3><b>Register</b></h3></div>
									  <form:form id="ajax-register-form" modelAttribute="userForm" action="registerAuth" method="post" role="form" autocomplete="off">
											<div class="form-group ">
											  <form:input type="text" name="username" id="username" tabindex="1" class="form-control"  path="username" placeholder="Username"/>
											  <form:errors path="username"/>
											</div>
											<div class="form-group">
											  <form:input type="email" name="email" id="email" tabindex="1" class="form-control" path="email" placeholder="Email Address"/>
											  <form:errors path="email"/>
											</div>
											<div class="form-group">
											  <form:input type="password" name="password" id="password" tabindex="2" class="form-control" path="password" placeholder="Password"/>
												<form:errors path="password" />
											</div>
											<div class="form-group">
											  <form:input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control"  path="passwordCheck" placeholder="Confirm Password"/>
												<form:errors path="passwordCheck"/>
											</div>
											<div class="form-group">
											  <div class="row">
												<div class="col-lg-12">
												  <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-info" value="Register Now">
												</div>
											  </div>
											</div>
										
									   </form:form>
									</div>
				</div>
			</div>
		
		
		
	
	</body>

</html>