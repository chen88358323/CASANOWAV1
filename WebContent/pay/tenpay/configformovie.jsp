<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<% 

//�̻���
String partner = "";

//��Կ
String key = "";

//������ɺ���ת��URL
String return_url = basePath+"pay/tenpay/payReturnUrlformovie.jsp";

//���ղƸ�֪ͨͨ��URL
String notify_url = basePath+"pay/tenpay/payNotifyUrlformovie.jsp";

%>
