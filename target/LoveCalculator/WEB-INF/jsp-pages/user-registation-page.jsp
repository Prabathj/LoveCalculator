<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<style type="text/css">
.errors {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>
</head>
<body>
	<h1 align="center">User Registration</h1>
	<hr />
	<form:form action="process-registration" method="GET"
		modelAttribute="regInfo">
		<div align="center">
			<p>
				<label>Name :</label>
				<form:input path="name" />
				<form:errors path="name" cssClass="errors"/>
			</p>
			<p>
				<label>User Name :</label>
				<form:input path="userName" />
				<form:errors path="userName" cssClass="errors"/>
			</p>
			<p>
				<label>Password :</label>
				<form:password path="password" />
			</p>
			<p>
				<form:select path="country">
					<form:option value="sl" label="Sri Lanka"></form:option>
					<form:option value="aus" label="Austalia"></form:option>
					<form:option value="ind" label="India"></form:option>
					<form:option value="jpa" label="Japan"></form:option>
				</form:select>
			</p>
			<p>
				<label>Hobbies : </label> Foot Ball :
				<form:checkbox path="hobbies" value="football" />
				Ruggby :
				<form:checkbox path="hobbies" value="ruggby" />
				Read :
				<form:checkbox path="hobbies" value="read" />
				Music :
				<form:checkbox path="hobbies" value="music" />
			</p>
			<p>
				<label>Gender : </label> Male
				<form:radiobutton path="gender" value="male" />
				Female
				<form:radiobutton path="gender" value="female" />
			</p>
			<p>
				<label>Age :</label>
				<form:input path="uAge" />
				<form:errors path="uAge" cssClass="errors"/>
			</p>
			<div align="center">
				<p>
					<label>Contact Details</label>
				</p>
				<p>
					<label>Email: </label>
					<form:input path="commInfo.uEmail" />
					<form:errors path="commInfo.uEmail" cssClass="errors"/>
				</p>
				<p>	
					<label> Contact No: </label>
					<form:input path="commInfo.uMobileNum" />	
					<form:errors path="commInfo.uMobileNum" cssClass="errors"/>				
				</p>
				<p>
					<lable> Registration Date: </label>
					<form:input path="regDate" />	
					<form:errors path="regDate" cssClass="errors"/>
				</p>
				
				
			</div>

			<input type="submit" value="Register" />
		</div>
	</form:form>
</body>
</html>