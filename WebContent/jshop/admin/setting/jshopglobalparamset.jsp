<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>全局参数设置</title>


</head>

<body>
	<!-- 编辑会员区域 -->
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
			<div class="box ui-tabs ui-widget ui-widget-content ui-corner-all"
				id="box-tabs">
				<!-- box / title -->
				<div class="title">
					<h5>全局参数设置</h5>
					<ul
						class="links ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
						<li
							class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
							<a href="#box-basic">基础信息</a>
						</li>
					</ul>
				</div>
				<div id="box-basic"
					class="ui-tabs-panel ui-widget-content ui-corner-bottom">

					<div class="form">
						<div class="fields">
							<div class="field">
								<div class="label label-radio">
									<label> 注册邮件激活: </label>
								</div>
								<div class="radios">
									<div class="radio">
										<input type="radio" id="issendactivatemail"
											name="issendactivatemail" value="1" /> <label for="radio-1">
											开启 </label>
									</div>
									<div class="radio">
										<input type="radio" id="issendactivatemail"
											name="issendactivatemail" value="0" checked /> <label
											for="radio-2"> 关闭 </label>
									</div>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small"> 服务器地址: </label>
								</div>
								<div class="input">
									<input id="mobilehost" name="mobilehost" type="text"
										value="127.0.0.1" class="small" />
								</div>
							</div>
						</div>
					</div>
					<div class="title">
						<h5>购物规则</h5>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field">
								<div class="label">
									<label for="input-small"> 商品库存报警数量: </label>
								</div>
								<div class="input">
									<input id="stockwarning" name="stockwarning" type="text"
										value="" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small"> 积分换算比率: </label>
								</div>
								<div class="input">
									<input id="integralconversionratio"
										name="integralconversionratio" type="text" value=""
										class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label label-radio">
									<label> 全场电子优惠激活: </label>
								</div>
								<div class="radios">
									<div class="radio">
										<input type="radio" id="isglobalecoupon"
											name="isglobalecoupon" value="1" /> <label for="radio-1">
											开启 </label>
									</div>
									<div class="radio">
										<input type="radio" id="isglobalecoupon"
											name="isglobalecoupon" value="0" checked /> <label
											for="radio-2"> 关闭 </label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="title">
						<h5>模板规则</h5>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field">
								<div class="label">
									<label for="input-small"> 智能过滤可生成对象: <br></br>（上线时建议关闭）</label>
								</div>
								<div class="radios">
									<div class="radio">
										<input type="radio" id="freemarkerfilter"
											name="freemarkerfilter" value="1" /> <label for="radio-1">
											开启 </label>
									</div>
									<div class="radio">
										<input type="radio" id="freemarkerfilter"
											name="freemarkerfilter" value="0" checked /> <label
											for="radio-2"> 关闭 </label>
									</div>
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
									<input type="submit" id="submit" name="submit" value="更新" />
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

	<script type="text/javascript"
		src="<%=basePath%>jshop/admin/js/jshopglobalparamsetjs.js"></script>




</body>
</html>