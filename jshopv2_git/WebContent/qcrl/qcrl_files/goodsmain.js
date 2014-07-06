//排行选择
function divdisk(nowid,hoverid){
	$('#hoverlist_'+nowid).addClass('hover');
	for (var i = 1; i <= hoverid; i++) {
		if (i!=nowid){
			$('#hoverlist_'+i).removeClass('hover');
		}
	}
}
//产品价格选择
function goodsprice(value,keyname,key,keynum,endkey,attarraynum){
	//第一步给去样式
	$('#pricekey'+endkey+'_'+key).removeClass('plab').addClass('plab1');
	var openid='';
	for (var i = 1; i <= keynum; i++) {
		if (i!=key){
			openid=openid+'#pricekey'+endkey+'_'+i+',';
		}
	}
	$(openid).removeClass('plab1').addClass('plab');
	//第二步计算值
	//当前产品默认价格
	var bprice=$('#bprice').val();
	bprice=parseFloat(bprice);
	value=parseFloat(value);
	var newprice=value+bprice;
	$('#attvaluebprice_'+endkey).val(value);
	$('#attrkeyvalue_'+endkey).val(keyname);
	$('#newprice_'+endkey).val(newprice);
	var bpricenum=0;
	for (var ii = 1; ii <= attarraynum; ii++) {
		if (ii!=endkey){
			bpricenum=bpricenum+parseFloat($('#attvaluebprice_'+ii).val());
		}
	}
	var numprice=newprice+bpricenum;
	var pricestr="￥"+numprice;
	$("#pricenum").empty().append(pricestr);
}
//产品价格选择（下拉类）
function goodspriceselect(selectvalue){
	//得到图片数量
	var select_array = selectvalue.split('|');
	var value=select_array[0];
	var keyname=select_array[1];
	var key=select_array[2];
	var keynum=select_array[3];
	var endkey=select_array[4];
	var attarraynum=select_array[5];
	//第一步给去样式
	$('#pricekey'+endkey+'_'+key).removeClass('plab').addClass('plab1');
	var openid='';
	for (var i = 1; i <= keynum; i++) {
		if (i!=key){
			openid=openid+'#pricekey'+endkey+'_'+i+',';
		}
	}
	$(openid).removeClass('plab1').addClass('plab');
	//第二步计算值
	//当前产品默认价格
	var bprice=$('#bprice').val();
	bprice=parseFloat(bprice);
	value=parseFloat(value);
	var newprice=value+bprice;
	$('#attvaluebprice_'+endkey).val(value);
	$('#attrkeyvalue_'+endkey).val(keyname);
	$('#newprice_'+endkey).val(newprice);

	var bpricenum=0;
	for (var ii = 1; ii <= attarraynum; ii++) {
		if (ii!=endkey){
			bpricenum=bpricenum+parseFloat($('#attvaluebprice_'+ii).val());
		}
	}
	var numprice=newprice+bpricenum;
	var pricestr="￥"+numprice;
	$("#pricenum").empty().append(pricestr);
}
//点击小图替换大图
function mepicshow(imgidname,imgsrc){
	$("#"+imgidname).attr("src",imgsrc);
}
//加载翻页
//pagemax:一页显示数量
//maxhit:翻页数量
//nowpage:当前页面
//loadname:列表显示ID位置
//pagetextname：翻页文字内容显示ID
//pagebottonname：翻页按钮位置
function pageload(pagemax,maxhit,nowpage,loadurl,loadname,pagetextname,pagebottonname,formname){
	var counturl=loadurl+'&countnum=2&freshid='+Math.random();
	$.get(counturl,function(data){
		$(this).pagination(data,{
			//每页显示的数据量
			items_per_page:pagemax,
			//翻页页数
			num_edge_entries: 2,
			//翻页按钮数量
			num_display_entries: maxhit,
			//当前页数
			current_page:nowpage,
			prev_text:"上一页",
			next_text:"下一页",
			home_text:"首页",
			end_text:"尾页",
			loadname:loadname,
			pagetextname:pagetextname,
			pagebottonname:pagebottonname,
			formname:formname,
			//加载网址
			loadurl:loadurl,
			callback: pageselectCallback
		});
		pageselectCallback(loadurl,0,pagemax,data,loadname,pagetextname,formname);
	})
}
//执行GET请求
//loadurl:请求网址
//page_id:当前页码
//page_id2：每页显示的数量
//countnum:总数
//loadname:列表显示ID位置
//pagetextname：翻页文字内容显示ID
function pageselectCallback(loadurl,page_id,page_id2,countnum,loadname,pagetextname,formname){
	//定义limit开始数字 当前页数*每页显示的数量
	page_id=parseInt(page_id)
	page_id2=parseInt(page_id2)
	var limitstard=(page_id*page_id2);
	$(loadname).load(loadurl,{
		//当前页面数据初始ID号，limit $Minpageid
		'MinPageid':limitstard,
		//当前页码
		'page_id':page_id,
		//每页显示内容数量
		'MaxPerPage':page_id2
	});
	if (formname){
		var formlist = document.getElementById(formname);
		formlist.elements[3].value = page_id;
		$('#pagenum').html(countnum);
		$(pagetextname).html("总计：<span class='orange'>"+countnum+"</span> 条记录 每页显示<span class='orange'> "+page_id2+" </span>条");
	}else{
		$(pagetextname).html("总计：<span class='orange'>"+countnum+"</span> 条记录 当前<span class='orange'> "+((page_id*page_id2))+"-"+((page_id*page_id2)+page_id2)+" </span>条 每页显示<span class='orange'> "+page_id2+" </span>条");
	}

}

//bbsAJAX浏览方式
function bbslist(nowbbsid,rebbsid,ismesstype,did,countnum){
	var messageURL="index.php?ac=messmain&at=ajaxgoodsmessage&did="+did+"&max=5&ismesstype="+ismesstype;
	$(rebbsid).removeClass('this');
	$(nowbbsid).addClass('this');
	$(this).pagination(countnum,{
		//每页显示的数据量
		items_per_page:5,
		//翻页页数
		num_edge_entries: 2,
		//翻页按钮数量
		num_display_entries: 5,
		//当前页数
		current_page:0,
		prev_text:"上一页",
		next_text:"下一页",
		home_text:"首页",
		end_text:"尾页",
		loadname:"#loadingtabelist",
		pagetextname:'#pagetextname',
		pagebottonname:'#pagebottonname',
		//加载网址
		loadurl:messageURL,
		callback: pageselectCallback
	});
	pageselectCallback(messageURL,0,5,countnum,"#loadingtabelist",'#pagetextname',false);
}

//给组件加底图
//inputname:要添加的值
//value:要添加的值
//putnamelist:要读取并判断的列
//spanid:按钮DIV ID
//imagedivid:按钮ID加底色的DIV ID
//srcvalue:按钮图片名
function notekey(inputname,value,putnamelist,spanid){
	var nowinputvalue=$(inputname).val();
	//读取按钮所有值，并生成数组
	var putnamelist_str=$(putnamelist).val();
	var putnamelist_array = putnamelist_str.split(',');
	//定义当前按钮ID值
	var nowopenclass=spanid+value;
	//去掉所有ID的底色
	var openclass='';
	for (var i = 0; i < putnamelist_array.length; i++) {
		//当按钮底色不等于当前值的时候，去掉色底和值
		if (putnamelist_array[i]!=value){
			//生成按钮ID值
			openclass=openclass+spanid+putnamelist_array[i]+',';
		}
	}

	openclass=openclass.substring(0,openclass.length-1);


	//假如ID值不等于
	//	if (value==nowinputvalue){
	//去掉相关值
	var nowimageIDvalue=$(nowopenclass).attr('class');
	if (nowimageIDvalue){
		$(nowopenclass).removeClass('hover');
		var emptyval_exp='\''+value+"',";
		var emptyval = nowinputvalue.replace(emptyval_exp,"");
		$(inputname).val(emptyval);
		return false;
	}
	var newval=nowinputvalue+"'"+value+"',";
	$(inputname).val(newval);
	//	$(inputname).val(value);
	//去掉其它选择
	//	$(openclass).removeClass('luo_lab1').addClass('luo_lab');
	//	$(openclass2).empty();
	$(nowopenclass).addClass('hover');
}

//搜索
function notesearch(){
	var loadurl=$('#loadurl').val();

	var color=$('#color').val();
	//去掉最后一个,
	color=color.substring(0,color.length-1);
	//设定正则表达式的参数，替换指定参数
	var reStr=new RegExp("&color=[\\w\,\']*","gi");
	//设定替换参数
	var peStr = '&color='+color;
	//进行替换
	loadurl= loadurl.replace(reStr, peStr);

	var bprice1=$('#bprice1').val();
	bprice1=parseFloat(bprice1);
	bprice1= isNaN(bprice1) ? 0 : bprice1;

	var bprice2=$('#bprice2').val();
	bprice2=parseFloat(bprice2);
	bprice2= isNaN(bprice2) ? 0 : bprice2;
	if(bprice1>bprice2){
		alert('提示：价格范围填写错误，第一个值必须小于第二值，请重新填写');
		return false;
	}

	reStr=new RegExp("&bprice1=\\w*","gi");
	peStr = '&bprice1='+bprice1;
	loadurl= loadurl.replace(reStr, peStr);

	reStr=new RegExp("&bprice2=\\w*","gi");
	peStr = '&bprice2='+bprice2;
	loadurl= loadurl.replace(reStr, peStr);

	var weight1=$('#weight1').val();
	weight1=parseFloat(weight1);
	weight1= isNaN(weight1) ? 0 : weight1;

	var weight2=$('#weight2').val();
	weight2=parseFloat(weight2);
	weight2= isNaN(weight2) ? 0 : weight2;
	if(weight1 > weight2){
		alert('提示：重量范围填写错误，第一个值必须小于第二值，请重新填写');
		return false;
	}
	reStr=new RegExp("&weight1=[\\w.]*","gi");
	peStr = '&weight1='+weight1;
	loadurl= loadurl.replace(reStr, peStr);

	reStr=new RegExp("&weight2=[\\w.]*","gi");
	peStr = '&weight2='+weight2;
	loadurl= loadurl.replace(reStr, peStr);


	var cutters=$('#cutters').val();
	cutters=cutters.substring(0,cutters.length-1);
	reStr=new RegExp("&cutters=[\\w\,\']*","gi");
	peStr = '&cutters='+cutters;
	loadurl= loadurl.replace(reStr, peStr);

	var polishing=$('#polishing').val();
	polishing=polishing.substring(0,polishing.length-1);
	reStr=new RegExp("&polishing=[\\w\,\']*","gi");
	peStr = '&polishing='+polishing;
	loadurl= loadurl.replace(reStr, peStr);

	var symmetrical=$('#symmetrical').val();
	symmetrical=symmetrical.substring(0,symmetrical.length-1);
	reStr=new RegExp("&symmetrical=[\\w\,\']*","gi");
	peStr = '&symmetrical='+symmetrical;
	loadurl= loadurl.replace(reStr, peStr);

	//静度
	var clarity=$('#clarity').val();
	//去掉最后一个,
	clarity=clarity.substring(0,clarity.length-1);
	reStr=new RegExp("&clarity=[\\w\,\']*","gi");
	peStr = '&clarity='+clarity;
	loadurl= loadurl.replace(reStr, peStr);

	var shape=$('#shape').val();
	shape=shape.substring(0,shape.length-1);
	reStr=new RegExp("&shape=[\\w\,\']*","gi");
	peStr = '&shape='+shape;
	loadurl= loadurl.replace(reStr, peStr);

	var certificate=$('#certificate').val();
	certificate=certificate.substring(0,certificate.length-1);
	reStr=new RegExp("&certificate=[\\w\,\']*","gi");
	peStr = '&certificate='+certificate;
	loadurl= loadurl.replace(reStr, peStr);

	var certificatecoding=$('#certificatecoding').val();
	certificatecoding= certificatecoding=='请输入证书编号' ?'' : certificatecoding;
	reStr=new RegExp("&certificatecoding=\\w*","gi");
	peStr = '&certificatecoding='+certificatecoding;
	loadurl= loadurl.replace(reStr, peStr);

	var city=$('#city').val();
	city=city.substring(0,city.length-1);
	reStr=new RegExp("&city=[\\w\,\']*","gi");
	peStr = '&city='+city;
	loadurl= loadurl.replace(reStr, peStr);

	var isgoodsnum=$('input:checkbox[name="isgoodsnum"]:checked').val();
	isgoodsnum= isgoodsnum==undefined ? 0 : 1;
	reStr=new RegExp("&isgoodsnum=\\w*","gi");
	peStr = '&isgoodsnum='+isgoodsnum;
	loadurl= loadurl.replace(reStr, peStr);
	$('#loadurl').val(loadurl);
	$('#oldloadurladd').val(loadurl);
	var maxperpage=$('#maxperpage').val();

	pageload(maxperpage,5,0,loadurl,'#loadingtabelist','#pageinfo','#pagebottonnamelist','selectform');
}

//参数复位
function notesearchre(srcvalue){
	var labclass="#lab_D,#lab_E,#lab_F,#lab_G,#lab_H,#lab_I,#lab_J,#lab_K,#lab_L,#labC_FL,#labC_IF,#labC_VVS1,#labC_VVS2,#labC_VS1,#labC_VS2,#labC_SI1,#labC_SI2,#labCut_EX,#labCut_VG,#labCut_GD,#labP_EX,#labP_VG,#labP_GD,#labW_EX,#labW_VG,#labW_GD,";
	labclass=labclass+'#labS_Round,#labS_Princess,#labS_Pear,#labS_Heart,#labS_Marquise,#labS_Oval,#labS_Emerald,#labS_Radiant,#labS_Cushion,#labW_GIA,#labW_HRD,#labW_IGI,#labW_NGTC,'
	labclass=labclass+'#labCi_bj,#labCi_sh,#labCi_all'

	var inputname='#color,#clarity,#cutters,#polishing,#symmetrical,#shape,#certificate,#city';

	$(labclass).removeClass('hover');
	$(inputname).val('');

	var inputname2='#weight1,#weight2,#bprice1,#bprice2';
	$(inputname2).val('0');
	$('#certificatecoding').val('请输入证书编号');
}

//热门搜索
function coolkeylist(url){
	var maxperpage=$('#maxperpage').val();
	pageload(maxperpage,5,0,url,'#loadingtabelist','#pageinfo','#pagebottonnamelist','selectform');
}

function delnokedb(gnid){
	var nokedblist=$('#nokedblist').val();
	var reStr=null;
	//设定正则表达式的参数，替换指定参数
	reStr=new RegExp("[^0-9,]*"+gnid+",","gi");
	//进行替换
	nokedblist= nokedblist.replace(reStr, '');
	$('#nokedblist').val(nokedblist);
	var oldloadurladd=$('#oldloadurladd').val();
	oldloadurladd=oldloadurladd+'&listtype=3';
	nokedblist=nokedblist.substring(0,nokedblist.length-1);
	if(nokedblist){
		$('#loadingnokedb').load(oldloadurladd,{
			//当前页面数据初始ID号，limit $Minpageid
			'nokedblist':nokedblist,
			'MinPageid':0,
			//当前页码
			'page_id':0,
			//每页显示内容数量
			'MaxPerPage':10
		});
	}else{
		$('#loadingnokedb').empty();
	}
}
function nokedb(gnid){
	var nokedblist=$('#nokedblist').val();
	//得到产品是否选中
	var gnidtype=$('input:checkbox[name="nokedb'+gnid+'"]:checked').val();
	var reStr=null;
	if(gnidtype!=undefined){
		nokedblist=nokedblist+gnid+',';
		$('#nokedblist').val(nokedblist);
	}else{
		//设定正则表达式的参数，替换指定参数
		reStr=new RegExp("[^0-9,]*"+gnid+",","gi");
		//进行替换
		nokedblist= nokedblist.replace(reStr, '');
		$('#nokedblist').val(nokedblist);
	}
	var oldloadurladd=$('#oldloadurladd').val();
	oldloadurladd=oldloadurladd+'&listtype=3';
	nokedblist=nokedblist.substring(0,nokedblist.length-1);
	if(nokedblist){
		$('#loadingnokedb').load(oldloadurladd,{
			//当前页面数据初始ID号，limit $Minpageid
			'nokedblist':nokedblist,
			'MinPageid':0,
			//当前页码
			'page_id':0,
			//每页显示内容数量
			'MaxPerPage':10
		});
	}else{
		$('#loadingnokedb').empty();
	}

}
//首页选择分类地址
function homeshopselect(outID,link,listnameID,nowid,numid){
	$.ajax({
		type: "get",
		url: link,
		data: {},
		global: false,
		beforeSend: function(data) {
			$('#loadingdiv').hide();
			$('#loadingstr').show();
			$("#loadingstr").text("正在加载数据");
		},
		success: function(data) {
			$('#loadingstr').hide();
			$('#loadingdiv').show();
			$("#loadingdiv").html(data);
		}
	});
	var clikeclass=listnameID+nowid
	$(clikeclass).addClass('hover');
	var openid='';
	for (var i = 1; i <= numid; i++) {
		if (i!=nowid){
			openid=openid+listnameID+i+',';
		}
	}
	openid=openid+'#neiow';
	$(openid).removeClass('hover');
}
//优惠卷验证及价格替换
function discountsn(ocdsn){
	var productmoney=$("#productmoney").val();
	var discount_productmoney=$("#discount_productmoney").val();
	var discountmoney=$("#discountmoney").val();
	var link='/index.php?ac=order&at=discount&ocdsn='+ocdsn+'&productmoney='+productmoney+'&discount_productmoney='+discount_productmoney+'&discountmoney='+discountmoney
	$.ajax({
		type: "get",
		url: link,
		data: {},
		global: false,
		success: function(data) {
			if (data!='false'){
				$("#priceall").html(data);
			}

		}
	});

}
//分店选择
function shopselect(value){
	if(value=='0' || value==''){
		return false;
	}
	var value_array = value.split('|');
	$("#addressstr").html(value_array[1]);
}


//排序列表
// string :要替换的字段
// val:要写入的值
//bottonid:要改变按钮样式的ID
//nowid:要显示的ID
//clearid：要去变和隐藏的ID
function onlimit(string,val,formname,bottonid,imageid,image_asc,image_desc){
	var formlist=document.getElementById(formname);
	//查找指定表单的loadurl值
	var loadurl=formlist.elements[0].value;
	//获取默认一页显示数量
	var maxperpage=formlist.elements[1].value;
	//获取翻页数量
	var maxhit=formlist.elements[2].value;
	//获取翻页数量
	var nowpage=formlist.elements[3].value;
	//loadname:列表显示ID位置
	var loadname=formlist.elements[6].value;
	//pagetextname：翻页文字内容显示ID
	var pagetextname=formlist.elements[7].value;
	//pagebottonname：翻页按钮位置
	var pagebottonname=formlist.elements[8].value;
	//pagelistcut：是否不翻页，如果为0，则表过不翻页
	var pagelistcut=formlist.elements[10].value;
	//设定要排序的字段替换
	var reStr=new RegExp("(limitkey=)\\w*(&limitclass=)\\w*","gi");
	//设定替换参数
	var peStr = '$1'+string+'$2'+val;
	//进行替换
	var str= loadurl.replace(reStr, peStr);
	formlist.elements[0].value = str;
	//获取翻页数量
	//var maxhit=Math.round(document.selectform.maxhit.value);
	//pageload(pageid,maxhit,0,str);
	pageload(maxperpage,maxhit,nowpage,str,loadname,pagetextname,pagebottonname,formname);

	//return false;
	//改变样式
	//拼接需要增加样式的ID值
	//$(clearid).removeClass('displaytrue limitdesc limitasc').addClass('displaynone');
	//$(nowid).removeClass('displaynone limitdesc limitasc').addClass('displaytrue limit'+val);
	if (val=='asc') {
		var limittype='desc';
	}else{
		var limittype='asc';
	}
//	var bottnvar="javascript:onlimit('"+string+"','"+limittype+"','"+bottonid+"','"+nowid+"','"+clearid+"','"+formname+"','"+bottonname+"','"+checkname+"')";
	var bottnvar="javascript:onlimit('"+string+"','"+limittype+"','"+formname+"','"+bottonid+"','"+imageid+"','"+image_asc+"','"+image_desc+"')";
	$(bottonid).removeAttr("href").attr("href",bottnvar);
	if (val=='asc') {
		$(imageid).removeAttr("src").attr("src",image_desc);
	}else{
		$(imageid).removeAttr("src").attr("src",image_asc);
	}


}


//对注册密码进行控制
function show(val){
	if(val=="password"){
		$("#passwordinput").empty();
		$("#passwordinput").append('<input type="password" name="password" id="password" maxlength="15" style="width:260px;" class="memberinput" value="" onblur="if(this.value==\'\'){show_hover(\'password\');}"/>');
		document.memberreg.password.focus();
	}else{
		$("#passwordinput2").empty();
		$("#passwordinput2").append('<input type="password" name="password2" id="password2" maxlength="15" style="width:260px;" class="memberinput" value="" onblur="if(this.value==\'\'){show_hover(\'password2\');}"/>');
		document.memberreg.password2.focus();
	}
}
function show_hover(val){
	if(val=='password'){
		$("#passwordinput").empty();
		$("#passwordinput").append('<input type="text" name="password" id="password" maxlength="15" style="width:260px;" class="memberinput" value="密码" onfocus="if(this.value==\'密码\'){show(\'password\');}"/>');
	}else{
		$("#passwordinput2").empty();
		$("#passwordinput2").append('<input type="text" name="password2" id="password2" maxlength="15" style="width:260px;" class="memberinput" value="重复密码" onfocus="if(this.value==\'重复密码\'){show(\'password2\');}"/>');
	}
}
