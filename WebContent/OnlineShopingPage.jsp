<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
</head>
<h3>add items to cart</h3>
<body>
<form action="MainShoppingItems" method="post">
		<select name="ShopingItems" size="4" multiple="multiple">
			<option value="Audi">Audi</option>
			<option value="BMW">BMW</option>
			<option value="Mercedes">Mercedes</option>
			<option value="Alto">Alto</option>
		</select> <input type="submit" name="add" value="Add to Card">
</form>
</body>
</html>