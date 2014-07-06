package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ExpresstempleteTDao;
import com.jshop.dao.impl.ExpresstempleteTDaoImpl;
import com.jshop.entity.ExpresstempleteT;
import com.jshop.service.ExpresstempleteTService;
@Service("expresstempleteTService")
@Scope("prototype")
public class ExpresstempleteTServiceImpl implements ExpresstempleteTService {
	private ExpresstempleteTDao expresstempleteTDao;


	public ExpresstempleteTDao getExpresstempleteTDao() {
		return expresstempleteTDao;
	}

	public void setExpresstempleteTDao(ExpresstempleteTDao expresstempleteTDao) {
		this.expresstempleteTDao = expresstempleteTDao;
	}

	public int delExpresstemplete(String[] list) {
		return this.getExpresstempleteTDao().delExpresstemplete(list);
	}

	public int updateExpresstemplete(ExpresstempleteT et) {
		return this.getExpresstempleteTDao().updateExpresstemplete(et);
	}

	public int addExpresstemplete(ExpresstempleteT et) {
		return this.getExpresstempleteTDao().addExpresstemplete(et);
	}

	public int countfindAllExpresstempleteT() {
		return this.getExpresstempleteTDao().countfindAllExpresstempleteT();
	}

	public List<ExpresstempleteT> findAllExpresstempleteT(int currentPage, int lineSize) {
		return this.getExpresstempleteTDao().findAllExpresstempleteT(currentPage, lineSize);
	}

	public ExpresstempleteT findExpresstempleteByLogisticsid(String logisticsid) {
		return this.getExpresstempleteTDao().findExpresstempleteByLogisticsid(logisticsid);
	}

	public ExpresstempleteT findExpresstempleteBytempleteid(String expresstempleteid) {
		return this.getExpresstempleteTDao().findExpresstempleteBytempleteid(expresstempleteid);
	}
}
