package com.AdvancedMapping.Mapping.ReturnTypeData;

public class PasswordUpdate {
	
	private String userId;
	private String oldpassword;
	private String newpassword;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public PasswordUpdate(String userId, String oldpassword, String newpassword) {
		super();
		this.userId = userId;
		this.oldpassword = oldpassword;
		this.newpassword = newpassword;
	}
	public PasswordUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
