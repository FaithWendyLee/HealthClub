<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">

<script type="text/javascript">
	function changeNavTo(tabId) {
		$("ul.nav > li.active").attr("class", null);
		$("ul.nav > li#" + tabId ).attr("class", "active");
	}
</script>
<title>导航</title>
</head>
<body>
<div class="navbar">
	 <div class="navbar-inner">
	    <a class="brand" href="#">Health Club</a>
	    <ul class="nav">
	      <li id="make_activity" class="active"><a href="make_activity.jsp" >制定活动安排</a></li>
	      <li id="search_user"><a href="search_user.jsp" >修改会员信息</a></li>
	      <li id="search_activity"><a href="search_activity.jsp" >修改活动信息</a></li>
	    </ul>
	  </div>
	</div>
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>