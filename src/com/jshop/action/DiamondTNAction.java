package com.jshop.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.jshop.entity.DiamondT;
import com.jshop.entity.GoodsT;
import com.jshop.service.DiamondTService;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Controller("diamondTAction")
public class DiamondTNAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name="diamondTService")
	private DiamondTService diamondTService;
	private DiamondT diamond;

	public DiamondT getDiamond() {
		return diamond;
	}

	public void setDiamond(DiamondT diamond) {
		this.diamond = diamond;
	}

	public DiamondTService getDiamondTService() {
		return diamondTService;
	}

	public void setDiamondTService(DiamondTService diamondTService) {
		this.diamondTService = diamondTService;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		
		this.clearErrorsAndMessages();

	}
	/**
	 * 增加钻石商品
	 * 验证方法
	 */
//public void	validateAddDiamond(){
//	
//}
	/**
	 * 增加钻石商品
	 */
	@Action(value = "/addDiamonds", 
			results = { 
			@Result(name = "success", location = "/jshop/admin/goods/goodsmanagement.jsp"),
			@Result(name = "error", location = "/jshop/admin/goods/adddiamonds.jsp"),
			@Result(name = "input", location = "/jshop/admin/goods/adddiamonds.jsp")
					
	})
	public String addDiamond() {
		if(diamond==null){
			return "error";
		}else {
			diamond.setCreatetime(new Date());
			diamondTService.addDiamond(diamond);
			return "success";
		}
	}

	/**
	 * 更新普通商品（没有开启规格，没有开启属性和参数）
	 * 
	 * @return
	 */
	private boolean updateNormalGoods() {
		GoodsT gt = new GoodsT();
			return false;
	}

	/**
	 * 增加开启了商品类型的商品（没有开启规格，只开启属性和参数）
	 * 
	 * @return
	 */
	private boolean addAttrsGoods() {
		GoodsT gt = new GoodsT();
			return false;
	}

	/**
	 * 更新开启了商品类型的商品（没有开启规格，只开启属性和参数）
	 * 
	 * @return
	 */
	private boolean updateAttrsGoods() {
		GoodsT gt = new GoodsT();
			return false;
	}

	/**
	 * 增加开启规格的商品（开启规格，没有开启属性和参数，有增加货品的过程）
	 * 
	 * @return
	 */
	private boolean addSpecificationGoods() {
		GoodsT gt = new GoodsT();
			return false;
	}

	/**
	 * 更新开启规格的商品（开启规格，没有开启属性和参数，有更新货品的过程）
	 * 
	 * @return
	 */
	private boolean updateSpecificationGoods() {
		GoodsT gt = new GoodsT();
			return false;
	}

	/**
	 * 增加属性参数规格的商品(属性参数，和规格都开启，有增加货品的过程)
	 * 
	 * @return
	 */
	private boolean addAttrandSpecificationGoods() {
		GoodsT gt = new GoodsT();
			return false;
	}


	/**
	 * 获取用户的所有商品信息
	 */
	@Action(value = "getDiamondsList")
	public void finddefaultAllGoods() {
//		int currentPage = page;
//		int lineSize = rp;
//		if (Validate.StrNotNull(sortname) && Validate.StrNotNull(sortorder)) {
//			String queryString = "from GoodsT as gt where gt.creatorid=:creatorid order by " + sortname + " " + sortorder + "";
//			List<GoodsT> list = this.getGoodsTService().sortAllGoods(currentPage, lineSize, BaseTools.adminCreateId(), queryString);
//			if (!list.isEmpty()) {
//				ProcessGoodsList(list);
//			}
//		}
	}

	/**
	 * 迭代处理供前台显示
	 * 
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public void ProcessGoodsList(List<GoodsT> list) {
	}

}
