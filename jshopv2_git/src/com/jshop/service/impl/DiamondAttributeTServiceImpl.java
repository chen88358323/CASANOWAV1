package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Service;
import com.jshop.dao.DiamondAttributeTDao;
import com.jshop.entity.DiamondAttributeT;
import com.jshop.service.DiamondAttributeTService;
@Service("diamondAttributeTService")
public class DiamondAttributeTServiceImpl implements DiamondAttributeTService {
	@Resource(name="diamondAttributeTDao")
	private DiamondAttributeTDao diamondAttributeTDao;

	@JSON(serialize=false)
	public DiamondAttributeTDao getDiamondAttributeTDao() {
		return diamondAttributeTDao;
	}

	public void setDiamondAttributeTDao(DiamondAttributeTDao diamondAttributeTDao) {
		this.diamondAttributeTDao = diamondAttributeTDao;
	}

	public int updateDiamondAttributeT(DiamondAttributeT gat) {
		return this.getDiamondAttributeTDao().updateDiamondAttributeT(gat);
	}

	public int addDiamondAttributeT(DiamondAttributeT gat) {
		return this.getDiamondAttributeTDao().addDiamondAttributeT(gat);
	}

	public DiamondAttributeT findDiamondAttributeTById(String attid) {
		return null;
	}

	public long countfindAllDiamondAttributeT() {
		return this.getDiamondAttributeTDao().countfindAllDiamondAttributeT();
	}
	/**
	 * 加载所有属性
	 * */
	public List<DiamondAttributeT> findAllDiamondAttributeT(int currentPage, int lineSize) {
		return this.getDiamondAttributeTDao().findAllDiamondAttributeT(currentPage, lineSize);
	}

	public int delDiamondAttributeT(String[] list) {
		return this.getDiamondAttributeTDao().delDiamondAttributeT(list);
	}

	public List<DiamondAttributeT> findDiamondAttributeTByDiamondTypeName(String goodsTypeName) {
		return this.getDiamondAttributeTDao().findDiamondAttributeTByDiamondTypeName(goodsTypeName);
	}

	public List<DiamondAttributeT> findDiamondAttributeTBygoodsTypeId(String goodsTypeId) {
		return this.getDiamondAttributeTDao().findDiamondAttributeTBygoodsTypeId(goodsTypeId);
	}

	public List<DiamondAttributeT> sortAllDiamondAttributeT(int currentPage, int lineSize, String queryString) {

		return this.getDiamondAttributeTDao().sortAllDiamondAttributeT(currentPage, lineSize, queryString);
	}

	public int updateDiamondAttributeTgoodsTypeName(String goodsTypeName, String goodsTypeId) {
		return this.getDiamondAttributeTDao().updateDiamondAttributeTgoodsTypeName(goodsTypeName, goodsTypeId);
	}

	public int updateDiamondAttributeissametolinkBygoodsattributeid(String[] goodsattributeid, String issametolink) {
		return this.getDiamondAttributeTDao().updateDiamondAttributeissametolinkBygoodsattributeid(goodsattributeid, issametolink);
	}

	public int updateDiamondAttributeissearchBygoodsattributeid(String[] goodsattributeid, String issearch) {
		return this.getDiamondAttributeTDao().updateDiamondAttributeissearchBygoodsattributeid(goodsattributeid, issearch);
	}

	@Override
	public List<DiamondAttributeT> findDiamondAttibuteByType() {
		// TODO Auto-generated method stub
		return diamondAttributeTDao.findDiamondAttibuteByType();
	}

	
}
