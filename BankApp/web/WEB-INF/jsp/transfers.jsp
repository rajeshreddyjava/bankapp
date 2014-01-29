<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="include.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<form:form commandName="transferForm">
	<fieldset>
	<legend>Transfers</legend>
		<table>
		<tr>
		<td>
		    <label>From: </label>
		</td>
		    <td>
			<form:select path="fromAccountType" id="fromAccountType">
			<form:option value="checking"/>
			<form:option value="savings"/>
			</form:select>
			</td><td><a href="user/transfers/addReceiver.do" >Add Receiver</a></td>
		</tr>
		<tr> 
		<td> To :</td>
		<td> <form:select path="toAccountNumber" id="toAccountNumber">
			<form:option value="Select----"/>
			<form:options items="${receiversMap}"/>
			</form:select> </td>
		</tr>
		<tr>
		<td> Scheduled Date:</td>
		<td> <form:input path="scheduledDate" class="date-picker" id = "scheduleDate"/>
		 </td>
		</tr>
		<tr>
		<td>
		</td>
		<td>
		<p><input type="submit" value="Deposit" name="_deposit"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Cancel" name="_cancel"/></p>
		</td>
		</tr>
		</table>
	</fieldset>
	</form:form>

</body>
</html>