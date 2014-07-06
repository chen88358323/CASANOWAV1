<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>增加新商品</title>
<!-- include the Tools -->

<style type="text/css">
#triggers img {
	cursor: pointer;
	margin: 0 5px;
	background-color: #fff;
	border: 1px solid #ccc;
	padding: 2px;
	width: 200px;
	height: 150px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
}

.abelinked {
	display: block;
	border: 1px solid #aaa;
	text-decoration: none;
	background-color: #fafafa;
	color: #123456;
	margin: 2px;
	clear: both;
}
</style>
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
			<!-- tabs -->
			<div class="box ui-tabs ui-widget ui-widget-content ui-corner-all"
				id="box-tabs">
				<!-- box / title -->
				<div class="title">
					<h5>增加新商品</h5>
					<ul
						class="links ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
						<li
							class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
							<a href="#box-basic">基础信息</a>
						</li>

					</ul>
				</div>
				<!-- box / title -->
				<!-- form start -->

				<div class="form">
					<div class="fields">
						<s:form action="addDiamonds.action" id="diamond.frm"
							name="diamond.frm">
							<div class="field">
								<div class="label">
									<label for="input-small"> 货号: </label>
								</div>
								<div class="input">
									<s:textfield id="diamond.skuid" name="diamond.skuid"
										class="small"  label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small"> 形状: </label>
								</div>
								<div class="input">
									<s:textfield id="diamond.sharp" name="diamond.sharp"
										class="small" label="形状"/>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small"> 钻重: </label>
								</div>
								<div class="input">
									<s:textfield id="diamond.weight" name="diamond.weight"
										class="small" label="钻重"/>
								</div>
							</div>
							<div class="field">
								<div class="label">颜色:</div>
								<div class="input">
									<s:textfield id="diamond.color" name="diamond.color"
										class="small"label="颜色"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">净度:</div>
								<div class="input">
									<s:textfield id="diamond.clarity" name="diamond.clarity"
										class="small"label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">切工:</div>
								<div class="input">
									<s:textfield id="diamond.cut" name="diamond.cut"
										class="small"label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">抛光:</div>
								<div class="input">
									<s:textfield id="diamond.polishing"
										name="diamond.polishing" class="small"label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">对称:</div>
								<div class="input">
									<s:textfield id="diamond.symmetric"
										name="diamond.symmetric" class="small"label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">荧光:</div>
								<div class="input">
									<s:textfield id="diamond.fluorsecent"
										name="diamond.fluorsecent" class="small"label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">直径:</div>
								<div class="input">
									<s:textfield id="diamond.diameter"
										name="diamond.diameter" class="small"label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">台面:</div>
								<div class="input">
									<s:textfield id="diamond.table" name="diamond.table"
										class="small"label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">货品状态:</div>
								<div class="input">
									<s:textfield id="diamond.skustate"
										name="diamond.skustate" class="small"label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">售价:</div>
								<div class="input">
									<s:textfield id="diamond.interprice"
										name="diamond.interprice" class="small"label="售价"></s:textfield>
								</div>
							</div>

							<div class="field">
								<div class="label">会员价:</div>
								<div class="input">
									<s:textfield id="diamond.disprice"
										name="diamond.disprice" class="small"label="会员价"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">证书类型:</div>
								<div class="input">
									<s:textfield id="diamond.licensetype"
										name="diamond.licensetype" class="small"label="货号"></s:textfield>
								</div>
							</div>
							<div class="field">
								<div class="label">证书编号:</div>
								<div class="input">
									<s:textfield id="diamond.licenseNo"
										name="diamond.licenseNo" class="small"label="货号"></s:textfield>
								</div>
							</div>
							<s:submit value="保存商品" onclick="" />
						</s:form>
					</div>
				</div>
			</div>
			<!-- form end -->

		</div>
	</div>
	<!-- end content / right -->

	<!-- end content -->
	<!-- footer -->
	<%@include file="/jshop/admin/footer.jsp"%>
	<!-- end footert -->
	<script type="text/javascript" src="/jshop/admin/js/adddiamondjs.js"></script>
</body>
</html>
