<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%String table=(String) request.getAttribute("table"); %>
<body>
<h1>Products</h1>
<%= table %>
<a href="AddForm">Add Product</a><br>
</body>
</html>