<%@page import="model.Activity"%>
<%@page import="model.Card"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getParameter("index") != null){
		List<Card> cards = (List<Card>) session.getAttribute("cards");
	 	int index = Integer.parseInt(request.getParameter("index"));
	 	session.setAttribute("p_card", cards.get(index));
	 	session.setAttribute("p_card_activities", cards.get(index).getActivities());
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		changeNavTo("show_cards");
	});
</script>
<title></title>
</head>
<body>
	<div id="main">
		<jsp:include page="nav.jsp" />
		<div id="site_content">
			<div id="center_content">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>id</th>
							<th>教练</th>
							<th>地点</th>
							<th>时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="#session.p_card_activities" status="as">
							<tr>
								<th><s:property value="id" /></th>
								<th><s:property value="coachNumber" /></th>
								<th><s:property value="place" /></th>
								<th><s:date name="time" format="yyyy-MM-dd hh:mm" /></th>
								<th><a class="btn"
									href="UnScheduleActivity.action?id=<s:property value="id" />">删除</a></th>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>