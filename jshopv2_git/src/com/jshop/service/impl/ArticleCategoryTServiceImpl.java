package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ArticleCategoryTDao;
import com.jshop.dao.impl.ArticleCategoryTDaoImpl;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.service.ArticleCategoryTService;
@Service("articleCategoryTService")
@Scope("prototype")
public class ArticleCategoryTServiceImpl implements ArticleCategoryTService {
	@Resource(name="articleCategoryTDao")
	private ArticleCategoryTDao articleCategoryTDao;

	public ArticleCategoryTDao getArticleCategoryTDao() {
		return articleCategoryTDao;
	}

	public void setArticleCategoryTDao(ArticleCategoryTDaoImpl articleCategoryTDao) {
		this.articleCategoryTDao = articleCategoryTDao;
	}

	public void addArticleCategoryT(ArticleCategoryT act) {
		getArticleCategoryTDao().addArticleCategoryT(act);
	}

	public int checkArticleCategoryName(String name, String creatorid) {
		return getArticleCategoryTDao().checkArticleCategoryName(name, creatorid);
	}

	public int checkArticleCategoryNamewithoutMe(String articleCategoryTid, String name, String creatorid) {
		return getArticleCategoryTDao().checkArticleCategoryNamewithoutMe(articleCategoryTid, name, creatorid);
	}

	public int checkArticleCategorySign(String sign, String creatorid) {
		return getArticleCategoryTDao().checkArticleCategorySign(sign, creatorid);
	}

	public int checkArticleCategorySignwithoutMe(String articleCategoryTid, String sign, String creatorid) {
		return getArticleCategoryTDao().checkArticleCategorySignwithoutMe(articleCategoryTid, sign, creatorid);
	}

	public int countfindAllArticleCategoryT(String status, String creatorid) {
		return getArticleCategoryTDao().countfindAllArticleCategoryT(status, creatorid);
	}

	public int countfindAllArticleCategoryTByGrade(String grade, String status, String creatorid) {
		return getArticleCategoryTDao().countfindAllArticleCategoryTByGrade(grade, status, creatorid);
	}

//	public int delArticleCategoryT(String articlecategoryTid, String status, String creatorid) {
//		return getArticleCategoryTDaoImpl().delArticleCategoryT(articlecategoryTid, status, creatorid);
//	}
	
	public void delArticleCategoryT(ArticleCategoryT act) {
		this.getArticleCategoryTDao().delArticleCategoryT(act);
		
	}
	
	public List<ArticleCategoryT> findAllArticleCategoryT(int currentPage, int lineSize, String status, String creatorid) {
		return getArticleCategoryTDao().findAllArticleCategoryT(currentPage, lineSize, status, creatorid);
	}

	

	public List<ArticleCategoryT> findAllArticleCategoryTByGrade(int currentPage, int lineSize, String status, String grade, String creatorid) {
		return getArticleCategoryTDao().findAllArticleCategoryTByGrade(currentPage, lineSize, status, grade, creatorid);
	}

	public List<ArticleCategoryT> findArticleCategoryByGrade(String grade, String status, String creatorid) {
		return getArticleCategoryTDao().findArticleCategoryByGrade(grade, status, creatorid);
	}

	public ArticleCategoryT findArticleCategoryByarticleCategoryTid(String articleCategoryTid) {
		return getArticleCategoryTDao().findArticleCategoryByarticleCategoryTid(articleCategoryTid);
	}

	public List<ArticleCategoryT> findArticleCategoryByparentId(String status, String parentId, String creatorid) {
		return getArticleCategoryTDao().findArticleCategoryByparentId(status, parentId, creatorid);
	}

	public List<ArticleCategoryT> findArticleCategoryByparentIdnull(String status, String creatorid) {
		return getArticleCategoryTDao().findArticleCategoryByparentIdnull(status, creatorid);
	}

	public ArticleCategoryT findPathParentIdByParentId(String parentId, String creatorid) {
		return getArticleCategoryTDao().findPathParentIdByParentId(parentId, creatorid);
	}

	public void updateArticleCategoryT(ArticleCategoryT act) {
		this.getArticleCategoryTDao().updateArticleCategoryT(act);
	}

	public List<ArticleCategoryT> findAllArticleCategoryBycreatorid(String creatorid) {
		return getArticleCategoryTDao().findAllArticleCategoryBycreatorid(creatorid);
	}

	public List<ArticleCategoryT> findArticleCategoryByposition(int lineSize, String status, String position, String creatorid) {
		return getArticleCategoryTDao().findArticleCategoryByposition(lineSize, status, position, creatorid);
	}

	public List<ArticleCategoryT> findArticleCategoryByposition(int lineSize, String status, String position) {
		return getArticleCategoryTDao().findArticleCategoryByposition(lineSize, status, position);
	}

	public List<ArticleCategoryT> sortAllArticleCategoryT(int currentPage, int lineSize, String status, String creatorid, String queryString) {

		return this.getArticleCategoryTDao().sortAllArticleCategoryT(currentPage, lineSize, status, creatorid, queryString);
	}

	public List<ArticleCategoryT> findArticleCategoryByGrade(String grade, String status) {
		return this.getArticleCategoryTDao().findArticleCategoryByGrade(grade,status);
	}
	
	
	
}
