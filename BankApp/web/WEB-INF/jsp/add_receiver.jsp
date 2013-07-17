<%@include file="include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<form:form id ="jform" commandName="addReceiverForm" action="/user/addreceiver.do" method="POST">
		<fieldset>

			<legend>Add Receiver</legend>
			<table>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" maxlength = "15" id ="firstName"></td>
					<td><span id = "error"></span></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" id = "lastName"></td>
				</tr>
				<tr>
					<td>Nick Name:</td>
					<td><input type="text" name="nickName" id ="nickName"></td>
				</tr>
				<tr>
					<td>Account Number:</td>
					<td><input type="text" name="accountNumber" id = "accountNumber"></td>
				</tr>
				<tr>
					<td>Re-enter Account Number:</td>
					<td><input type="text" name="reAccountNumber" id ="reAccountNumber"></td>
				</tr>
				<tr>
					<td>Stree Address:</td>
					<td><input type="text" name="address.streetAddress" id = "streetAddress"></td>
				</tr>
				
				<tr>
					<td>City :</td>
					<td><input type="text" name="address.city" id="city"></td>
				</tr>
				<tr>
					<td>State :</td>
					<td><input type="text" name="address.state" id ="state"></td>
				</tr>
				<tr>
					<td>Zip Code:</td>
					<td><input type="text" name="address.zipCode" id ="zipCode"></td>
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td><input type="text" name="phoneNumber" id ="phoneNumber"></td>
				</tr>
				<tr>
					<td>Email Address:</td>
					<td><input type="text" name="emailAddress" id ="emailAddress"></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" value="Add Reciver" id ="send">Add Receiver</button>
				</tr>


			</table>
		</fieldset>
		</form:form>
</body>
</html>