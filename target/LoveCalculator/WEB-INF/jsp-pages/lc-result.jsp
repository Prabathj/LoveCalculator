<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Love Result</title>
</head>
<body>
<h1 align="left">Hi ${userName}</h1>
<hr/>
	<p>Partner Name: ${userInfo.userName}</p>
	<p>Crush Name: ${userInfo.crushName}</p>
	<p>You Both are ${relationship}</p>
	
	<a href=<c:url value = "send-email"/>>Send Result via Email</a>
</body>
</html>