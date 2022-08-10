<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WelCome to LC</title>

<style type="text/css">
.errors {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>


<script type="text/javascript">
	function validateU() {

		var uname = document.getElementById("yn").value;
		if (uname.length < 3) {
			alert("User Name should be more than two characters");
			return false;
		} else
			return true;

	}
</script>


</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr />
	<c:url var="homepage"  value="process-homepage" />
	<form:form action="${homepage}" method="get"
		modelAttribute="userInfo">
		<div align="center">
			<p>
				<label for="yn">Your Name : </label>
				<form:input id="yn" path="userName" />
				<form:errors path="userName" cssClass="errors"/>
			</p>
			<p>
				<label for="cn">Crush Name :</label>
				<form:input id="cn" path="crushName" />
				<form:errors path="crushName" cssClass="errors"/>
			</p>
			<p>
			<form:checkbox path="termsConditions" /> I agree with the terms & conditions
			<form:errors path="termsConditions" cssClass="errors"/>
			</p>
			
			<input type="submit" value="calculate" />
		</div>
	</form:form>
</body>
</html>