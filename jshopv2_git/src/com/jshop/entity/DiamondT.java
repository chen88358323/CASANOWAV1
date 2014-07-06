package com.jshop.entity;

import java.util.Date;

public class DiamondT  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long diamonid;
	//形状
	private String sharp;
	//钻重
	private float weight;
	//颜色
	private String color;
	//净度
	private String clarity;
//	切工
	private String cut;
//	抛光
	private String polishing;
//	对称
	private String symmetric;
//	荧光
	private String fluorsecent;
//	直径
	private String diameter;
//	台面
	private String table;
//	货号
	private String skuid;
	//货品状态
	private int skustate;
//	证书类型
	private String  licensetype;
	//证书号
	private String licenseNo;
	//折扣
	private float discount;
	//折扣后价格
	private float disprice;
	//国际价格
	private float interprice;
	//类别
	private String category;
	//添加时间
	private Date createtime;
	//update time
	private Date modifytime;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	public long getDiamonid() {
		return diamonid;
	}
	public void setDiamonid(long diamonid) {
		this.diamonid = diamonid;
	}
	public String getSharp() {
		return sharp;
	}
	public void setSharp(String sharp) {
		this.sharp = sharp;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getClarity() {
		return clarity;
	}
	public void setClarity(String clarity) {
		this.clarity = clarity;
	}
	public String getCut() {
		return cut;
	}
	public void setCut(String cut) {
		this.cut = cut;
	}
	public String getPolishing() {
		return polishing;
	}
	public void setPolishing(String polishing) {
		this.polishing = polishing;
	}
	public String getSymmetric() {
		return symmetric;
	}
	public void setSymmetric(String symmetric) {
		this.symmetric = symmetric;
	}
	public String getFluorsecent() {
		return fluorsecent;
	}
	public void setFluorsecent(String fluorsecent) {
		this.fluorsecent = fluorsecent;
	}
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getSkuid() {
		return skuid;
	}
	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}
	public int getSkustate() {
		return skustate;
	}
	public void setSkustate(int skustate) {
		this.skustate = skustate;
	}
	public String getLicensetype() {
		return licensetype;
	}
	public void setLicensetype(String licensetype) {
		this.licensetype = licensetype;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getDisprice() {
		return disprice;
	}
	public void setDisprice(float disprice) {
		this.disprice = disprice;
	}
	public float getInterprice() {
		return interprice;
	}
	public void setInterprice(float interprice) {
		this.interprice = interprice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public DiamondT(long diamonid, String sharp, float weight, String color,
			String clarity, String cut, String polishing, String symmetric,
			String fluorsecent, String diameter, String table, String skuid,
			int skustate, String licensetype, String licenseNo, float discount,
			float disprice, float interprice) {
		super();
		this.diamonid = diamonid;
		this.sharp = sharp;
		this.weight = weight;
		this.color = color;
		this.clarity = clarity;
		this.cut = cut;
		this.polishing = polishing;
		this.symmetric = symmetric;
		this.fluorsecent = fluorsecent;
		this.diameter = diameter;
		this.table = table;
		this.skuid = skuid;
		this.skustate = skustate;
		this.licensetype = licensetype;
		this.licenseNo = licenseNo;
		this.discount = discount;
		this.disprice = disprice;
		this.interprice = interprice;
	}
	public DiamondT(){}
}
