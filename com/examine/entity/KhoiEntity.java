package com.examine.entity;

public class KhoiEntity {
	private String oMaKhoi;
	private String oTenKhoi;	
	/**
	 * 
	 */
	
	
	public KhoiEntity() {
	}
	/**
	 * @param oMaKhoi
	 */
	public KhoiEntity(String oMaKhoi) {
		super();
		this.oMaKhoi = oMaKhoi;
	}
	/**
	 * @param oMaKhoi
	 * @param oTenKhoi
	 */
	public KhoiEntity(String oMaKhoi, String oTenKhoi) {
		this.oMaKhoi = oMaKhoi;
		this.oTenKhoi = oTenKhoi;
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
	/**
	 * @return the oTenKhoi
	 */
	public String getTenKhoi() {
		return oTenKhoi;
	}
	/**
	 * @param oTenKhoi the oTenKhoi to set
	 */
	public void setTenKhoi(String oTenKhoi) {
		this.oTenKhoi = oTenKhoi;
	}
	
	
	
	
}
