<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="head.jsp"></jsp:include>
	</head>
	<body>
		<div class="container-fluid">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
		<!--  <img src="${pageContext.request.contextPath}/image/imageDisplay?id=1"/>	-->	
		<div  id=myCarousel class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active" style="width:auto; height:400px;">
				  <img class="d-block w-100"  src="${pageContext.request.contextPath}/image/imageDisplay?id=${firstPost.image.id}">
				  <div class="carousel-caption d-none d-md-block">
					<h5>${firstPost.title}</h5>
					<p>${firstPost.category.name}</p>
				</div>
				</div>
			
			<c:forEach var="temp" items="${latesPosts}">
				
				
				<div class="carousel-item" style="width:auto; height:400px;">
				  <img class="d-block w-100"  src="${pageContext.request.contextPath}/image/imageDisplay?id=${temp.image.id}">
				  <div class="carousel-caption d-none d-md-block">
					<h5>${temp.title}</h5>
					<p>${temp.category.name}</p>
				</div>
				</div>
			
			
			</c:forEach>
			</div>
			<a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<div class="w-75 p-3">
			<div class="row">
				<div class="col-lg-12">
					<div class="card-deck">
						<c:forEach var="temp" items="${allPosts}">
							<div class="card">
								<img class="card-img-top" src="${pageContext.request.contextPath}/image/imageDisplay?id=${temp.image.id}">
								<div class="card-body">
								  <h5 class="card-title">${temp.title}</h5>
								   <a href="${pageContext.request.contextPath}/post/getPost?id=${temp.id}" class="btn btn-primary">Read Article</a>
								</div>
								<div class="card-footer">
								  <small class="text-muted">${temp.category.name}, <mark>${temp.author.username}</mark> </small>
								</div>
							</div>
						</c:forEach>
						<!-- Will be populated with card objects -->
					</div>
				</div>
			</div>
		</div>
		
	</body>

</html>














