<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Test for Login Page</title>
	</head>
	<body>
		<form:form  action="${pageContext.request.contextPath}/authUser" method="POST" >
			Username: <input type="text" name="username" placeholder="Username"/><br>
			Password: <input type="password" name="password" placeholder="Password"/>
			<input type="submit" value="login"/>
		</form:form>
	
	</body>
</html>