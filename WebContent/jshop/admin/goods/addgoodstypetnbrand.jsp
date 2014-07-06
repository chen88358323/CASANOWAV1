<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>商品类型品牌增加/编辑</title>

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
							请选择商品类型
						</h5>

					</div>
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="select">
										商品类型:
									</label>
								</div>
								<div class="select">
									<span id="goodstypetnselect"></span>
								</div>
							</div>
						</div>
					</div>
					<!-- box / title -->
					<div class="title">
						<h5>
							商品品牌列表
						</h5>

					</div>
					<!-- end box / title -->
					<div class="table">
						<!-- flexigrid -->
						<div id="flexbrandmanagement" style="width: 98%; margin-left: 15px;">
							<table id="brandmanagement" style="display: none;"></table>
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
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/goodstypetnbrandmanagementjs.js"></script>

	</body>
</html>
