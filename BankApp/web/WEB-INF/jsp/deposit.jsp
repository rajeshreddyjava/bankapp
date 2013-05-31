<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="include.jsp"%>

<script type="text/javascript">


</script>

<title>Deposit</title>
</head>
<body>
	<form:form id="deposit" commandName="depositForm" enctype="multipart/form-data" method="POST">
		<fieldset>
		<legend>Deposit</legend>
		<div class = "deposit">
		<p>Deposit into</p>
		<p><form:radiobuttons path="accountTypeSelected"  items="${accountTypes}"/>
		</p>
		<p>Amount : <form:input path="amount"/></p>
		<p><input id="check" type="radio" name="depositMode" value="check" />Check</p>
		<p><input id = "cash" type="radio" name="depositMode" value="cash" checked="checked"/>Cash</p>
		<div id="checkFile" style='display:none'>
		<p>Please Upload Check Image</p>
		<p><input name="checkImage" type="file"/></p>
		<p> Check on Date : <input type="text" name="checkDepositedDate" class="date-picker"/>
		</div>
		<p><input type="submit" value="Deposit" name="_deposit"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Cancel" name="_cancel"/></p>
		</div>                
		</fieldset>
	</form:form>

</body>
</html>