<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/flat-ui.css" rel="stylesheet" media="screen">
<link href="../css/docs.css" rel="stylesheet" media="screen">
<!-- stylesheets -->
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/colour.css" rel="stylesheet" type="text/css" />
<!-- modernizr enables HTML5 elements and feature detects -->
<script type="text/javascript" src="../js/modernizr-1.5.min.js"></script>
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/highcharts.js"></script>
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
				<li id="show_user_charts"><a href="ShowUserCharts.action">显示会员图表</a></li>
				<li id="show_activity_charts"><a href="ShowActivityCharts.action">显示活动图表</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>