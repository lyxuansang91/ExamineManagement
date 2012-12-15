/**
 * 
 */
package com.examine.entity;

/**
 * @author sang
 *
 */
public class UserEntity {
	private String oUserName;
	private String oPassword;
	
	
	
	
	
	/**
	 * 
	 */
	public UserEntity() {
	}
	/**
	 * @param oUserName
	 * @param oPassword
	 * @param oPermission
	 */
	public UserEntity(String oUserName, String oPassword) {
		this.oUserName = oUserName;
		this.oPassword = oPassword;
	}
	/**
	 * @return the oUserName
	 */
	public String getUserName() {
		return oUserName;
	}
	/**
	 * @param oUserName the oUserName to set
	 */
	public void setUserName(String oUserName) {
		this.oUserName = oUserName;
	}
	/**
	 * @return the oPassword
	 */
	public String getPassword() {
		return oPassword;
	}
	/**
	 * @param oPassword the oPassword to set
	 */
	public void setPassword(String oPassword) {
		this.oPassword = oPassword;
	}
	
	
	
	

}
