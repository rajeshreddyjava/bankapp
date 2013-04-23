<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="include.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<fieldset>
<legend>Transactions</legend>
<c:forEach var="transaction" items = "${transactions}">
<c:out value = "${transaction.amount}"/> -- <c:out value="${transaction.transactionDate}"></c:out><br/>

</c:forEach>

</fieldset>

</div>

</body>
</html>