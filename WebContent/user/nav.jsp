<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- stylesheets -->
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/colour.css" rel="stylesheet" type="text/css" />
<!-- modernizr enables HTML5 elements and feature detects -->
<script type="text/javascript" src="../js/modernizr-1.5.min.js"></script>
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">

	function changeNavTo(tabId) {
		$("ul.sf-menu > li.selected").attr("class", null);
		$("ul.sf-menu > li#" + tabId ).attr("class", "selected");
	}
</script>
</head>
<body>
	<header>
		<div id="logo">
			<h1>
				<a href="#">Health </a>Club
			</h1>
		</div>
		<nav>
			<ul class="sf-menu" id="nav">
				<li id="home" class="selected"><a href="home.jsp">首页</a></li>
				<li id="change_info"><a href="change_info.jsp">修改个人资料</a></li>
				<li id="see_payment"><a href="see_payment.jsp">查看缴费信息</a></li>
				<li id="schedule_activity"><a href="schedule_activity.jsp">预定健身活动</a></li>
				<li id="see_activity"><a href="see_activity.jsp">查看已有活动</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>