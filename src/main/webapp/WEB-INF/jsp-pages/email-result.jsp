<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Sent</title>
</head>
<body>

	<h2>Hi ${userName}</h2>
	Email Sent to ${emailDetails.emailId} successfully
	<c:url var="processfeedback"  value="sendFeedBack" />
	<form:form action="${processfeedback}" modelAttribute="feedBackInfo">
		<div align="left">
			<p>
				<label>Name </label>
				<form:input path="feedBUser" />
			</p>
			<p>
				<label>Header </label>
				<form:input path="feedBheader" />
			</p>
			<p>
				<label>Message (Max 200 Characters)</label>
				<form:input path="feedBbody" maxlength="200" />
				<input type="submit" value="Send Feedback">
		</div>
	</form:form>
	<a href=<c:url value = "home"/>> Home Page</a>
</body>
</html>