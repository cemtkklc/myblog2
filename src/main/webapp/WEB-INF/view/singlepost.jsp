<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="head.jsp"></jsp:include>
		<title>${singlePost.title} </title>
	</head>
	<body>
		<div class="container-fluid">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
		
		<div class="row" style="width:auto; height:500px;">
				<img src="${pageContext.request.contextPath}/image/imageDisplay?id=${singlePost.image.id}" class="rounded" style="width:auto; height:500px;"/>
		</div>
		<div class="row" style="width:500px; height:auto;">
				<h2> ${singlePost.title}</h2>
		
		</div>
		<div class="row" style="width:500px; height:auto;">
				<h2> ${singlePost.body}</h2>
		
		</div>
		<br>
		<mark>${singlePost.author.username}</mark>
		
		
		
		
	
	</body>

</html>