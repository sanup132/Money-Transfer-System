package com.AdvancedMapping.Mapping.ReturnTypeData;

import java.util.ArrayList;
import java.util.List;

public class UserWithPayee {
	
	private String userName;
	
	private List<PayeeData> payeeDate= new ArrayList<>();

	public UserWithPayee(String userName, List<PayeeData> payeeDate) {
		super();
		this.userName = userName;
		this.payeeDate = payeeDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<PayeeData> getPayeeDate() {
		return payeeDate;
	}

	public void setPayeeDate(List<PayeeData> payeeDate) {
		this.payeeDate = payeeDate;
	}

	public UserWithPayee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
