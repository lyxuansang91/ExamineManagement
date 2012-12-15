/**
 * 
 */
package com.examine.data;
import com.examine.entity.UserEntity;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.examine.ui.UserUI;


/**
 * @author sang
 *
 */
public class User extends UserEntity {
	
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param oUserName
	 * @param oPassword
	 * @param oPermission
	 */
	public User(String oUserName, String oPassword) {
		super(oUserName, oPassword);
		// TODO Auto-generated constructor stub
	}

	public boolean isValidUser(){
		MongoDBConnection mongoConnection = new MongoDBConnection("userdb", "user", 27017, "localhost");
		mongoConnection.createConnection();
		//System.out.println("123456");
		BasicDBObject obj = new BasicDBObject();
		obj.put("user", this.getUserName());
		obj.put("password", this.getPassword());
		//System.out.println(obj);
		return(mongoConnection.existData(obj));
	}
	
	
	public static DBCursor displayAllUser(){
		MongoDBConnection mongoClient = new MongoDBConnection("examineManagement", "user", 27017, "localhost");
		mongoClient.createConnection();
		return  mongoClient.displayAll();
		//mongoClient.closeConnection();
	
	}
	
	public static DBCursor displayUser(String userName){
		MongoDBConnection mongoClient = new MongoDBConnection("examineManagement", "user", 27017, "localhost");
		mongoClient.createConnection();
		return mongoClient.display(new BasicDBObject("user", userName));
	}
		
}
