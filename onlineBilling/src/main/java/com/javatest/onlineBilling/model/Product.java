package com.javatest.onlineBilling.model;

public class Product {
	private String name;
	private Long id;
	private Double price;
	private String productDesc;
	private CatagoryEnum category;
	
	public Product(Long id,String name,String productDesc,Double price,CatagoryEnum category){
		this.name = name;
		this.id = id;
		this.price = price;
		this.productDesc = productDesc;
		this.category =category; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public CatagoryEnum getCategory() {
		return category;
	}
	
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		else{
			if(obj instanceof Product){
				if(((Product) obj).getId().equals(this.id))
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
