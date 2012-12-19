/**
 * 
 */
package com.examine.data;

import java.util.ArrayList;
import java.util.Date;

import com.examine.entity.KhoiEntity;
import com.examine.entity.PhongThiEntity;
import com.examine.entity.SoBaoDanhEntity;
import com.examine.entity.ThiSinhEntity;
import com.examine.entity.TruongEntity;
import com.examine.config.Configuration;
import com.examine.data.MongoDBConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 * @author sang
 *
 */
public class ThiSinh {
	private TruongEntity truong;
	private KhoiEntity khoi;
	private ThiSinhEntity thisinh;
	private PhongThiEntity phong;
	private SoBaoDanhEntity sobaodanh;

	/**
	 * @param truong
	 * @param khoi
	 * @param thisinh
	 * @param phong
	 * @param sobaodanh
	 */
	public ThiSinh(TruongEntity truong, KhoiEntity khoi, ThiSinhEntity thisinh,
			PhongThiEntity phong, SoBaoDanhEntity sobaodanh) {
		super();
		this.truong = truong;
		this.khoi = khoi;
		this.thisinh = thisinh;
		this.phong = phong;
		this.sobaodanh = sobaodanh;
	}
	/**
	 * @param truong
	 * @param khoi
	 * @param thisinh
	 * @param phong
	 */
	public ThiSinh(TruongEntity truong, KhoiEntity khoi, ThiSinhEntity thisinh,
			PhongThiEntity phong) {
		super();
		this.truong = truong;
		this.khoi = khoi;
		this.thisinh = thisinh;
		this.phong = phong;
	}
	/**
	 * @return the truong
	 */
	public TruongEntity getTruong() {
		return truong;
	}
	/**
	 * @param truong the truong to set
	 */
	public void setTruong(TruongEntity truong) {
		this.truong = truong;
	}
	/**
	 * @return the khoi
	 */
	public KhoiEntity getKhoi() {
		return khoi;
	}
	/**
	 * @param khoi the khoi to set
	 */
	public void setKhoi(KhoiEntity khoi) {
		this.khoi = khoi;
	}
	/**
	 * @return the thisinh
	 */
	public ThiSinhEntity getThisinh() {
		return thisinh;
	}
	/**
	 * @param thisinh the thisinh to set
	 */
	public void setThisinh(ThiSinhEntity thisinh) {
		this.thisinh = thisinh;
	}
	/**
	 * @param truong
	 * @param khoi
	 * @param thisinh
	 */
	public ThiSinh(TruongEntity truong, KhoiEntity khoi, ThiSinhEntity thisinh) {
		this.truong = truong;
		this.khoi = khoi;
		this.thisinh = thisinh;
	}
	/**
	 * 
	 */
	public ThiSinh() {
	}
	
	public static void deleteRecord(String sobaodanh) {
		MongoDBConnection mongoClient = new MongoDBConnection(Configuration.DATABASE_NAME, "Diem_ThiSinh_Phong", Configuration.PORT, Configuration.HOST);
		mongoClient.createConnection();
		mongoClient.removeElement(new BasicDBObject("SBD", sobaodanh));
	}
	
	public static ArrayList<ThiSinh> getAllRows() {
		// TODO Auto-generated method stub
		//System.out.println(1);
		ArrayList<ThiSinh> arrResult = new ArrayList<ThiSinh>();
		MongoDBConnection mongoClient = new MongoDBConnection(Configuration.DATABASE_NAME, "Diem_ThiSinh_Phong", Configuration.PORT, Configuration.HOST);
		mongoClient.createConnection();
		DBCursor cursor = mongoClient.displayAll();

		while(cursor.hasNext()){
			
			ThiSinh newElement = new ThiSinh();
			BasicDBObject curObj = (BasicDBObject)cursor.next();
			String hodem = curObj.getString("HoDem");
			String ten = curObj.getString("Ten");
			String quequan = curObj.getString("QueQuan");
			Date ngaysinh = curObj.getDate("NgaySinh");
			String khuvucuutien = curObj.getString("KhuVucUuTien");
			String khoi = curObj.getString("Khoi");
			String sobaodanh = curObj.getString("SBD");
			BasicDBObject truong = (BasicDBObject) curObj.get("Truong");
			BasicDBObject phong = (BasicDBObject) curObj.get("Phong");
			String tenphong = phong.getString("TenPhong");
			
			//System.out.println(truong.getString("TenTruong"));
			newElement.setSobaodanh(new SoBaoDanhEntity(sobaodanh));
			newElement.setThisinh(new ThiSinhEntity(hodem, ten, ngaysinh, quequan, khuvucuutien));
			newElement.setKhoi(new KhoiEntity(khoi));
			newElement.setTruong(new TruongEntity(truong.getString("MaTruong"), truong.getString("TenTruong")));
			newElement.setPhong(new PhongThiEntity(tenphong));
			arrResult.add(newElement);
			
			
		}
		return arrResult;
	}
	/**
	 * @return the phong
	 */
	public PhongThiEntity getPhong() {
		return phong;
	}
	/**
	 * @param phong the phong to set
	 */
	public void setPhong(PhongThiEntity phong) {
		this.phong = phong;
	}
	/**
	 * @return the sobaodanh
	 */
	public SoBaoDanhEntity getSobaodanh() {
		return sobaodanh;
	}
	/**
	 * @param sobaodanh the sobaodanh to set
	 */
	public void setSobaodanh(SoBaoDanhEntity sobaodanh) {
		this.sobaodanh = sobaodanh;
	}
	
	
	
	
}
