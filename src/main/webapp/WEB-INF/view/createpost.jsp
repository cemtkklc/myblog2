<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>


<html>
	<head>
		<jsp:include page="head.jsp"></jsp:include>
		<title>Create Post</title>
	</head>
	<body>
		<div class="container-fluid">
			<jsp:include page="header.jsp"></jsp:include>
			
			
		<div class="form-group">
		<!-- 		
			<form action="upload" enctype="multipart/form-data" method="POST">
				<input type="file"  name="file"/><br>
				
				<input type="submit"  class="btn btn-primary" value="Upload"/>
			</form>
			 -->
			<form:form action="createPostProcess" enctype="multipart/form-data" method="Post" modelAttribute="tempPost">
				<input type="file" name="file"/><br>
				<label for="ttl">Title:</label>
				<form:input type="text" class="form-control" id="ttl" path="title"/>
				<label for="categories" >Select Category:</label>
					<select  class="form-control"  name="categories" id="categories">
						<option value="news">News</option>
						<option value="economy">Economy</option>
						<option value="politics">Politics</option>
						<option value="science">Science</option>
						<option value="technology">Technology</option>
						<option value="cultureart">Culture Art</option>
						<option value="others">Others</option>
					</select>
				<label for="bdy">Body:</label>
				<form:textarea  class="form-control"  rows="10" id="bdy" path="body"></form:textarea><br>
				<button type="submit" class="btn btn-primary">Post it!</button>
			
			</form:form><!-- 
			<label for="ttl">Title:</label>
			<input type="text" class="form-control" id="ttl">
			<label for="categories" >Select Category:</label>
			<select class="form-control" id="categories">
				<option>News</option>
				<option>Economy</option>
				<option>Politics</option>
				<option>Science</option>
				<option>Technology</option>
				<option>Culture Art</option>
				<option>Others</option>
			</select>
			<label for="bdy">Body:</label>
			<textarea  class="form-control"  rows="10" id="bdy"></textarea><br>
			<button type="submit" class="btn btn-primary">Post it!</button>
			 -->
		</div>
		</div>
		
		
	</body>

</html>