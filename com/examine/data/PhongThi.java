/**
 * 
 */
package com.examine.data;
import com.examine.entity.PhongThiEntity;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.util.ArrayList;

/**
 * @author sang
 *
 */
public class PhongThi extends PhongThiEntity {

	public PhongThi(String oMaPhong, String oTenphong) {
		super(oMaPhong, oTenphong);
		// TODO Auto-generated constructor stub
	}
	
	
	public PhongThi() {
		super();
	}
	
	
	
	public static DBCursor displayAllPhongThi(){
		MongoDBConnection mongoClient = new MongoDBConnection("examineManagement", "PhongThi", 27017, "localhost");
		mongoClient.createConnection();
		DBCursor cursor = mongoClient.displayAll();
		return cursor;
	}
	
	public static DBCursor displayPhongThi(String maPhong, String tenPhong){
		MongoDBConnection mongoClient = new MongoDBConnection("examineManagement", "PhongThi", 27017, "localhost");
		
		mongoClient.createConnection();
		ArrayList x = new ArrayList();
		x.add(new BasicDBObject("MaPhong", maPhong));
		x.add(new BasicDBObject("TenPhong", tenPhong));
		BasicDBObject basicObject = new BasicDBObject("$or", x);
		DBCursor cursor = mongoClient.display(basicObject);
		return cursor;
		//DBCursor cursor = mongoClient.display();
	}

}
