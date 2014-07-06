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
<title>珠宝属性管理</title>
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
					<h5>珠宝参数设置</h5>
				</div>
				<!-- end box / title -->
				<div class="table">
					<s:form action=""
						id="diamondattri.frm" name="diamondattri.frm">
					<!-- flexigrid -->
					<div id="flexdiamondattributenmanagement"
						style="width: 98%; margin-left: 18px;">
						<table id="diamondattributenmanagement" style="display: none;"></table>
					</div>
					
					</s:form>
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
	<script type="text/javascript">
	var session="true";
	var rid="";
	var globalrjson="";//post json data to backstage server

	$(document).ready(function() {
		$("#diamondattributenmanagement").flexigrid( {
			url : 'findAllDiamondAttributeT.action',
			dataType : 'json',
			cache : false,
			colModel : [{ 
				display:'属性名称',
				name:'attname',
				width:315,
				sortable:true,
				align:'center'
			},{ 
				display:'属性值',
				name:'attvalue',
				width:115,
				sortable:true,
				align:'center'
			},{ 
				display:'创建时间',
				name:'createtime',
				width:415,
				sortable:true,
				align:'center'
			}],
			buttons : [ {
				name : '添加',
				bclass : 'add',
				onpress : action
			}, {
				name : '编辑',
				bclass : 'edit',
				onpress : action
			},{
				name:'删除',
				bclass:'delete',
				onpress:action
			}],
//			searchitems : [{
//				display:'请选择搜索条件',
//				name:'sc',
//				isdefault : true
//			}],
			sortname : "createtime",
			sortorder : "desc",
			usepager : true,
			title : '珠宝属性列表',
			useRp : true,
			rp : 20,
			rpOptions : [ 5, 20, 40, 100 ],
			showTableToggleBtn : true,
			width :'auto',
			height :'auto',
			pagestat : '显示{from}到{to}条，共{total}条记录',
			procmsg : '正在获取数据，请稍候...',
			checkbox:true
		});

		function action(com, grid) {
			if (com == '添加') {
				window.location.href="addDiamondAttributeT.action?session="+session+"#goods";
				return;
			}else if (com == '编辑') {
				if ($('.trSelected', grid).length == 1) {
					jConfirm('确定编辑此项吗?', '信息提示', function(r) {
						if (r) {
							var str = $('.trSelected', grid)[0].id.substr(3);
							window.location.href = "editDiamondAttributeT.action?session="+session+"#pagecontent&datid=" + str;
							return;
						}
					});
				} else {
					jAlert('请选择一条信息', '信息提示');
					return false;
				}
			} else if (com == '删除') {
				if ($('.trSelected', grid).length > 0) {
					jConfirm('确定删除此项吗?', '信息提示', function(r) {
						if (r) {
							var str = "";
							$('.trSelected', grid).each(function() {
								str += this.id.substr(3) + ",";
							});
							$.post("delDiamondAttributeT.action", {
								"datid" : str
							}, function(data) {
								$('#diamondattributenmanagement').flexReload();
							});
						}
					});
					return;
				} else {
					jAlert('请选择要删除的信息!', '信息提示');
					return false;
				}
				
			} 
		}
	});
	
	</script>
</body>
</html>
