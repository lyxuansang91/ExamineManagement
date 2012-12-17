package com.examine.entity;

/**
 * 
 * @author huutoan91
 *
 */
public class PhongThiEntity {

		private String oMaPhong;
		private String oTenPhong;
		
		public PhongThiEntity(String oMaPhong, String oTenphong){
			this.oMaPhong = oMaPhong;
			this.oTenPhong = oTenphong;
			
		}
		 
		public PhongThiEntity() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * return MaPhong
		 */
		public String getMaPhong(){
			return oMaPhong;
		}
		
		/**
		 * 
		 * @set MaPhong
		 */
		public void setMaPhong(String oMaPhong){
			
			this.oMaPhong = oMaPhong;
		}
		/**
		 * 
		 * return TenPhong
		 */
		public String getTenPhong(){
			return oTenPhong;
	
		}
		/**
		 * 
		 * set TenPhong
		 */
		public void setTenPhong(String oTenPhong){
			this.oTenPhong = oTenPhong;
		}
}
