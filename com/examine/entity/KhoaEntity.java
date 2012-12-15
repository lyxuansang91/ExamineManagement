package com.examine.entity;



public class KhoaEntity {
	
	private String oMaKhoa; 
	private String oTenKhoa;
	private String oMaKhoi;
	private String oMaTruong;
	
	
	
	
	
	
	/**
	 * 
	 */
	public KhoaEntity() {
	}
	/**
	 * @param oMaKhoa
	 * @param oTenKhoa
	 * @param oMaKhoi
	 * @param oMaTruong
	 */
	public KhoaEntity(String oMaKhoa, String oTenKhoa, String oMaKhoi,
			String oMaTruong) {
		this.oMaKhoa = oMaKhoa;
		this.oTenKhoa = oTenKhoa;
		this.oMaKhoi = oMaKhoi;
		this.oMaTruong = oMaTruong;
	}
	/**
	 * @return the oMaKhoa
	 */
	public String getMaKhoa() {
		return oMaKhoa;
	}
	/**
	 * @param oMaKhoa the oMaKhoa to set
	 */
	public void setMaKhoa(String oMaKhoa) {
		this.oMaKhoa = oMaKhoa;
	}
	/**
	 * @return the oTenKhoa
	 */
	public String getTenKhoa() {
		return oTenKhoa;
	}
	/**
	 * @param oTenKhoa the oTenKhoa to set
	 */
	public void setTenKhoa(String oTenKhoa) {
		this.oTenKhoa = oTenKhoa;
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
	 * @return the oMaTruong
	 */
	public String getMaTruong() {
		return oMaTruong;
	}
	/**
	 * @param oMaTruong the oMaTruong to set
	 */
	public void setMaTruong(String oMaTruong) {
		this.oMaTruong = oMaTruong;
	}



}
