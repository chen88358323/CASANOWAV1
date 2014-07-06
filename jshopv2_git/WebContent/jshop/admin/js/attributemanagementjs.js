
/**
 * Global variables
 */
var session="true";
var rid="";
var globalrjson="";//post json data to backstage server
/*===========================================Gorgeous split-line==============================================*/

/**
 * Function
 */
/*
 * To obtain random rid
 */
function getIdforradom(){
	var myDate=new Date();
	rid="1"+myDate.getSeconds().toString()+myDate.getMilliseconds().toString();
}
/*
 * Delete Page elements According to rid 
 */
function delParamPChild(rid){
	$('#add'+rid).remove();
}
/*===========================================Gorgeous split-line==============================================*/

/**
 * Required to initialize the page data
 */

/**
 * flexigrid list 
 */
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
//		searchitems : [{
//			display:'请选择搜索条件',
//			name:'sc',
//			isdefault : true
//		}],
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
/*===========================================Gorgeous split-line==============================================*/


