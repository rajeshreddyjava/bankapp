<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="include.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<form:form>
		<table>
		<tr>
		<td>
		    <label>From: </label>
		    </td>
		    <td>
			<select>
				<option>Checking</option>
				<option>Savings</option>
			</select>
			</td><td><a href="/addReceiver.do" >Add Receiver</a></td>
		</tr>
		</table>
	</form:form>

</body>
</html>