package com.jshop.entity;

// Generated 2012-9-13 10:50:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * JshopbasicInfoT generated by hbm2java
 */
public class JshopbasicInfoT implements java.io.Serializable {

	private String basicinfoid;
	private String jshopname;
	private String jshopslogan;
	private String country;
	private String province;
	private String city;
	private String street;
	private String qqservice;
	private String taobaowwservice;
	private String skypeservice;
	private String yahooservice;
	private String msnservice;
	private String emailservice;
	private String phoneservice;
	private String openstate;
	private String siteclosenotes;
	private String sitelogo;
	private String licensed;
	private String usercenternote;
	private String jshopnotice;
	private String registerclose;
	private String icpnum;
	private String sendName;
	private String sendCountry;
	private String sendProvince;
	private String sendCity;
	private String sendDistrict;
	private String sendStreet;
	private String sendTelno;
	private String sendMobile;
	private String sendContactor;
	private String state;
	private String district;
	private String creatorid;
	private Date createtime;
	private String metaKeywords;
	private String metaDes;

	public JshopbasicInfoT() {
	}

	public JshopbasicInfoT(String basicinfoid, String jshopname, String state,
			String creatorid, Date createtime) {
		this.basicinfoid = basicinfoid;
		this.jshopname = jshopname;
		this.state = state;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	public JshopbasicInfoT(String basicinfoid, String jshopname,
			String jshopslogan, String country, String province, String city,
			String street, String qqservice, String taobaowwservice,
			String skypeservice, String yahooservice, String msnservice,
			String emailservice, String phoneservice, String openstate,
			String siteclosenotes, String sitelogo, String licensed,
			String usercenternote, String jshopnotice, String registerclose,
			String icpnum, String sendName, String sendCountry,
			String sendProvince, String sendCity, String sendDistrict,
			String sendStreet, String sendTelno, String sendMobile,
			String sendContactor, String state, String district,
			String creatorid, Date createtime, String metaKeywords,
			String metaDes) {
		this.basicinfoid = basicinfoid;
		this.jshopname = jshopname;
		this.jshopslogan = jshopslogan;
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.qqservice = qqservice;
		this.taobaowwservice = taobaowwservice;
		this.skypeservice = skypeservice;
		this.yahooservice = yahooservice;
		this.msnservice = msnservice;
		this.emailservice = emailservice;
		this.phoneservice = phoneservice;
		this.openstate = openstate;
		this.siteclosenotes = siteclosenotes;
		this.sitelogo = sitelogo;
		this.licensed = licensed;
		this.usercenternote = usercenternote;
		this.jshopnotice = jshopnotice;
		this.registerclose = registerclose;
		this.icpnum = icpnum;
		this.sendName = sendName;
		this.sendCountry = sendCountry;
		this.sendProvince = sendProvince;
		this.sendCity = sendCity;
		this.sendDistrict = sendDistrict;
		this.sendStreet = sendStreet;
		this.sendTelno = sendTelno;
		this.sendMobile = sendMobile;
		this.sendContactor = sendContactor;
		this.state = state;
		this.district = district;
		this.creatorid = creatorid;
		this.createtime = createtime;
		this.metaKeywords = metaKeywords;
		this.metaDes = metaDes;
	}

	public String getBasicinfoid() {
		return this.basicinfoid;
	}

	public void setBasicinfoid(String basicinfoid) {
		this.basicinfoid = basicinfoid;
	}

	public String getJshopname() {
		return this.jshopname;
	}

	public void setJshopname(String jshopname) {
		this.jshopname = jshopname;
	}

	public String getJshopslogan() {
		return this.jshopslogan;
	}

	public void setJshopslogan(String jshopslogan) {
		this.jshopslogan = jshopslogan;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getQqservice() {
		return this.qqservice;
	}

	public void setQqservice(String qqservice) {
		this.qqservice = qqservice;
	}

	public String getTaobaowwservice() {
		return this.taobaowwservice;
	}

	public void setTaobaowwservice(String taobaowwservice) {
		this.taobaowwservice = taobaowwservice;
	}

	public String getSkypeservice() {
		return this.skypeservice;
	}

	public void setSkypeservice(String skypeservice) {
		this.skypeservice = skypeservice;
	}

	public String getYahooservice() {
		return this.yahooservice;
	}

	public void setYahooservice(String yahooservice) {
		this.yahooservice = yahooservice;
	}

	public String getMsnservice() {
		return this.msnservice;
	}

	public void setMsnservice(String msnservice) {
		this.msnservice = msnservice;
	}

	public String getEmailservice() {
		return this.emailservice;
	}

	public void setEmailservice(String emailservice) {
		this.emailservice = emailservice;
	}

	public String getPhoneservice() {
		return this.phoneservice;
	}

	public void setPhoneservice(String phoneservice) {
		this.phoneservice = phoneservice;
	}

	public String getOpenstate() {
		return this.openstate;
	}

	public void setOpenstate(String openstate) {
		this.openstate = openstate;
	}

	public String getSiteclosenotes() {
		return this.siteclosenotes;
	}

	public void setSiteclosenotes(String siteclosenotes) {
		this.siteclosenotes = siteclosenotes;
	}

	public String getSitelogo() {
		return this.sitelogo;
	}

	public void setSitelogo(String sitelogo) {
		this.sitelogo = sitelogo;
	}

	public String getLicensed() {
		return this.licensed;
	}

	public void setLicensed(String licensed) {
		this.licensed = licensed;
	}

	public String getUsercenternote() {
		return this.usercenternote;
	}

	public void setUsercenternote(String usercenternote) {
		this.usercenternote = usercenternote;
	}

	public String getJshopnotice() {
		return this.jshopnotice;
	}

	public void setJshopnotice(String jshopnotice) {
		this.jshopnotice = jshopnotice;
	}

	public String getRegisterclose() {
		return this.registerclose;
	}

	public void setRegisterclose(String registerclose) {
		this.registerclose = registerclose;
	}

	public String getIcpnum() {
		return this.icpnum;
	}

	public void setIcpnum(String icpnum) {
		this.icpnum = icpnum;
	}

	public String getSendName() {
		return this.sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getSendCountry() {
		return this.sendCountry;
	}

	public void setSendCountry(String sendCountry) {
		this.sendCountry = sendCountry;
	}

	public String getSendProvince() {
		return this.sendProvince;
	}

	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}

	public String getSendCity() {
		return this.sendCity;
	}

	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}

	public String getSendDistrict() {
		return this.sendDistrict;
	}

	public void setSendDistrict(String sendDistrict) {
		this.sendDistrict = sendDistrict;
	}

	public String getSendStreet() {
		return this.sendStreet;
	}

	public void setSendStreet(String sendStreet) {
		this.sendStreet = sendStreet;
	}

	public String getSendTelno() {
		return this.sendTelno;
	}

	public void setSendTelno(String sendTelno) {
		this.sendTelno = sendTelno;
	}

	public String getSendMobile() {
		return this.sendMobile;
	}

	public void setSendMobile(String sendMobile) {
		this.sendMobile = sendMobile;
	}

	public String getSendContactor() {
		return this.sendContactor;
	}

	public void setSendContactor(String sendContactor) {
		this.sendContactor = sendContactor;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDes() {
		return this.metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}

}