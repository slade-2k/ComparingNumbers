<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Comparing Numbers</title>
	</head>
	<body>
		<c:out value="${Fehler}" default=""/>
		<form method="GET" action="/ComparingNumbers/Controller">
			Zahl 1:<input type="text" name="number1"/><br>
			Zahl 2:<input type="text" name="number2"/><br>
			Zahl 3:<input type="text" name="number3"/><br>
			<input type="submit" value="Bestimme die größte Zahl"/><br>
		</form>
	</body>
</html>