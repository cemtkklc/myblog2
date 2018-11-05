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
		<br><br>
		<hr>
		<div class="w-100 p-3">
			<div class="row">
				<div class="col-lg-12">
					<div class="card-deck">
						<c:forEach var="temp" items="${postList}">
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