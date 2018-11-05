<!DOCTYPE html>

<html>
	<head>
		<title>Upload File</title>
	</head>
	<body>
		<h2>Select File to Upload!!</h2><br>
		<hr>
		<form action="upload" enctype="multipart/form-data" method="POST">
			<input type="file" name="file"/><br>
			<input type="submit" value="Upload"/>
		</form>
	</body>
	
</html>