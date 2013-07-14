<%@include file="include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<form:form commandName="addReceiverForm" action="/addreceiver.do" method="POST">
		<fieldset>

			<legend>Add Receiver</legend>
			<table>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<td>Nick Name:</td>
					<td><input type="text" name="nickName"></td>
				</tr>
				<tr>
					<td>Account Number:</td>
					<td><input type="text" name="accountNumber"></td>
				</tr>
				<tr>
					<td>Re-enter Account Number:</td>
					<td><input type="text" name="reAccountNumber"></td>
				</tr>
				<tr>
					<td>Stree Address:</td>
					<td><input type="text" name="address.streetAddress"></td>
				</tr>
				
				<tr>
					<td>City :</td>
					<td><input type="text" name="address.city"></td>
				</tr>
				<tr>
					<td>State :</td>
					<td><input type="text" name="address.state"></td>
				</tr>
				<tr>
					<td>Zip Code:</td>
					<td><input type="text" name="address.zipCode"></td>
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td><input type="text" name="phoneNumber"></td>
				</tr>
				<tr>
					<td>Email Address:</td>
					<td><input type="text" name="emailAddress"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add Reciver" />
				</tr>


			</table>
		</fieldset>
		</form:form>
</body>
</html>