<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Information</title>
</head>
<body>
	<h1 align="center">Payment Information</h1>
	<p>
	Bill Against the Credit Card Number 
	</p>	
	<p>
	${billInfo.ccNo} for an amount of ${billInfo.ammountInfo} [ ${billInfo.ammount} ${billInfo.currencyCode.symbol} ] has been generated on ${billInfo.billDate}
	</p>

</body>
</html>