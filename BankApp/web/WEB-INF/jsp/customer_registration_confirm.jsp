<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="include.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Confirmation</title>
</head>
<body>
	<div class="regconfirm">
		<p align="center">
			<b>Confirmation</b>
		</p>
		<p>
			Congratulations <b>${customerRegistrationForm.firstName}
				${customerRegistrationForm.lastName}</b> You have successfully opened
			following account(s) at our bank
		</p>
		<ul>
			<c:forEach items="${customerRegistrationForm.accountType}"
				var="accountType">
				<li class="list"><c:out value="${accountType}" /></li>
				<br />
			</c:forEach>
		</ul>
		<p>
			Your User Id for Online banking is <b><c:out
					value="${customerRegistrationForm.userId}"></c:out></b><br />
		</p>

		<p>
			You will receive a confirmation email along with account number(s) to
			your email <b><u><c:out
						value="${customerRegistrationForm.email}" /></u></b>
		</p>
	</div>
</body>
</html>