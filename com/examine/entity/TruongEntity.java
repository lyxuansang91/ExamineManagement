package com.examine.entity;
/**
 * 
 * @author huutoan91
 *
 */
public class TruongEntity {
	private String oMaTruong;
	private String oTenTruong;
	
	public TruongEntity(String oMaTruong, String oTenTruong){
		this.oMaTruong = oMaTruong;
		this.oTenTruong = oTenTruong;
	}
	/**
	 * 
	 * @return MaTruong
	 */
	public String getMaTruong(){
		return oMaTruong;
		
	}
	/**
	 * 
	 * @set MaTruong
	 */
	public void setMaTruong(String oMaTruong){
		this.oMaTruong = oMaTruong;
		
	}
	/**
	 * 
	 * @return TenTruong
	 */
	public String getTenTruong(){
		return oTenTruong;
	}
	/**
	 * 
	 * set TenTruong
	 */
	public void setTenTruong(String oTenTruong){
		this.oTenTruong = oTenTruong;
	}
}
