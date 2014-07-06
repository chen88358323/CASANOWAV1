<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>增加/编辑角色权限</title>
	</head>
	<body>
		<!-- header 包含头部导航-->
		<%@include file="/jshop/admin/header.jsp"%>
		<!-- end header -->
		<!-- content -->
		<div id="content">
			<!-- end content / left -->
			<%@include file="/jshop/admin/left.jsp"%>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
				<!-- table -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						<h5>
							增加/编辑角色权限
						</h5>
					</div>


					<div class="form">
						<div class="fields">
							<div class="field  field-first">
								<div class="label">
									<label for="input-small">
										角色名称：
									</label>
								</div>
								<div class="input">
									<input id="rolename" name="rolename" type="text" class="small" />

								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										说明：
									</label>
								</div>
								<div class="input">
									<input id="note" name="note" type="text" class="small" />

								</div>

							</div>
							
							<div class="field">
								<div class="label label-checkbox">
									<label>
										可选功能:
									</label>
								</div>
								<div class="checkboxes">
									<div id="functionsdiv">
									
									</div>
										
								</div>
							</div>
						</div>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="button" id="submit" name="submit" value="提交" />
										<input type="button" id="modify" name="modify" value="修改" style="display: none;" />
										<input type="hidden" id="hidid" name="hidid" value="" />
										
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- end table -->



			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/rolemanagementjs.js"></script>

	</body>
</html>