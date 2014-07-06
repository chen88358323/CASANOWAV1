package com.jshop.entity;

// Generated 2012-9-13 10:50:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * 钻石属性PO
 */
public class DiamondAttributeT implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2393909710346704800L;
	private long gaid;
	private int level;
	private long fid;
	private String attname;
	private String attvalue;
	private Date createtime;
	private Date updatetime;
	public long getGaid() {
		return gaid;
	}
	public void setGaid(long gaid) {
		this.gaid = gaid;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public long getFid() {
		return fid;
	}
	public void setFid(long fid) {
		this.fid = fid;
	}
	public String getAttname() {
		return attname;
	}
	public void setAttname(String attname) {
		this.attname = attname;
	}
	public String getAttvalue() {
		return attvalue;
	}
	public void setAttvalue(String attvalue) {
		this.attvalue = attvalue;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public DiamondAttributeT(long gaid, int level, long fid, String attname,
			String attvalue, Date createtime, Date updatetime) {
		this.gaid = gaid;
		this.level = level;
		this.fid = fid;
		this.attname = attname;
		this.attvalue = attvalue;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}
	
	public DiamondAttributeT(){}
}
