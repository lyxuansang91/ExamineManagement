package com.examine.entity;

/**
 * 
 * @author huutoan91
 *
 */
public class DiemEntity {

	private String oMaDiem;
	private String oMaPhach;
	private String oDiem;
	
	public DiemEntity(){
		
		
	}
	
	public DiemEntity(String oMaDiem, String oMaPhach, String oDiem){
		
		this.oMaDiem = oMaDiem;
		this.oMaPhach = oMaPhach;
		this.oDiem = oDiem;
		
	}
	
	/**
	 * return MaDiem
	 * 
	 */
	
	public String getMaDiem(){

		return oMaDiem;
	
	}
	
	/**
	 * setMaDiem
	 * 
	 */
	
	public void setMaDiem(String oMaDiem){
		this.oMaDiem = oMaDiem;
		
	}
	
	/**
	 * return MaPhach
	 * 
	 */
	
	public String getMaPhach(){
		return oMaPhach;
	}
	
	/**
	 * setMaPhach
	 */
	
	public void setMaPhach(String oMaPhach){
		this.oMaPhach = oMaPhach;
	}
	
	/**
	 * return Diem
	 */
	
	public String getDiem(){
		return oDiem;
	}
	
	/**
	 * setDiem
	 */
	
	public void setDiem(String oDiem){
		this.oDiem = oDiem;
	}
}
