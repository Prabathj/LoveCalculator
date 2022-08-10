<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WelCome to LC</title>
</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr/>
	<form action="process-homepage-b" method="get" >
	<div align="center">
	<p>
	<label for="yn">Your Name : </label>
	<input type="text" id="yn"  name="userName"/>
	</p>
	<p>
	<label for="cn">Crush Name :</label>
	<input type="text" id="cn" name="crushName"/>
	</p>	
	
	<input type="submit" value="calculate"/>
	</div>
	</form>
</body>