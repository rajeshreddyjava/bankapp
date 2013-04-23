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
	<legend>Personal Information</legend>
		<table>
			<tr>
				<td><abbr class="req" title = "required">*</abbr>First Name</td>
				<td><form:input path="firstName"></form:input></td>
			</tr>
			<tr>
				<td><abbr class="req" title = "required">*</abbr>Last Name</td>
				<td><form:input path="lastName"></form:input></td>
			</tr>
			<tr>
				<td>Street Address</td>
				<td><form:input path="address.streetAddress"></form:input></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input path="address.city"></form:input></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:select path="address.state">
						<form:options items="${states}" />
					</form:select>
			</tr>
			<tr>
				<td>Zip Code</td>
				<td><form:input path="address.zipCode"></form:input></td>
			</tr>

			<tr>
				<td><abbr class="req" title = "required">*</abbr>SSN</td>
				<td><form:input path="SSN"></form:input></td>
			</tr>
			<tr>
				<td><abbr class="req" title = "required">*</abbr>Date Of Birth</td>
				<td><form:select  items="${dateFieldsList.get(0)}" path ="yearDOB"/>
				<form:select  items="${dateFieldsList.get(1)}" path ="monthDOB"/>
				<form:select  items="${dateFieldsList.get(2)}" path ="dayDOB"/></td>
			</tr>
			<tr>
				<td><abbr class="req" title = "required">*</abbr>Gender</td>
				<td><form:radiobutton path="gender" value="male" />Male<form:radiobutton
						path="gender" value="female" />Female</td>
			</tr>
			</table>
			<p class="p_button">	<input class="button" type="submit" value="Next" name="_intro" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input class="button" type="submit" value="Cancel" name="_cancel" /></p>
			
	</fieldset>	

	</form:form>
</body>
</html>