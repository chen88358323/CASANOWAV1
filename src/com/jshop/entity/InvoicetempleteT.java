package com.jshop.entity;

// Generated 2012-9-13 10:50:57 by Hibernate Tools 3.4.0.CR1

/**
 * InvoicetempleteT generated by hbm2java
 */
public class InvoicetempleteT implements java.io.Serializable {

	private String invoicetempleteid;
	private String logisticsid;
	private String state;
	private String kindeditorCode;

	public InvoicetempleteT() {
	}

	public InvoicetempleteT(String invoicetempleteid, String state,
			String kindeditorCode) {
		this.invoicetempleteid = invoicetempleteid;
		this.state = state;
		this.kindeditorCode = kindeditorCode;
	}

	public InvoicetempleteT(String invoicetempleteid, String logisticsid,
			String state, String kindeditorCode) {
		this.invoicetempleteid = invoicetempleteid;
		this.logisticsid = logisticsid;
		this.state = state;
		this.kindeditorCode = kindeditorCode;
	}

	public String getInvoicetempleteid() {
		return this.invoicetempleteid;
	}

	public void setInvoicetempleteid(String invoicetempleteid) {
		this.invoicetempleteid = invoicetempleteid;
	}

	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getKindeditorCode() {
		return this.kindeditorCode;
	}

	public void setKindeditorCode(String kindeditorCode) {
		this.kindeditorCode = kindeditorCode;
	}

}