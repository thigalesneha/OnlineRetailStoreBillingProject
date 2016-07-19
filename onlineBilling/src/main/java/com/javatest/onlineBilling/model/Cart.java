package com.javatest.onlineBilling.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Product,Integer> productMap;
	private String userName;
	
	public Cart(){
		productMap = new HashMap<Product, Integer>();
	}
	
	public Map<Product, Integer> getProductMap() {
		return productMap;
	}
	public void setProductMap(Map<Product, Integer> productMap) {
		this.productMap = productMap;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public boolean equals(Object obj) {

		if(obj==null){
			return false;
		}
		else{
			if(obj instanceof Cart){
				if(((Cart) obj).getUserName().equals(this.userName))
				{
					return true;
				}
			}
			else{
				return false;
			}
		}
		return false;
	}
	
}
