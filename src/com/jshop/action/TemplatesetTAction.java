package com.jshop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.TemplateT;
import com.jshop.entity.TemplatesetT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.TemplateTService;
import com.jshop.service.TemplatesetTService;
import com.jshop.service.impl.ArticleCategoryTServiceImpl;
import com.jshop.service.impl.GoodsCategoryTServiceImpl;
import com.jshop.service.impl.TemplateTServiceImpl;
import com.jshop.service.impl.TemplatesetTServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Controller("templatesetTAction")
public class TemplatesetTAction extends ActionSupport {
	
	private TemplatesetTService templatesetTService;
	private TemplateTService templateTService;
	private GoodsCategoryTService goodsCategoryTService;
	private ArticleCategoryTService articleCategoryTService;
	@Resource(name = "serial")
	private Serial serial;
	private String tsid;
	private String templateurl;
	private String systemcontent;
	private String buildhtmlpath;
	private Date createtime;
	private String creatorid;
	private String sign;
	private TemplatesetT bean = new TemplatesetT();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String query;
	private String qtype;
	private String syscontentstrs;
	private String templatestrs;
	private String templatesetstrs;
	private boolean slogin;
	private boolean sucflag;
	
	@JSON(serialize = false)
	public TemplatesetTService getTemplatesetTService() {
		return templatesetTService;
	}

	public void setTemplatesetTService(TemplatesetTService templatesetTService) {
		this.templatesetTService = templatesetTService;
	}
	@JSON(serialize = false)
	public TemplateTService getTemplateTService() {
		return templateTService;
	}

	public void setTemplateTService(TemplateTService templateTService) {
		this.templateTService = templateTService;
	}
	@JSON(serialize = false)
	public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}

	public void setGoodsCategoryTService(GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
	}
	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getTsid() {
		return tsid;
	}

	public void setTsid(String tsid) {
		this.tsid = tsid;
	}

	public String getSystemcontent() {
		return systemcontent;
	}

	public String getTemplateurl() {
		return templateurl;
	}

	public void setTemplateurl(String templateurl) {
		this.templateurl = templateurl;
	}

	public String getBuildhtmlpath() {
		return buildhtmlpath;
	}

	public void setBuildhtmlpath(String buildhtmlpath) {
		this.buildhtmlpath = buildhtmlpath;
	}

	public void setSystemcontent(String systemcontent) {
		this.systemcontent = systemcontent;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public TemplatesetT getBean() {
		return bean;
	}

	public void setBean(TemplatesetT bean) {
		this.bean = bean;
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

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getSyscontentstrs() {
		return syscontentstrs;
	}

	public void setSyscontentstrs(String syscontentstrs) {
		this.syscontentstrs = syscontentstrs;
	}

	public String getTemplatestrs() {
		return templatestrs;
	}

	public void setTemplatestrs(String templatestrs) {
		this.templatestrs = templatestrs;
	}

	public String getTemplatesetstrs() {
		return templatesetstrs;
	}

	public void setTemplatesetstrs(String templatesetstrs) {
		this.templatesetstrs = templatesetstrs;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 查询所有模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "findAllTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String findAllTemplatesetT() {

		if ("sc".equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.findDefaultAllTemplateset();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllTemplateset() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getTemplatesetTService().countfindAllTemplatesetT(BaseTools.adminCreateId());
		List<TemplatesetT> list = this.getTemplatesetTService().findAllTemplatesetT(currentPage, lineSize, BaseTools.adminCreateId());
		if (list != null) {
			this.ProcessTemplatesetTlist(list);
		}
	}

	public void ProcessTemplatesetTlist(List<TemplatesetT> list) {
		rows.clear();
		for (Iterator it = list.iterator(); it.hasNext();) {
			TemplatesetT tst = (TemplatesetT) it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", tst.getTsid());
			cellMap.put("cell", new Object[] { tst.getThemename(), tst.getSystemcontent(), tst.getSign(), tst.getStatus(), tst.getTemplateurl(), tst.getBuildhtmlpath(), tst.getCreatetime(), "<a target='_blank' id='edittemplateset' href='addtemplateset.jsp?tsid=" + tst.getTsid() + "' name='edittemplateset'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 获取系统内容，包含文章分类，和商品分类的预先读取
	 * 
	 * @return
	 */
	@Action(value = "findSystemcontent", results = { @Result(name = "json", type = "json") })
	public String findSystemcontent() {

		List<GoodsCategoryT> gclist = this.getGoodsCategoryTService().findAllGoodsCategoryBycreatorid(BaseTools.adminCreateId());
		List<ArticleCategoryT> aclist = this.getArticleCategoryTService().findAllArticleCategoryBycreatorid(BaseTools.adminCreateId());
		//组织商品分类的所有信息
		this.setSyscontentstrs("");
		if (gclist != null) {
			this.setSyscontentstrs("<option value='-1'>---请选择---</option><option value='0'>--自定义系统内容--</option><option value='1'>--以下是所创建的商品分类--</option>");
			for (Iterator it = gclist.iterator(); it.hasNext();) {
				GoodsCategoryT gct = (GoodsCategoryT) it.next();
				if (gct.getGrade().equals("0")) {
					this.syscontentstrs += "<option value='" + gct.getGoodsCategoryTid() + "," + gct.getSign() + "'>" + gct.getName() + "</option>";
				} else if (gct.getGrade().equals("1")) {
					this.syscontentstrs += "<option value='" + gct.getGoodsCategoryTid() + "," + gct.getSign() + "'>&nbsp;&nbsp;" + gct.getName() + "</option>";
				} else {
					this.syscontentstrs += "<option value='" + gct.getGoodsCategoryTid() + "," + gct.getSign() + "'>&nbsp;&nbsp;&nbsp;" + gct.getName() + "</option>";
				}

			}
		}
		if (aclist != null) {
			this.syscontentstrs += "<option value='2'>--以下是所创建的文章分类--</option>";
			for (Iterator it = aclist.iterator(); it.hasNext();) {
				ArticleCategoryT act = (ArticleCategoryT) it.next();
				if (act.getGrade().equals("0")) {
					this.syscontentstrs += "<option value='" + act.getArticleCategoryTid() + "," + act.getSign() + "'>" + act.getName() + "</option>";
				} else if (act.getGrade().equals("1")) {
					this.syscontentstrs += "<option value='" + act.getArticleCategoryTid() + "," + act.getSign() + "'>&nbsp;&nbsp;" + act.getName() + "</option>";
				} else {
					this.syscontentstrs += "<option value='" + act.getArticleCategoryTid() + "," + act.getSign() + "'>&nbsp;&nbsp;&nbsp;" + act.getName() + "</option>";
				}
			}
		}
		this.setSucflag(true);
		return "json";

	}

	/**
	 * 获取所有模板文件路径
	 */
	@Action(value = "getAllTemplate", results = { @Result(name = "json", type = "json") })
	public String getAllTemplate() {
		List<TemplateT> list = this.getTemplateTService().findAllTemplateWithNoParam(BaseTools.adminCreateId(), "1");
		if (list != null) {
			this.setTemplatestrs("");
			this.setTemplatestrs("<option value='-1'>---请选择---</option>");
			for (Iterator it = list.iterator(); it.hasNext();) {
				TemplateT tt = (TemplateT) it.next();
				this.templatestrs += "<option value='" + tt.getUrl() + "," + tt.getSign() + "'>" + tt.getUrl() + "</option>";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 获取模板文件和系统内容的输出路径
	 * 
	 * @return
	 */
	@Action(value = "getTemplateOutHtmlPath", results = { @Result(name = "json", type = "json") })
	public String getTemplateOutHtmlPath() {

		List<TemplatesetT> list = this.getTemplatesetTService().findAllTemplatesetWithNoParam(BaseTools.adminCreateId());
		if (list != null) {
			this.setTemplatesetstrs("<option value='-1'>---请选择---</option>");
			for (Iterator it = list.iterator(); it.hasNext();) {
				TemplatesetT tst = (TemplatesetT) it.next();
				this.templatesetstrs += "<option value='" + tst.getBuildhtmlpath() + "'>" + tst.getSystemcontent() + "</option>";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 增加模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "addTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String addTemplatesetT() {

		TemplatesetT tst = new TemplatesetT();
		tst.setTsid(this.getSerial().Serialid(Serial.TEMPLATESET));
		tst.setSystemcontent(this.getSystemcontent().trim());
		tst.setTemplateurl(this.getTemplateurl());
		tst.setBuildhtmlpath(this.getBuildhtmlpath());
		tst.setCreatetime(BaseTools.systemtime());
		tst.setCreatorid(BaseTools.adminCreateId());
		tst.setSign(this.getSign());
		//获取模板主题和状态
		TemplateT tt = new TemplateT();
		tt = this.getTemplateTService().findTemplateBysign(this.getSign(), "1");
		if (tt != null) {
			tst.setThemeid(tt.getThemeid());
			tst.setThemename(tt.getThemename());
			tst.setStatus(tt.getStatus());
		}
		if (this.getTemplatesetTService().addTemplatesetT(tst) > 0) {
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 根据tsid获取模板文件和系统内容设定值
	 * 
	 * @return
	 */
	@Action(value = "findTemplatesetTBytsid", results = { @Result(name = "json", type = "json") })
	public String findTemplatesetTBytsid() {

		if (Validate.StrNotNull(this.getTsid())) {
			bean = this.getTemplatesetTService().findTemplatesetTBytsid(this.getTsid());
			if (bean != null) {
				this.setSucflag(true);
				return "json";
			} else {
				this.setSucflag(false);
				return "json";
			}
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 更新模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "updateTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String updateTemplatesetT() {

		TemplatesetT tst = new TemplatesetT();
		tst.setTsid(this.getTsid());
		tst.setTemplateurl(this.getTemplateurl());
		tst.setSystemcontent(this.getSystemcontent().trim());
		tst.setBuildhtmlpath(this.getBuildhtmlpath());
		tst.setCreatetime(BaseTools.systemtime());
		tst.setCreatorid(BaseTools.adminCreateId());
		tst.setSign(this.getSign());
		//获取模板主题和状态
		TemplateT tt = new TemplateT();
		tt = this.getTemplateTService().findTemplateBysign(this.getSign(), "1");
		if (tt != null) {
			tst.setThemeid(tt.getThemeid());
			tst.setThemename(tt.getThemename());
			tst.setStatus(tt.getStatus());
		}
		if (this.getTemplatesetTService().updateTemplatesetT(tst) > 0) {
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 删除模板文件和系统内容设定
	 * 
	 * @return
	 */
	@Action(value = "delTemplatesetT", results = { @Result(name = "json", type = "json") })
	public String delTemplatesetT() {

		if (Validate.StrNotNull(this.getTsid())) {
			String[] strs = this.getTsid().split(",");
			this.getTemplatesetTService().delTemplatesetT(strs);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}
}
