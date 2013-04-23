<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<BASE HREF="http://localhost:8080/BankApp/">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" href="css/jquery.datepick.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div class="page">
		<div class="header"><tiles:insertAttribute name="header" />	</div>
		<div class="main_content"><tiles:insertAttribute name="body" /></div>
		<div class="footer"><tiles:insertAttribute name="footer" />	</div>
	</div>
	<script src="scripts/jquery-1.9.1.min.js"></script>
<script src="scripts/bank_scripts.js"></script>
</body>
</html>