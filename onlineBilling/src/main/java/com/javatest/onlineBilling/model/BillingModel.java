package com.javatest.onlineBilling.model;

public class BillingModel {
	private Integer billNumer;
	private Integer noOfItems;
	private Double billAmount;
	private Double taxAmount;
	private Double totalBillAmount;
	
	private static Integer billNumberStaticVar = 10; 
	
	public BillingModel(){
		billNumer = billNumberStaticVar++;
	}
	
	public Integer getBillNumer() {
		return billNumer;
	}
	public void setBillNumer(Integer billNumer) {
		this.billNumer = billNumer;
	}
	public Integer getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(Integer noOfItems) {
		this.noOfItems = noOfItems;
	}
	public Double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Double getTotalBillAmount() {
		return totalBillAmount;
	}
	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

}
