package com.examine.entity;

public class MonEntity {
	private String oMaMon;
	private String oTenMon;
	private String oMaKhoi;
	
	
	
	
	/**
	 * 
	 */
	public MonEntity() {
	}
	/**
	 * @param oMaMon
	 * @param oTenMon
	 * @param oMaKhoi
	 */
	public MonEntity(String oMaMon, String oTenMon, String oMaKhoi) {
		this.oMaMon = oMaMon;
		this.oTenMon = oTenMon;
		this.oMaKhoi = oMaKhoi;
	}
	/**
	 * @return the oMaMon
	 */
	public String getMaMon() {
		return oMaMon;
	}
	/**
	 * @param oMaMon the oMaMon to set
	 */
	public void setMaMon(String oMaMon) {
		this.oMaMon = oMaMon;
	}
	/**
	 * @return the oTenMon
	 */
	public String getTenMon() {
		return oTenMon;
	}
	/**
	 * @param oTenMon the oTenMon to set
	 */
	public void setTenMon(String oTenMon) {
		this.oTenMon = oTenMon;
	}
	/**
	 * @return the oMaKhoi
	 */
	public String getMaKhoi() {
		return oMaKhoi;
	}
	/**
	 * @param oMaKhoi the oMaKhoi to set
	 */
	public void setMaKhoi(String oMaKhoi) {
		this.oMaKhoi = oMaKhoi;
	}
}
