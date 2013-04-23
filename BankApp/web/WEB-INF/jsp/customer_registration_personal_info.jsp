<%@include file="include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Registration</title>
</head>
<body>
	<form:form method="POST" commandName="customerRegistrationForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<fieldset>

			<legend>Personal Details (contd..)</legend>

			<table>
				<tr>
					<td>Drivers License Number</td>
					<td><form:input path="driverLicenseNumber"></form:input></td>
				</tr>
				<tr>
					<td>Issued By</td>
					<td><form:select path="licenseIssuedState">
							<form:options items="${states}" />
						</form:select></td>
				</tr>
				<tr>
					<td>Expiration Date</td>
					<td><form:select items="${dateFieldsList.get(0)}"
							path="yearLicense" /> <form:select
							items="${dateFieldsList.get(1)}" path="monthLicense" /> <form:select
							items="${dateFieldsList.get(2)}" path="dayLicense" /></td>
				</tr>
				<tr>
					<td><abbr class="req" title="required">*</abbr>Home Phone</td>
					<td><form:input path="homePhone"></form:input></td>
				</tr>
				<tr>
					<td>Mobile Phone</td>
					<td><form:input path="mobilePhone"></form:input></td>
				</tr>
				<tr>
					<td><abbr class="req" title="required">*</abbr>Email Address</td>
					<td><form:input path="email"></form:input></td>
				</tr>

				<tr>
					<td><abbr class="req" title="required">*</abbr>Confirm Email
						Address</td>
					<td><form:input path="confirmEmail"></form:input></td>
				</tr>


			</table>
			<p class="p_button">
				<input class="button" type="submit" value="Previous" name="_intro" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input	class="button" type="submit" value="Next" name="_personal" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button" type="submit" value="Cancel" name="_cancel" />
			</p>
		</fieldset>
	</form:form>
</body>
</html>