/*
  PHP version 5
  Copyright (c) 2002-2010 ECISP.CN
  声明：这不是一个免费的软件，请在许可范围内使用
  作用：JS验证文件
  作者：Bili E-mail:huangqyun@163.com  QQ:6326420
  http://www.ecisp.cn	http://www.easysitepm.com
 */
// *tab窗口转换
//* clikeclass:当前点击的ID
//* opendivclass：要找开的DIV
//* clikeclass02:按钮前缀
//* opendivclass02:内容前缀
//* vallist：当前显示的序列号，从1开始
//* taplen:最大序列号
//* stylename：按钮点击上的变化后的样式
//* overstylename：按钮离开后的变化样式
function windowsclass(clikeclass,opendivclass,clikeclass02,opendivclass02,vallist,taplen,stylename,overstylename){
	$(clikeclass).removeClass(overstylename).addClass(stylename);
	$(opendivclass).show();
	var openid='';
	var opendivid='';
	for (i = 1; i <= taplen; i++) {
		if (i!=vallist){
			openid=openid+'#'+clikeclass02+i+',';
			opendivid=opendivid+'#'+opendivclass02+i+',';
		}
	}
	openid=openid+'#neiow';
	opendivid=opendivid+'#neiow';
	$(opendivid).hide();
	$(openid).removeClass(stylename).addClass(overstylename);
}
// * 验证码刷新
// * inputname：验证表单名称
// * url：验证码刷新地址
function sessionimg(inputname,url){
	var imgtitle=url+'public/seccode.php?rd='+Math.random();
	$("#"+inputname).attr("src", function() {
		return imgtitle;
	});
}

// * 内容跟贴留言保存
// * seccodetype:是否开启验证码功能
function messform(seccodetype){
	if(document.messformsave.content.value=="") {
		document.messformsave.content.focus();
		alert(forum_input_err);
		return false;
	}
	if(seccodetype=='1' && document.messformsave.seccode.value.match(/^[A-Z]{4}$/ig)==null) {
		document.messformsave.seccode.focus();
		alert(seccode_empty);
		return false;
	}
}

// * 会员登陆验证
// * seccodetype:是否开启验证码功能
function memberlogin(seccodetype){
	if(document.memberreg.username.value.match(/^[^!~`\'\"#\$\%\^&\*\(\)\+\{\}\[\]\|\\/\?\<\>\,\:\;]{5,}$/ig)==null || document.memberreg.username.value=="帐号") {
		document.memberreg.username.focus();
		alert(loing_input_err);
		return false;
	}
	if(document.memberreg.password.value=="" || document.memberreg.password.value=="密码" || document.memberreg.password.value<5) {
		document.memberreg.password.focus();
		alert(loing_input_err);
		return false;
	}

	if(seccodetype=='1' && document.memberreg.seccode.value.match(/^[A-Z]{4}$/ig)==null) {
		document.memberreg.seccode.focus();
		alert(seccode_empty);
		return false;
	}
}

//检查输入的字段是否存在
//dbname：检查的字段,value：值,loadurl：检查URL,gettxtid:要替换的ID，okmess：成功消息,nomess:失败消息,bottonname：要锁定的按钮
function checktypename(dbname,value,loadurl,gettxtid,okmess,nomess,bottonname){
	var um=document.getElementById(gettxtid);
	if (value=='') {
		um.innerHTML="<font color=\"red\">"+nomess+"</font>";
		$('#'+bottonname).attr('disabled','true');
		return false;
	}
	$.ajax({
		type: "POST",
		url: loadurl,
		data: dbname+"="+value,
		success: function(date){
			if (date=="false"){
				um.innerHTML="<font color=\"red\">"+nomess+"</font>";
				$('#'+bottonname).attr('disabled','true');
			}else{
				um.innerHTML="<font color=\"#1CB521\">"+okmess+"</font>";
				$('#'+bottonname).attr('disabled','');
			}
		}
	});
}

// * 会员注册
function memberdbreg(membercard_curl){
	if(membercard_curl){
		if(!document.memberreg.membercard.value.match(/^[0-9]{7,18}$/ig)) {
			alert(membercard_err);
			document.memberreg.membercard.focus();
			return false;
		}
	}
	if(!document.memberreg.username.value.match(/^[^!@~`\'\"#\$\%\^&\*\(\)\+\-\{\}\[\]\|\\/\?\<\>\,\.\:\;]{2,16}$/ig) || document.memberreg.username.value=="帐号") {
		alert(username_len);
		document.memberreg.username.focus();
		return false;
	}
	if(!document.memberreg.email.value.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/ig)) {
		alert(email_err);
		document.memberreg.email.focus();
		return false;
	}

	if(document.memberreg.qq.value.length>5){
		if(!document.memberreg.qq.value.match(/^[0-9]{5,15}$/ig)) {
			alert(qq_err);
			document.memberreg.qq.focus();
			return false;
		}
	}
	if(!document.memberreg.mobile.value.match(/^[1]{1}[0-9]{10}$/ig)) {
		alert(mobile_err);
		document.memberreg.mobile.focus();
		return false;
	}
	if(document.memberreg.password.value.length<6 || document.memberreg.password.value.length>15 || document.memberreg.email.value=="密码" ) {
		alert(password_len);
		document.memberreg.password.focus();
		return false;
	}
	if ( document.memberreg.password.value=="123456" || document.memberreg.password.value=="111111" || document.memberreg.password.value=="aaaaaa" || document.memberreg.password.value=="654321" || document.memberreg.password.value=="abcdef") {
		alert(password_len2);
		document.memberreg.password.focus();
		return false;
	}
	if ( document.memberreg.username.value==document.memberreg.password.value ){
		alert(password_len2);
		document.memberreg.password.focus();
		return false;
	}
	if( document.memberreg.password2.value =="" ) {
		alert(password2_empty);
		document.memberreg.password2.focus();
		return false;
	}
	if( document.memberreg.password2.value != document.memberreg.password.value ) {
		alert(password_disaffinity);
		document.memberreg.password.focus();
		return false;
	}
	if(!document.getElementById("agree").checked) {
		alert(agree_empty);
		return false;
	}
}

// * 密码修改
function editpassword(){
	if( document.editmember.oldpassword.value =="" || document.editmember.oldpassword.value.length<6) {
		alert(oldpassword_err);
		document.editmember.oldpassword.focus();
		return false;
	}
	if(document.editmember.password.value.length<6 || document.editmember.password.value.length>15 ) {
		alert(password_len);
		document.editmember.password.focus();
		return false;
	}
	if ( document.editmember.password.value=="123456" || document.editmember.password.value=="111111" || document.editmember.password.value=="aaaaaa" || document.editmember.password.value=="654321" || document.editmember.password.value=="abcdef") {
		alert(password_len2);
		document.editmember.password.focus();
		return false;
	}
	if( document.editmember.password2.value =="" ) {
		alert(password2_empty);
		document.editmember.password2.focus();
		return false;
	}
	if( document.editmember.password2.value != document.editmember.password.value ) {
		alert(password_disaffinity);
		document.editmember.password.focus();
		return false;
	}
}
// * 邮箱修改
function editmail(){
	if( document.editmember.password.value =="" || document.editmember.password.value.length<6) {
		alert(password_len);
		document.editmember.password.focus();
		return false;
	}
	if(!document.editmember.email.value.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/ig)) {
		alert(email_err);
		document.editmember.email.focus();
		return false;
	}
}
// * 找回密码验证
// * seccodetype:是否开启验证码功能
function lostpassword(seccodetype){
	if(document.lostpassworddb.username.value.match(/^[^\!@~`\'\"#\$\%\^&\*\(\)\+\-\{\}\[\]\|\\/\?\<\>\,\.\:\;]{2,16}$/ig)==null || document.memberreg.username.value=="帐号") {
		document.lostpassworddb.username.focus();
		alert(username_empty);
		return false;
	}
	if(!document.lostpassworddb.email.value.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
		alert(email_err);
		document.lostpassworddb.email.focus();
		return false;
	}
	if(seccodetype=='1' && document.lostpassworddb.seccode.value.match(/^[A-Z]{4}$/ig)==null) {
		document.lostpassworddb.seccode.focus();
		alert(seccode_empty);
		return false;
	}
}
// * 发布话题验证
// * seccodetype:是否开启验证码功能
function forumcreat(seccodetype){
	if(document.bbsmainform.title.value=="") {
		alert(forum_title_err);
		document.bbsmainform.title.focus();
		return false;
	}
	if (document.bbsmainform.username.value=="") {
		alert(forum_input_err);
		document.bbsmainform.username.focus();
		return false;
	}
	if (document.bbsmainform.content.value=="") {
		alert(forum_input_err);
		document.bbsmainform.content.focus();
		return false;
	}
	if(!document.bbsmainform.email.value.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
		alert(email_err);
		document.bbsmainform.email.focus();
		return false;
	}
	if(seccodetype=='1' && document.bbsmainform.seccode.value.match(/^[A-Z]{4}$/ig)==null) {
		document.bbsmainform.seccode.focus();
		alert(seccode_empty);
		return false;
	}
}


//检查购物车更新数量是否为数字
function orderamount(id) {
	var amout=document.getElementById("amount"+id);
	var amountvalue=document.getElementById("amount"+id).value;
	if (amountvalue.match(/^[1-9]{1}[0-9]*$/ig)==null){
		alert(order_amout_err);
		amout.value='1';
		return false;
	}
}

//订单检查
function ordersave(){
	var osid=$('input:radio[name=osid]:checked').val()
	var amid=$('input:radio[name=amid]:checked').val()
	if(osid==1){
		if (amid==0){
			if (document.ordersaveform.alias.value==""){
				document.ordersaveform.alias.focus();
				alert('请填写收货人姓名');
				return false;
			}
			if (document.ordersaveform.mobile.value.match(/^1[0-9]{10}$/ig)==null){
				document.ordersaveform.mobile.focus();
				alert('请填写收货人手机');
				return false;
			}
			if(document.ordersaveform.citytwo.value==0 || document.ordersaveform.citythree.value==0 || document.ordersaveform.district.value==0 ){
				alert('请选择您所属地区！');
				return false;
			}
			if(document.ordersaveform.address.value==""){
				document.ordersaveform.address.focus();
				alert('请填写收货人地址！');
				return false;
			}
		}
	}else if(osid==0){
		if (document.ordersaveform.consignee.value==""){
			document.ordersaveform.consignee.focus();
			alert('请填写收货人姓名');
			return false;
		}
		if (document.ordersaveform.mobile2.value.match(/^1[0-9]{10}$/ig)==null){
			document.ordersaveform.mobile2.focus();
			alert('请填写收货人手机');
			return false;
		}
	}
}

//询盘时检查
function enquirysave(){
	if(document.mainform.linkman.value==""){
		document.mainform.linkman.focus();
		alert(alias_empty);
		return false;
	}
	if(!document.mainform.email.value.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
		alert(email_err);
		document.mainform.email.focus();
		return false;
	}
	if(document.mainform.address.value==""){
		document.mainform.address.focus();
		alert(address_title);
		return false;
	}
	if(document.mainform.tel.value=="" && document.mainform.mobile.value=="" ){
		document.mainform.tel.focus();
		alert(tel_empty);
		return false;
	}
}