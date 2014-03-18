<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		changeNavTo('show_activities');
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
						<s:iterator value="#session.activities" status="as">
							<tr>
								<th><s:property value="id" /></th>
								<th><s:property value="coachNumber" /></th>
								<th><s:property value="place" /></th>
								<th><s:date name="time" format="yyyy-MM-dd hh:mm" /></th>
								<th><a class="btn"
									href="change_activity.jsp?index=<s:property value='#as.index'/>&coachNumber=<s:property value='coachNumber'/>&place=<s:property value='place'/>&time=<s:date name='time' format='yyyy-MM-dd hh:mm' />">修改</a></th>
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