package com.jshop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.FunctionM;
import com.jshop.service.FunctionMService;
import com.jshop.service.impl.FunctionMServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Controller("functionMAction")
public class FunctionMAction extends ActionSupport {
	private FunctionMService functionMService;
	private Serial serial;
	private String id;
    private String visiturl;
    private String visitmethodname;
    private String functionname;
    private Date createtime;
    private String moduleid;
    private FunctionM bean=new FunctionM();
    private List<FunctionM> beanlist=new ArrayList<FunctionM>();
	private Map<String,Object>map=new HashMap<String,Object>();
	private List rows=new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String query;
	private String qtype;
	private boolean sucflag;
	@JSON(serialize = false)
	public FunctionMService getFunctionMService() {
		return functionMService;
	}
	public void setFunctionMService(FunctionMService functionMService) {
		this.functionMService = functionMService;
	}
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVisiturl() {
		return visiturl;
	}
	public void setVisiturl(String visiturl) {
		this.visiturl = visiturl;
	}
	public String getVisitmethodname() {
		return visitmethodname;
	}
	public void setVisitmethodname(String visitmethodname) {
		this.visitmethodname = visitmethodname;
	}
	public String getFunctionname() {
		return functionname;
	}
	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getModuleid() {
		return moduleid;
	}
	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}
	public FunctionM getBean() {
		return bean;
	}
	public void setBean(FunctionM bean) {
		this.bean = bean;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	
	public List<FunctionM> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<FunctionM> beanlist) {
		this.beanlist = beanlist;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	/**
	 * 增加可访问的功能路径或方法
	 * @return
	 */
	@Action(value = "addFunctionM", results = { @Result(name = "json", type = "json") })
	public String addFunctionM(){
		FunctionM fm=new FunctionM();
		fm.setId(this.getSerial().Serialid(Serial.FUNCTION));
		fm.setFunctionname(this.getFunctionname());
		fm.setVisitmethodname(this.getVisitmethodname());
		fm.setVisiturl(this.getVisiturl());
		fm.setModuleid(this.getModuleid());
		fm.setCreatetime(BaseTools.systemtime());
		this.getFunctionMService().addFunctionM(fm);
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 根据id获取功能信息数据
	 * @return
	 */
	@Action(value = "findFunctionMById", results = { @Result(name = "json", type = "json") })
	public String findFunctionMById(){
		if(Validate.StrNotNull(this.getId())){
			bean=this.getFunctionMService().findFunctionMById(this.getId().trim());
			if(bean!=null){
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	/**
	 * 更新功能
	 * @return
	 */
	@Action(value = "updateFunctionM", results = { @Result(name = "json", type = "json") })
	public String updateFunctionM(){
		bean.setId(this.getId());
		bean.setFunctionname(this.getFunctionname());
		bean.setVisitmethodname(this.getVisitmethodname());
		bean.setVisiturl(this.getVisiturl());
		bean.setModuleid(this.getModuleid());
		bean.setCreatetime(BaseTools.systemtime());
		this.getFunctionMService().updateFunctionM(bean);
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 根据模块id查询对应功能列表
	 * @return
	 */
	@Action(value = "findAllFunctionMBymoduleid", results = { @Result(name = "json", type = "json") })
	public String findAllFunctionMBymoduleid(){
		if(Validate.StrNotNull(this.getModuleid())){
			this.findDefaultAllFunctionMBymoduleid();
		}else{
			this.findAllFunctionM();
		}
		return "json";
	}
	
	
	public void findDefaultAllFunctionMBymoduleid(){
		List<FunctionM>list=this.getFunctionMService().findAllFunctionMBymoduleid(this.getModuleid().trim());
		if(!list.isEmpty()){
			total=list.size();
			this.ProcessFunctionMList(list);
		}
	}
	
	public void findAllFunctionM(){
		List<FunctionM>list=this.getFunctionMService().findAllFunctionM();
		if(!list.isEmpty()){
			total=list.size();
			this.ProcessFunctionMList(list);
		}
	}
	
	public void ProcessFunctionMList(List<FunctionM>list){
		for(Iterator it=list.iterator();it.hasNext();){
			FunctionM fm=(FunctionM)it.next();
			Map<String,Object>cellMap=new HashMap<String,Object>();
			cellMap.put("id", fm.getId());
			cellMap.put("cell", new Object[]{
				fm.getFunctionname(),
				fm.getVisiturl(),
				fm.getVisitmethodname(),
				BaseTools.formateDbDate(fm.getCreatetime())
			});
			rows.add(cellMap);
		}
	}
	
	/**
	 * 删除系统模块功能
	 * @return
	 */
	@Action(value = "delFunctionM", results = { @Result(name = "json", type = "json") })
	public String delFunctionM(){
		if(Validate.StrNotNull(this.getId())){
			String []strs=StringUtils.split(this.getId(),",");
			if(this.getFunctionMService().delFunctionM(strs)>0){
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	/**
	 * 获取所有功能，给前台的checkbox显示
	 * @return
	 */
	@Action(value = "findAllFunction", results = { @Result(name = "json", type = "json") })
	public String findAllFunction(){
		beanlist=this.getFunctionMService().findAllFunctionM();
		return "json";
	}
	
}
