<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="head.jsp"></jsp:include>
		<title>My Posts</title>
	</head>	
	<body>
		<div class="container-fluid">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
		<c:forEach var="temp" items="${postList}">
			<h2>${temp.title}</h2>
			<p>${temp.body}</p>
		
		</c:forEach>
	
	
	</body>
</html>

