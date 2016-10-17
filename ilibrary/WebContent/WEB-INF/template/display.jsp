<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset=UTF-8>
<title>Display</title>
</head>
<body>
	<table border="0.5" bgcolor="#FFBBFF" width = 70%>
		<tr>
    		<th>Title</th>
    		<th> </th>
    		<th></th>
  		</tr> 
  		<s:iterator value="booklst" var="t">
  		<tr>
    		<td>${t.getTitle()}</td>
    		<td>
    			<form action="view_detail" method="post">
    				<input type="hidden" name="viewbook.ISBN" value="${t.getISBN()}">
    				<input type="submit" value="View">
    			</form>
    		</td>
    		<td>
    			<form action="del" method="post">
    				<input type="hidden" name="delbook.ISBN" value="${t.getISBN()}">
    				<input type="submit" value="Delete">
    			</form>
    		</td>
  		</tr>
  		</s:iterator>
</table>
</body>
</html>