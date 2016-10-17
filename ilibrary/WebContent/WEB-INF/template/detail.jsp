<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail</title>
</head>
<body>
	<table border="0.5" bgcolor="#CAFF70" width = 70%>
		<h1>Book</h1>
		<tr>
			<th>Title</th>
			<td>${ viewbook.getTitle()}</td>
		</tr>
		<tr>
			<th>Publisher</th>
			<td>${ viewbook.getPublisher()}</td>
		</tr>
		<tr>
			<th>Pulish Date</th>
			<td>${ viewbook.getPublishDate()}</td>
		</tr>
		<tr>
			<th>Price</th>
			<td>${ viewbook.getPrice()}</td>
		</tr>
		<tr>
			<th>ISBN</th>
			<td>${ viewbook.getISBN()}</td>
		</tr>
		
	</table>
		
	<table border="0.5" bgcolor="#C1CDCD" width = 70%>
		<h1>Author</h1>
		<tr>
			<th>Name</th>
			<td>${ author.getName()}</td>
		</tr>
		<tr>
			<th>Nation</th>
			<td>${ author.getNation()}</td>
		</tr>
		<tr>
			<th>Old</th>
			<td>${ author.getOld()}</td>
		</tr>
	</table>
</body>
</html>