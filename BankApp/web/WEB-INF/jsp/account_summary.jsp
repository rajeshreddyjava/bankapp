<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="include.jsp"%>
</head>
<body>
	<div class="content">
		<fieldset  class="acct_sum">
			<legend>Accounts</legend>
			
				<c:forEach var="account" items="${summary}">
				<div id="acct_summary"><a href="user/accounts.do?type=<c:out value='${account.accountType}'/>"><c:out value="${account.accountType}" /></a><span class="spacer"></span><c:out value="${account.currentBalance}" /></div>
				</c:forEach>
		</fieldset>

	</div>
	
</body>
</html>