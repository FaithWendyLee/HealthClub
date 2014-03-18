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
				<form class="form-horizontal" action="ChangeActivity.action"
					method="post">
					<div class="card">
						<div class="control-group">
							<label class="control-label">活动地点</label>
							<div class="controls">
								<input type="text" name="place" placeholder="请输入活动地点"
									value="<s:property value='#parameters.place'/>">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">教练编号</label>
							<div class="controls">
								<input type="text" name="coachNumber"
									placeholder="请输入教练编号"
									value="<s:property value='#parameters.coachNumber'/>">
							</div>
						</div>
						<div id="type" class="control-group">
							<label class="control-label">时间</label>
							<div class="controls">
								<div class="input-append date form_datetime">
									<input size="16" type="text" name="time"
										value="<s:property value='#parameters.time'/>" readonly>
									<span class="add-on"><i class="icon-th"></i></span>
								</div>
								<script type="text/javascript"
									src="../js/bootstrap-datetimepicker.js"></script>
								<script type="text/javascript">
									$(".form_datetime").datetimepicker({
										format : "yyyy-mm-dd hh:ii"
									});
								</script>
							</div>
						</div>
					</div>
					<input type="hidden" name="index"
						value="<s:property value='#parameters.index'/>" />
					<!-- 按钮 -->

					<div class="control-group" id="buttons">
						<div class="controls">
							<button type="submit" class="btn inline">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>