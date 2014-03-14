<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>Insert title here</title>
<script type="text/javascript">
	function changeNavTo(tabId) {
		$("ul.nav > li.active").attr("class", null);
		$("ul.nav > li#" + tabId ).attr("class", "active");
	}
</script>
</head>
<body>
<div class="navbar">
	 <div class="navbar-inner">
	    <a class="brand" href="#">Health Club</a>
	    <ul class="nav">
	      <li id="home" class="active"><a href="home.jsp"  >首页</a></li>
	      <li id="change_info"><a href="change_info.jsp" >修改个人资料</a></li>
	      <li id="see_payment"><a href="see_payment.jsp" >查看缴费信息</a></li>
	      <li id="schedule_activity"><a href="schedule_activity.jsp" >预定健身活动</a></li>
	      <li id="see_activity"><a href="see_activity.jsp" >查看已有活动</a></li>
	    </ul>
	  </div>
	</div>
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>