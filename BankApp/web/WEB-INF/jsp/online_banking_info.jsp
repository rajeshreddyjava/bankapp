<%@include file="include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Registration</title>
</head>
<body>
	<form:form method="POST" 
		commandName="customerRegistrationForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
	<fieldset>
	<legend>Online Banking Details</legend>
		<table>
			<tr>
				<td>Please select type(s) of account(s)</td>
				<td><form:checkboxes items="${aacountTypeList}" path="accountType" ></form:checkboxes></td>
			</tr>
			<tr>
				<td><abbr class="req" title = "required">*</abbr>User Id</td>
				<td><form:input path="userId"></form:input></td>
			</tr>
			<tr>
				<td><abbr class="req" title = "required">*</abbr>Password</td>
				<td><form:password path="password"></form:password></td>
			</tr>
			<tr>
				<td><abbr class="req" title = "required">*</abbr>Confirm Password</td>
				<td><form:password path="confirmPassword"></form:password></td>
			</tr>
		</table>	
				<p class="p_button"><input class="button" type="submit" value="Previous" name="_personal" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button" type="submit" value="Finish" name="_finish" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button" type="submit" value="Cancel" name="_cancel" /></p>
			
		
</fieldset>
	</form:form>
</body>
</html>