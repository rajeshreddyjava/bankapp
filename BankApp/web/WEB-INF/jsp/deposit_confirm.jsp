<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<BASE HREF="http://localhost:8080/BankApp/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<fieldset>
<legend>Deposited</legend>

<div class="confirm">
Your amount &#36 ${depositForm.amount} has been deposited to ${depositForm.accountTypeSelected}.

Please go to account summary if you would like to verify <a href="user/accounts.do">Account Summary</a>
</div>
</fieldset>

</body>
</html>