<%@include file="include.jsp"%>
<html>

<head>
<BASE HREF="http://localhost:8080/BankApp/">
</head>
<body>
<c:set var="loggedOut" value="true"></c:set>
<div class="topnav">
<sec:authorize access="isAuthenticated()" ><c:set var="loggedOut" value="false"></c:set>
Welcome <sec:authentication property="principal.username"></sec:authentication>&nbsp;&nbsp;<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
</sec:authorize>
<c:if test="${loggedOut}"><a href = "public/login.do" >Login</a></c:if>
</div>
<div class="menu">
<ul>
<sec:authorize access="isAuthenticated()" >
<li><a class="link" href="user/home.do">Home</a></li>
</sec:authorize>
<sec:authorize access="hasRole('public')" >
<li><a class="link" href="public/home.do">Home</a></li>
</sec:authorize>
<li><a class="link" href="user/accounts.do">Accounts</a></li>
<li><a class="link" href="user/deposits.do">Deposits</a></li>
<li><a class="link" href="user/transfers.do">Transfers</a></li>
<li><a class="link" href="user/profile.do">Profile</a></li>
<li><a class="link" href="user/customer_serivce.do">Customer Services</a></li>

</ul>
</div>

</body>
</html>