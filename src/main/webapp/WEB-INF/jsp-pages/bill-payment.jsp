<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Payment</title>
</head>
<body>
	<h1 align="center">Bill Payment</h1>

	<form:form action="bill-process" modelAttribute="billInfo" method="GET">
		<div align="center">
			<p>
				<label>Credit Card- </label>
				<form:input path="ccNo" />
			</p>
			<p>
				<label>Bill Value- </label>
				<form:input path="ammountInfo" />
			</p>			
			<p>
				<label>Ammount- </label>
				<form:input path="ammount" />
			</p>				
			<p>
				<label>Currency- </label>
				<form:input path="currencyCode" />
			</p>
			<p>
				<label>Bill Date- </label>
				<form:input path="billDate" />
			</p>


			<input type="submit" value="PAY" />
		</div>


	</form:form>

</body>
</html>