<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Login Page</title>
</head>
<body onload='document.f.j_username.focus();'>
	<c:if test="${not empty error}">
	
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
	
<fieldset class="login">
<legend>Login</legend>
		<div>
		<table>
			<tr>
				<td>User Name:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
		</table>
		<p class="p_button">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="button" name="submit" type="submit" value="Login" />
		</p>
		<p align="center"><a href="public/forgot.do?credential=password.do">Forgot Password?</a>&nbsp&nbsp&nbsp <a href="public/forgot.do?credential=username">Forgot Username?</a></p>
		<p align="center"><a href="public/cust_reg.do">Open an Account</a></p>
		</div>
		
</fieldset>

	</form>
</body>
</html>