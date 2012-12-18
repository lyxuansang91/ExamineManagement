/**
 * 
 */
package com.examine.data;
import com.examine.entity.PhongThiEntity;
import com.examine.config.Configuration;
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
		MongoDBConnection mongoClient = new MongoDBConnection(Configuration.DATABASE_NAME, "PhongThi", Configuration.PORT, Configuration.HOST);
		mongoClient.createConnection();
		DBCursor cursor = mongoClient.displayAll();
		return cursor;
	}
	
	public static void deleteRowByID(String id){
		MongoDBConnection mongoClient = new MongoDBConnection(Configuration.DATABASE_NAME, "PhongThi", Configuration.PORT, Configuration.HOST);
		mongoClient.createConnection();
		mongoClient.removeElement(new BasicDBObject("MaPhong", id));
	}
	
	public static ArrayList<PhongThi> getallRows(){
		ArrayList<PhongThi> rsList = new ArrayList<PhongThi>();
		DBCursor curr = PhongThi.displayAllPhongThi();
		while(curr.hasNext()){
			
			BasicDBObject curObj = (BasicDBObject)curr.next();
			//System.out.println(curObj.getString("MaPhong") + " " + curObj.getString("TenPhong"));
			PhongThi elementPT = new PhongThi(curObj.getString("MaPhong"), curObj.getString("TenPhong"));
			rsList.add(elementPT);
		}
		return rsList;
	}
	
	public static PhongThi getRowById(String id){
		DBCursor curr = PhongThi.displayPhongThi(id, "");
		BasicDBObject curObj = (BasicDBObject) curr.next();
		PhongThi rsPT = new PhongThi(curObj.getString("MaPhong"), curObj.getString("TenPhong"));
		return rsPT;
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


	public static void updateRow(PhongThi newPT) {
		// TODO Auto-generated method stub
		MongoDBConnection mongoClient = new MongoDBConnection("examineManagement", "PhongThi", 27017, "localhost");
		mongoClient.createConnection();
		BasicDBObject updateObj = new BasicDBObject("$set", new BasicDBObject("TenPhong", newPT.getTenPhong()));
		mongoClient.update(new BasicDBObject("MaPhong", newPT.getMaPhong()),  updateObj);
	}


	public static void addNew(PhongThi newPT) {
		// TODO Auto-generated method stub
		MongoDBConnection mongoClient = new MongoDBConnection("examineManagement", "PhongThi", 27017, "localhost");
		mongoClient.createConnection();
		BasicDBObject insertObj = new BasicDBObject();
		insertObj.put("MaPhong", newPT.getMaPhong());
		insertObj.put("TenPhong", newPT.getTenPhong());
		System.out.println(newPT.getMaPhong());
		mongoClient.addNew(insertObj);
	}

}
