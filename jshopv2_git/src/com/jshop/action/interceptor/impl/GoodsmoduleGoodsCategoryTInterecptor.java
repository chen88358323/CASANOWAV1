package com.jshop.action.interceptor.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.jshop.action.interceptor.GoodsmoduleInterecptor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
@ParentPackage("jshop")

@Controller("goodsmoduleGoodsCategoryTInterecptor")
public class GoodsmoduleGoodsCategoryTInterecptor extends MethodFilterInterceptor {
	private GoodsmoduleInterecptor goodsmoduleInterecptor;
	
	public GoodsmoduleInterecptor getGoodsmoduleInterecptor() {
		return goodsmoduleInterecptor;
	}

	public void setGoodsmoduleInterecptor(GoodsmoduleInterecptor goodsmoduleInterecptor) {
		this.goodsmoduleInterecptor = goodsmoduleInterecptor;
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext=invocation.getInvocationContext();
		Map<String,Object> params=invocation.getInvocationContext().getParameters();
		if(actionContext.getName().equals("updateGoodscategoryT")){
			if(params.get("goodsCategoryTid")!=null&&params.get("name")!=null){
				String []namestrs=(String[])params.get("name");
				String []goodsCategoryTidstrs=(String[])params.get("goodsCategoryTid");
				String nlsname=namestrs[0];
				String nlsid=goodsCategoryTidstrs[0];
				this.getGoodsmoduleInterecptor().updateGoodsCategoryBynlsid(nlsid, nlsname);
			}
			return invocation.invoke();
			//捕获生成商品分类静态页需要的数据并调用template下的createhtml去执行
			
		}
		return invocation.invoke();
	}


}
