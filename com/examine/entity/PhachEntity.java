/**
 * 
 */
package com.examine.entity;

/**
 * @author sang
 *
 */
public class PhachEntity {
	private String oMaPhach;
	private String oSoBaoDanh;
	private String oMaMon;
	private String oMaPhong;	
	/**
	 * 
	 */
	public PhachEntity() {
	}
	/**
	 * @param oMaPhach
	 * @param oSoBaoDanh
	 * @param oMaMon
	 * @param oMaPhong
	 */
	public PhachEntity(String oMaPhach, String oSoBaoDanh, String oMaMon,
			String oMaPhong) {
		this.oMaPhach = oMaPhach;
		this.oSoBaoDanh = oSoBaoDanh;
		this.oMaMon = oMaMon;
		this.oMaPhong = oMaPhong;
	}
	/**
	 * @return the oMaPhach
	 */
	public String getMaPhach() {
		return oMaPhach;
	}
	/**
	 * @param oMaPhach the oMaPhach to set
	 */
	public void setMaPhach(String oMaPhach) {
		this.oMaPhach = oMaPhach;
	}
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
	 * @return the oMaPhong
	 */
	public String getMaPhong() {
		return oMaPhong;
	}
	/**
	 * @param oMaPhong the oMaPhong to set
	 */
	public void setMaPhong(String oMaPhong) {
		this.oMaPhong = oMaPhong;
	}
	
	
}
