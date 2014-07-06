package com.jshop.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.entity.DiamondAttributeT;
import com.jshop.service.DiamondAttributeTService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Controller("diamondAttributeTAction")
public class DiamondAttributeTAction extends ActionSupport {
	private static final Log log = LogFactory.getLog(DiamondAttributeTAction.class);
	
	private static final long serialVersionUID = 3835126859814088983L;
	private List<DiamondAttributeT> datlist;
	private DiamondAttributeT dat;
	//返回前段vo序列
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	//每页显示条数
	private int rp;
	//当前页码
	private int page = 1;
	
	//总记录条数
	private long total=0;
	private String datid;
	

	public String getDatid() {
		return datid;
	}

	public void setDatid(String datid) {
		this.datid = datid;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@JSON(serialize=false)
	public DiamondAttributeT getDat() {
		return dat;
	}

	public void setDat(DiamondAttributeT dat) {
		this.dat = dat;
	}
	@JSON(serialize=false)
	public List<DiamondAttributeT> getDatlist() {
		return datlist;
	}

	public void setDatlist(List<DiamondAttributeT> datlist) {
		this.datlist = datlist;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	@Resource(name="diamondAttributeTService")
	private DiamondAttributeTService diamondAttributeTService;
	public DiamondAttributeTService getDiamondAttributeTService() {
		return diamondAttributeTService;
	}

	public void setDiamondAttributeTService(
			DiamondAttributeTService diamondAttributeTService) {
		this.diamondAttributeTService = diamondAttributeTService;
	}


	/**
	 * 更新参数
	 * 
	 * @return
	 */
	@Action(value = "UpdateDiamondAttributeT", results = { @Result(name = "json", type = "json") })
	public String UpdateDiamondAttributeT() {
		return "success";
	}
	
	
	/**
	 * 修改属性值
	 * 获取钻石属性列表
	 */
	@Action(value = "/editDiamondAttributeT", 
			results = { 
			@Result(name = "success", location = "/jshop/admin/goods/diamondattribute/editdiamondattribute.jsp")
	})
	public String editDiamondAttributeT() {
		dat=diamondAttributeTService.findDiamondAttributeTById(datid);
		datlist.add(dat);
		return "success";
	}
	
	/**
	 * 修改属性值
	 */
	@Action(value = "/doEditDiamondAttributeT", 
			results = { 
			@Result(name = "success", location = "/jshop/admin/goods/diamondattribute/editdiamondattribute.jsp")
	})
	public String doEditDiamondAttributeT() {
		dat=diamondAttributeTService.findDiamondAttributeTById(datid);
		return "success";
	}
	/**
	 * 删除属性值
	 * 获取钻石属性列表
	 */
	@Action(value = "/delDiamondAttributeT", 
			results = { 
			@Result(name = "success", location = "/jshop/admin/goods/diamondattribute/editdiamondattribute.jsp")
	})
	public String delDiamondAttributeT() {
		
		String[] strarr=datid.split(",");
		datlist=diamondAttributeTService.findDiamondAttibuteByType();
		return "success";
	}
	/**
	 * 增加属性值
	 */
	@Action(value = "/doAddDiamondAttributeT", 
			results = { 
			@Result(name = "success", location = "/jshop/admin/goods/diamondattribute/adddiamondattribute.jsp")
	})
	public String doAddDiamondAttributeT() {
		attrilist=new ArrayList<Map<String,String>>();
		datlist=diamondAttributeTService.findDiamondAttibuteByType();
		for (Iterator<DiamondAttributeT> iterator = datlist.iterator(); iterator.hasNext();) {
			Map<String,String> m=new HashMap<String,String>();
			DiamondAttributeT dat = (DiamondAttributeT) iterator.next();
			m.put("gaid", dat.getGaid()+"");
			m.put("attname", dat.getAttname());
			attrilist.add(m);
		}
		return "success";
	}
	/**
	 * 增加属性值前
	 * 获取钻石属性列表
	 */
	@Action(value = "/addDiamondAttributeT", 
			results = { 
			@Result(name = "success", location = "/jshop/admin/goods/diamondattribute/adddiamondattribute.jsp")
	})
	public String addDiamondAttributeT() {
		datlist=diamondAttributeTService.findDiamondAttibuteByType();
		return "success";
	}
	//前台下拉框
	private List<Map<String, String>> attrilist = null;
	public List<Map<String, String>> getAttrilist() {
		return attrilist;
	}

	public void setAttrilist(List<Map<String, String>> attrilist) {
		this.attrilist = attrilist;
	}

	/**
	 * 获取钻石及其他商品的规定参数
	 */
	@Action(value = "/findAllDiamondAttributeT",results = { @Result(name = "json", type = "json") })
	public String findAllDiamondAttributeT() {
		total=diamondAttributeTService.countfindAllDiamondAttributeT();
		List<DiamondAttributeT> list=diamondAttributeTService.findAllDiamondAttributeT(page, rp);
		transVO(list);
		return "json";

	}
	/**
	 * 根据所选类型获取值
	 * 可以改成sql直接查,目前这种方法是为了走缓存
	 * 但最好修改成静态页(freemarker或者velocity)后,
	 * 删除此方法
	 */
	@Action(value = "/queryAttributeValueByType",results = { @Result(name = "json", type = "json") })
	public String queryAttributeValueByType() {
		if(attributeName==null||"".equals(attributeName)||attributeId==null||"".equals(attributeId)){
			attributeValue="";
		}else{
			datlist=diamondAttributeTService.findDiamondAttibuteByType();
			for (Iterator<DiamondAttributeT> iterator = datlist.iterator(); iterator.hasNext();) {
				DiamondAttributeT dat = (DiamondAttributeT) iterator.next();
				if(dat.getAttname().equals(attributeName))
					attributeValue=dat.getAttvalue();
			}
		}
		log.info("Method------>queryAttributeValueByType()  attributeValue is "+attributeValue);
		return "json";
	}
	private String attributeId;
	private String attributeName;
	private String attributeValue;

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	//po  --> vo
	public void transVO(List<DiamondAttributeT> list) {
		rows.clear();
		for (Iterator<DiamondAttributeT> it = list.iterator(); it.hasNext();) {
			DiamondAttributeT dat = (DiamondAttributeT) it.next();
			
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id",dat.getGaid());
			cellMap.put("cell", new Object[] {dat.getAttname(),dat.getAttvalue(),BaseTools.formateDbDate(dat.getCreatetime())});
			rows.add(cellMap);
		}
	}
}
