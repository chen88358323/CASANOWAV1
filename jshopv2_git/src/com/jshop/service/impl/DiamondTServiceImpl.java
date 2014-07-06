package com.jshop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.DiamondTDao;
import com.jshop.entity.DiamondT;
import com.jshop.service.DiamondTService;
@Service("diamondTService")
//@Scope("prototype")
public class DiamondTServiceImpl implements DiamondTService {
	@Resource(name="diamondTDao")
	private DiamondTDao diamondTDao;

	public DiamondTDao getDiamondTDao() {
		return diamondTDao;
	}

	public void setDiamondTDao(DiamondTDao diamondTDao) {
		this.diamondTDao = diamondTDao;
	}

	public int delDiamond(String[] list, String creatorid) {
		return getDiamondTDao().delDiamond(list, creatorid);
	}

	public int updateDiamond(DiamondT g) {
		return getDiamondTDao().updateDiamond(g);
	}

	public int updateDiamondSaleState(String[] goodsid, String salestate, String creatorid) {
		return getDiamondTDao().updateDiamondSaleState(goodsid, salestate, creatorid);
	}

	public int updateDiamondbargainprice(String[] goodsid, String bargainprice, String creatorid) {
		return getDiamondTDao().updateDiamondbargainprice(goodsid, bargainprice, creatorid);
	}

	public int updateDiamondhotsale(String[] goodsid, String hotsale, String creatorid) {
		return getDiamondTDao().updateDiamondhotsale(goodsid, hotsale, creatorid);
	}

	public int updateDiamondreadcount(String goodsid) {
		return getDiamondTDao().updateDiamondreadcount(goodsid);
	}

	public int updateDiamondrecommended(String[] goodsid, String recommended, String creatorid) {
		return getDiamondTDao().updateDiamondrecommended(goodsid, recommended, creatorid);
	}

	public int updateDiamondisNew(String[] goodsid, String isNew, String creatorid) {
		return getDiamondTDao().updateDiamondisNew(goodsid, isNew, creatorid);
	}

	public int updateDiamondismobileplatformgoods(String[] goodsid, String ismobileplatformgoods, String creatorid) {
		return getDiamondTDao().updateDiamondismobileplatformgoods(goodsid, ismobileplatformgoods, creatorid);
	}

	public int updateDiamondrelatedfit(String goodsid, String list) {
		return getDiamondTDao().updateDiamondrelatedfit(goodsid, list);
	}

	public int updateDiamondrelatedgoods(String goodsid, String list) {
		return getDiamondTDao().updateDiamondrelatedgoods(goodsid, list);
	}

	public int updateDiamondreplycount(String goodsid) {
		return getDiamondTDao().updateDiamondreplycount(goodsid);
	}

	public int updateDiamondsortid(String goodsid, String goodsortid) {
		return getDiamondTDao().updateDiamondsortid(goodsid, goodsortid);
	}

	public int updateDiamondsortname(String goodsid, String goodssortname) {
		return getDiamondTDao().updateDiamondsortname(goodsid, goodssortname);
	}

	public int updateSort(String goodsid, Integer sort) {
		return getDiamondTDao().updateSort(goodsid, sort);
	}

	public int updateFiveDiamondState(String[] goodsid, String recommended, String hotsale, String bargainprice, String isNew, String ismobileplatformgoods) {
		return getDiamondTDao().updateFiveDiamondState(goodsid, recommended, hotsale, bargainprice, isNew, ismobileplatformgoods);
	}
	//增加钻石
	public int addDiamond(DiamondT g) {
		return diamondTDao.addDiamond(g);
	}

	public int countAllDiamond(Date creatorid) {
		return getDiamondTDao().countAllDiamond(creatorid);
	}

	public List<DiamondT> findAllDiamond(int currentPage, int lineSize, String creatorid) {
		return getDiamondTDao().findAllDiamond(currentPage, lineSize, creatorid);
	}

	public DiamondT findDiamondById(String goodsid) {
		return getDiamondTDao().findDiamondById(goodsid);
	}

	public List<DiamondT> findDiamondByKeyword(String keywordid, int currentPage, int lineSize) {
		return getDiamondTDao().findDiamondByKeyword(keywordid, currentPage, lineSize);
	}

	public int countfindDiamondByKeyword(String keywordid) {
		return getDiamondTDao().countfindDiamondByKeyword(keywordid);
	}

	public List<DiamondT> findDiamondByLtypeid(String ltypeid, String salestate, int currentPage, int lineSize) {
		return getDiamondTDao().findDiamondByLtypeid(ltypeid, salestate, currentPage, lineSize);
	}

	public List<DiamondT> findDiamondByNavid(String navid, String salestate, final int currentPage, final int lineSize) {
		return getDiamondTDao().findDiamondByNavid(navid, salestate, currentPage, lineSize);
	}

	public int countfindDiamondByNavid(String navid, String salestate) {
		return getDiamondTDao().countfindDiamondByNavid(navid, salestate);
	}

	public int countfindDiamondByLtypeid(String ltypeid, String salestate) {
		return getDiamondTDao().countfindDiamondByLtypeid(ltypeid, salestate);
	}

	public List<DiamondT> findDiamondByStypeid(String stypeid, String salestate) {
		return getDiamondTDao().findDiamondByStypeid(stypeid, salestate);
	}

	public List<DiamondT> findDiamondBybrand(String brand) {
		return getDiamondTDao().findDiamondBybrand(brand);
	}

	public List<DiamondT> findDiamondBymodel(String model) {
		return getDiamondTDao().findDiamondBymodel(model);
	}

	public List<DiamondT> findDiamondByprice(String price) {
		return getDiamondTDao().findDiamondByprice(price);
	}

	public List<DiamondT> findDiamondByusersetnum(String usersetnum) {
		return getDiamondTDao().findDiamondByusersetnum(usersetnum);
	}

	public List<DiamondT> findDiamondForoptiontransferselect(String navid, String ltypeid, String stypeid, String goodsname) {
		return getDiamondTDao().findDiamondForoptiontransferselect(navid, ltypeid, stypeid, goodsname);
	}

	public List<DiamondT> findAllDiamondtWithoutSplitpage() {
		return getDiamondTDao().findAllDiamondtWithoutSplitpage();
	}

	public List<DiamondT> findDiamondLimitByDiamondType(String nlstypeid, int limit) {
		return getDiamondTDao().findDiamondLimitByDiamondType(nlstypeid, limit);
	}

	public List<DiamondT> findSamepriceDiamond(int limit, double minprice, double maxprice, String goodsid) {
		return getDiamondTDao().findSamepriceDiamond(limit, minprice, maxprice, goodsid);
	}

	public List<DiamondT> findDiamondByDiamondname(int currentPage, int lineSize, String goodsname) {
		return getDiamondTDao().findDiamondByDiamondname(currentPage, lineSize, goodsname);
	}

	public List<DiamondT> findMoreDiamondByDiamondType(String nlstypeid, int currentPage, int lineSize) {
		return getDiamondTDao().findMoreDiamondByDiamondType(nlstypeid, currentPage, lineSize);
	}

	public int countfindMoreDiamondByDiamondType(String nlstypeid) {
		return getDiamondTDao().countfindMoreDiamondByDiamondType(nlstypeid);
	}

	public int countfindSearchDiamond(String goodsname) {
		return getDiamondTDao().countfindSearchDiamond(goodsname);
	}

	public List<DiamondT> findSearchDiamond(String goodsname, int currentPage, int lineSize) {
		return getDiamondTDao().findSearchDiamond(goodsname, currentPage, lineSize);
	}

	public int countfindAllDiamondlistMore(String salestate) {
		return getDiamondTDao().countfindAllDiamondlistMore(salestate);
	}

	public List<DiamondT> findAllDiamondlistMore(int currentPage, int lineSize, String salestate) {
		return getDiamondTDao().findAllDiamondlistMore(currentPage, lineSize, salestate);
	}

	public int countfindMoreBargainPriceDiamond() {
		return getDiamondTDao().countfindMoreBargainPriceDiamond();
	}

	public int countfindMoreBargainPriceDiamondByDiamondType(String nlstypeid) {
		return getDiamondTDao().countfindMoreBargainPriceDiamondByDiamondType(nlstypeid);
	}

	public int countfindMoreHotSaleDiamondByDiamondType(String nlstypeid) {
		return getDiamondTDao().countfindMoreHotSaleDiamondByDiamondType(nlstypeid);
	}

	public int countfindMoreRecommendedDiamondByDiamondType(String nlstypeid) {
		return getDiamondTDao().countfindMoreRecommendedDiamondByDiamondType(nlstypeid);
	}

	public List<DiamondT> findMoreBargainPriceDiamond(int currentPage, int lineSize) {
		return getDiamondTDao().findMoreBargainPriceDiamond(currentPage, lineSize);
	}

	public List<DiamondT> findMoreBargainPriceDiamondByDiamondType(String nlstypeid, int currentPage, int lineSize) {
		return getDiamondTDao().findMoreBargainPriceDiamondByDiamondType(nlstypeid, currentPage, lineSize);
	}

	public List<DiamondT> findMoreHotSaleDiamondByDiamondType(String nlstypeid, int currentPage, int lineSize) {
		return getDiamondTDao().findMoreHotSaleDiamondByDiamondType(nlstypeid, currentPage, lineSize);
	}

	public List<DiamondT> findMoreRecommendedDiamondByDiamondType(String nlstypeid, int currentPage, int lineSize) {
		return getDiamondTDao().findMoreRecommendedDiamondByDiamondType(nlstypeid, currentPage, lineSize);
	}

	public List<DiamondT> findAllDiamondByismobileplatformgoods(int currentPage, int lineSize, String creatorid) {
		return getDiamondTDao().findAllDiamondByismobileplatformgoods(currentPage, lineSize, creatorid);
	}

	public int countfindAllDiamondByismobileplatformgoods(String creatorid) {
		return getDiamondTDao().countfindAllDiamondByismobileplatformgoods(creatorid);
	}

	public List<DiamondT> findAllDiamondForImgT() {
		return getDiamondTDao().findAllDiamondForImgT();
	}

	public List<DiamondT> findAllDiamondBynavid(String navid, String salestate) {
		return getDiamondTDao().findAllDiamondBynavid(navid, salestate);
	}

	public int updateHtmlPath(String goodsid, String htmlPath) {
		return getDiamondTDao().updateHtmlPath(goodsid, htmlPath);
	}

	public int updatecommentsumBygoodsid(String goodsid, int totalcomment) {
		return getDiamondTDao().updatecommentsumBygoodsid(goodsid, totalcomment);
	}

	public int updatestarsumBygoodsid(String goodsid, int star) {
		return getDiamondTDao().updatestarsumBygoodsid(goodsid, star);
	}

	public List<DiamondT> finaAllDiamondT(String salestate) {
		return getDiamondTDao().finaAllDiamondT(salestate);
	}

	public List<DiamondT> findDiamondByLtypeid(String ltypeid, String salestate) {
		return getDiamondTDao().findDiamondByLtypeid(ltypeid, salestate);
	}

	public int updatestarusersumBygoodsid(String goodsid, int staruser) {
		return getDiamondTDao().updatestarusersumBygoodsid(goodsid, staruser);
	}

	public List<DiamondT> findAllDiamondBynavidorderbyParams(String navid, String salestate, String sales, String memberprice, String totalcomment, String bargainprice, String hotsale, String recommended, String isNew, String value) {
		return getDiamondTDao().findAllDiamondBynavidorderbyParams(navid, salestate, sales, memberprice, totalcomment, bargainprice, hotsale, recommended, isNew, value);
	}

	public List<DiamondT> findAllDiamondByLtypeidorderbyParams(String ltypeid, String salestate, String sales, String memberprice, String totalcomment, String bargainprice, String hotsale, String recommended, String isNew, String value) {
		return getDiamondTDao().findAllDiamondByLtypeidorderbyParams(ltypeid, salestate, sales, memberprice, totalcomment, bargainprice, hotsale, recommended, isNew, value);
	}

	public List<DiamondT> sortAllDiamond(int currentPage, int lineSize, String creatorid, String queryString) {
		return this.getDiamondTDao().sortAllDiamond(currentPage, lineSize, creatorid, queryString);
	}

	public int updateDiamondTypeNameBygoodsTypeId(String goodsTypeName, String goodsTypeId) {
		return this.getDiamondTDao().updateDiamondTypeNameBygoodsTypeId(goodsTypeName, goodsTypeId);
	}

	public int updateDiamondCategoryBynlsid(String queryString) {
		return this.getDiamondTDao().updateDiamondCategoryBynlsid(queryString);
	}

	public int updateDiamondSaleState(String goodsTypeId, String salestate) {
		return this.getDiamondTDao().updateDiamondSaleState(goodsTypeId, salestate);
	}

	public List<DiamondT> findshuffleDiamond(int currentPage, int lineSize, String salestate, String recommended) {
		return this.getDiamondTDao().findshuffleDiamond(currentPage, lineSize, salestate, recommended);
	}

	public List<DiamondT> findDiamondByattrs(int currentPage, int lineSize, String attr, String salestate) {
		return this.getDiamondTDao().findDiamondByattrs(currentPage, lineSize, attr, salestate);
	}

	@Override
	public List<DiamondT> findDiamondByNavid(String navid, String salestate,
			String ismobileplatformgoods) {
		return this.getDiamondTDao().findDiamondByNavid(navid, salestate, ismobileplatformgoods);
	}

	@Override
	public List<DiamondT> findAllDiamondBynavid(String navid, String salestate,
			String isSpecificationsOpen) {
		return this.getDiamondTDao().findAllDiamondBynavid(navid, salestate, isSpecificationsOpen);
	}

	@Override
	public List<DiamondT> findAllDiamondBynavidandltypeid(String navid,
			String ltypeid, String salestate, String isSpecificationsOpen) {
		return this.getDiamondTDao().findAllDiamondBynavidandltypeid(navid, ltypeid, salestate, isSpecificationsOpen);
	}

	@Override
	public List<DiamondT> findAllDiamondBynavidandltypeidandstypeid(String navid,
			String ltypeid, String stypeid, String salestate,
			String isSpecificationsOpen) {
		return this.getDiamondTDao().findAllDiamondBynavidandltypeidandstypeid(navid, ltypeid, stypeid, salestate, isSpecificationsOpen);
	}

	@Override
	public int updateHtmlPath(String goodsid, String htmlPath, Date updatetime) {
		return this.getDiamondTDao().updateHtmlPath(goodsid, htmlPath, updatetime);
	}

	@Override
	public List<DiamondT> findAllDiamondByNoTerm() {		
		return this.getDiamondTDao().findAllDiamondByNoTerm();
	}

}
