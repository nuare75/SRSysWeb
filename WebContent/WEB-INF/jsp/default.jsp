<!DOCTYPE HTML>
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title><sitemesh:write property='title' /></title>

<link rel="stylesheet" href="<c:url value="/resources/style/jquery-ui.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/style/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/style/jquery-ui.theme.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/style/jquery-ui.structure.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/style/ui.jqgrid.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/style/ui.jqgrid-bootstrap.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/style/styles.css"/>" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<script src="<c:url value="/resources/script/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/resources/script/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/script/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/script/grid.locale-en.js"/>"></script>
<script src="<c:url value="/resources/script/jquery.jqGrid.src.js"/>"></script>
<script src="<c:url value="/resources/script/librarySys.js"/>"></script>

<sitemesh:write property='head'/>

<style type="text/css">
label {
	width: 200px; display: inline-block;
}

OR 
label {
	width: 200px; display: inline-flex;
}

OR 
label {
	width: 200px; display: inline-table;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: -35px;">
			<div class="page-header">
				<h1>
					&nbsp;&nbsp;<img src="<c:url value='/resources/images/book.jpg'/>" class="img-rounded" alt="Where Knowledge Gathers" width="80" height="70" align="middle" title="Student Registration System"> STUDENT REGISTRATION
				</h1>
			</div>
		</div>
		<div class="row" style="margin-top: -20px;">
			<ul class="nav nav-tabs nav-justified navbar-static-top">
				<li><a href="<c:url value='/emp/'/>">Home</a></li>
				<li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">Student <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/student/stu-manage'/>">Student Info Management </a></li>
					</ul></li>
				<li><a href="<c:url value='/logout'/>">Logout</a></li>
			</ul>
		</div>
		<div class="row" style="margin-top: -5px;">
			<div align="right">
				<h6>
					<b>Current login as : User1</b>
				</h6>
			</div>
		</div>
		<div class="row">
			<sitemesh:write property='body' />
		</div>
		<div class="row">
			<div class="navbar-fixed-bottom">
				<h6>
					&nbsp;&nbsp;<b>Copyright Nuril Anwar 2016</b>
				</h6>
			</div>
		</div>
	</div>
</body>
</html>
