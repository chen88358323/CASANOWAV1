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

<title>增加商品类型</title>

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
					<h5>增加属性值</h5>

				</div>

				<div class="form">
					<s:form action="doEditDiamondAttributeT.action"
						id="diamondattri.frm" name="diamondattri.frm">
						<div class="fields">
							<div class="field field-first">
								<label for="select"> 属性名: </label>
								<s:select list="datlist" listValue="attname" listKey="gaid"
									name="diamondattsel" id="diamondattsel" ></s:select>
								<div class="input">
									<s:textfield id="attributeValue" name="attributeValue"
										class="small" label="属性值" value="%{#request.dat.attvalue}"></s:textfield>
								</div>
								<input type="button" id="addparam" name="addparam" value="增加属性" />
							</div>
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
		$(document).ready(function() {
			//$("#diamondAttributeT.attvalue").val(<s:property value="datlist.selfBank.id"/>);
			
			$("#diamondattsel").change(function() {
				 $.ajax({
					    type: "POST",
					    url: "queryAttributeValueByType.action",
					    data:{attributeName:$("#diamondattsel").find("option:selected").text(),attributeId:$("#diamondattsel").val()},
					    dataType:"json", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
					    success: function(data){ 
					    		 var temp=$.map(data, function(val, key) {
					    			 if(key === 'attributeValue') {
					    				 return val;
					    			 }
					    		 });
					    		 $("#attributeValue").val(temp);

					    		 
					    },
					    error: function(data){
					     alert("json=" + data);
					     return false;
					    }
				 });
			});
		});
	</script>
</body>
</html>
