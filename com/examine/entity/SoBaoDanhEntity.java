/**
 * 
 */
package com.examine.entity;


/**
 * @author sang
 *
 */
public class SoBaoDanhEntity {
	private String oSoBaoDanh;
	private String oMaThiSinh;
	private String oMaKhoa;
	private String oMaTruong;
	
	
	
	
	
	/**
	 * @param oSoBaoDanh
	 * @param oMaThiSinh
	 * @param oMaKhoa
	 * @param oMaTruong
	 */
	public SoBaoDanhEntity(String oSoBaoDanh, String oMaThiSinh,
			String oMaKhoa, String oMaTruong) {
		this.oSoBaoDanh = oSoBaoDanh;
		this.oMaThiSinh = oMaThiSinh;
		this.oMaKhoa = oMaKhoa;
		this.oMaTruong = oMaTruong;
	}
	/**
	 * 
	 */
	public SoBaoDanhEntity() {
	}
	/**
	 * @param oSoBaoDanh
	 * @param oMaThiSinh
	 * @param oMaKhoa
	 */
	
	/**
	 * @return the oSoBaoDanh
	 */
	public String getSoBaoDanh() {
		return oSoBaoDanh;
	}
	/**
	 * @param oSoBaoDanh the oSoBaoDanh to set
	 */
	public void setSoBaoDanh(String oSoBaoDanh) {
		this.oSoBaoDanh = oSoBaoDanh;
	}
	/**
	 * @return the oMaThiSinh
	 */
	public String getMaThiSinh() {
		return oMaThiSinh;
	}
	/**
	 * @param oMaThiSinh the oMaThiSinh to set
	 */
	public void setMaThiSinh(String oMaThiSinh) {
		this.oMaThiSinh = oMaThiSinh;
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
