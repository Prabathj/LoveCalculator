<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Confirmation</title>
</head>
<body>
	<h1>Registration Information</h1>
	Name :${regInfo.name}
	<br/> UserName :${regInfo.userName}
	<br/> Password :${regInfo.password}
	<br/> Country :${regInfo.country}
	<br/> Hobbies :
	<c:forEach var="temp" items="${regInfo.hobbies}">
	${temp}
	</c:forEach>
	<br/> Gender :${regInfo.gender}
	<br/> Age :${regInfo.uAge}
	<br/> Email :${regInfo.commInfo.uEmail}
	<br/> Mobile :${regInfo.commInfo.uMobileNum}
	<br/> Reg Date :${regInfo.regDate}
</body>
</html>