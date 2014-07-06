package com.jshop.service;

import java.util.List;
import java.util.Map;

import com.jshop.entity.DiamondAttributeT;

public interface DiamondAttributeTService {

	/**
	 * 增加商品参数
	 * @param gat
	 * @return
	 */
	public abstract int addDiamondAttributeT(DiamondAttributeT gat);
	/**
	 * 更新商品参数
	 * @param gat
	 * @return
	 */
	public abstract int updateDiamondAttributeT(DiamondAttributeT gat);
	
	/**
	 * 根据goodstypeid获取参数
	 * @param goodsattributeid
	 * @return
	 */
	public abstract DiamondAttributeT findDiamondAttributeTById(String attid);
	/**
	 * 获取所有的商品参数
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<DiamondAttributeT> findAllDiamondAttributeT(final int currentPage,final int lineSize);
	/**
	 * 统计说去所有的商品参数
	 * @return
	 */
	public abstract long countfindAllDiamondAttributeT();
	/**
	 * 删除商品参数
	 * @param list
	 * @return
	 */
	public abstract int delDiamondAttributeT(String []list);
	/**
	 * 根据商品类型名称获取商品参数
	 * @param goodsTypeName
	 * @return
	 */
	public abstract List<DiamondAttributeT> findDiamondAttributeTByDiamondTypeName(String goodsTypeName);
	/**
	 * 根据商品类型名称获取商品属性参数
	 * @param goodsTypeName
	 * @return
	 */
	public abstract List<DiamondAttributeT> findDiamondAttributeTBygoodsTypeId(String goodsTypeId);
	/**
	 * 根据排序方式进行排序
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<DiamondAttributeT>sortAllDiamondAttributeT(final int currentPage,final int lineSize,String queryString);
	/**
	 * 更新商品参数表中的商品类型名称
	 * @param goodsTypeName
	 * @param goodsTypeId
	 * @return
	 */
	public abstract int updateDiamondAttributeTgoodsTypeName(String goodsTypeName,String goodsTypeId);
	/**
	 * 根据id更新是否支持检索
	 * @param goodsattributeid
	 * @param issearch
	 * @return
	 */
	public abstract int updateDiamondAttributeissearchBygoodsattributeid(String[] goodsattributeid,String issearch);
	/**
	 * 根据id更新是否支持关联检索
	 * @param goodsattributeid
	 * @param issametolink
	 * @return
	 */
	public abstract int updateDiamondAttributeissametolinkBygoodsattributeid(String[] goodsattributeid,String issametolink);
	
	/**
	 * 获得主属性类型集合
	 * */
	public List<DiamondAttributeT> findDiamondAttibuteByType() ;
}
