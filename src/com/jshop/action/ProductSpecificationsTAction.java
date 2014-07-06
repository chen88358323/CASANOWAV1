package com.jshop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.ProductSpecificationsT;
import com.jshop.service.ProductSpecificationsTService;
import com.jshop.service.impl.ProductSpecificationsTServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Controller("productSpecificationsTAction")
public class ProductSpecificationsTAction extends ActionSupport {
	@Resource(name = "serial")
	private Serial serial;
	private ProductSpecificationsTService productSpecificationsTService;

	private String specificationsid;
	private String name;
	private String note;
	private String sort;
	private String specificationsType;
	private String specificationsValue;
	private Date createtime;
	private String creatorid;
	private String state;
	private ProductSpecificationsT bean = new ProductSpecificationsT();
	private List beanlist = new ArrayList();
	private List<ProductSpecificationsT> specification = new ArrayList<ProductSpecificationsT>();
	private String query;
	private String qtype;
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String specificationslist = null;
	private String specificationsselect = null;
	private boolean slogin;
	private boolean sucflag;
	private String sortname;
	private String sortorder;

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize = false)
	public ProductSpecificationsTService getProductSpecificationsTService() {
		return productSpecificationsTService;
	}

	public void setProductSpecificationsTService(ProductSpecificationsTService productSpecificationsTService) {
		this.productSpecificationsTService = productSpecificationsTService;
	}

	public String getSpecificationsid() {
		return specificationsid;
	}

	public void setSpecificationsid(String specificationsid) {
		this.specificationsid = specificationsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSpecificationsType() {
		return specificationsType;
	}

	public void setSpecificationsType(String specificationsType) {
		this.specificationsType = specificationsType;
	}

	public String getSpecificationsValue() {
		return specificationsValue;
	}

	public void setSpecificationsValue(String specificationsValue) {
		this.specificationsValue = specificationsValue;
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

	public ProductSpecificationsT getBean() {
		return bean;
	}

	public void setBean(ProductSpecificationsT bean) {
		this.bean = bean;
	}

	public List getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List beanlist) {
		this.beanlist = beanlist;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSpecificationslist() {
		return specificationslist;
	}

	public void setSpecificationslist(String specificationslist) {
		this.specificationslist = specificationslist;
	}

	public List<ProductSpecificationsT> getSpecification() {
		return specification;
	}

	public void setSpecification(List<ProductSpecificationsT> specification) {
		this.specification = specification;
	}

	public String getSpecificationsselect() {
		return specificationsselect;
	}

	public void setSpecificationsselect(String specificationsselect) {
		this.specificationsselect = specificationsselect;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	/**
	 * 清楚错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加所有商品规格值
	 * 
	 * @return
	 */
	@Action(value = "addProductSpecification", results = { @Result(name = "json", type = "json") })
	public String addProductSpecification() {
		ProductSpecificationsT pst = new ProductSpecificationsT();
		pst.setSpecificationsid(this.getSerial().Serialid(Serial.PRODUCTSPECIFICATION));
		pst.setName(this.getName().trim());
		pst.setNote(this.getNote());
		pst.setSort(this.getSort());
		pst.setSpecificationsType(this.getSpecificationsType());
		pst.setSpecificationsValue(this.getSpecificationsValue());
		pst.setCreatetime(BaseTools.systemtime());
		pst.setCreatorid(BaseTools.adminCreateId());
		pst.setState("1");
		this.getProductSpecificationsTService().addProductSpecification(pst);
		this.setSucflag(true);
		return "json";

	}

	/**
	 * 查询所有商品规格值
	 * 
	 * @return
	 */
	@Action(value = "findAllProductSpecificationsT", results = { @Result(name = "json", type = "json") })
	public String findAllProductSpecificationsT() {
		if ("sc".equals(this.getQtype())) {
			this.findDefaultAllProductSpecificationsT();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllProductSpecificationsT() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getProductSpecificationsTService().countfindAllProductSpecificationsT();
		String queryString = "from ProductSpecificationsT order by " + sortname + " " + sortorder + " ";
		if (Validate.StrNotNull(sortname) && Validate.StrNotNull(sortorder)) {
			List<ProductSpecificationsT> list = this.getProductSpecificationsTService().sortAllProductSpecificationsT(currentPage, lineSize, queryString);
			if (list != null) {
				this.ProcessProductSpecificationsTList(list);
			}
		}
	}

	public void ProcessProductSpecificationsTList(List<ProductSpecificationsT> list) {
		rows.clear();
		StringBuilder sb = new StringBuilder();
		String[] array;
		for (Iterator it = list.iterator(); it.hasNext();) {
			ProductSpecificationsT gst = (ProductSpecificationsT) it.next();
			if (gst.getSpecificationsType().equals("1")) {
				gst.setSpecificationsType("文字类型");
			} else {
				gst.setSpecificationsType("图片类型");
			}
			array = gst.getSpecificationsValue().split("-");
			if (array.length > 1) {
				for (int i = 0; i < array.length; i++) {
					JSONObject jo = (JSONObject) JSONValue.parse(array[i]);
					Iterator iter = jo.keySet().iterator();
					while (iter.hasNext()) {
						String key = iter.next().toString();
						if (key.equals("goodsattributename")) {
							sb.append(jo.get(key).toString() + "  ");
						}
					}
				}
			}else{
				JSONObject jo = (JSONObject) JSONValue.parse(gst.getSpecificationsValue());
				Iterator iter = jo.keySet().iterator();
				while (iter.hasNext()) {
					String key = iter.next().toString();
					if (key.equals("goodsattributename")) {
						sb.append(jo.get(key).toString() + "  ");
					}
				}
			}
			gst.setSpecificationsValue(sb.toString());
			if (gst.getNote() == null) {
				gst.setNote("");
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gst.getSpecificationsid());
			cellMap.put("cell", new Object[] { gst.getName() + "[" + gst.getNote() + "]", gst.getSpecificationsType(), gst.getSpecificationsValue(), gst.getSort(), BaseTools.formateDbDate(gst.getCreatetime()) });
			rows.add(cellMap);
			sb.delete(0, sb.length());
		}

	}

	/**
	 * 根据规格值id获取规格值
	 * 
	 * @return
	 */
	@Action(value = "findProductSpecificationsTByspecificationsid", results = { @Result(name = "json", type = "json") })
	public String findProductSpecificationsTByspecificationsid() {

		if (Validate.StrNotNull(this.getSpecificationsid())) {
			bean = this.getProductSpecificationsTService().findProductSpecificationsTByspecificationsid(this.getSpecificationsid().trim());
			if (bean != null) {

				return "json";
			}
		}
		return "json";

	}

	/**
	 * 更新商品规格值
	 * 
	 * @return
	 */
	@Action(value = "updateProductSpecification", results = { @Result(name = "json", type = "json") })
	public String updateProductSpecification() {

		ProductSpecificationsT pst = new ProductSpecificationsT();
		pst.setSpecificationsid(this.getSpecificationsid().trim());
		pst.setName(this.getName().trim());
		pst.setNote(this.getNote());
		pst.setSort(this.getSort());
		pst.setSpecificationsType(this.getSpecificationsType());
		pst.setSpecificationsValue(this.getSpecificationsValue());
		pst.setCreatetime(BaseTools.systemtime());
		pst.setCreatorid(BaseTools.adminCreateId());
		@SuppressWarnings("unused")
		int i = this.getProductSpecificationsTService().updateProductSpecification(pst);
		this.setSucflag(true);
		return "json";

	}

	/**
	 *删除商品规格值
	 * 
	 * @return
	 */
	@Action(value = "delProductSpecification", results = { @Result(name = "json", type = "json") })
	public String delProductSpecification() {

		if (Validate.StrNotNull(this.getSpecificationsid())) {
			String[] list = this.getSpecificationsid().split(",");
			int i = this.getProductSpecificationsTService().delProductSpecification(list);
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	/**
	 * 查询所有商品规格值
	 * 
	 * @return
	 */
	@Action(value = "findAllSpecificationsforjson", results = { @Result(name = "json", type = "json") })
	public String findAllSpecificationsforjson() {
		this.setSpecificationslist("");
		this.setSpecificationsselect("");
		String tempvalue = "";
		String strbeg = "";
		String strend = "";
		this.specification = this.getProductSpecificationsTService().findAllProductSpecificationsTWithoutPage();
		if (this.specification != null) {
			for (Iterator it = this.specification.iterator(); it.hasNext();) {
				ProductSpecificationsT pst = (ProductSpecificationsT) it.next();
				tempvalue = pst.getName();
				if (pst.getNote() == null) {
					pst.setName(pst.getName() + "[]");
				} else {
					pst.setName(pst.getName() + "[" + pst.getNote() + "]");
				}
				this.specificationslist += "<div class='checkbox'><input type='checkbox' id='" + pst.getSpecificationsid() + "' name='pstspecificationsid' onclick='checkpstspecificationsid()' value='" + tempvalue + "'/><label>" + pst.getName() + "</label></div>";
				strbeg = "<select id='" + pst.getSpecificationsid() + "' name='" + pst.getSpecificationsid() + "'><option value='0'>---请选择---</option>";
				this.specificationsselect += "<option value='" + tempvalue + "'>" + pst.getName() + "</option>";
			}
			this.setSpecificationslist(this.specificationslist);
			this.setSpecificationsselect(strbeg + this.specificationsselect);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(true);
		return "json";

	}
}
