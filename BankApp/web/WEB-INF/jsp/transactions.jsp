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
<table>
<tr>
<th colspan="2" width="33%">Type</th>
<th colspan="2" width="33%">Amount</th>
<th colspan="2"  width="33%">Date</th>
</tr>

<c:forEach var="transaction" items = "${transactions}">
<tr>
<td colspan="2" align="center"><c:out value="${transaction.transactionType}"></c:out></td> <td colspan="2" align="center"> &#36 <c:out value = "${transaction.amount}"/></td><td colspan="2" align="center"> <c:out value="${transaction.transactionDate}"></c:out></td>
</tr>

</c:forEach>
</table>
</fieldset>

</div>

</body>
</html>