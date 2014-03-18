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
							<th>银行账户</th>
							<th>密码</th>
							<th>余额</th>
							<th>状态</th>
							<th>种类</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="#session.cards" status="cs">
							<tr>
								<th><s:property value="id" /></th>
								<th><s:property value="bankaccount" /></th>
								<th><s:property value="password" /></th>
								<th><s:property value="remaining" /></th>
								<th><s:property value="status" /></th>
								<th><s:property value="type" /></th>
								<th><a class="btn"
									href="change_info.jsp?index=<s:property value='#cs.index'/>">修改用户信息</a>
									<a class="btn"
									href="change_attendance.jsp?index=<s:property value='#cs.index'/>">修改参与活动</a>
								</th>
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