package com.jshop.entity;

// Generated 2012-9-13 10:50:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * KeywordT generated by hbm2java
 */
public class KeywordT implements java.io.Serializable {

	private String keywordid;
	private String keywordname;
	private Integer searchCount;
	private Integer sort;
	private String type;
	private String state;
	private Date createtime;
	private String creatorid;

	public KeywordT() {
	}

	public KeywordT(String keywordid, String keywordname, String type,
			String state, Date createtime, String creatorid) {
		this.keywordid = keywordid;
		this.keywordname = keywordname;
		this.type = type;
		this.state = state;
		this.createtime = createtime;
		this.creatorid = creatorid;
	}

	public KeywordT(String keywordid, String keywordname, Integer searchCount,
			Integer sort, String type, String state, Date createtime,
			String creatorid) {
		this.keywordid = keywordid;
		this.keywordname = keywordname;
		this.searchCount = searchCount;
		this.sort = sort;
		this.type = type;
		this.state = state;
		this.createtime = createtime;
		this.creatorid = creatorid;
	}

	public String getKeywordid() {
		return this.keywordid;
	}

	public void setKeywordid(String keywordid) {
		this.keywordid = keywordid;
	}

	public String getKeywordname() {
		return this.keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}

	public Integer getSearchCount() {
		return this.searchCount;
	}

	public void setSearchCount(Integer searchCount) {
		this.searchCount = searchCount;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

}
