/**
 * 
 */
package com.examine.entity;

import java.util.Date;

/**
 * @author sang
 *
 */
public class ThiSinhEntity {
	/**
	 *  
	 *  */
	private String oMaThiSinh;
	private String oHoDem;
	private String oTen;
	private Date oNgaySinh;
	private String oQueQuan;
	private boolean oGioiTinh;
	private String oDanToc;
	private String oKhuVucUuTien;
	private String oCMT;
	private String oHoKhau;
	
	
	/**
	 * 
	 */
	public ThiSinhEntity() {
	}
	/**
	 * @param oMaThiSinh
	 * @param oHoDem
	 * @param oTen
	 * @param oNgaySinh
	 * @param oQueQuan
	 * @param oGioiTinh
	 * @param oDanToc
	 * @param oKhuVucUuTien
	 * @param oCMT
	 * @param oHoKhau
	 */
	public ThiSinhEntity(String oMaThiSinh, String oHoDem, String oTen,
			Date oNgaySinh, String oQueQuan, boolean oGioiTinh, String oDanToc,
			String oKhuVucUuTien, String oCMT, String oHoKhau) {
		this.oMaThiSinh = oMaThiSinh;
		this.oHoDem = oHoDem;
		this.oTen = oTen;
		this.oNgaySinh = oNgaySinh;
		this.oQueQuan = oQueQuan;
		this.oGioiTinh = oGioiTinh;
		this.oDanToc = oDanToc;
		this.oKhuVucUuTien = oKhuVucUuTien;
		this.setCMT(oCMT);
		this.oHoKhau = oHoKhau;
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
	 * @return the oHoDem
	 */
	public String getHoDem() {
		return oHoDem;
	}
	/**
	 * @param oHoDem the oHoDem to set
	 */
	public void setHoDem(String oHoDem) {
		this.oHoDem = oHoDem;
	}
	/**
	 * @return the oTen
	 */
	public String getTen() {
		return oTen;
	}
	/**
	 * @param oTen the oTen to set
	 */
	public void setTen(String oTen) {
		this.oTen = oTen;
	}
	/**
	 * @return the oNgaySinh
	 */
	public Date getNgaySinh() {
		return oNgaySinh;
	}
	/**
	 * @param oNgaySinh the oNgaySinh to set
	 */
	public void setNgaySinh(Date oNgaySinh) {
		this.oNgaySinh = oNgaySinh;
	}
	/**
	 * @return the oQueQuan
	 */
	public String getQueQuan() {
		return oQueQuan;
	}
	/**
	 * @param oQueQuan the oQueQuan to set
	 */
	public void setQueQuan(String oQueQuan) {
		this.oQueQuan = oQueQuan;
	}
	/**
	 * @return the oGioiTinh
	 */
	public boolean getGioiTinh() {
		return oGioiTinh;
	}
	/**
	 * @param oGioiTinh the oGioiTinh to set
	 */
	public void setGioiTinh(boolean oGioiTinh) {
		this.oGioiTinh = oGioiTinh;
	}
	/**
	 * @return the oDanToc
	 */
	public String getDanToc() {
		return oDanToc;
	}
	/**
	 * @param oDanToc the oDanToc to set
	 */
	public void setDanToc(String oDanToc) {
		this.oDanToc = oDanToc;
	}
	/**
	 * @return the oKhuVucUuTien
	 */
	public String getKhuVucUuTien() {
		return oKhuVucUuTien;
	}
	/**
	 * @param oKhuVucUuTien the oKhuVucUuTien to set
	 */
	public void setKhuVucUuTien(String oKhuVucUuTien) {
		this.oKhuVucUuTien = oKhuVucUuTien;
	}
	/**
	 * @return the oHoKhau
	 */
	public String getHoKhau() {
		return oHoKhau;
	}
	/**
	 * @param oHoKhau the oHoKhau to set
	 */
	public void setHoKhau(String oHoKhau) {
		this.oHoKhau = oHoKhau;
	}
	/**
	 * @return the oCMT
	 */
	public String getCMT() {
		return oCMT;
	}
	/**
	 * @param oCMT the oCMT to set
	 */
	public void setCMT(String oCMT) {
		this.oCMT = oCMT;
	}
}


